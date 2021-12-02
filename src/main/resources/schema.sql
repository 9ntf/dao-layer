CREATE TABLE CUSTOMERS
(
    id SERIAL PRIMARY KEY,
    name varchar(255) not null,
    surname varchar(255),
    age int default 0,
    phone_number varchar(255)
);

CREATE TABLE ORDERS
(
    id int,
    date DATE ,
    customer_id int,
    product_name varchar(255) not null ,
    amount int default 0,
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES CUSTOMERS (id)
);