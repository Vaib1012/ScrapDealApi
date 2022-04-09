drop database testdb;
create database userdb;
use userdb;
create table users(user_id bigint auto_increment,
email varchar(100) not null,
password varchar(200) not null,
username varchar(30) not null,
primary key(user_id));

drop table saved_stocks;
create table saved_stocks(stock_id bigint auto_increment,
stock_rank int,
company_name varchar(150) not null,
nse float(10,4),
bse float(10,4),
percent_profit float(10,4),
buy_from varchar(10),
saved_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
user_id bigint ,
primary key(stock_id),
foreign key(user_id) references users(user_id));