create or replace view article_info
(article_id, author_id, editor_id, module_id, article_title, article_intro, add_time, author_name, author_avatar_link, like_num)
as
select a.article_id, a.author_id, a.editor_id, a.module_id, a.article_title, a.article_intro, a.add_time, au.user_name, au.user_avatar_link, count(u.like_id) from article as a left join user as au on a.author_id = au.user_id left join user_like_article as u on a.article_id = u.article_id group by a.article_id;

create or replace view comment_info
(comment_id,content,add_time,like_num,article_id,user_id,user_name,user_avatar_link)
as
select c.comment_id,c.content,c.add_time,c.like_num,c.article_id,u.user_id,u.user_name,u.user_avatar_link from comment as c left join user as u on c.user_id = u.user_id;


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





