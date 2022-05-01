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
('Liza2', current_date),
('Liza3', current_date),
('Liza4', current_date),
('Liza5', current_date),
('Liza6', current_date),
('Liza7', current_date),
('Liza8', current_date),
('Liza9', current_date),
('Liza10', current_date),
('Liza11', current_date),
('Inna', current_date);

drop table if exists users;
create table users (
    id bigserial primary key,
    email varchar(255),
    password varchar(255),
    create_date timestamp
);
insert into users (email, password, create_date) values
('angelicalis39@mail.ru', '12345', current_date),
('lastochkanya@mail.ru', 'qwerty', current_date);

drop table if exists orders;
create table orders (
    id bigserial primary key,
    client_id bigint references clients(id),
    price decimal,
    create_date timestamp
);
insert into orders (client_id, price, create_date) values
(5, '199.0', current_date),
(3, '35.5', current_date),
(2, '87.25', current_date),
(2, '13.7', current_date),
(2, '100.0', current_date),
(1, '180.0', current_date);
