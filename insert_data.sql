use yourheadline;



insert into user values(1, 'author0', '123456', 'author', '', '1999-01-01', 'male', '666@gmail.com', '12345678901', '2019-11-14');
insert into user values(2, 'author1', '123456', 'author', '', '1999-01-01', 'male', '666@gmail.com', '12345678901', '2019-11-14');
insert into user values(3, 'editor0', '123456', 'editor', '', '1999-01-01', 'male', '666@gmail.com', '12345678901', '2019-11-14');
insert into user values(4, 'editor1', '123456', 'editor', '', '1999-01-01', 'male', '666@gmail.com', '12345678901', '2019-11-14');
insert into user values(5, 'newauthor0', '123456', 'unchecked_author', '', '1999-01-01', 'male', '666@gmail.com', '12345678901', '2019-11-14');
insert into user values(6, 'newauthor1', '123456', 'unchecked_author', '', '1999-01-01', 'male', '666@gmail.com', '12345678901', '2019-11-14');
insert into user values(7, 'tom', '123456', 'normal', '', '1999-01-01', 'male', '666@gmail.com', '12345678901', '2019-11-14');
insert into user values(8, 'jerry', '123456', 'normal', '', '1999-01-01', 'male', '666@gmail.com', '12345678901', '2019-11-14');




insert into editor_worker values(3, 1);
insert into editor_worker values(4, 2);



insert into editor_authorize_author values(1, 3, '2019-11-14');
insert into editor_authorize_author values(2, 3, '2019-11-14');



insert into author_apply values(5, '2019-11-14', '');
insert into author_apply values(6, '2019-11-14', '');





insert into module values(null, '科技', '');
insert into module values(null, '电影', '');
insert into module values(null, '游戏', '');




insert into article values(null, 1, 3, 1, "模块1文章1", "文章简介",  "啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊", '', '2019-11-14');
insert into article values(null, 1, 3, 1, "模块1文章2", "文章简介",  "啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊", '', '2019-11-14');
insert into article values(null, 1, 3, 2, "模块2文章1", "文章简介",  "啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊", '', '2019-11-14');
insert into article values(null, 1, 3, 2, "模块2文章2", "文章简介",  "啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊", '', '2019-11-14');
insert into article values(null, 1, 3, 2, "模块2文章3", "文章简介",  "啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊", '', '2019-11-14');
insert into article values(null, 1, 3, 3, "模块3文章1", "文章简介",  "啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊", '', '2019-11-14');








insert into article_unchecked values(null, 1, 3, "模块3未审核文章1", '简介',  "啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊", '2019-11-14');
insert into article_unchecked values(null, 1, 3, "模块3未审核文章2", '简介',  "啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊", '2019-11-14');
insert into article_unchecked values(null, 1, 2, "模块2未审核文章1", '简介',  "啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊", '2019-11-14');







insert into comment values(null, "111111111111111111111111111111噢噢噢噢噢噢噢噢噢噢噢噢噢噢噢噢哦哦哦", '2019-11-14', null, 1, 1);
insert into comment values(null, "2222222222222222222222222222噢噢噢噢噢噢噢噢噢噢噢噢噢噢噢噢哦哦哦", '2019-11-14', null, 1, 1);
insert into comment values(null, "333333333333333333333333333噢噢噢噢噢噢噢噢噢噢噢噢噢噢噢噢哦哦哦", '2019-11-14', null, 1, 1);
insert into comment values(null, "44444444444444444444444噢噢噢噢噢噢噢噢噢噢噢噢噢噢噢噢哦哦哦", '2019-11-14', null, 1, 1);
insert into comment values(null, "5555555555555555555555555噢噢噢噢噢噢噢噢噢噢噢噢噢噢噢噢哦哦哦", '2019-11-14', null, 1, 1);





insert into user_chase_key values (null, 1, "啊", null, '2019-11-14');
insert into user_chase_key values (null, 1, "3", null, '2019-11-14');
insert into user_chase_key values (null, 1, "2", null, '2019-11-14');




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