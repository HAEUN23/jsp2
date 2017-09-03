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

select * from user;

delete from user
where user_no=7;

select * from user, board
where user.user_no = board.writer;