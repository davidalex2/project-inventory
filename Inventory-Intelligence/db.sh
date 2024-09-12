#!/bin/bash

PG_USER="postgres"
COMMON_PASSWORD="root"
PG_HOST="localhost"
PG_PORT="5432"

export PGPASSWORD="$COMMON_PASSWORD"


DB_NAME=("inventory_db")

for db_name in "${DB_NAME[@]}"
do
   
    if psql -h $PG_HOST -p $PG_PORT -U $PG_USER -lqt | cut -d \| -f 1 | grep -qw $db_name; then
        echo "Database $db_name already exists. Skipping."
    else
       
        createdb -h $PG_HOST -p $PG_PORT -U $PG_USER $db_name
		
        echo "Database $db_name created successfully."
    fi
	

done


echo "DATABASE is created successfully."

#CREATING TABLES FOR USER DETAIL AND LOGIN

TABLE_1="CREATE TABLE IF NOT EXISTS user_detail(userName VARCHAR(255) UNIQUE NOT NULL,password VARCHAR(255) NOT NULL)";

TABLE_2="CREATE TABLE IF NOT EXISTS roles_detail(role_id SERIAL PRIMARY KEY,role_name VARCHAR(255) NOT NULL,role_desc VARCHAR(255) NOT NULL)";

TABLE_3="CREATE TABLE IF NOT EXISTS detail_role (username varchar(255) unique not null,id_role INT NOT NULL,u_id serial PRIMARY KEY
,FOREIGN KEY (username)REFERENCES user_detail(username)
,FOREIGN KEY (id_role) REFERENCES roles_detail(role_id))";

TABLE_4="CREATE TABLE IF NOT EXISTS customer(u_id INT UNIQUE NOT NULL ,name VARCHAR(255),address VARCHAR(255),age INT,
gender VARCHAR(255),status VARCHAR(255),shop VARCHAR(255),site VARCHAR(255),p_no NUMERIC CHECK (p_no > 9),email VARCHAR(255),fOREIGN KEY(u_id) REFERENCES detail_role(u_id))";

#CREATING TABLES FOR ORDER

TABLE_5="CREATE TABLE IF NOT EXISTS orders (
    order_id SERIAL PRIMARY KEY,
    customer_name VARCHAR(255) NOT NULL,
    total_amount NUMERIC(10, 2) NOT NULL,
    order_date DATE NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'Placed',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ";

TABLE_6=" CREATE TABLE IF NOT EXISTS order_item (
    order_item_id SERIAL PRIMARY KEY,
    order_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    quantity INT NOT NULL,
    price_per_unit NUMERIC(10, 2) NOT NULL,
    total_amount NUMERIC(10, 2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (product_id) REFERENCES Product(product_id)
) ";

TABLE_7=" CREATE TABLE IF NOT EXISTS Invoice (
    invoice_id SERIAL PRIMARY KEY,
    order_id BIGINT NOT NULL,
    total_amount NUMERIC(10, 2) NOT NULL,
    issued_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (order_id) REFERENCES orders(order_id)
) ";

FUNTION_1=" CREATE OR REPLACE FUNCTION insert_invoice()
RETURNS TRIGGER AS \$\$
BEGIN
    INSERT INTO invoice (order_id, total_amount, issued_at)
    VALUES (NEW.order_id, NEW.total_amount, NEW.created_at);
    RETURN NEW;
END;
\$\$ LANGUAGE plpgsql; ";

TRIGGER_1=" CREATE TRIGGER after_insert_orders
AFTER INSERT ON orders
FOR EACH ROW
EXECUTE FUNCTION insert_invoice();";

#CREATING TABLE FOR PRODUCT
TABLE_8="CREATE TABLE Product (
    product_id BIGINT PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    description TEXT,
    price NUMERIC(10, 2) NOT NULL,
    category VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)";

#CREATING TABLES FOR SITE
EXTENSION_1=" CREATE EXTENSION IF NOT EXISTS \"uuid-ossp\" ;";

TABLE_9=" CREATE TABLE Site (
    site_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    site_name VARCHAR(255) NOT NULL,
    location VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)";

TABLE_10=" CREATE TABLE Floor (
    floor_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    site_id UUID NOT NULL,
    floor_name VARCHAR(255) NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (site_id) REFERENCES Site(site_id)
)";

TABLE_11=" CREATE TABLE Zone (
    zone_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    floor_id UUID NOT NULL,
    zone_name VARCHAR(255) NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (floor_id) REFERENCES Floor(floor_id)
)";


#USER 
psql -U "$PG_USER" -h "$PG_HOST" -p "$PG_PORT" -d "$DB_NAME" -c "$TABLE_1"
psql -U "$PG_USER" -h "$PG_HOST" -p "$PG_PORT" -d "$DB_NAME" -c "$TABLE_2"
psql -U "$PG_USER" -h "$PG_HOST" -p "$PG_PORT" -d "$DB_NAME" -c "$TABLE_3"
psql -U "$PG_USER" -h "$PG_HOST" -p "$PG_PORT" -d "$DB_NAME" -c "$TABLE_4"

#SITE AND ZONE
psql -U "$PG_USER" -h "$PG_HOST" -p "$PG_PORT" -d "$DB_NAME" -c "$EXTENSION_1"
psql -U "$PG_USER" -h "$PG_HOST" -p "$PG_PORT" -d "$DB_NAME" -c "$TABLE_9"
psql -U "$PG_USER" -h "$PG_HOST" -p "$PG_PORT" -d "$DB_NAME" -c "$TABLE_10"
psql -U "$PG_USER" -h "$PG_HOST" -p "$PG_PORT" -d "$DB_NAME" -c "$TABLE_11"


#PRODUCT
psql -U "$PG_USER" -h "$PG_HOST" -p "$PG_PORT" -d "$DB_NAME" -c "$TABLE_8"

#ORDER
psql -U "$PG_USER" -h "$PG_HOST" -p "$PG_PORT" -d "$DB_NAME" -c "$TABLE_5"
psql -U "$PG_USER" -h "$PG_HOST" -p "$PG_PORT" -d "$DB_NAME" -c "$TABLE_6"
psql -U "$PG_USER" -h "$PG_HOST" -p "$PG_PORT" -d "$DB_NAME" -c "$TABLE_7"
psql -U "$PG_USER" -h "$PG_HOST" -p "$PG_PORT" -d "$DB_NAME" -c "$FUNTION_1"
psql -U "$PG_USER" -h "$PG_HOST" -p "$PG_PORT" -d "$DB_NAME" -c "$TRIGGER_1"


unset PGPASSWORD

echo "Database = $DB_NAME,Tables ,Functions and Triggers are created successfully."


