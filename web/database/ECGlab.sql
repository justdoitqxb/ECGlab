create database if not exists ECGlab default character set utf8;
drop table if exists ECGlab.ECG_user
create table if not exists ECGlab.ECG_user(
	username varchar(100) character set utf8 not null,
	password varchar(100) not null
);
insert into ECGlab.ECG_user(username, password) values('qxb', '123456');