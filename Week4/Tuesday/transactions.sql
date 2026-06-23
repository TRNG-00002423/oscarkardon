-- Section A: Happy Path
BEGIN;

INSERT INTO order_header (customer_id, status)
SELECT customer_id, 'PAID'
FROM customer
WHERE email = 'alpha@example.com';

INSERT INTO order_line (order_id, line_no, product_id, qty, unit_price)
SELECT 
    oh.order_id,
    1,
    p.product_id,
    2,
    p.unit_price
FROM order_header oh
JOIN customer c 
    ON c.customer_id = oh.customer_id
JOIN product p 
    ON p.sku = 'BASE-A'
WHERE c.email = 'alpha@example.com'
ORDER BY oh.order_id DESC
LIMIT 1;

UPDATE product
SET stock_qty = stock_qty - 2
WHERE sku = 'BASE-A'
AND stock_qty >= 2;

COMMIT;

SELECT *
FROM order_header
ORDER BY order_id DESC
LIMIT 1;

SELECT sku, stock_qty
FROM product
WHERE sku = 'BASE-A';


--Section B — Rollback on rule violation
--simulate qty greater than available quantity
BEGIN;

INSERT INTO order_header (customer_id, status)
SELECT customer_id, 'PAID'
FROM customer
WHERE email = 'alpha@example.com';

INSERT INTO order_line (order_id, line_no, product_id, qty, unit_price)
SELECT 
    oh.order_id,
    1,
    p.product_id,
    2,
    p.unit_price
FROM order_header oh
JOIN customer c 
    ON c.customer_id = oh.customer_id
JOIN product p 
    ON p.sku = 'BASE-A'
WHERE c.email = 'alpha@example.com'
ORDER BY oh.order_id DESC
LIMIT 1;

UPDATE product
SET stock_qty = stock_qty - 100000
WHERE sku = 'BASE-A';

ROLLBACK;

SELECT *
FROM order_header
ORDER BY order_id DESC
LIMIT 1;

SELECT sku, stock_qty
FROM product
WHERE sku = 'BASE-A';


--Section C — Savepoint
--simulate qty greater than available quantity then correct
BEGIN;

SAVEPOINT after_header;

INSERT INTO order_header (customer_id, status)
SELECT customer_id, 'PAID'
FROM customer
WHERE email = 'alpha@example.com';

SAVEPOINT after_lines;


INSERT INTO order_line (order_id, line_no, product_id, qty, unit_price)
SELECT 
    oh.order_id,
    1,
    p.product_id,
    2,
    p.unit_price
FROM order_header oh
JOIN customer c 
    ON c.customer_id = oh.customer_id
JOIN product p 
    ON p.sku = 'BASE-A'
WHERE c.email = 'alpha@example.com'
ORDER BY oh.order_id DESC
LIMIT 1;

UPDATE product
SET stock_qty = stock_qty - 100000
WHERE sku = 'BASE-A';

ROLLBACK TO SAVEPOINT after_lines;

UPDATE product
SET stock_qty = stock_qty - 2
WHERE sku = 'BASE-A'
AND stock_qty >= 2;

COMMIT;

SELECT *
FROM order_header
ORDER BY order_id DESC
LIMIT 1;

SELECT sku, stock_qty
FROM product
WHERE sku = 'BASE-A';