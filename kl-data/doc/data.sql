drop database if exists `kl-db`;
create database `kl-db`;

use `kl-db`;
create user 'kldbuser'@'%' identified by '123456';
grant all privileges on `kl-sn-db`.* to 'kldbuser'@'%' identified by '123456';
flush privileges;

drop table if exists obj1;
create table obj1(
  id bigint not null auto_increment,
  name varchar(64) not null comment 'name',
  primary key(`id`)
)engine=innodb;

drop table if exists obj2;
create table obj2(
  id bigint not null auto_increment,
  name varchar(64) not null comment 'name',
  primary key(`id`)
)engine=innodb;