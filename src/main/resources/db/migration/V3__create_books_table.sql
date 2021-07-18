create table books(
   id int primary key auto_increment,
   title varchar(100) not null,
   author varchar(100) not null,
   description varchar(100) not null,
   done_date datetime null,
   done bit
);
alter table books add column category_id int null;
alter table books add foreign key (category_id) references categories (id);