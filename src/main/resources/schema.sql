create table user
(
    id         int auto_increment,
    first_name varchar(255) NOT NULL,
    last_name  varchar(255) NOT NULL,
);

insert into user(id, first_name, last_name) values ( 1,'Tuan', 'Pham' )