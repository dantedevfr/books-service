-- === VALID BOOK 1 ===
INSERT INTO book (id, title, author, description) VALUES (1, 'Clean Code', 'Robert C. Martin', 'A handbook of agile software craftsmanship');

INSERT INTO section (id, content, type, book_id) VALUES
(1, 'Intro to Clean Code', 'INTRO', 1),
(2, 'Principles of writing clean code', 'BODY', 1),
(3, 'Conclusion and summary', 'ENDING', 1);

-- === VALID BOOK 2 ===
INSERT INTO book (id, title, author, description) VALUES (2, 'The Pragmatic Programmer', 'Andrew Hunt', 'From journeyman to master');

INSERT INTO section (id, content, type, book_id) VALUES
(4, 'Why Pragmatism matters', 'INTRO', 2),
(5, 'Tips and techniques', 'BODY', 2),
(6, 'Final advice', 'ENDING', 2),
(7, 'Alternative endings', 'ENDING', 2);

-- VALID BOOK 3
INSERT INTO book (id, title, author, description) VALUES (10, 'Valid Book', 'Author A', 'All validations passed');
INSERT INTO section (id, content, type, book_id) VALUES
(20, 'Intro', 'INTRO', 10),
(21, 'Body', 'BODY', 10),
(22, 'End', 'ENDING', 10);

-- === INVALID BOOK (missing INTRO) ===
INSERT INTO book (id, title, author, description) VALUES (3, 'Incomplete Book', 'Unknown Author', 'This book is invalid by design');

INSERT INTO section (id, content, type, book_id) VALUES
(8, 'Some body content', 'BODY', 3),
(9, 'A conclusion', 'ENDING', 3);

-- INVALID: Empty title
INSERT INTO book (id, title, author, description) VALUES (11, '', 'Author B', 'No title');
INSERT INTO section (id, content, type, book_id) VALUES
(23, 'Intro', 'INTRO', 11),
(24, 'Body', 'BODY', 11),
(25, 'End', 'ENDING', 11);

-- INVALID: Empty author
INSERT INTO book (id, title, author, description) VALUES (12, 'Book with no author', '', 'No author');
INSERT INTO section (id, content, type, book_id) VALUES
(26, 'Intro', 'INTRO', 12),
(27, 'Body', 'BODY', 12),
(28, 'End', 'ENDING', 12);

-- INVALID: No sections
INSERT INTO book (id, title, author, description) VALUES (13, 'No Sections Book', 'Author D', 'Missing sections');

-- INVALID: Missing INTRO
INSERT INTO book (id, title, author, description) VALUES (14, 'Missing Intro', 'Author E', 'No intro section');
INSERT INTO section (id, content, type, book_id) VALUES
(29, 'Body', 'BODY', 14),
(30, 'End', 'ENDING', 14);

-- INVALID: Missing BODY
INSERT INTO book (id, title, author, description) VALUES (15, 'Missing Body', 'Author F', 'No body section');
INSERT INTO section (id, content, type, book_id) VALUES
(31, 'Intro', 'INTRO', 15),
(32, 'End', 'ENDING', 15);

-- INVALID: Missing ENDING
INSERT INTO book (id, title, author, description) VALUES (16, 'Missing Ending', 'Author G', 'No ending section');
INSERT INTO section (id, content, type, book_id) VALUES
(33, 'Intro', 'INTRO', 16),
(34, 'Body', 'BODY', 16);


-- INVALID BOOK WITH MULTIPLE ERRORS
INSERT INTO book (id, title, author, description)
VALUES (20, '', '', 'This book violates multiple validation rules');

