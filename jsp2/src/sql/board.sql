drop table board;
create table board(
b_num int AUTO_INCREMENT primary key,
title varchar(300) not null,
content text,
reg_date datetime not null,
writer int not null
);

select * from board;

insert into board(title, content, reg_Date, writer)
values('test5','냉무2',now(),8);

update user
set name='김경훈'
where user_no=8
;

delete from user
where user_no=7;


select b.*, u.name
from user as u , board as b
where u.user_no = b.writer;

select * from board;

select * from board2;

update  board2 b2
set b2.title=
(select b1.title from board b1 where b2.b_num=b1.b_num)
;

update board
set title ='test2'
where b_num=2;