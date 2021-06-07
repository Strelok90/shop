create table products
(
    id         identity primary key,
    title      varchar(128),
    price      int,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

insert into products(title, price)
values ('Product_1', 10),
       ('Product_2', 20),
       ('Product_3', 30),
       ('Product_4', 40),
       ('Product_5', 50),
       ('Product_6', 60),
       ('Product_7', 70),
       ('Product_8', 80),
       ('Product_9', 90),
       ('Product_10', 100),
       ('Product_11', 110),
       ('Product_12', 120),
       ('Product_13', 130),
       ('Product_14', 140),
       ('Product_15', 150),
       ('Product_16', 160),
       ('Product_17', 170),
       ('Product_18', 180),
       ('Product_19', 190),
       ('Product_20', 200),
       ('Product_21', 210)
;

create table users
(
    id         bigserial primary key,
    username   varchar(50) unique,
    password   varchar(100),
    enabled    boolean,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp


);
insert into users(username, password, enabled)
values ('user1', '{noop}123', 1),
       ('user2', '{noop}123', 1),
       ('user3', '{noop}123', 1);

CREATE TABLE authorities
(
    username  varchar(50) NOT NULL,
    authority varchar(50) NOT NULL,

    UNIQUE KEY authorities_idx_1 (username, authority),

    CONSTRAINT authorities_ibfk_1
        FOREIGN KEY (username)
            REFERENCES users (username)
);

INSERT INTO authorities
VALUES ('user1', 'ROLE_ADMIN'),
       ('user2', 'ROLE_MANAGER'),
       ('user3', 'ROLE_USER');

create table order_items
(
    id             bigserial primary key,
    title          varchar(255),
    quantity       int,
    price_per_item int,
    price          int
);