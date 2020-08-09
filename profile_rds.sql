use profile;
-- --------------------------------------------------------USER TABLE -----------------------------------------------------
create table USER(
user_id int primary key auto_increment,
first_name varchar(50),
last_name varchar(50),
email_id varchar(60),
mobile_no varchar(40),
date_of_joining varchar(40),
department varchar(50),
is_assets_assign varchar(10),
is_user_present varchar(10)
);

insert into USER (user_id,first_name, last_name, email_id,mobile_no, date_of_joining, department,is_assets_assign,is_user_present)
 values (10101, 'Etan', 'Woliter', 'ewoliterm@zdnet.com', '9765314820','25/05/2019', 'Testing','NO','YES');
 -- Auto Increment
 insert into USER(first_name, last_name, email_id,mobile_no, date_of_joining, department,is_assets_assign,is_user_present) 
 values ('Pearla', 'Mould', 'pmould0@qq.com','9765314820', '09/05/2020', 'Developer','NO','YES');
insert into USER(first_name, last_name, email_id,mobile_no, date_of_joining, department,is_assets_assign,is_user_present) 
values ('Kaia', 'Castello', 'kcastello1@earthlink.net','9865014420', '24/06/2019', 'HR','NO','YES');
insert into USER(first_name, last_name, email_id,mobile_no, date_of_joining, department,is_assets_assign,is_user_present)
 values ('Hermy', 'Lown', 'hlown2@globo.com', '11/02/2019','9553148450', 'Finance','NO','YES');
insert into USER(first_name, last_name, email_id,mobile_no, date_of_joining, department,is_assets_assign,is_user_present)
 values ('Marylou', 'Jelleman', 'mjelleman3@flavors.me','9123456720', '20/12/2019', 'Developer','NO','YES');
insert into USER(first_name, last_name, email_id,mobile_no, date_of_joining, department,is_assets_assign,is_user_present) 
values ('Jilly', 'Blabie', 'jblabie4@shop-pro.jp','9698532140', '13/10/2018', 'Testing','NO','YES');
insert into USER(first_name, last_name, email_id,mobile_no, date_of_joining, department,is_assets_assign,is_user_present)
 values ('Lexine', 'Breeds', 'lbreeds5@whitehouse.gov','9764578035', '25/01/2019', 'Finance','NO','YES');
insert into USER(first_name, last_name, email_id,mobile_no, date_of_joining, department,is_assets_assign,is_user_present)
 values ('Pepi', 'Blaisdell', 'pblaisdell6@uiuc.edu','8736442820', '07/05/2019', 'Developer','NO','YES');
insert into USER(first_name, last_name, email_id,mobile_no, date_of_joining, department,is_assets_assign,is_user_present)
 values ('Sarina', 'Ottey', 'sottey7@comcast.net', '8765320100','16/03/2020', 'Architect','NO','YES');
insert into USER(first_name, last_name, email_id,mobile_no, date_of_joining, department,is_assets_assign,is_user_present) 
values ('Gothart', 'Allanby', 'gallanby8@jigsy.com','753986401', '01/09/2019', 'HR','NO','YES');
insert into USER(first_name, last_name, email_id,mobile_no, date_of_joining, department,is_assets_assign,is_user_present)
 values ('Leon', 'Trusse', 'ltrusse9@cafepress.com','7789295410', '16/04/2019', 'Architect','NO','YES');
 
 select*from USER;
 
 -- --------------------------------------------------LOGIN TABLE -------------------------------------------
 create table LOGIN(
 login_id int primary key auto_increment,
 username varchar(50),
 password varchar(50),
 role varchar(30)
 );
 
 
 insert into LOGIN(username,password,role)
 values('admin','admin','admin');
 
insert into LOGIN(username,password,role)
values('10101','10101','user');
insert into LOGIN(username,password,role)
values('10102','10102','user');
insert into LOGIN(username,password,role)
values('10103','10103','user');
insert into LOGIN(username,password,role)
values('10104','10104','user');
insert into LOGIN(username,password,role)
values('10105','10105','user');
insert into LOGIN(username,password,role)
values('10106','10106','user');
insert into LOGIN(username,password,role)
values('10107','10107','user');
insert into LOGIN(username,password,role)
values('10108','10108','user');
insert into LOGIN(username,password,role)
values('10109','10109','user');
insert into LOGIN(username,password,role)
values('10110','10110','user');
insert into LOGIN(username,password,role)
values('10111','10111','user');

select*from LOGIN;
 -- ---------------------------------------------------------------------------------------------------
 -- ------------------------------------ASSETS TABLE ----------------------------------------------------------
 
 create table ASSETS(
 assets_id int primary key auto_increment,
 asset_key varchar(50),
 assigned int,
 available int,
 total int
 );
 
insert into ASSETS(asset_key,assigned,available,total)values('MN01',100,600,700);
insert into ASSETS(asset_key,assigned,available,total)values('MN02',200,200,400);
insert into ASSETS(asset_key,assigned,available,total)values('MN03',300,300,600);
insert into ASSETS(asset_key,assigned,available,total)values('MN04',400,400,800);
insert into ASSETS(asset_key,assigned,available,total)values('MN05',500,200,700);
insert into ASSETS(asset_key,assigned,available,total)values('CPU01',150,630,780);
insert into ASSETS(asset_key,assigned,available,total)values('CPU02',100,600,700);
insert into ASSETS(asset_key,assigned,available,total)values('CPU03',400,600,1000);
insert into ASSETS(asset_key,assigned,available,total)values('CPU04',100,100,200);
insert into ASSETS(asset_key,assigned,available,total)values('CPU05',150,200,350);
insert into ASSETS(asset_key,assigned,available,total)values('KB01',100,800,900);
insert into ASSETS(asset_key,assigned,available,total)values('KB02',100,900,1000);
insert into ASSETS(asset_key,assigned,available,total)values('MS01',100,900,1000);
insert into ASSETS(asset_key,assigned,available,total)values('MS02',100,800,900);
insert into ASSETS(asset_key,assigned,available,total)values('LD01',100,500,600);
insert into ASSETS(asset_key,assigned,available,total)values('PR01',30,70,100);
insert into ASSETS(asset_key,assigned,available,total)values('PR02',15,55,70);
insert into ASSETS(asset_key,assigned,available,total)values('HP01',100,500,600);
insert into ASSETS(asset_key,assigned,available,total)values('HP02',100,500,600);
insert into ASSETS(asset_key,assigned,available,total)values('LP01',100,100,200);
insert into ASSETS(asset_key,assigned,available,total)values('LP02',100,100,200);
insert into ASSETS(asset_key,assigned,available,total)values('LP03',100,100,200);
 
 select*from ASSETS;
-- -----------------------------------------------------------------------------------------------------------
 