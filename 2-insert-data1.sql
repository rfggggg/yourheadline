use yhl;



insert into user values(1, 'author0', '123456', 'author', '', '1999-01-01', 'male', '666@gmail.com', '12345678901', '2019-11-14');
insert into user values(2, 'author1', '123456', 'author', '', '1999-01-01', 'male', '666@gmail.com', '12345678901', '2019-11-14');
insert into user values(3, 'editor0', '123456', 'editor', '', '1999-01-01', 'male', '666@gmail.com', '12345678901', '2019-11-14');
insert into user values(4, 'editor1', '123456', 'editor', '', '1999-01-01', 'male', '666@gmail.com', '12345678901', '2019-11-14');
insert into user values(5, 'newauthor0', '123456', 'author', '', '1999-01-01', 'male', '666@gmail.com', '12345678901', '2019-11-14');
insert into user values(6, 'newauthor1', '123456', 'author', '', '1999-01-01', 'male', '666@gmail.com', '12345678901', '2019-11-14');
insert into user values(7, 'tom', '123456', 'normal', '', '1999-01-01', 'male', '666@gmail.com', '12345678901', '2019-11-14');
insert into user values(8, 'jerry', '123456', 'normal', '', '1999-01-01', 'male', '666@gmail.com', '12345678901', '2019-11-14');




insert into editor values(3, 1);
insert into editor values(4, 2);



insert into author values(1, 3, '2019-11-14', '', '', '', 1, '2019-12-2');
insert into author values(2, 3, '2019-11-14', '', '', '', 0, '2019-12-2');

insert into author values(5, null, null, '', '', '', 0, '2019-12-1');
insert into author values(6, null, null, '', '', '', 0, '2019-12-1');





insert into module values(null, '科技', '');
insert into module values(null, '电影', '');
insert into module values(null, '游戏', '');




insert into article_unchecked values(null, 1, null, 3, "一篇文章-1", '简介',  "啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊", "", '2019-11-14');
insert into article_unchecked values(null, 1, null, 3, "一篇文章-2", '简介',  "啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊", "", '2019-11-14');
insert into article_unchecked values(null, 1, null, 2, "一篇文章-3", '简介',  "啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊", "", '2019-11-14');







insert into comment values(1, "文章不错", '2019-11-14', 1, 1, 1);
insert into comment values(2, "噢噢噢噢噢噢噢噢哦哦哦", '2019-11-14', 1, 1, 1);
insert into comment values(3, "文章内容丰富，文字水平高blabla", '2019-11-14', 1, 1, 1);
insert into comment values(4, "挺好", '2019-11-14', 2, 1, 1);
insert into comment values(5, "啊啊啊啊啊啊啊啊啊啊啊啊噢噢噢噢噢噢噢噢噢噢噢噢噢噢噢噢哦哦哦", '2019-11-14', 2, 1, 1);





insert into viewed values(null, 1, 1, '2019-11-14');
insert into viewed values(null, 1, 2, '2019-11-14');
insert into viewed values(null, 1, 3, '2019-11-14');
insert into viewed values(null, 1, 4, '2019-11-14');



insert into collect values (null, 1, 1, '2019-11-14');
insert into collect values (null, 1, 3, '2019-11-14');
insert into collect values (null, 1, 2, '2019-11-14');



insert into user_like_article values (null, 1, 1, '2019-11-22');
insert into user_like_article values (null, 1, 2, '2019-11-22');
insert into user_like_article values (null, 1, 3, '2019-11-22');
insert into user_like_article values (null, 1, 4, '2019-11-22');
insert into user_like_article values (null, 1, 5, '2019-11-22');
insert into user_like_article values (null, 1, 6, '2019-11-22');
insert into user_like_article values (null, 2, 1, '2019-11-22');
insert into user_like_article values (null, 2, 2, '2019-11-22');
insert into user_like_article values (null, 2, 3, '2019-11-22');
insert into user_like_article values (null, 2, 4, '2019-11-22');
insert into user_like_article values (null, 2, 5, '2019-11-22');
insert into user_like_article values (null, 3, 1, '2019-11-22');
insert into user_like_article values (null, 3, 2, '2019-11-22');
insert into user_like_article values (null, 3, 3, '2019-11-22');
insert into user_like_article values (null, 3, 4, '2019-11-22');
insert into user_like_article values (null, 4, 1, '2019-11-22');


insert into follow values (null, 1, 2, '2019-11-14');
insert into follow values (null, 5, 1, '2019-11-14');
insert into follow values (null, 5, 2, '2019-11-14');



insert into user_like_comment values (null, 1, 1, "2019-11-14");
insert into user_like_comment values (null, 1, 2, "2019-11-14");
insert into user_like_comment values (null, 1, 3, "2019-11-14");