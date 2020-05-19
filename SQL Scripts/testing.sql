LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/project/publishers.csv'
INTO TABLE publishers
FIELDS TERMINATED BY ',' ENCLOSED BY '"'
LINES TERMINATED BY '\n';

LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/project/authors.csv'
INTO TABLE authors
FIELDS TERMINATED BY ',' ENCLOSED BY '"'
LINES TERMINATED BY '\n';

LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/project/orders.csv'
INTO TABLE orders
FIELDS TERMINATED BY ',' ENCLOSED BY '"'
LINES TERMINATED BY '\n';

LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/project/customers.csv'
INTO TABLE customers
FIELDS TERMINATED BY ',' ENCLOSED BY '"'
LINES TERMINATED BY '\n';

LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/project/cart.csv'
INTO TABLE cart
FIELDS TERMINATED BY ',' ENCLOSED BY '"'
LINES TERMINATED BY '\n';

use bookStore;
update book set NoOfBooks = NoOfBooks + '50' where ISBN = '1';
insert into orders values (10, 6);
insert into customers (password, firstname, phone, shipaddress, type, email, username, lastname)  values ('******', 'arsany', 0120000000, 'ibnmom', 'user', '@gmail.com', 'sanyatef', 'atef');
delete from customers where firstname = 'arsany';
select * from authors where ISBN = 100;

update book natural join authors
set author = 'michael said'
where title = 'Absalom, Absalom!';

delete book, authors from (book natural join authors)
where ISBN = '2';

select * from book where title = 'olivertwist';

select * from book where NoOfBooks < 20;