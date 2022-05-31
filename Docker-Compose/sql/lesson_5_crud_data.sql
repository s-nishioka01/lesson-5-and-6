USE purchase_list;
DROP TABLE IF EXISTS purchases;

CREATE TABLE purchases
(
	id INT unsigned AUTO_INCREMENT,
	itemName VARCHAR(100) NOT NULL,
	price INT(10) NOT NULL,
	purchaseDate DATE NOT NULL,
	PRIMARY KEY (id)
);

INSERT INTO purchases (id, itemName, price, purchaseDate) VALUE (1, "Book", 700, "2022-5-1");
INSERT INTO purchases (id, itemName, price, purchaseDate) VALUE (2, "Apple", 300, "2022-5-3");
INSERT INTO purchases (id, itemName, price, purchaseDate) VALUE (3, "Macbook", 120000, "2022-5-7");



