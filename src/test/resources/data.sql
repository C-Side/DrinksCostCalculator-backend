INSERT INTO persons (id, name, role, age)
VALUES (1, 'Lukas', 'test', 30);

INSERT INTO drink_categories (id, category, alcoholic)
VALUES (1, 'Bier', true),
       (2, 'Nicht-alkoholisch', false);

INSERT INTO drinks (id, name, price, drink_categories_id)
VALUES (1, 'Bier', 2.54, 1),
       (2, 'Wasser', 1.13, 2);

INSERT INTO person_drinks (person_id, drink_id, quantity)
VALUES (1, 1, 4),
       (1, 2, 3);