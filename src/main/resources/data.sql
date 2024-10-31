DELETE FROM book;
INSERT INTO book (id, title, category, isbn, cost, year, description) 
VALUES 
  (1, 'Database Book', 'Technology', '1122334455', 29.99, 2020, 'A book about databases'),
  (2, 'Spring Boot Guide', 'Technology', '2233445566', 35.99, 2021, 'Guide to Spring Boot');
INSERT INTO author (first_name, last_name) VALUES ('John', 'Doe');
