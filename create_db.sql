drop database if exists yourheadline;
create database yourheadline default character set utf8mb4;
use yourheadline;

create table if not exists user (

user_id int not null auto_increment primary key,

user_name varchar(50) unique not null,
password varchar(50) not null,

user_type varchar(50) not null default "normal",

user_avatar_link longtext,

birth_date date default "2000-01-01",
gender varchar(20) default "",

email varchar(50) default "",
mobile_phone varchar(20) default "",

add_time date default "2000-01-01"

);



create table if not exists editor (
editor_id int primary key references user(user_id),
worker_id int default 0
);




create table if not exists author (
author_id int primary key references user(user_id),
authorized int,
authorize_editor_id int,
authorize_date date,
id_card_back longtext,
id_card_front longtext,
apply_text longtext,
apply_time date
);



create table if not exists module (
module_id int not null auto_increment primary key,
module_name varchar(20) unique,
photo_link varchar(50) default ''

);







create table if not exists article (

article_id int not null auto_increment primary key,

author_id int references user(user_id),
editor_id int references user(user_id),
module_id int references module(module_id),

article_title varchar(200),
article_intro text,
article_text longtext,

cover_link longtext,

add_time date

);





create table if not exists article_unchecked (

id int not null auto_increment primary key,

author_id int references user(user_id),
module_id int references module(module_id),

article_title varchar(200),
article_intro text,
article_text longtext,

cover_link longtext,

apply_time date

);





create table if not exists comment (

comment_id int not null auto_increment primary key,
content varchar(1024) not null,
add_time date,
like_num int default 0,

article_id int references article(article_id),
user_id int references user(user_id)

);




create table if not exists user_chase_key (

key_id int not null auto_increment primary key,
user_id int references user(user_id),
key_word varchar(20),
last_chase_time date default '2019-11-1',
add_time date

);



create table if not exists viewed (

view_id int not null auto_increment primary key,

user_id int references user(user_id),
article_id int references article(article_id),
add_time date

);



create table if not exists collect (

collect_id int not null auto_increment primary key,

user_id int references user(user_id),
article_id int references article(article_id),
add_time date

);




create table if not exists user_like_article (

like_id int not null auto_increment primary key,
user_id int references user(user_id),
article_id int references article(article_id),
add_time date

);





create table if not exists follow (

follow_id int not null auto_increment primary key,
user_id int references user(user_id),
author_id int references user(user_id),
add_time date

);




create table if not exists user_like_comment (

like_id int not null auto_increment primary key,
user_id int references user(user_id),
comment_id int references comment(comment_id),
add_time date

);
