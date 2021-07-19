create table users_books(
   id int primary key auto_increment
);
alter table users_books add column user_id int null;
alter table users_books add foreign key (user_id) references users (id);

alter table users_books add column book_id int null;
alter table users_books add foreign key (book_id) references books (id);