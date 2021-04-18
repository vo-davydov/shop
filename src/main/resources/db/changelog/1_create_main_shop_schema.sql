CREATE TABLE IF NOT EXISTS sys_user
(
    id          SERIAL PRIMARY KEY,
    email       VARCHAR(128),
    phone       VARCHAR(128),
    first_name  VARCHAR(128),
    last_name   VARCHAR(128),
    patronymic  VARCHAR(128),
    password    VARCHAR(128),
    create_date TIMESTAMP,
    update_date TIMESTAMP
    );

CREATE TYPE role_type AS ENUM (
    'ROLE_ADMIN',
    'ROLE_CUSTOMER',
    'ROLE_MANAGER');

CREATE TABLE IF NOT EXISTS sys_roles
(
    id          SERIAL PRIMARY KEY,
    role        VARCHAR(128),
    user_id     INT NOT NULL,
    create_date TIMESTAMP,
    update_date TIMESTAMP,
    CONSTRAINT user_fk
    FOREIGN KEY (user_id) REFERENCES sys_user (id)
    );

CREATE TABLE IF NOT EXISTS sys_address
(
    id          SERIAL PRIMARY KEY,
    user_id     INT NOT NULL,
    address     VARCHAR(128),
    city        VARCHAR(128),
    post_code   VARCHAR(128),
    create_date TIMESTAMP,
    update_date TIMESTAMP,
    CONSTRAINT user_fk
    FOREIGN KEY (user_id) REFERENCES sys_user (id)
    );

CREATE TYPE products_status AS ENUM ('out_of_stock', 'in_stock', 'running_low');

CREATE TABLE IF NOT EXISTS sys_product
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(128),
    price       NUMERIC,
    status      products_status,
    create_date TIMESTAMP,
    update_date TIMESTAMP
    );

CREATE TABLE IF NOT EXISTS sys_order
(
    id          SERIAL PRIMARY KEY,
    user_id     INT NOT NULL,
    create_date TIMESTAMP,
    update_date TIMESTAMP
);

CREATE TABLE IF NOT EXISTS order_item
(
    user_id    INT NOT NULL,
    product_id INT NOT NULL,
    quantity   INT DEFAULT 1,
    PRIMARY KEY (user_id, product_id),
    CONSTRAINT customer_fk
    FOREIGN KEY (user_id) REFERENCES sys_user (id),
    CONSTRAINT product_fk
    FOREIGN KEY (product_id) REFERENCES sys_product (id)
    );
