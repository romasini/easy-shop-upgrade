CREATE TABLE categories (
    id serial PRIMARY KEY,
    title VARCHAR(255) NOT NULL
);

CREATE TABLE products (
    id bigserial PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    price INT,
    category_id INT NOT NULL REFERENCES categories(id)
    );

CREATE TABLE roles (
    id serial PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE users (
    id bigserial PRIMARY KEY,
    username VARCHAR(30) NOT NULL,
    password VARCHAR(80) NOT NULL,
    email    VARCHAR(50) UNIQUE
);

CREATE TABLE users_roles(
    user_id bigint NOT NULL REFERENCES users(id),
    role_id int NOT NULL REFERENCES roles(id),
    PRIMARY KEY(user_id, role_id)
);

CREATE TABLE profiles(
    id bigserial PRIMARY KEY,
    user_id bigint REFERENCES users(id),
    firstname VARCHAR(255),
    lastname VARCHAR(255),
    phone VARCHAR(150),
    email VARCHAR(150),
    birthdate date,
    sex char(1) default 'x',
    address VARCHAR(255)
);

CREATE TABLE orders (
    id bigserial PRIMARY KEY,
    user_id bigint REFERENCES users(id),
    customer_name VARCHAR(255),
    customer_phone VARCHAR(255),
    customer_address VARCHAR(255) ,
    price INT);

CREATE TABLE order_items (
    id bigserial PRIMARY KEY,
    product_id bigint REFERENCES products(id),
    order_id bigint REFERENCES orders(id),
    quantity INT,
    price INT,
    price_per_product INT);

INSERT INTO roles(name)
VALUES
('ROLE_ADMIN'),
('ROLE_MANAGER'),
('ROLE_CUSTOMER');

INSERT INTO users (username, password, email)
VALUES
('admin','$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'admin@market.ru'),
('manager1','$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'manager1@market.ru');

INSERT INTO users_roles(user_id, role_id)
VALUES
(1,1),
(2,2);

INSERT INTO profiles(user_id, firstname, lastname, phone, email, birthdate, sex, address)
VALUES
(1, 'Peter', 'Peterson', '888999999', 'admin@market.ru', '2000-01-01', 'm', 'St.Petersburg, Nevsky prospekt, 10'),
(2, 'Andrew', 'Petrov', '878969799', 'manager1@market.ru', '1995-01-10', 'm', 'St.Petersburg, 1 line, 1');

INSERT INTO categories (title)
VALUES
('Category 1'),
('Category 2'),
('Category 3'),
('Category 4'),
('Category 5');

INSERT INTO products (title, price, category_id)
VALUES
('Prod 1', 100, 1),
('Prod 2', 200, 1),
('Prod 3', 300, 1),
('Prod 4', 400, 2),
('Prod 5', 500, 2),
('Prod 6', 600, 2),
('Prod 7', 700, 3),
('Prod 8', 800, 3),
('Prod 9', 900, 4),
('Prod 10', 1000, 4),
('Prod 11', 1100, 4),
('Prod 12', 1200, 4),
('Prod 13', 1300, 4),
('Prod 14', 1400, 4),
('Prod 15', 1500, 5),
('Prod 16', 1600, 5),
('Prod 17', 1700, 5),
('Prod 18', 1800, 5),
('Prod 19', 1900, 5),
('Prod 20', 2000, 1),
('Prod 21', 2100, 2),
('Prod 22', 2200, 3),
('Prod 23', 2300, 4),
('Prod 24', 2400, 5),
('Prod 25', 2500, 1),
('Prod 26', 2600, 2),
('Prod 27', 2700, 3),
('Prod 28', 2800, 4),
('Prod 29', 2900, 5),
('Prod 30', 3000, 1),
('Prod 31', 3100, 2),
('Prod 32', 3200, 3)
;

