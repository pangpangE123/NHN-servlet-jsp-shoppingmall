use nhn_academy_26;

CREATE TABLE users (
                       user_id VARCHAR(50) NOT NULL,
                       user_name VARCHAR(10) NOT NULL,
                       user_password VARCHAR(200) NOT NULL,
                       user_birth VARCHAR(8) NOT NULL,
                       user_auth INT NOT NULL,
                       user_point INT NOT NULL,
                       created_at DATETIME NOT NULL,
                       latest_login_at DATETIME DEFAULT NULL,
                       PRIMARY KEY (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='회원';

CREATE TABLE role (
                      role_id INT NOT NULL AUTO_INCREMENT,
                      role_name ENUM('ADMIN', 'USER') NOT NULL,
                      PRIMARY KEY (role_id)
);

INSERT INTO role (role_name) VALUES ('ADMIN'), ('USER');

CREATE TABLE product (
                         product_id INT NOT NULL AUTO_INCREMENT,
                         product_name VARCHAR(50) NOT NULL,
                         product_price INT NOT NULL,
                         product_description TEXT NULL,
                         PRIMARY KEY (product_id)
);

CREATE TABLE category (
                          category_id INT NOT NULL AUTO_INCREMENT,
                          category_name VARCHAR(20) NOT NULL,
                          PRIMARY KEY (category_id)
);

CREATE TABLE product_classification (
                                        product_id INT NOT NULL,
                                        category_id INT NOT NULL,
                                        PRIMARY KEY (product_id, category_id)
);

CREATE TABLE cart (
                      cart_id INT NOT NULL AUTO_INCREMENT,
                      user_id VARCHAR(50) NOT NULL,
                      PRIMARY KEY (cart_id)
);

CREATE TABLE cart_product (
                              cart_in_product_id BIGINT NOT NULL AUTO_INCREMENT,
                              count INT NOT NULL,
                              cart_id INT NOT NULL,
                              product_id INT NOT NULL,
                              PRIMARY KEY (cart_in_product_id)
);

CREATE TABLE orders (
                        order_id BIGINT NOT NULL AUTO_INCREMENT,
                        orderdate DATETIME NOT NULL,
                        order_price INT NOT NULL,
                        user_id VARCHAR(50) NOT NULL,
                        address_id BIGINT NOT NULL,
                        PRIMARY KEY (order_id)
);

CREATE TABLE order_product (
                               order_product_id BIGINT NOT NULL AUTO_INCREMENT,
                               order_id BIGINT NOT NULL,
                               product_id INT NOT NULL,
                               order_price INT NOT NULL,
                               order_count INT NOT NULL,
                               PRIMARY KEY (order_product_id)
);

CREATE TABLE address (
                         address_id BIGINT NOT NULL AUTO_INCREMENT,
                         address VARCHAR(255) NOT NULL,
                         user_id VARCHAR(50) NOT NULL,
                         PRIMARY KEY (address_id)
);

CREATE TABLE product_image (
                               product_image_id BIGINT NOT NULL AUTO_INCREMENT,
                               product_image_path VARCHAR(300) NOT NULL,
                               product_image_name VARCHAR(50) NOT NULL,
                               product_id INT NOT NULL,
                               PRIMARY KEY (product_image_id)
);

CREATE TABLE point_saved_date (
                                  point_saved_date_id BIGINT NOT NULL AUTO_INCREMENT,
                                  saved_date DATETIME NOT NULL,
                                  saved_reason VARCHAR(100) NOT NULL,
                                  user_id VARCHAR(50) NOT NULL,
                                  PRIMARY KEY (point_saved_date_id)
);

CREATE TABLE point_used_date (
                                 point_used_date_id BIGINT NOT NULL AUTO_INCREMENT,
                                 used_date DATETIME NOT NULL,
                                 user_id VARCHAR(50) NOT NULL,
                                 PRIMARY KEY (point_used_date_id)
);

-- Foreign Key Constraints
ALTER TABLE users ADD CONSTRAINT FK_role_TO_users FOREIGN KEY (user_auth) REFERENCES role (role_id);
ALTER TABLE product_classification ADD CONSTRAINT FK_product_TO_product_classification FOREIGN KEY (product_id) REFERENCES product (product_id);
ALTER TABLE product_classification ADD CONSTRAINT FK_category_TO_product_classification FOREIGN KEY (category_id) REFERENCES category (category_id);
ALTER TABLE cart ADD CONSTRAINT FK_users_TO_cart FOREIGN KEY (user_id) REFERENCES users (user_id);
ALTER TABLE cart_product ADD CONSTRAINT FK_cart_TO_cart_product FOREIGN KEY (cart_id) REFERENCES cart (cart_id);
ALTER TABLE cart_product ADD CONSTRAINT FK_product_TO_cart_product FOREIGN KEY (product_id) REFERENCES product (product_id);
ALTER TABLE orders ADD CONSTRAINT FK_users_TO_order FOREIGN KEY (user_id) REFERENCES users (user_id);
ALTER TABLE orders ADD CONSTRAINT FK_address_TO_order FOREIGN KEY (address_id) REFERENCES address (address_id);
ALTER TABLE order_product ADD CONSTRAINT FK_order_TO_order_product FOREIGN KEY (order_id) REFERENCES orders (order_id);
ALTER TABLE order_product ADD CONSTRAINT FK_product_TO_order_product FOREIGN KEY (product_id) REFERENCES product (product_id);
ALTER TABLE address ADD CONSTRAINT FK_users_TO_address FOREIGN KEY (user_id) REFERENCES users (user_id);
ALTER TABLE product_image ADD CONSTRAINT FK_product_TO_product_image FOREIGN KEY (product_id) REFERENCES product (product_id);
ALTER TABLE point_saved_date ADD CONSTRAINT FK_users_TO_point_saved_date FOREIGN KEY (user_id) REFERENCES users (user_id);
ALTER TABLE point_used_date ADD CONSTRAINT FK_users_TO_point_used_date FOREIGN KEY (user_id) REFERENCES users (user_id);
