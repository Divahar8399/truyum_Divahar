create database truyum_data;
use truyum_data;
create table menu_item(
id int primary key,
Name varchar(50),
Price int,
Active varchar(5),
Date_of_Launch Date,
Category varchar(100),
Free_Delivery varchar(5));
 
 /*View Menu Item List Admin (TYUC001)-a*/
insert into menu_item(id,Name,Price,Active,Date_of_Launch,Category,Free_Delivery) values(1,'Sandwich',99,'Yes','2017/03/15','Main Course','Yes');
insert into menu_item(id,Name,Price,Active,Date_of_Launch,Category,Free_Delivery) values(2,'Burger',129,'Yes','2017/12/23','Main Course','No');
insert into menu_item(id,Name,Price,Active,Date_of_Launch,Category,Free_Delivery) values(3,'Pizza',149,'Yes','2018/08/21','Main Course','No');
insert into menu_item(id,Name,Price,Active,Date_of_Launch,Category,Free_Delivery) values(4,'French Fries',57,'Yes','2017/07/02','Starters','No');
insert into menu_item(id,Name,Price,Active,Date_of_Launch,Category,Free_Delivery) values(5,'Chocalate Browine',32,'Yes','2022/11/02','Dessert','No');

/*View Menu Item List Admin (TYUC001)-b*/
select * from menu_item;

/*. View Menu Item List Customer (TYUC002)-a*/
select * from menu_item where ((year(Date_of_Launch)<=2021) and (Active like "Yes"));

/*Edit Menu Item (TYUC003)-a*/
select * from menu_item where id = 5;

/*Edit Menu Item (TYUC003)-b*/
update menu_item set Active = 'No' where id in (4);
update menu_item set Date_of_Launch = '2017/12/23' where id in (2); 

/*Add to Cart (TYUC004)*/
create table user(user_id int primary key);

insert into user values(1);
insert into user values(2);

select * from user;

create table cart(
cart_id int primary key,
user_id int,
menu_id int,
Item_Name varchar(100),
price int,
Free_Delivery varchar(10),
constraint fk1 foreign key(user_id) references user(user_id),
constraint fk2 foreign key(menu_id) references menu_item(id));

insert into cart values(1,1,2,'Burger',129,'No');
insert into cart values(2,1,5,'Chocalate Browine',32,'No');
insert into cart values(3,1,1,'Sandwich',99,'Yes');

select * from cart;

/*View Cart (TYUC005)-a*/
select c.cart_id,c.Item_Name,c.price,c.Free_Delivery from cart c join menu_item m on m.id = c.menu_id where c.user_id = 1;

/*View Cart (TYUC005)-b*/
select u.user_id,sum(c.price)Total from cart c join user u on u.user_id = c.user_id where u.user_id = 1;

/*Remove Item from Cart (TYUC006)-a*/
delete from cart where user_id =1 and menu_id = 1;

select * from cart;
