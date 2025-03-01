SELECT * FROM information_schema.tables WHERE table_name = 'products';

CREATE TABLE products (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10,2) NOT NULL
);

SELECT * FROM products;


