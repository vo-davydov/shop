CREATE TABLE IF NOT EXISTS sys_user
(
    id          SERIAL PRIMARY KEY,
    username    VARCHAR(128),
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
    role        role_type,
    create_date TIMESTAMP,
    update_date TIMESTAMP
);

CREATE TABLE IF NOT EXISTS user_roles
(
    user_id bigint not null references sys_user (id),
    role_id bigint not null references sys_roles (id),
    primary key (user_id, role_id)
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
    title       VARCHAR(128),
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

CREATE TABLE IF NOT EXISTS sys_order
(
    id          SERIAL PRIMARY KEY,
    user_id     INT,
    price       NUMERIC,
    address     VARCHAR(255),
    create_date TIMESTAMP,
    update_date TIMESTAMP,
    CONSTRAINT customer_fk
        FOREIGN KEY (user_id) REFERENCES sys_user (id)
);

CREATE TABLE IF NOT EXISTS order_item
(
    id                SERIAL PRIMARY KEY,
    order_id          INT NOT NULL,
    product_id        INT NOT NULL,
    title             VARCHAR(255),
    quantity          INT DEFAULT 1,
    price_per_product NUMERIC,
    price             NUMERIC,
    create_date       TIMESTAMP,
    update_date       TIMESTAMP,
    CONSTRAINT customer_fk
        FOREIGN KEY (order_id) REFERENCES sys_order (id),
    CONSTRAINT product_fk
        FOREIGN KEY (product_id) REFERENCES sys_product (id)
);

CREATE TABLE IF NOT EXISTS sys_categories
(
    id          SERIAL PRIMARY KEY,
    title       varchar(255),
    description varchar(5000),
    create_date TIMESTAMP,
    update_date TIMESTAMP
);

CREATE TABLE IF NOT EXISTS product_categories
(
    product_id  INT NOT NULL,
    category_id INT NOT NULL,
    foreign key (product_id) references sys_product (id),
    foreign key (category_id) references sys_categories (id)
);
