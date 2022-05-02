drop table if exists clients;
create table clients (
    id bigserial primary key,
    name varchar(255),
    create_date timestamp
);
insert into clients (name, create_date) values
('Kirill', current_date),
('Valera', current_date),
('Vikrotia', current_date),
('Elizabet', current_date),
('Inna', current_date);

-- ##########################################################
drop table if exists users;
create table users (
    id bigserial primary key,
    name varchar(255),
    email varchar(255),
    password varchar(255),
    role varchar(255),
    create_date timestamp
);
insert into users (email, name, password, create_date) values
('angelicalis39@mail.ru',   'Kira',     '$2a$12$jmcmMdbO8KXDJf7vTO1a7eAiPD23r4LhmhsaTJyKIpfUQQMq.S76i',    current_date), --12345
('neverendingsky@mail.ru',  'Anonimus', '$2a$12$jhbHNaWNvWugwA2pcUjG4OOU2SKPV9ktahA4HAL.bD2dff3y9RxNG',  current_date), --root123
('lastochkanya@mail.ru',    'Inna',     '$2a$12$aJ1f0eTpBzJzIlHtPgq2ueiJIESscz1vBYBAG0M/yOxRJRDdcm4ZW',   current_date); --qwerty

-- ##########################################################
drop table if exists roles;
create table roles (
    id bigserial primary key,
    name varchar(63) not null
);
insert into roles (name) values
('ROLE_GUEST'),
('ROLE_CLIENT'),
('ROLE_ADMIN');

-- ##########################################################
drop table if exists users_roles;
create table users_roles (
    user_id bigint not null,
    role_id bigint not null,
    CONSTRAINT users_roles_pkey PRIMARY KEY (user_id, role_id),
    CONSTRAINT fk_roles FOREIGN KEY (role_id)
        REFERENCES public.roles (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT fk_users FOREIGN KEY (user_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
insert into users_roles values
(1, 3),
(2, 1),
(3, 2);

-- ##########################################################
drop table if exists orders;
create table orders (
    id bigserial primary key,
    client_id bigint references clients(id),
    price decimal,
    create_date timestamp
);
insert into orders (client_id, price, create_date) values
(5, '199.0',    current_date),
(3, '35.5',     current_date),
(2, '87.25',    current_date),
(2, '13.7',     current_date),
(2, '1000.0',   current_date),
(1, '180.0',    current_date);
