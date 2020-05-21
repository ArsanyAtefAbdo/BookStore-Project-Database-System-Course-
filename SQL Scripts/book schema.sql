Create schema bookStore;
use bookStore;

# ---------------------------------------------
# ------------------PART 1---------------------
# ---------------------------------------------
Create Table publishers (
publisher_name Varchar (100) primary key Not Null,
address Varchar(100) Not Null,
phone Varchar(100));

#----  may be change ISBN to INT -------

Create Table book (
ISBN int AUTO_INCREMENT Primary Key Not Null,
title Varchar(100) Not Null,
publisher_name Varchar (100) Not Null,
publication_year Date,
price INT default 0  Not Null,
category ENUM ('Science', 'Art', 'Religion', 'History', 'Geography'),
NoOfBooks INT default 20 Not Null,
constraint fk1 foreign key (publisher_name) references publishers (publisher_name) on delete cascade on update cascade);

Create Table authors (
ISBN int Not Null,
author Varchar(100) Not Null,
constraint pk1 primary key (ISBN, author),
constraint fk2 foreign key (ISBN) references book (ISBN) on delete cascade on update cascade);

Create Table orders (
ISBN int Primary Key Not Null,
NoOfBooks INT default 20,
constraint fk3 foreign key (ISBN) references book (ISBN) on delete cascade on update cascade);

# ---------------------------------------------
# ------------------PART 2---------------------
# ---------------------------------------------
Create Table customers (
username Varchar (10) Primary Key Not Null,
password Varchar(100) Not Null,
firstname Varchar (100) Not Null,
lastname Varchar (100) Not Null,
email Varchar (100)  Not Null,
phone Varchar(100),
shipAddress Varchar(100) Not Null,
type ENUM ('user', 'manager'));

Create Table cart (
cartid int AUTO_INCREMENT PRIMARY KEY,
username Varchar (10) Not Null,
ISBN int Not Null ,
NoOfBooks INT,
date Date Not Null);

Create Table promote (
username Varchar (10) Primary Key Not Null,
constraint fk6 foreign key (username) references customers (username) on delete cascade on update cascade);

#Drop schema bookStore;