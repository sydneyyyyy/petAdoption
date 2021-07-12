
--Select Statements--
select * from customer;
select * from species;
select * from breed;
select * from pet;
select * from application;
select * from employee;
select * from status;

--Drops--
drop table status;

--Truncates--

--Alter Statements--
alter table pet add column name varchar;

alter table breed add column sid int references species(id);

alter table pet drop column sid;

alter table application drop column status;
alter table application drop column bsupapproval;
alter table application drop column secondapproval;
alter table application add column status int references status(id);

alter table pet 
alter column image type varchar(255);

alter table application add column status varchar;
alter table application add column bsupapproval boolean;
alter table application add column secondapproval boolean;

alter table employee add unique (username);

alter table customer add unique (username);

--Update Statements--
update breed 
set sid=1
where id=1;

update breed 
set sid=2
where id=2;

--Table Creation--
create table customer(
id serial primary key,
fname varchar,
lname varchar,
username varchar,
password varchar,
information varchar);

create table status(
id serial primary key,
status varchar,
approved boolean);

create table species(
id serial primary key,
sName varchar);

create table breed(
id serial primary key,
bName varchar);

create table pet(
id serial primary key,
sId int references species(id),
bId int references breed(id),
size varchar,
age int,
gender varchar,
price float,
available boolean,
image bytea);

create table application(
id serial primary key,
pId int references pet(id),
cId int references customer(id),
subDate date,
bSupApproval boolean,
secondApproval boolean,
status varchar);

create table employee(
id serial primary key,
fname varchar,
lname varchar,
username varchar,
password varchar,
sId int references species(id));

--Insert Statements--

insert into status 
values
(default, 'submitted', null),
(default, 'first approval', null),
(default, 'second approval', null),
(default, 'accepted', null),
(default, 'denied', null),
(default, 'info requested', null);

insert into species 
values
(default, 'Cat'),
(default, 'Dog'),
(default, 'Bird'),
(default, 'Fish');

insert into employee 
values
(default, 'Emmett', 'Riddle', 'eriddle', 'pass', 6),
(default, 'Gregory', 'Diaz', 'gdiaz', 'pass', 5),
(default, 'Mark', 'Mersman', 'mmersman', 'pass', 1),
(default, 'Sydney', 'Porter', 'sporter', 'pass', 2);

insert into customer 
values
(default, 'Test1', 'Test', 'test', 'password', null),
(default, 'Test2', 'Test2', 'test2', 'password', null);

insert into breed 
values 
(default,'Goldendoodle', 1),
(default,'German Shepard', 1),
(default,'Labrador Retriever', 1),
(default,'French Bulldog', 1),
(default,'Maine Coon', 2),
(default,'American Shorthair', 2),
(default,'Sphynx', 2),
(default,'Persian', 2),
(default,'Tucan', 5),
(default,'Amazon Parrot', 5),
(default,'African Grey', 5),
(default,'Cockatiel', 5),
(default,'Scarlet Macaw', 5),
(default,'Betta', 6),
(default,'Lion Fish', 6),
(default,'Clown Fish', 6),
(default,'Angel Fish', 6),
(default,'Star Fish', 6);

insert into pet --Dogs--
values
(default, 6, 'S', 4, 'M', 200, true, null, 'Stich'),
(default, 6, 'S', 1, 'F', 250, true, null, 'Molly'),
(default, 6, 'S', 8, 'F', 100, true, null, 'Sally'),
(default, 1, 'L', 2, 'M', 95, true, null, 'Forrest'),
(default, 3, 'M', 4, 'F', 100, true, null, 'Dolly'),
(default, 3, 'L', 6, 'M', 90, true, null, 'Beaux'),
(default, 3, 'M', 7, 'M', 850, true, null, 'Jack'),
(default, 5, 'L', 2, 'F', 60, true, null, 'Maple'),
(default, 5, 'L', 1, 'M', 75, true, null, 'Mac'),
(default, 5, 'XL', 3, 'F', 1000, true, null, 'Magnolia'),
(default, 4, 'XL', 9, 'M', 650, true, null, 'Tuck'),
(default, 4, 'L', 4, 'F', 250, true, null, 'Jenny'),
(default, 4, 'XL', 1, 'M', 290, true, null, 'Bubba');

insert into pet --Cats--
values
(default, 2, 'S', 4, 'M', 200, true, null, 'Tom'),
(default, 2, 'S', 1, 'F', 250, true, null, 'Betty'),
(default, 7, 'S', 8, 'F', 100, true, null, 'Sammy'),
(default, 7, 'S', 2, 'M', 95, true, null, 'Jerry'),
(default, 7, 'M', 4, 'F', 100, true, null, 'Lil Kitty'),
(default, 8, 'S', 6, 'M', 90, true, null, 'Jo'),
(default, 8, 'M', 7, 'M', 850, true, null, 'George'),
(default, 8, 'S', 2, 'F', 60, true, null, 'Mel'),
(default, 9, 'S', 100, 'M', 75, true, null, 'Bob'),
(default, 9, 'M', 312, 'F', 1000, true, null, 'Maggy'),
(default, 9, 'S', 89, 'M', 650, true, null, 'Allen'),
(default, 10, 'S', 4, 'F', 250, true, null, 'Janice'),
(default, 10, 'S', 4, 'F', 250, true, null, 'Nan'),
(default, 10, 'M', 1, 'M', 290, true, null, 'Bruce');

insert into pet --Birds--
values
(default, 11, 'S', 4, 'M', 200, true, null, 'Sam'),
(default, 11, 'S', 1, 'F', 250, true, null, 'Polly'),
(default, 11, 'S', 8, 'F', 100, true, null, 'Marge'),
(default, 12, 'S', 2, 'M', 95, true, null, 'Jared'),
(default, 12, 'M', 4, 'F', 100, true, null, 'Lilly'),
(default, 12, 'S', 6, 'M', 90, true, null, 'Jim'),
(default, 13, 'M', 7, 'M', 850, true, null, 'Greg'),
(default, 13, 'S', 2, 'F', 60, true, null, 'Milly'),
(default, 13, 'S', 2, 'M', 75, true, null, 'Rob'),
(default, 14, 'M', 2, 'F', 1000, true, null, 'Minnie'),
(default, 14, 'S', 9, 'M', 650, true, null, 'Alex'),
(default, 14, 'S', 4, 'F', 250, true, null, 'Jan'),
(default, 15, 'S', 4, 'F', 250, true, null, 'Nantucket'),
(default, 15, 'S', 4, 'F', 250, true, null, 'Cally'),
(default, 15, 'M', 1, 'M', 290, true, null, 'Bravo');

insert into pet --Fish--
values
(default, 16, 'L', 4, 'M', 200, true, null, 'Flounder'),
(default, 16, 'S', 1, 'F', 250, true, null, 'Ariel'),
(default, 16, 'L', 8, 'F', 100, true, null, 'Doll'),
(default, 17, 'S', 2, 'M', 95, true, null, 'Sebastian'),
(default, 17, 'M', 4, 'F', 100, true, null, 'Lilly'),
(default, 17, 'S', 6, 'M', 90, true, null, 'Triton'),
(default, 18, 'M', 7, 'M', 850, true, null, 'Eric'),
(default, 18, 'S', 2, 'F', 60, true, null, 'Ursela'),
(default, 18, 'S', 2, 'M', 75, true, null, 'Hook'),
(default, 19, 'M', 2, 'F', 1000, true, null, 'Wendy'),
(default, 19, 'S', 9, 'M', 650, true, null, 'Peter'),
(default, 19, 'S', 4, 'F', 250, true, null, 'Jane'),
(default, 20, 'L', 4, 'F', 250, true, null, 'Jill'),
(default, 20, 'S', 4, 'F', 250, true, null, 'Sarah'),
(default, 20, 'M', 1, 'M', 290, true, null, 'Jaws');


--Delete Statements--
delete from species where id=3;
delete from species where id=4;

