create table activityList
(
	activityName varchar(100)  not null,
	pCount int not null,
	startTime timestamp  not null,
	endTime timestamp  not null,
	finalTime timestamp  not null,
	id int primary not null
);

create table activityDetail
(
	id  int primary,
	 name varchar(40),
	foreign key(id) references activityList(id)
);