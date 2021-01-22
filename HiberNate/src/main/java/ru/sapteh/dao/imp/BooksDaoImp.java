package ru.sapteh.dao.imp;

import com.sun.istack.NotNull;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.sapteh.dao.BooksDao;
import ru.sapteh.model.Books;

public class BooksDaoImp implements BooksDao<Books, Integer> {
    private final SessionFactory factory;

    public BooksDaoImp(SessionFactory factory){
        this.factory=factory;
    }


    public void create(@NotNull final Books books) {
        try(final Session session = factory.openSession()){
            session.beginTransaction();
            session.save(books);
            session.getTransaction().commit();
        }
    }


    public Books read(@NotNull final Integer id) {
        try(final Session session = factory.openSession()){
            final Books result = session.get(Books.class, id);
            return result != null ? result : new Books();
        }
    }

    public void update(@NotNull final Books books) {
        try(final Session session = factory.openSession()){
            session.beginTransaction();
            session.update(books);
            session.getTransaction().commit();
        }
    }

    public void delete(@NotNull final Books books) {
        try(final Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(books);
            session.getTransaction().commit();
        }
    }

}
