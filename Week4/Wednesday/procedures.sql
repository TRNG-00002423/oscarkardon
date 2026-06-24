CREATE OR REPLACE PROCEDURE adjust_stock(
    p_sku TEXT,
    p_delta INT
)
LANGUAGE plpgsql
AS $$
DECLARE
    current_stock INT;
BEGIN
    SELECT stock_qty
    INTO current_stock
    FROM product 
    WHERE sku = p_sku;

    IF current_stock + p_delta < 0 THEN
        RAISE EXCEPTION 'Insufficient stock for SKU %', p_sku;
    END IF;

    UPDATE product
    SET stock_qty = stock_qty + p_delta
    WHERE sku = p_sku;
END;
$$;


CALL adjust_stock('BASE-A', -5);
CALL adjust_stock('BASE-A', -100);

SELECT * FROM product;
--THis makes the code more reusable and will have the check built in 


CREATE OR REPLACE PROCEDURE fetch_order_total(
    IN p_order_id INT,
    INOUT p_total NUMERIC
)
LANGUAGE plpgsql
AS $$
BEGIN
    SELECT COALESCE(SUM(qty * unit_price), 0)
    INTO p_total
    FROM order_line
    WHERE order_id = p_order_id;
END;
$$;

CALL fetch_order_total(1, null);
