DROP DATABASE IF EXISTS gui_lab4;
CREATE DATABASE IF NOT EXISTS gui_lab4;

CREATE TABLE make (
	make_id INT PRIMARY KEY AUTO_INCREMENT,
	make_name VARCHAR(50)
);

CREATE TABLE model (
	model_id INT PRIMARY KEY AUTO_INCREMENT,
	model_name VARCHAR(50)
);

CREATE TABLE make_model (
	make_model_id INT PRIMARY KEY AUTO_INCREMENT,
	make_id INT NOT NULL,
	model_id INT NOT NULL,
	FOREIGN KEY (make_id) REFERENCES make(make_id),
	FOREIGN KEY (model_id) REFERENCES model(model_id)
);

CREATE TABLE category (
	category_id INT PRIMARY KEY AUTO_INCREMENT,
	category_name VARCHAR(100)
);

CREATE TABLE make_model_category (
	make_model_id INT,
	category_id INT,
	FOREIGN KEY (make_model_id) REFERENCES make_model(make_model_id),
	FOREIGN KEY (category_id) REFERENCES category(category_id),
	PRIMARY KEY (make_model_id, category_id)
);

CREATE TABLE part (
	part_id INT PRIMARY KEY AUTO_INCREMENT,
	make_id INT NOT NULL,
	model_id INT NOT NULL,
	category_id INT NOT NULL,
	unit_price DECIMAL(15,2),
	part_year YEAR(4),
	part_name VARCHAR(100),
	FOREIGN KEY (make_id) REFERENCES make(make_id),
	FOREIGN KEY (model_id) REFERENCES model(model_id),
	FOREIGN KEY (category_id) REFERENCES category(category_id)
);

CREATE TABLE order_detail (
	order_detail_id INT PRIMARY KEY AUTO_INCREMENT
);

-- Insert hiihued primary key davhtsan gsn aldaa garsan ued cart_info-iin quantity-iig n update hiine
CREATE TABLE cart_info (
	order_detail_id INT,
	part_id INT,
	quantity INT NOT NULL,
	PRIMARY KEY (order_detail_id, part_id),
	FOREIGN KEY (order_detail_id) REFERENCES order_detail(order_detail_id),
	FOREIGN KEY (part_id) REFERENCES part(part_id) 
);

CREATE TABLE customer_order (
	receipt_number INT PRIMARY KEY AUTO_INCREMENT,
	tax_rate DECIMAL(3,3),
	tax_amount DECIMAL(15,2),
	order_detail_id INT,
	FOREIGN KEY (order_detail_id) REFERENCES order_detail(order_detail_id)
);

