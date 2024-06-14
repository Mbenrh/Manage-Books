package org.example.dao;

import org.example.models.Livre;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class DaoLivre {

    private EntityManagerFactory emf;
    private EntityManager em;

    public void open() {
        emf = Persistence.createEntityManagerFactory("testjpa");
        em = emf.createEntityManager();
    }
    public void close() {
        em.close();
        emf.close();
    }


    public void create(Livre livre) {
        em.getTransaction().begin();
        em.persist(livre);
        em.getTransaction().commit();
    }

    public void update(Livre livre) {
        em.getTransaction().begin();
        em.merge(livre);
        em.getTransaction().commit();
    }

    public Livre get(Long isbn) {
        em.getTransaction().begin();
        Livre livre = em.find(Livre.class, isbn);
        em.getTransaction().commit();
        return livre;
    }

    public void delete(Livre livre) {
       // Livre livre = em.find(Livre.class, isbn);
        em.getTransaction().begin();
        em.remove(livre);
        em.getTransaction().commit();
    }

    public List<Livre> getAll() {
        em.getTransaction().begin();
        List<Livre> livres = em.createQuery("select l from Livre l", Livre.class).getResultList();
        em.getTransaction().commit();
        return livres;
    }
}
