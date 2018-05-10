package implementation.hibernate;

import abstraction.interfaces.PersistencePerson;
import abstraction.model.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PersistenceHibernate implements PersistencePerson {

    @Override
    public void save(Person pessoa) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dsp-persistencePU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(pessoa);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void list() {
        System.out.println("List init");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dsp-persistencePU");
        EntityManager em = emf.createEntityManager();
        List<Person> l = em.createQuery("from Person", Person.class).getResultList();
        
        for (Person p : l) {
            System.out.println("Id: " + p.getId() + "Nome: " + p.getName() + " Adress: " + p.getAdress() 
                    + " Phone: " + p.getPhone() + " Email: " + p.getEmail());
        }
        em.close();
        
        System.out.println("List end");
    }
    
}
