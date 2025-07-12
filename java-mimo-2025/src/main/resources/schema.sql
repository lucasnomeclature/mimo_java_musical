CREATE TABLE if not exists countries (
    id int not null GENERATED ALWAYS AS IDENTITY PRIMARY KEY,    
    name VARCHAR(255) not null unique,
    continent VARCHAR(50) not null
);

CREATE TABLE if not exists authors (
    id int not null GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(255) not null unique,
    country_id int,
    CONSTRAINT fk_author_country FOREIGN KEY (country_id) REFERENCES countries(id)
);

CREATE TABLE if not exists books (
    id int not null GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    isbn VARCHAR(255) not null unique,
    title VARCHAR(255) not null unique,    
    original_language VARCHAR(50),
    pub_year INT,
    author_id int,
    price int,
    CONSTRAINT fk_book_author FOREIGN KEY (author_id) REFERENCES authors(id)
); 

/*

INSERT INTO countries (name, continent) VALUES
('United Kingdom', 'Europe'),
('United States', 'North America'),
('Russia', 'Europe'),
('France', 'Europe'),
('Colombia', 'South America'),  -- New country
('India', 'Asia');

INSERT INTO authors (name, country_id) VALUES
('Daniel Defoe', (SELECT id FROM countries WHERE name = 'United Kingdom')),
('Mark Twain', (SELECT id FROM countries WHERE name = 'United States')),
('Leo Tolstoy', (SELECT id FROM countries WHERE name = 'Russia')),
('Jules Verne', (SELECT id FROM countries WHERE name = 'France')),
('Fyodor Dostoevsky', (SELECT id FROM countries WHERE name = 'Russia')),
('Gabriel García Márquez', (SELECT id FROM countries WHERE name = 'Colombia')),
('Amartya Sen', (SELECT id FROM countries WHERE name = 'India')),
('Harper Lee', (SELECT id FROM countries WHERE name = 'United States')),
('John Steinbeck', (SELECT id FROM countries WHERE name = 'United States'));

INSERT INTO books (isbn, title, original_language, pub_year, price, author_id) VALUES
('978-0141439822', 'Robinson Crusoe', 'English', 1719, 10, (SELECT id FROM authors WHERE name = 'Daniel Defoe')),
('978-0486400778', 'The Adventures of Tom Sawyer', 'English', 1876, 10, (SELECT id FROM authors WHERE name = 'Mark Twain')),
('978-0143035008', 'Anna Karenina', 'Russian', 1877, 10, (SELECT id FROM authors WHERE name = 'Leo Tolstoy')),
('978-1503215153', 'The Mysterious Island', 'French', 1874, 10, (SELECT id FROM authors WHERE name = 'Jules Verne')),
('978-0140449136', 'Crime and Punishment', 'Russian', 1866, 10, (SELECT id FROM authors WHERE name = 'Fyodor Dostoevsky')),
('978-0060883287', 'One Hundred Years of Solitude', 'Spanish', 1967, 10, (SELECT id FROM authors WHERE name = 'Gabriel García Márquez')),
('978-0374105839', 'The Argumentative Indian', 'English', 2005, 10, (SELECT id FROM authors WHERE name = 'Amartya Sen')),
('978-0061120084', 'To Kill a Mockingbird', 'English', 1960, 10, (SELECT id FROM authors WHERE name = 'Harper Lee')),
('978-0143039433', 'The Grapes of Wrath', 'English', 1939, 10, (SELECT id FROM authors WHERE name = 'John Steinbeck'));

*/