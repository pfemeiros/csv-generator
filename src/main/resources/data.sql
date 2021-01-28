drop table if exists student;

create table student(
    id int auto_increment,
    name varchar(255),
    birth_date date,
    address varchar(255)
);

insert into student(id, name, birth_date, address) values (1, 'Pedro', '2000-01-01', 'Rua 1');
insert into student(id, name, birth_date, address) values (2, 'Maria', '2001-01-01', 'Rua 2');
insert into student(id, name, birth_date, address) values (3, 'Ana', '2002-01-01', 'Rua 3');
insert into student(id, name, birth_date, address) values (4, 'Paulo', '2003-01-01', 'Rua 4');
insert into student(id, name, birth_date, address) values (5, 'Fabiana', '2004-01-01', 'Rua 5');