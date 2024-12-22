CREATE TABLE Offer (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       item VARCHAR(255) NOT NULL,
                       normal_price FLOAT NOT NULL,
                       required_quantity INT NULL,
                       special_price FLOAT NULL
);

INSERT INTO Offer (id, item, normal_price, required_quantity, special_price) VALUES (1, 'Item1', 100.0, NULL, NULL);
INSERT INTO Offer (id, item, normal_price, required_quantity, special_price) VALUES (2, 'Item2', 150.0, NULL, NULL);
INSERT INTO Offer (id, item, normal_price, required_quantity, special_price) VALUES (3, 'Item3', 120.0, NULL, NULL);
INSERT INTO Offer (id, item, normal_price, required_quantity, special_price) VALUES (4, 'Item4', 80.0, NULL, NULL);
INSERT INTO Offer (id, item, normal_price, required_quantity, special_price) VALUES (5, 'Item5', 200.0, NULL, NULL);
INSERT INTO Offer (id, item, normal_price, required_quantity, special_price) VALUES (6, 'Item6', 300.0, NULL, NULL);
INSERT INTO Offer (id, item, normal_price, required_quantity, special_price) VALUES (7, 'Item7', 50.0, NULL, NULL);
INSERT INTO Offer (id, item, normal_price, required_quantity, special_price) VALUES (8, 'Item8', 400.0, NULL, NULL);
INSERT INTO Offer (id, item, normal_price, required_quantity, special_price) VALUES (9, 'Item9', 250.0, NULL, NULL);
INSERT INTO Offer (id, item, normal_price, required_quantity, special_price) VALUES (10, 'Item10', 180.0, NULL, NULL);
INSERT INTO Offer (id, item, normal_price, required_quantity, special_price) VALUES (11, 'Item11', 100.0, 3, 70.0);
INSERT INTO Offer (id, item, normal_price, required_quantity, special_price) VALUES (12, 'Item12', 150.0, 4, 112.5);
INSERT INTO Offer (id, item, normal_price, required_quantity, special_price) VALUES (13, 'Item13', 120.0, 5, 90.0);
INSERT INTO Offer (id, item, normal_price, required_quantity, special_price) VALUES (14, 'Item14', 80.0, 3, 60.0);
INSERT INTO Offer (id, item, normal_price, required_quantity, special_price) VALUES (15, 'Item15', 200.0, 4, 150.0);
INSERT INTO Offer (id, item, normal_price, required_quantity, special_price) VALUES (16, 'Item16', 300.0, 5, 225.0);
INSERT INTO Offer (id, item, normal_price, required_quantity, special_price) VALUES (17, 'Item17', 50.0, 3, 37.5);
INSERT INTO Offer (id, item, normal_price, required_quantity, special_price) VALUES (18, 'Item18', 400.0, 5, 300.0);
INSERT INTO Offer (id, item, normal_price, required_quantity, special_price) VALUES (19, 'Item19', 250.0, 4, 187.5);
INSERT INTO Offer (id, item, normal_price, required_quantity, special_price) VALUES (20, 'Item20', 180.0, 3, 135.0);
