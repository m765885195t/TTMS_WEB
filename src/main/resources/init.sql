drop database if exists ttms;
create database ttms;
use ttms;


create table user (
  user_id          int          not null auto_increment,
  user_identity    nvarchar(50) not null,
  user_name        nvarchar(50) not null unique,
  user_pass        nvarchar(50) not null,
  user_tel_num     nvarchar(20),
  user_addr        nvarchar(200),
  user_email       nvarchar(100),
  user_update_time timestamp,
  user_create_time timestamp             default now(),
  primary key (user_id)
);

create table play (
  play_id           int            not null auto_increment,
  play_type         int            not null,
  play_language     int            not null,
  play_name         nvarchar(200)  not null unique,
  play_introduction nvarchar(2000) not null,
  play_image        nvarchar(200),
  play_duration     int            not null,
  primary key (play_id)
);

create table sale (
  sale_id      int not null auto_increment,
  user_id      int,
  sale_time    timestamp    default now(),
  sale_payment float,
  sale_refund  float,
  sale_status  int,
  primary key (sale_ID)
);
create table sale_item
(
  sale_item_id int not null auto_increment,
  ticket_id    int,
  sale_id      int,
  sale_price   float,
  primary key (sale_item_id)
);
create table schedule (
  schedule_id     int      not null auto_increment,
  studio_id       int      not null,
  play_id         int      not null,
  schedule_time   long not null,
  schedule_price  float    not null,
  schedule_status int      not null,
  primary key (schedule_id)
);

create table seat (
  seat_id     int not null auto_increment,
  studio_id   int not null,
  seat_row    int not null,
  seat_column int not null,
  seat_status int not null,
  primary key (seat_id)
);

create table studio (
  studio_id           int           not null auto_increment,
  studio_name         nvarchar(100) not null unique,
  studio_row_count    int           not null,
  studio_col_count    int           not null,
  studio_introduction varchar(2000),
  studio_update_time  timestamp,
  studio_create_time  timestamp              default now(),
  primary key (studio_id)
);

create table ticket (
  ticket_id     int not null auto_increment,
  seat_id       int,
  schedule_id   int,
  ticket_price  float,
  ticket_status int,
  primary key (ticket_id)
);
INSERT into user (user_name, user_pass, user_identity,user_update_time, user_create_time)
VALUES ("root", "root", "1",now(),now())