drop database if exists yourheadline;
create database yourheadline default character set utf8mb4;
use yourheadline;

create table if not exists user (

user_id int not null auto_increment primary key,

user_name varchar(20) unique not null,
password varchar(20) not null,

user_avatar_link varchar(50),

birth_date date,
gender varchar(20),
	
email varchar(50),
mobile_phone varchar(20),
	
add_time date

);



create table if not exists editor (
editor_id int not null auto_increment primary key,
editor_account varchar(20) unique not null,
editor_worker_id int,
editor_password varchar(20)

);




create table if not exists author (
author_id int not null auto_increment primary key,
author_name varchar(20),
author_avatar_link varchar(50) default '',
add_time date,

authorize_editor_id int,

foreign key(authorize_editor_id) references editor(editor_id)
);





create table if not exists author_application (
id int not null auto_increment primary key,
author_name varchar(20) unique not null,
apply_time date,
application_file_link varchar(50)

);






create table if not exists module (
module_id int not null auto_increment primary key,
module_name varchar(20) unique,
photo_link varchar(50) default ''

);







create table if not exists article (

article_id int not null auto_increment primary key,

author_id int references author(author_id),
editor_id int references editor(editor_id),
module_id int references module(module_id),

article_title varchar(200),
article_intro text,
article_text text,

cover_link varchar(50),

add_time date

);





create table if not exists article_unchecked (

id int not null auto_increment primary key,

author_id int references author(author_id),
module_id int references module(module_id),

article_title varchar(200),
article_text text,

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
author_id int references author(author_id),
add_time date

);




create table if not exists user_like_comment (

like_id int not null auto_increment primary key,
user_id int references user(user_id),
comment_id int references comment(comment_id),
add_time date

);