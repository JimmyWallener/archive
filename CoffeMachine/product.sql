-- Skapa tabellen products
CREATE TABLE products (
  product VARCHAR(1) NOT NULL,
  product_name VARCHAR(255) NOT NULL,
  price DOUBLE NOT NULL
);

-- Lägg till data i tabellen products
INSERT INTO products (product, product_name, price) VALUES
('K', 'Kaffe', 12.00),
('E', 'Espresso', 14.00),
('C', 'Choklad', 11.50),
('L', 'Kaffe Latte', 13.00),
('P', 'Cappuccino', 13.50);
