CREATE DATABASE stocks;

CREATE TABLE stock_tb (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    unit_price NUMERIC(10,2) CHECK (unit_price > 0) NOT NULL,
    stock_qty INT NOT NULL,
    imported_date DATE DEFAULT CURRENT_DATE
);

INSERT INTO stock_tb(name,unit_price,stock_qty) VALUES ('Pepsi',2.5,10),
                                                       ('Pizza',5.2,5),
                                                       ('Burger',1.5,50),
                                                       ('ice cream',0.8,3);

SELECT * FROM stock_tb;