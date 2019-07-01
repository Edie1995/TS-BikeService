/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projekt2;

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
public class ServiceDao {

    @PersistenceUnit(name = "newUnit")
    public EntityManagerFactory emFactory;

    public void save(Service service) {
        EntityManager entityManager = emFactory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(service);
        tx.commit();
        entityManager.close();
    }

    public User get(Long id) {
        EntityManager entityManager = emFactory.createEntityManager();
        User user = entityManager.find(User.class, id);
        entityManager.close();
        return user;
    }

    public List<Service> getAll() {
        EntityManager entityManager = emFactory.createEntityManager();
        List<Service> services = entityManager.createQuery("from Service u order by u.id", Service.class).getResultList();
        entityManager.close();
        return services;
    }

    public List<Service> getAllForUser(String username) {
        EntityManager entityManager = emFactory.createEntityManager();
        List<Service> services = entityManager.createQuery("from Service where username = ?", Service.class).setParameter(1, username).getResultList();
        entityManager.close();
        return services;
    }

    public void remove(String user, String data) {
        EntityManager entityManager = emFactory.createEntityManager();
        Service service = entityManager.createQuery("from Service s where s.username like ? and s.data like ?", Service.class).setParameter(1, user).setParameter(2, data).getSingleResult();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Service serviceRemove = entityManager.find(Service.class, service.getId());
        entityManager.remove(serviceRemove);
        tx.commit();
        entityManager.close();
    }

    public void modify(String name, String data) {
        EntityManager entityManager = emFactory.createEntityManager();
        Service service = entityManager.createQuery("from Service where name like ?", Service.class).setParameter(1, name).getSingleResult();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Service serObj = (Service) entityManager.find(Service.class, service.getId());
        serObj.setData(data);
        tx.commit();
        entityManager.close();
    }

}
