CREATE database IF NOT EXISTS  employee_database;
use employee_database;
create table if not exists  employee (emp_id int, date_of_birth datetime , name varchar(30), permanent bit(1), salary double);
insert into employee values(1,"1998-05-15","ABC",1,500000);