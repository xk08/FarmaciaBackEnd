create table Drug (
	id bigint not null auto_increment,
    title varchar(200) not null,
    price varchar(50) not null,
    imageURL varchar(300) not null, 
    amount varchar(50) not null,
    primary key (id)
) ; 