-- INSERT CUSTOMERS 
INSERT INTO customer (email, phone)
VALUES 
('oscar@example.com', '617-555-1111'),
('bob@example.com', '781-555-2222');


-- INSERT ADDRESSES 
INSERT INTO address (customer_id, street, city, state, zip_code, country)
VALUES
(1, '123 Main St', 'Boston', 'MA', '02108', 'USA'),
(1, '456 Oak St', 'Cambridge', 'MA', '02139', 'USA'),
(2, '789 Pine St', 'Arlington', 'MA', '02476', 'USA');


-- INSERT PRODUCTS 
INSERT INTO product (sku, name, current_price, stock_on_hand)
VALUES
('SKU100', 'Keyboard', 50.00, 20),
('SKU200', 'Mouse', 25.00, 50),
('SKU300', 'Monitor', 200.00, 10);


-- INSERT ORDERS 
INSERT INTO orders (customer_id, shipping_address_id, status)
VALUES
(1, 1, 'OPEN'),
(2, 3, 'PAID');


-- INSERT ORDER LINES
INSERT INTO order_line (order_id, product_id, quantity, unit_price)
VALUES
(1, 1, 2, 50.00),
(1, 2, 1, 25.00),
(2, 3, 1, 200.00);


-- UPDATE PRODUCT PRICE
UPDATE product
SET current_price = 60.00
WHERE product_id = 1;


-- Check: order_line still has old price
SELECT *
FROM order_line
WHERE product_id = 1;


-- UPDATE ONE ORDER 
UPDATE orders
SET status = 'CANCELLED'
WHERE order_id = 1
  AND status = 'OPEN';

SELECT *
FROM orders;