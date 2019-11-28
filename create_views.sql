create or replace view article_info
<<<<<<< HEAD
(article_id, author_id, editor_id, module_id, article_title, article_intro, add_time, author_name, author_avatar_link, like_num)
as
select a.article_id, a.author_id, a.editor_id, a.module_id, a.article_title, a.article_intro, a.add_time, au.user_name, au.user_avatar_link, count(u.like_id) from article as a left join user as au on a.author_id = au.user_id left join user_like_article as u on a.article_id = u.article_id group by a.article_id;
=======
(article_id, author_id, editor_id, module_id, article_title, article_intro, add_time, cover_link, author_name, author_avatar_link, like_num)
as
select a.article_id, a.author_id, a.editor_id, a.module_id, a.article_title, a.article_intro, a.add_time, cover_link, au.user_name, au.user_avatar_link, count(u.like_id) from article as a left join user as au on a.author_id = au.user_id left join user_like_article as u on a.article_id = u.article_id group by a.article_id;
>>>>>>> xy




DROP PROCEDURE IF EXISTS select_collection_by_user_id;
delimiter //
create procedure select_collection_by_user_id(in p_uid Integer)
Begin
select * from article_info where article_id in 
(select article_id from collect where user_id = p_uid);
end //
delimiter ;



DROP PROCEDURE IF EXISTS select_history_by_user_id;
delimiter //
create procedure select_history_by_user_id(in p_uid Integer)
Begin
select * from article_info where article_id in 
(select article_id from viewed where user_id = p_uid);
end //
delimiter ;

<<<<<<< HEAD
=======
create or replace view user_like_author_info
(follow_id,user_id,author_id, author_name, author_avatar_link, add_time,follow_num)
as
select f.follow_id,f.user_id,author_like.author_id, author_like.author_name, author_like.author_avatar_link, author_like.add_time, author_like.follow_num
 from follow as f
 left join
 (select a.user_id, a.user_name, a.user_avatar_link, a.add_time, count(ff.author_id)
 from follow as ff left join user as a on ff.author_id = a.user_id group by ff.author_id)
 as author_like(author_id, author_name, author_avatar_link, add_time,follow_num)
 on f.author_id=author_like.author_id ;
>>>>>>> xy




