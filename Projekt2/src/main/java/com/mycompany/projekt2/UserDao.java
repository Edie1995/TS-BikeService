/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projekt2;

import com.mysql.jdbc.PreparedStatement;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author kruko
 */
@Stateless
public class UserDao {

    @PersistenceUnit(name = "newUnit")
    public EntityManagerFactory emFactory;

    public void save(User user) {
        EntityManager entityManager = emFactory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(user);
        tx.commit();
        entityManager.close();
    }

    public User get(Long id) {
        EntityManager entityManager = emFactory.createEntityManager();
        User user = entityManager.find(User.class, id);
        entityManager.close();
        return user;
    }

    public List<User> getAll() {
        EntityManager entityManager = emFactory.createEntityManager();
        PreparedStatement ps;
        
        List<User> users = entityManager.createQuery("from User u order by u.id", User.class).getResultList();
        entityManager.close();
        return users;
    }

    public void remove(String login, String position) {
        EntityManager entityManager = emFactory.createEntityManager();
        User user = entityManager.createQuery("from User u where u.login like ? and u.position like ?", User.class).setParameter(1, login).setParameter(2, position).getSingleResult();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        User userRemove = entityManager.find(User.class, user.getId());
        entityManager.remove(userRemove);
        tx.commit();
        entityManager.close();
    }

    public void modify(String login, String password, String position) {
        EntityManager entityManager = emFactory.createEntityManager();
        User user = entityManager.createQuery("from User where login = ?",User.class).setParameter(1,login).getSingleResult();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        User userObj = (User)entityManager.find(User.class, user.getId());       
        userObj.setPassword(password);
        userObj.setPosition(position);
        tx.commit();
        entityManager.close();
    }

    public User checkPassword(String login, String password) {
        EntityManager entityManager = emFactory.createEntityManager();
        User user = entityManager.createQuery("from User u where login = ? and password = ?", User.class).setParameter(1, login).setParameter(2, password).getSingleResult();
        entityManager.close();
        return user;
    }

    public String getPosition(String login, String password) {
        User user = checkPassword(login, password);
        if (user != null) {
            return user.getPosition();
        } else {
            return "nie ma takiego ziomeczka";
        }
    }

}
