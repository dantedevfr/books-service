CREATE TABLE book (
    id BIGINT PRIMARY KEY,
    title VARCHAR(255),
    author VARCHAR(255),
    description VARCHAR(255)
);

CREATE TABLE section (
    id BIGINT PRIMARY KEY,
    content VARCHAR(255),
    type VARCHAR(255),
    book_id BIGINT,
    CONSTRAINT fk_book FOREIGN KEY (book_id) REFERENCES book(id)
);
