package io.github.book_base.repository;

import io.github.book_base.HibernateUtil;
import io.github.book_base.model.User;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class UserRepository {
    public List<User> findAll(){
        var session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        var result = session.createQuery("from User", User.class).list();
        session.getTransaction().commit();
        session.close();
        return result;
    }
    public Optional<User>findOne(Integer id){
        var session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        var result = session.get(User.class , id);
        session.getTransaction().commit();
        session.close();
        return Optional.ofNullable(result);
    }
    public Optional<User>findByNameAndPassword(String name, String password){
        var session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query<User> query = session.createQuery("from User where name= :name and password= :password", User.class);
        query.setParameter("name", name);
        query.setParameter("password", password);
        var result = query.getSingleResult();
        session.getTransaction().commit();
        session.close();
        return Optional.ofNullable(result);
    }
}
