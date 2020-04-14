drop table if exists EMPLOYER;
drop table if exists DEPARTMENT;

create table EMPLOYER (
    ID int auto_increment primary key,
    FULLNAME varchar(250) not null,
    SALARY decimal(20, 2) not null,
    DEPARTMENTID int not null
);

create table DEPARTMENT (
     ID int auto_increment primary key,
     NAME varchar(250) not null,
     CHIEFID int not null
);