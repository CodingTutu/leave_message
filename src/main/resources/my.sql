create table admin(
    a_id int primary key auto_increment,
    a_name varchar(100),
    a_password varchar(100)
)default charset = utf8;

create table article(
    r_id int primary key auto_increment,
    r_author varchar(100),
    r_summary varchar(100),
    r_content text,
    r_date varchar(100),
    r_verify int,
    r_publish int,
    r_status int
)default charset = utf8;

insert into admin values(1,'admin','admin');

create table words(
  lw_id int primary key auto_increment,
  lw_name varchar(100),
  lw_date varchar(100),
  lw_content varchar(100),
  lw_for_name varchar(100),
  lw_for_article_id varchar(100)
)default charset = utf8;

create table reply(
  lr_id int primary key auto_increment,
  lr_name varchar(100),
  lr_date varchar(100),
  lr_content varchar(100),
  lr_for_name varchar(100),
  lr_for_words varchar(100),
  lr_for_article_id varchar(100)
)default charset = utf8;