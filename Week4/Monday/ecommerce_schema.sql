--drop tables if they exist
DROP TABLE if exists customer;
DROP TABLE if exists product;
DROP TABLE if exists orders;
DROP TABLE if exists order_line;
DROP TABLE if exists address;

--create customer table
Create table customer (
	customer_id SERIAL PRIMARY KEY,
	email VARCHAR(255) UNIQUE NOT NULL,
	phone varchar(20)
);

--create address table
CREATE TABLE address (
    address_id SERIAL PRIMARY KEY,
    customer_id INT NOT NULL,
    street VARCHAR(255) NOT NULL,
    city VARCHAR(100) NOT NULL,
    state VARCHAR(100) NOT NULL,
    zip_code VARCHAR(20) NOT NULL,
    country VARCHAR(100) NOT NULL,

    FOREIGN KEY (customer_id)
        REFERENCES customer(customer_id)
        ON DELETE CASCADE
);

--create product table
CREATE TABLE product (
    product_id SERIAL PRIMARY KEY,
    sku VARCHAR(50) NOT NULL UNIQUE,
    name VARCHAR(255) NOT NULL,
    current_price DECIMAL(10,2) NOT NULL,
    stock_on_hand INT NOT NULL,

	CHECK (current_price >= 0)

);

--create orders table
CREATE TABLE orders (
    order_id SERIAL PRIMARY KEY,
    customer_id INT NOT NULL,
    shipping_address_id INT NOT NULL,
    order_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(20) NOT NULL,

    FOREIGN KEY (customer_id)
        REFERENCES customer(customer_id)
        ON DELETE RESTRICT,

    FOREIGN KEY (shipping_address_id)
        REFERENCES address(address_id)
        ON DELETE RESTRICT
);

--create order_line table
CREATE TABLE order_line (
    order_line_id SERIAL PRIMARY KEY,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    unit_price DECIMAL(10,2) NOT NULL,

    CHECK (quantity > 0),
    CHECK (unit_price >= 0),

    UNIQUE (order_id, product_id),

    FOREIGN KEY (order_id)
        REFERENCES orders(order_id)
        ON DELETE CASCADE,

    FOREIGN KEY (product_id)
        REFERENCES product(product_id)
        ON DELETE RESTRICT
);

