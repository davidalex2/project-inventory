--CREATE ORDERS TABLE
CREATE TABLE "orders" (
    order_id SERIAL PRIMARY KEY,
    customer_name VARCHAR(255) NOT NULL,
    total_amount NUMERIC(10, 2) NOT NULL,
    order_date DATE NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'Placed',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

--CREATE ORDER_ITEM TABLE
CREATE TABLE order_item (
    order_item_id SERIAL PRIMARY KEY,
    order_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    quantity INT NOT NULL,
    price_per_unit NUMERIC(10, 2) NOT NULL,
    total_amount NUMERIC(10, 2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES "orders"(order_id),
    FOREIGN KEY (product_id) REFERENCES Product(product_id)
);

--CREATE INVOICE TABLE
CREATE TABLE Invoice (
    invoice_id SERIAL PRIMARY KEY,
    order_id BIGINT NOT NULL,
    total_amount NUMERIC(10, 2) NOT NULL,
    issued_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (order_id) REFERENCES "orders"(order_id)
);


--CREATE INVOICE FUNCTION AND TRIGGER

--FUNCTION
CREATE OR REPLACE FUNCTION insert_invoice()
RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO invoice (order_id, total_amount, issued_at)
    VALUES (NEW.order_id, NEW.total_amount, New.created_at);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

--TRIGGER
CREATE TRIGGER after_insert_orders
AFTER INSERT ON orders
FOR EACH ROW
EXECUTE FUNCTION insert_invoice();
