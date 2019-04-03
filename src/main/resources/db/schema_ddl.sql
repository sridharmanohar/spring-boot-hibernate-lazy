create table company (
id int(4) not null auto_increment primary key,
name varchar(40) not null
)

create table employee (
id int(4) not null auto_increment primary key,
name varchar(40) not null,
company_id int(4) not null,
foreign key (company_id) references company(id)
)

create table product (
id int(4) not null auto_increment primary key,
name varchar(40) not null,
company_id int(4) not null,
foreign key (company_id) references company(id)
)
