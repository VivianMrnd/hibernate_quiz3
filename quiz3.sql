create database q3;
use q3;

-------------- list ----------------------------------------------------
create table personDetail(
p_id int primary key auto_increment,
lastname varchar(255) not null,
firstname varchar(255) not null,
middlename varchar(255)  null,
age int not null
);

create table barangay(
b_id int primary key auto_increment,
bname varchar(100),
idx int,
p_id int
);

-------------- Map ----------------------------------------------------
create table personDetail(
p_id int primary key auto_increment,
lastname varchar(255) not null,
firstname varchar(255) not null,
middlename varchar(255)  null,
age int not null
);

create table barangay(
b_id int primary key auto_increment,
street varchar(100),
bname varchar(100),
p_id int
);

-------------- set ----------------------------------------------------
create table personDetail(
p_id int primary key auto_increment,
lastname varchar(255) not null,
firstname varchar(255) not null,
middlename varchar(255)  null,
age int not null
);

create table barangay(
b_id int primary key auto_increment,
bname varchar(100),
p_id int
);

-------------- many to many ----------------------------------------------------
create table personDetail(
id int primary key auto_increment,
lastname varchar(255) not null,
firstname varchar(255) not null,
middlename varchar(255)  null,
age int not null
);

create table barangay(
id int primary key auto_increment,
bname varchar(100)
);

create table person_location(
persons_id int,
barangays_id int,
foreign key(persons_id) references persondetail(id),
foreign key(barangays_id) references barangay(id)
);

-------------- one to many ----------------------------------------------------
create table personDetail(
id int primary key auto_increment,
lastname varchar(255) not null,
firstname varchar(255) not null,
middlename varchar(255)  null,
age int not null
);

create table barangay(
id int primary key auto_increment,
bname varchar(100),
person_id int,
CONSTRAINT fk_person_id FOREIGN KEY (person_id) REFERENCES personDetail(id)
);



-- drop table barangay;
-- drop table personDetail;
-- drop table person_location;
-- select A.lastname, B.bname, c.persons_id ,c.barangays_id from personDetail A inner join barangay B 
-- inner join person_location C where C.persons_id = A.id;
-- select A.* , B.bname from personDetail A inner join barangay B where A.id = 2;
-- select * from barangay;
-- select * from personDetail;