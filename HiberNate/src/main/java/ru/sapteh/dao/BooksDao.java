package ru.sapteh.dao;

public interface BooksDao <Books, Key>{
     void create(Books books);
     Books read(Key key);
     void update(Books books);
     void delete(Books books);
}
