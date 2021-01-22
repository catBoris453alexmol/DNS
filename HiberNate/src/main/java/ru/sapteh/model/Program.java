package ru.sapteh.model;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.dao.BooksDao;
import ru.sapteh.dao.imp.BooksDaoImp;


public class Program {
    public static void main(String[] args) {

        SessionFactory factory = null;

        try {

            factory = new Configuration().configure().buildSessionFactory();

            BooksDao<Books, Integer> booksDao = new BooksDaoImp(factory);

//            BooksDao<Books, Integer> booksDao = new BooksDaoImp(factory);

            //Insert value to database
            final Books books = booksDao.read(2);

            booksDao.create(new Books("das", "dsads", "dasds"));
//
//            final Books result = booksDao.read(1);
//            System.out.println("===============================>");
//            System.out.println("Created : " + result);
//            System.out.println();
//
//            result.setName("ddasd");
//            result.setAutor("ssss");
//            result.setPublisher("doooty");
//
            //update
            books.setId(5);
            booksDao.update(books);

            final Books update = new Books();
            System.out.println("===============================>");
            System.out.println("Created : " + update);
            System.out.println();
            books.setName("ddasd");
            books.setAutor("ssss");
            books.setPublisher("doooty");


            //delete
            booksDao.delete(booksDao.read(1));

            System.out.println("===============================>");
            System.out.println("Delete(empty obj) : " + booksDao.read(1));
            System.out.println();


        } finally {
            if(factory != null) {
                factory.close();
            }
        }


    }
}