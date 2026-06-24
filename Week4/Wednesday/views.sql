CREATE OR REPLACE VIEW v_order_line_detail AS 
SELECT oh.order_id, c.email, p.sku, ol.qty, 
(ol.qty * ol.unit_price) as line_total, oh.status
FROM order_header oh
JOIN customer c 
ON c.customer_id = oh.customer_id
JOIN order_line ol
ON ol.order_id = oh.order_id
JOIN product p
ON p.product_id = ol.product_id;

SELECT * FROM v_order_line_detail;

-- 1	"alpha@example.com"	"BASE-A"	2	20.00
-- 2	"alpha@example.com"	"BASE-B"	1	20.00
-- 3	"beta@example.com"	"BASE-C"	3	15.00
-- 4	"alpha@example.com"	"BASE-A"	2	20.00
-- 5	"alpha@example.com"	"BASE-A"	2	20.00
-- 6	"alpha@example.com"	"BASE-A"	2	20.00
-- 10	"alpha@example.com"	"BASE-A"	2	20.00


CREATE OR REPLACE VIEW v_customer_spend AS 
SELECT c.email, COUNT(oh.order_id) as order_count, 
COALESCE(SUM((ol.qty * ol.unit_price)), 0) AS lifetime_spend 
FROM customer c
LEFT JOIN order_header oh 
ON c.customer_id = oh.customer_id
LEFT JOIN order_line ol
ON ol.order_id = oh.order_id
GROUP BY c.email;

SELECT * FROM v_customer_spend;

-- "alpha@example.com"	8	120.00
-- "gamma@example.com"	0	0
-- "beta@example.com"	1	15.00

--views can't replace indexes because indexes make lookup time faster but views require the same lookup time as normal