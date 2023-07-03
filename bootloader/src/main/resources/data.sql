INSERT INTO PRODUCTS (ID, SEQUENCE)
VALUES (1, 10),
       (2, 7),
       (3, 15),
       (4, 13),
       (5, 6);

INSERT INTO SIZES (ID, PRODUCT_ID, BACK_SOON, SPECIAL)
VALUES (11, 1, TRUE, FALSE),
       (12, 1, FALSE, FALSE),
       (13, 1, TRUE, FALSE),
       (21, 2, FALSE, FALSE),
       (22, 2, FALSE, FALSE),
       (23, 2, TRUE, TRUE),
       (31, 3, TRUE, FALSE),
       (32, 3, TRUE, FALSE),
       (33, 3, FALSE, FALSE),
       (41, 4, FALSE, FALSE),
       (42, 4, FALSE, FALSE),
       (43, 4, FALSE, FALSE),
       (44, 4, TRUE, TRUE),
       (51, 5, TRUE, FALSE),
       (52, 5, FALSE, FALSE),
       (53, 5, FALSE, FALSE),
       (54, 5, TRUE, TRUE);

INSERT INTO STOCKS (SIZE_ID, QUANTITY)
VALUES (11, 0),
       (12, 0),
       (13, 0),
       (22, 0),
       (31, 10),
       (32, 10),
       (33, 10),
       (41, 0),
       (42, 0),
       (43, 0),
       (44, 10),
       (51, 10),
       (52, 10),
       (53, 10),
       (54, 10);
