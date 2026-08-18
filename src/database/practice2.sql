DROP DATABASE IF NOT EXISTS practice2;
CREATE DATABASE practice2;
USE practice2;
CREATE TABLE members (
    member_id INT PRIMARY KEY AUTO_INCREMENT,
    member_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    join_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    is_active BOOLEAN DEFAULT TRUE
);
CREATE TABLE products (
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(100) NOT NULL,
    price INT UNSIGNED NOT NULL,
    stock INT NOT NULL DEFAULT 0,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE orders (
    order_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    member_id INT,
    order_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    total_price INT UNSIGNED NOT NULL,
    FOREIGN KEY (member_id) REFERENCES members(member_id)
);
CREATE TABLE order_items (
    item_id INT PRIMARY KEY AUTO_INCREMENT,
    order_id BIGINT,
    product_id INT,
    quantity INT DEFAULT 1,
    price INT UNSIGNED NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);
CREATE TABLE students (
    student_id VARCHAR(10) PRIMARY KEY,
    student_name VARCHAR(30) NOT NULL,
    major VARCHAR(50),
    grade TINYINT UNSIGNED,
    enrolled_date DATE
);
CREATE TABLE employees (
    emp_id INT PRIMARY KEY AUTO_INCREMENT,
    emp_name VARCHAR(40) NOT NULL,
    salary INT UNSIGNED NOT NULL,
    hire_date DATE NOT NULL,
    department VARCHAR(50)
);
CREATE TABLE boards (
    board_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(200) NOT NULL,
    content TEXT NOT NULL,
    writer_id INT,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (writer_id) REFERENCES members(member_id)
);
CREATE TABLE comments (
    comment_id INT PRIMARY KEY AUTO_INCREMENT,
    board_id INT,
    writer_id INT,
    content VARCHAR(300) NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (board_id) REFERENCES boards(board_id),
    FOREIGN KEY (writer_id) REFERENCES members(member_id)
);
CREATE TABLE payments (
    payment_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    order_id BIGINT,
    payment_amount INT UNSIGNED NOT NULL,
    payment_method VARCHAR(30),
    payment_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (order_id) REFERENCES orders(order_id)
);
CREATE TABLE reviews (
    review_id INT PRIMARY KEY AUTO_INCREMENT,
    product_id INT,
    member_id INT,
    rating TINYINT UNSIGNED NOT NULL,
    review_text TEXT,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (product_id) REFERENCES products(product_id),
    FOREIGN KEY (member_id) REFERENCES members(member_id)
);