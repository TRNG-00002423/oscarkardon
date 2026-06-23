--1: INNER JOIN: List every paid order: customer email, order_id, placed_at, line revenue sum for that order (SUM(qty * unit_price)).
select c.email, oh.order_id, oh.placed_at, SUM(ol.qty * ol.unit_price)
FROM customer c
JOIN order_header oh on c.customer_id = oh.customer_id
JOIN order_line ol on oh.order_id = ol.order_id
WHERE oh.status = 'PAID'
GROUP by c.email, oh.order_id, oh.placed_at;

--2: LEFT JOIN: List all customers and their most recent order id (if any). Include customers with no orders (order_id NULL).
SELECT 
    c.full_name,
    c.email,
    oh.order_id
FROM customer c
LEFT JOIN order_header oh 
    ON oh.order_id = (
        SELECT MAX(oh2.order_id)
        FROM order_header oh2
        WHERE oh2.customer_id = c.customer_id
    );

--3 RIGHT JOIN: Same logical data as (2) but implement with RIGHT JOIN (hint: flip table order so you still “start” from customers mentally — comment why you ordered tables that way).
SELECT 
    c.full_name,
    c.email,
    oh.order_id
FROM order_header oh  
RIGHT JOIN customer c
    ON oh.order_id = (
        SELECT MAX(oh2.order_id)
        FROM order_header oh2
        WHERE oh2.customer_id = c.customer_id
    );
--had to flip tables to join on customers so all customers show up even if they don't have an order,
--not all orders show up even if they don't have a customer

--4:FULL OUTER JOIN: Produce a report showing all customers and all orders, pairing where customer_id matches; include unmatched rows on either side with NULLs.
select * 
from customer c
FULL OUTER JOIN order_header oh
ON oh.customer_id = c.customer_id
--orphan orders would orders without a customer attached

--5: CROSS JOIN (controlled): Build a small Cartesian product: each product paired with a literal status dimension you create via an inline VALUES list (e.g. ('STOCK_OK','STOCK_LOW') thresholds are optional). Cap the result: WHERE or small dimension so you do not explode row counts.
SELECT p.name, s.status
FROM product p
CROSS JOIN (
    VALUES ('STOCK_OK'),
           ('STOCK_LOW')
) AS s(status);


--6: Aggregate + HAVING: Per customer, show order_count and total spend; include only customers with total spend > 25.
select c.full_name, c.customer_id, count(oh.order_id) as order_count, sum(ol.qty * ol.unit_price) as spend
FROM customer c
JOIN order_header oh on c.customer_id = oh.customer_id
JOIN order_line ol on oh.order_id = ol.order_id
GROUP BY c.full_name, c.customer_id
HAVING SUM(ol.qty * ol.unit_price) > 25

--7: Subquery: Products that appear on more than one distinct order (by order_id).
SELECT *
FROM product p
WHERE p.product_id IN (
    SELECT ol.product_id
    FROM order_line ol
    GROUP BY ol.product_id
    HAVING COUNT(DISTINCT ol.order_id) > 1
);

--8: Set operation: Use UNION ALL to combine two SELECTs with compatible columns (e.g. “active customers” vs “customers with paid orders” — define the sets clearly in comments).
SELECT c.full_name, 'active_customer' as customer_status
FROM customer c
UNION ALL 
select c.full_name, 'customer_with_paid_orders' as customer_status
from customer c
JOIN order_header oh 
	ON c.customer_id = oh.customer_id
WHERE oh.status = 'PAID';
