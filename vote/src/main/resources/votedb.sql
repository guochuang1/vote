create database vote;
use vote;

create table voteuser(
	uid int primary key auto_increment,
	uname varchar(50),
	pwd varchar(50)
);


select *from voteuser;


create table votesubject(
	vsid int primary key auto_increment,
 	title varchar(100),
 	type int 
)

create table votepption(
	voteid int primary key,
	voteoption varchar(50),
	vsid int, 
	voteorder int
)

alter table votepption
	add constraint fk_votepption_vsid
		foreign key(vsid) references votesubject(vsid);

create table voteitem(
	viid int primary key auto_increment,
	voteid int,
	vsid int,
	uid int
)


alter table voteitem
	add constraint fk_voteitem_voteid
		foreign key(voteid) references votepption(voteid);
		
		
alter table voteitem
	add constraint fk_voteitem_vsid
		foreign key(vsid) references votesubject(vsid);
		
alter table voteitem
	add constraint fk_voteitem_uid
		foreign key(uid) references voteuser(uid);


