drop database if exists ttms;
create database ttms;
use ttms;

create table data_dict(
   dict_id              int not null auto_increment,
   dict_parent_id       int comment '所属字典的id',
   dict_index           int not null comment '字典的序号',
   dict_name            nvarchar(200) not null comment '字典名称',
   dict_value           nvarchar(100) not null comment '字典的值',
   primary key (dict_id)
);

create table user(
   user_id               int not null auto_increment,
   user_identity         nvarchar(50) not null comment '用户身份',
   user_name             nvarchar(50) not null comment '用户name',
   user_pass             nvarchar(50) not null comment '用户密码',
   user_tel_num          nvarchar(20) comment '联系电话',
   user_addr             nvarchar(200) comment '住址',
   user_email            nvarchar(100) comment 'Email',
   user_update_time            nvarchar(100) comment 'updateTime',
   user_create_time             timestamp default now() comment '用户创建时间',
   primary key (user_id)
);

create table play(
   play_id              int not null auto_increment,
   play_type            int not null comment '剧目类型',
   play_language        int not null comment  '剧目语言',
   play_name            nvarchar(200) not null comment '剧目名称',
   play_introduction    nvarchar(2000) not null comment '剧目信息',
   play_image           longblob comment '剧目图片',
   play_duration        int not null comment '剧目时长',
   primary key (play_id)
);

create table sale(
   sale_id              int not null auto_increment,
   user_id              int comment '用户id',
   sale_time            timestamp default now() comment '创建时间',
   sale_payment         float  comment '支付金额',
   sale_refund          float  comment '找回金额',
   sale_status          int comment '订单状态如下  0：销售 1：退款',
   primary key (sale_ID)
);
create table sale_item
(
   sale_item_id         int not null auto_increment,
   ticket_id            int comment '票id',
   sale_id              int comment '所属订单id',
   sale_price           float comment '售价',
   primary key (sale_item_id)
);
create table schedule(
   schedule_id          int not null auto_increment,
   studio_id            int not null comment '所在演出厅',
   play_id              int not null comment '所属剧目',
   schedule_time        datetime not null comment '演出时间',
   schedule_price       float not null comment '票价',
   schedule_status      int not null comment '0：待安排演出  1：已安排演',
   primary key (schedule_id)
);

create table seat(
   seat_id              int not null auto_increment,
   studio_id            int not null comment '所属演出厅',
   seat_row             int not null comment '行',
   seat_column          int not null comment '列',
   seat_status          int not null comment '0:正在使用  1：未使用  2：座位损坏',
   primary key (seat_id)
);

create table studio(
   studio_id            int not null auto_increment,
   studio_name          nvarchar(100) not null comment '演出厅名',
   studio_row_count     int not null comment '总行数',
   studio_col_count     int not null comment '总列数',
   studio_introduction  varchar(2000) comment '演出厅简介',
   primary key (studio_id)
);

create table ticket(
   ticket_id               int not null auto_increment,
   seat_id                 int comment '票所属的座位',
   schedule_id             int comment '票所属的演出计划',
   ticket_price            float  comment '票价',
   ticket_status           int comment '0：待销售 1：锁定 2：卖出 3不存在',
   primary key (ticket_id)
);