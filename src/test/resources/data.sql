INSERT INTO persons (id, name)
VALUES (1, 'Lukas');

INSERT INTO drinks (id, name, price)
VALUES (1, 'Bier', 2.54),
       (2, 'Wasser', 1.13);

INSERT INTO person_drinks (person_id, drink_id, quantity)
VALUES (1, 1, 4),
       (1, 2, 3);