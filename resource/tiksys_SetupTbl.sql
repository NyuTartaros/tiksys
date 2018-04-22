create database tiksys;
use tiksys;

create table ticketRecord (
	time datetime,
    name varchar(20),
    phoneNo varchar(20),
    haveMeal bool
);

create table train (
	time datetime,
    remainTicketNum int
);

insert into train values('2017-12-16 8:00:00',100);
insert into train values('2017-12-16 9:00:00',100);
insert into train values('2017-12-16 10:00:00',100);
insert into train values('2017-12-16 11:00:00',100);
insert into train values('2017-12-16 12:00:00',100);
insert into train values('2017-12-16 13:00:00',100);
insert into train values('2017-12-16 14:00:00',100);
insert into train values('2017-12-16 15:00:00',100);
insert into train values('2017-12-16 16:00:00',100);
insert into train values('2017-12-16 17:00:00',100);
insert into train values('2017-12-16 18:00:00',100);
insert into train values('2017-12-16 19:00:00',100);
insert into train values('2017-12-16 20:00:00',100);
insert into train values('2017-12-16 21:00:00',100);
insert into train values('2017-12-16 22:00:00',100);

insert into train values('2017-12-17 8:00:00',100);
insert into train values('2017-12-17 9:00:00',100);
insert into train values('2017-12-17 10:00:00',100);
insert into train values('2017-12-17 11:00:00',100);
insert into train values('2017-12-17 12:00:00',100);
insert into train values('2017-12-17 13:00:00',100);
insert into train values('2017-12-17 14:00:00',100);
insert into train values('2017-12-17 15:00:00',100);
insert into train values('2017-12-17 16:00:00',100);
insert into train values('2017-12-17 17:00:00',100);
insert into train values('2017-12-17 18:00:00',100);
insert into train values('2017-12-17 19:00:00',100);
insert into train values('2017-12-17 20:00:00',100);
insert into train values('2017-12-17 21:00:00',100);
insert into train values('2017-12-17 22:00:00',100);