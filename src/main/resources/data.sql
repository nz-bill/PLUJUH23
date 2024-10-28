CREATE TABLE IF NOT EXISTS ApplicationUser(id INT PRIMARY KEY, name VARCHAR(255), password VARCHAR(255) );

INSERT INTO ApplicationUser(id, name, password) VALUES (1, 'BIll', '123abc'), (2, 'Boll', 'password');

--INSERT INTO category (id, name) VALUES (1, "coffees"),(2, "juices");