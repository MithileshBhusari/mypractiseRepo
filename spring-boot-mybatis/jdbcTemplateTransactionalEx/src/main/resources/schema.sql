drop table USER if exists;

create table USER(Id serial,Name varchar(14),Dept varchar(10) NOT NULL,Salary bigint);