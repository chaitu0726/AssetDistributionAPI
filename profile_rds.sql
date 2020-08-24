use profile;
-- --------------------------------------------------------USERS TABLE -----------------------------------------------------
create table USERS(
user_id int primary key auto_increment,
first_name varchar(50),
last_name varchar(50),
email_id varchar(60),
mobile_no varchar(40),
date_of_joining varchar(40),
user_role varchar(50),
is_assets_assign varchar(10),
is_user_present,department,service varchar(10),
department varchar(30),
service varchar(50)
);
-- DIGITAl AND CLIENT SERVICES OPERATIONS
insert into USERS (user_id,first_name, last_name, email_id,mobile_no, date_of_joining,user_role,is_assets_assign,is_user_present,department,service)
 values (10101, 'Etan', 'Woliter', 'ewoliterm@zdnet.com', '9765314820','25/05/2019', 'Testing','NO','YES','Digital','Client Services Operations');
 -- Auto Increment
 insert into USERS(first_name, last_name, email_id,mobile_no, date_of_joining,user_role,is_assets_assign,is_user_present,department,service) 
 values ('Pearla', 'Mould', 'pmould0@qq.com','9765314820', '09/05/2020', 'Developer','NO','YES','Digital','Client Services Operations');
insert into USERS(first_name, last_name, email_id,mobile_no, date_of_joining,user_role,is_assets_assign,is_user_present,department,service) 
values ('Kaia', 'Castello', 'kcastello1@earthlink.net','9865014420', '24/06/2019', 'HR','NO','YES','Digital','Client Services Operations');
insert into USERS(first_name, last_name, email_id,mobile_no, date_of_joining,user_role,is_assets_assign,is_user_present,department,service)
 values ('Hermy', 'Lown', 'hlown2@globo.com', '11/02/2019','9553148450', 'Finance','NO','YES','Digital','Client Services Operations');
insert into USERS(first_name, last_name, email_id,mobile_no, date_of_joining,user_role,is_assets_assign,is_user_present,department,service)
 values ('Marylou', 'Jelleman', 'mjelleman3@flavors.me','9123456720', '20/12/2019', 'Developer','NO','YES','Digital','Client Services Operations');
insert into USERS(first_name, last_name, email_id,mobile_no, date_of_joining,user_role,is_assets_assign,is_user_present,department,service) 
values ('Jilly', 'Blabie', 'jblabie4@shop-pro.jp','9698532140', '13/10/2018', 'Testing','NO','YES','Digital','Client Services Operations');
insert into USERS(first_name, last_name, email_id,mobile_no, date_of_joining,user_role,is_assets_assign,is_user_present,department,service)
 values ('Lexine', 'Breeds', 'lbreeds5@whitehouse.gov','9764578035', '25/01/2019', 'Finance','NO','YES','Digital','Client Services Operations');
insert into USERS(first_name, last_name, email_id,mobile_no, date_of_joining,user_role,is_assets_assign,is_user_present,department,service)
 values ('Pepi', 'Blaisdell', 'pblaisdell6@uiuc.edu','8736442820', '07/05/2019', 'Developer','NO','YES','Digital','Client Services Operations');
insert into USERS(first_name, last_name, email_id,mobile_no, date_of_joining,user_role,is_assets_assign,is_user_present,department,service)
 values ('Sarina', 'Ottey', 'sottey7@comcast.net', '8765320100','16/03/2020', 'Architect','NO','YES','Digital','Client Services Operations');
insert into USERS(first_name, last_name, email_id,mobile_no, date_of_joining,user_role,is_assets_assign,is_user_present,department,service) 
values ('Gothart', 'Allanby', 'gallanby8@jigsy.com','753986401', '01/09/2019', 'HR','NO','YES','Digital','Client Services Operations');
insert into USERS(first_name, last_name, email_id,mobile_no, date_of_joining,user_role,is_assets_assign,is_user_present,department,service)
 values ('Leon', 'Trusse', 'ltrusse9@cafepress.com','7789295410', '16/04/2019', 'Architect','NO','YES','Digital','Client Services Operations');

-- DIGITAl AND CLIENT SERVICES TECHNOLOGY
insert into USERS(first_name, last_name, email_id,mobile_no, date_of_joining,user_role,is_assets_assign,is_user_present,department,service) 
 values ('Gilberto', 'Jindacek','pmould0@qq.com','9765314820', '09/05/2020', 'Developer','NO','YES','Digital','Client Services Technology');
insert into USERS(first_name, last_name, email_id,mobile_no, date_of_joining,user_role,is_assets_assign,is_user_present,department,service) 
values ('Olympie', 'Ledamun', 'kcastello1@earthlink.net','9865014420', '24/06/2019', 'HR','NO','YES','Digital','Client Services Technology');
insert into USERS(first_name, last_name, email_id,mobile_no, date_of_joining,user_role,is_assets_assign,is_user_present,department,service)
 values ('Amandi', 'Coyett', 'hlown2@globo.com', '11/02/2019','9553148450', 'Finance','NO','YES','Digital','Client Services Technology');
insert into USERS(first_name, last_name, email_id,mobile_no, date_of_joining,user_role,is_assets_assign,is_user_present,department,service)
 values ('Artie', 'Wickham', 'awickhamw@360.cn','9123456720', '20/12/2019', 'Developer','NO','YES','Digital','Client Services Technology');
insert into USERS(first_name, last_name, email_id,mobile_no, date_of_joining,user_role,is_assets_assign,is_user_present,department,service) 
values ('Jilly', 'Blabie', 'jblabie4@shop-pro.jp','9698532140', '13/10/2018', 'Testing','NO','YES','Digital','Client Services Technology');
insert into USERS(first_name, last_name, email_id,mobile_no, date_of_joining,user_role,is_assets_assign,is_user_present,department,service)
 values ('Dell', 'Galler', 'dgallerx@hostgator.com','9764578035', '25/01/2019', 'Finance','NO','YES','Digital','Client Services Technology');
insert into USERS(first_name, last_name, email_id,mobile_no, date_of_joining,user_role,is_assets_assign,is_user_present,department,service)
 values ('Tamas', 'Joney', 'tjoneyy@phpbb.com','8736442820', '07/05/2019', 'Developer','NO','YES','Digital','Client Services Technology');
insert into USERS(first_name, last_name, email_id,mobile_no, date_of_joining,user_role,is_assets_assign,is_user_present,department,service)
 values ('Michail', 'Tompkiss', 'mtompkissz@vistaprint.com','8765320100','16/03/2020', 'Architect','NO','YES','Digital','Client Services Technology');
insert into USERS(first_name, last_name, email_id,mobile_no, date_of_joining,user_role,is_assets_assign,is_user_present,department,service) 
values ('Stafani', 'Stoffer', 'sstoffer10@jiathis.com','753986401', '01/09/2019', 'HR','NO','YES','Digital','Client Services Technology');
insert into USERS(first_name, last_name, email_id,mobile_no, date_of_joining,user_role,is_assets_assign,is_user_present,department,service)
 values ('Kayne', 'MacCrossan', 'kmaccrossan11@si.edu','7789295410', '16/04/2019', 'Architect','NO','YES','Digital','Client Services Technology');

-- INSTITUTIONAL AND CLIENT SERVICES OPERATIONS
insert into USERS(first_name, last_name, email_id,mobile_no, date_of_joining,user_role,is_assets_assign,is_user_present,department,service) 
 values ('Carver', 'Castagne', 'ccastagne13@cbc.ca','9765314820', '09/05/2020', 'Developer','NO','YES','Institutional','Client Services Operations');
insert into USERS(first_name, last_name, email_id,mobile_no, date_of_joining,user_role,is_assets_assign,is_user_present,department,service) 
values ('Blinnie', 'Rubie', 'brubie14@buzzfeed.com','9865014420', '24/06/2019', 'HR','NO','YES','Institutional','Client Services Operations');
insert into USERS(first_name, last_name, email_id,mobile_no, date_of_joining,user_role,is_assets_assign,is_user_present,department,service)
 values ('Vivienne', 'Kelberer', 'vkelberer15@microsoft.com', '11/02/2019','9553148450', 'Finance','NO','YES','Institutional','Client Services Operations');
insert into USERS(first_name, last_name, email_id,mobile_no, date_of_joining,user_role,is_assets_assign,is_user_present,department,service)
 values ('Edd', 'Gealy', 'egealy16@altervista.org','9123456720', '20/12/2019', 'Developer','NO','YES','Institutional','Client Services Operations');
insert into USERS(first_name, last_name, email_id,mobile_no, date_of_joining,user_role,is_assets_assign,is_user_present,department,service) 
values ('Michaella', 'Down', 'mdown17@wp.com','9698532140', '13/10/2018', 'Testing','NO','YES','Institutional','Client Services Operations');
insert into USERS(first_name, last_name, email_id,mobile_no, date_of_joining,user_role,is_assets_assign,is_user_present,department,service)
 values ('Reggie', 'Eskriet', 'reskriet18@sciencedirect.com','9764578035', '25/01/2019', 'Finance','NO','YES','Institutional','Client Services Operations');
insert into USERS(first_name, last_name, email_id,mobile_no, date_of_joining,user_role,is_assets_assign,is_user_present,department,service)
 values ('Jean', 'Montgomery', 'jmontgomery19@typepad.com','8736442820', '07/05/2019', 'Developer','NO','YES','Institutional','Client Services Operations');
insert into USERS(first_name, last_name, email_id,mobile_no, date_of_joining,user_role,is_assets_assign,is_user_present,department,service)
 values ('Rozella', 'Glazer', 'rglazer1a@slideshare.net', '8765320100','16/03/2020', 'Architect','NO','YES','Institutional','Client Services Operations');
insert into USERS(first_name, last_name, email_id,mobile_no, date_of_joining,user_role,is_assets_assign,is_user_present,department,service) 
values ('Tirrell', 'Slixby', 'tslixby1b@stanford.edu','753986401', '01/09/2019', 'HR','NO','YES','Institutional','Client Services Operations');
insert into USERS(first_name, last_name, email_id,mobile_no, date_of_joining,user_role,is_assets_assign,is_user_present,department,service)
 values ('Lyn', 'Twyning', 'ltwyning1c@adobe.com','7789295410', '16/04/2019', 'Architect','NO','YES','Institutional','Client Services Operations');

-- --INSTITUTIONAL AND CLIENT SERVICES TECHNOLOGY
insert into USERS(first_name, last_name, email_id,mobile_no, date_of_joining,user_role,is_assets_assign,is_user_present,department,service) 
 values ('Curt', 'O''Collopy', 'cocollopy1o@edublogs.org','9765314820', '09/05/2020', 'Developer','NO','YES','Institutional','Client Services Technology');
insert into USERS(first_name, last_name, email_id,mobile_no, date_of_joining,user_role,is_assets_assign,is_user_present,department,service) 
values ('Dal', 'Chaplin', 'dchaplin1p@hugedomains.com','9865014420', '24/06/2019', 'HR','NO','YES','Institutional','Client Services Technology');
insert into USERS(first_name, last_name, email_id,mobile_no, date_of_joining,user_role,is_assets_assign,is_user_present,department,service)
 values ('Zsazsa', 'Whittick', 'zwhittick1q@bbc.co.uk', '11/02/2019','9553148450', 'Finance','NO','YES','Institutional','Client Services Technology');
insert into USERS(first_name, last_name, email_id,mobile_no, date_of_joining,user_role,is_assets_assign,is_user_present,department,service)
 values ('Cthrine', 'Buttel', 'cbuttel1r@psu.edu','9123456720', '20/12/2019', 'Developer','NO','YES','Institutional','Client Services Technology');
insert into USERS(first_name, last_name, email_id,mobile_no, date_of_joining,user_role,is_assets_assign,is_user_present,department,service) 
values ('Drusilla', 'Haggath', 'dhaggath1s@disqus.com','9698532140', '13/10/2018', 'Testing','NO','YES','Institutional','Client Services Technology');
insert into USERS(first_name, last_name, email_id,mobile_no, date_of_joining,user_role,is_assets_assign,is_user_present,department,service)
 values ('Avis', 'Elloy', 'aelloy1t@google.fr','9764578035', '25/01/2019', 'Finance','NO','YES','Institutional','Client Services Technology');
insert into USERS(first_name, last_name, email_id,mobile_no, date_of_joining,user_role,is_assets_assign,is_user_present,department,service)
 values ('Bradan', 'Loach', 'bloach1u@naver.com','8736442820', '07/05/2019', 'Developer','NO','YES','Institutional','Client Services Technology');
insert into USERS(first_name, last_name, email_id,mobile_no, date_of_joining,user_role,is_assets_assign,is_user_present,department,service)
 values ('Aura', 'Witherdon', 'awitherdon1v@cloudflare.com', '8765320100','16/03/2020', 'Architect','NO','YES','Institutional','Client Services Technology');
insert into USERS(first_name, last_name, email_id,mobile_no, date_of_joining,user_role,is_assets_assign,is_user_present,department,service) 
values ('Ethan', 'Knee', 'eknee1w@skyrock.com','753986401', '01/09/2019', 'HR','NO','YES','Institutional','Client Services Technology');
insert into USERS(first_name, last_name, email_id,mobile_no, date_of_joining,user_role,is_assets_assign,is_user_present,department,service)
 values ('Luke', 'Varian', 'lvarian1x@trellian.com','7789295410', '16/04/2019', 'Architect','NO','YES','Institutional','Client Services Technology');


 select*from USERS;
 
 -- --------------------------------------------------LOGIN TABLE -------------------------------------------
 create table LOGIN(
 login_id int primary key auto_increment,
 username varchar(50),
 password varchar(50),
 role varchar(30)
 );
 
 
insert into LOGIN(username,password,role)
values('admin1','admin1','DG_CSO');
 
insert into LOGIN(username,password,role)
values('admin2','admin2','DG_CST');
 
insert into LOGIN(username,password,role)
values('admin3','admin3','IN_CSO');
 
insert into LOGIN(username,password,role)
values('admin4','admin4','IN_CST');

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

--
insert into LOGIN(username,password,role)
values('10112','10112','user');
insert into LOGIN(username,password,role)
values('10113','10113','user');
insert into LOGIN(username,password,role)
values('10114','10114','user');
insert into LOGIN(username,password,role)
values('10115','10116','user');
insert into LOGIN(username,password,role)
values('10116','10116','user');
insert into LOGIN(username,password,role)
values('10117','10117','user');
insert into LOGIN(username,password,role)
values('10118','10118','user');
insert into LOGIN(username,password,role)
values('10119','10119','user');
insert into LOGIN(username,password,role)
values('10120','10120','user');

insert into LOGIN(username,password,role)
values('10121','10121','user');
insert into LOGIN(username,password,role)
values('10122','10122','user');
insert into LOGIN(username,password,role)
values('10123','10123','user');
insert into LOGIN(username,password,role)
values('10124','10124','user');
insert into LOGIN(username,password,role)
values('10125','10125','user');
insert into LOGIN(username,password,role)
values('10126','10126','user');
insert into LOGIN(username,password,role)
values('10127','10127','user');
insert into LOGIN(username,password,role)
values('10128','10128','user');
insert into LOGIN(username,password,role)
values('10129','10129','user');
insert into LOGIN(username,password,role)
values('10130','10130','user');

values('10131','10131','user');
insert into LOGIN(username,password,role)
values('10132','10132','user');
insert into LOGIN(username,password,role)
values('10133','10133','user');
insert into LOGIN(username,password,role)
values('10134','10134','user');
insert into LOGIN(username,password,role)
values('10135','10135','user');
insert into LOGIN(username,password,role)
values('10136','10136','user');
insert into LOGIN(username,password,role)
values('10137','10137','user');
insert into LOGIN(username,password,role)
values('10138','10138','user');
insert into LOGIN(username,password,role)
values('10139','10139','user');
insert into LOGIN(username,password,role)
values('10140','10140','user');
insert into LOGIN(username,password,role)
values('10141','10141','user');
select*from LOGIN;
 -- ---------------------------------------------------------------------------------------------------
 -- ------------------------------------ASSETS TABLE ----------------------------------------------------------
 
 create table ASSETS(
 assets_id int primary key auto_increment,
 asset_key varchar(50),
 assigned int,
 available int,
 total,asset_type int,
 asset_type varchar(70)
 );
 
insert into ASSETS(asset_key,assigned,available,total,asset_type)values('MN1',100,600,700,'Monitor');
insert into ASSETS(asset_key,assigned,available,total,asset_type)values('MN2',200,200,400,'Monitor');
insert into ASSETS(asset_key,assigned,available,total,asset_type)values('MN3',300,300,600,'Monitor');
insert into ASSETS(asset_key,assigned,available,total,asset_type)values('MN4',400,400,800,'Monitor');
insert into ASSETS(asset_key,assigned,available,total,asset_type)values('MN5',500,200,700,'Monitor');
insert into ASSETS(asset_key,assigned,available,total,asset_type)values('CPU1',150,630,780,'CPU');
insert into ASSETS(asset_key,assigned,available,total,asset_type)values('CPU2',100,600,700,'CPU');
insert into ASSETS(asset_key,assigned,available,total,asset_type)values('CPU3',400,600,1000,'CPU');
insert into ASSETS(asset_key,assigned,available,total,asset_type)values('CPU4',100,100,200,'CPU');
insert into ASSETS(asset_key,assigned,available,total,asset_type)values('CPU5',150,200,350,'CPU');
insert into ASSETS(asset_key,assigned,available,total,asset_type)values('KB1',100,800,900,'Keyboard');
insert into ASSETS(asset_key,assigned,available,total,asset_type)values('KB2',100,900,1000,'Keyboard');
insert into ASSETS(asset_key,assigned,available,total,asset_type)values('MS1',100,900,1000,'Mouse');
insert into ASSETS(asset_key,assigned,available,total,asset_type)values('MS2',100,800,900,'Mouse');
insert into ASSETS(asset_key,assigned,available,total,asset_type)values('LD1',100,500,600,'Landline');
insert into ASSETS(asset_key,assigned,available,total,asset_type)values('PR1',30,70,100,'Printer');
insert into ASSETS(asset_key,assigned,available,total,asset_type)values('PR2',15,55,70,'Printer');
insert into ASSETS(asset_key,assigned,available,total,asset_type)values('HP1',100,500,600,'Headphone');
insert into ASSETS(asset_key,assigned,available,total,asset_type)values('HP2',100,500,600,'Headphone');
insert into ASSETS(asset_key,assigned,available,total,asset_type)values('LP1',100,100,200,'Laptop');
insert into ASSETS(asset_key,assigned,available,total,asset_type)values('LP2',100,100,200,'Laptop');
insert into ASSETS(asset_key,assigned,available,total,asset_type)values('LP3',100,100,200,'Laptop');
 
 select*from ASSETS;
 
 create table ASSET_KEY(
 asset_key_id int primary key auto_increment,
 asset_type varchar(70),
 asset_key varchar(50)
 );
 
insert into ASSET_KEY(asset_type,asset_key) values ('Monitor','MN');
insert into ASSET_KEY(asset_type,asset_key) values ('CPU','CPU');
insert into ASSET_KEY(asset_type,asset_key) values ('Keyboard','KB');
insert into ASSET_KEY(asset_type,asset_key) values ('Mouse','MS');
insert into ASSET_KEY(asset_type,asset_key) values ('Printer','PR');
insert into ASSET_KEY(asset_type,asset_key) values ('Landline','LD');
insert into ASSET_KEY(asset_type,asset_key) values ('Headphone','HP');
insert into ASSET_KEY(asset_type,asset_key) values ('Laptop','LP');

select*from ASSET_KEY;

-- -----------------------------------------------------------------------------------------------------------
 