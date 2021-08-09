-- DBMS : oracle 11g

create table product(
	num number primary key,	
	name varchar2(30),
	price varchar2(20)
);

create sequence product_seq;
