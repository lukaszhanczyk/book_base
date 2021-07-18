package io.github.book_base.repository;

import io.github.book_base.HibernateUtil;
import io.github.book_base.model.Category;

import java.util.List;

public class CategoryRepository {
    public List<Category> findAll(){
        var session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        var result = session.createQuery("from Category", Category.class).list();
        session.getTransaction().commit();
        session.close();
        return result;
    }
}
