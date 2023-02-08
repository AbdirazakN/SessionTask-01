package peaksoft.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import org.hibernate.HibernateException;
import peaksoft.config.HiberConfig;
import peaksoft.models.Address;
import peaksoft.models.Country;
import peaksoft.models.Programmer;
import peaksoft.repository.ProgrammerRepository;

import java.util.List;

public class ProgrammerRepositoryImpl implements ProgrammerRepository {
    private EntityManager entityManager = HiberConfig.getEntityManager();

    @Override
    public String saveProgrammer(Programmer programmer) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(programmer);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return programmer.getFullName() + " The saved...";
    }

    @Override
    public String saveMoreProgrammers(List<Programmer> programmers) {
        try {
            entityManager.getTransaction().begin();
            for (Programmer programmer : programmers) {
                entityManager.persist(programmer);
            }
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return programmers.get(1)+" The saved...";
    }

    @Override
    public List<Programmer> getAllProgrammers() {
        List<Programmer> programmers = null;
        try {
            entityManager.getTransaction().begin();
            programmers = entityManager.createQuery("from Programmer ").getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return programmers;
    }

    @Override
    public Programmer findById(Long id) {
        Programmer programmer = null;
        try {
            entityManager.getTransaction().begin();
            programmer = entityManager.find(Programmer.class,id);
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return programmer;
    }

    @Override
    public Programmer removeById(Long id) {
        Programmer programmer = null;
        try {
            entityManager.getTransaction().begin();
            programmer = entityManager.find(Programmer.class,id);
            entityManager.remove(programmer);
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return programmer;
    }

    @Override
    public String removeAllProgrammers() {
        int deleteFromProgrammers = 0;
        try {
            entityManager.getTransaction().begin();
            deleteFromProgrammers = entityManager.createQuery("delete from Programmer ").executeUpdate();
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return deleteFromProgrammers+" programmers deleted...";
    }

    @Override
    public Programmer update(Long id, Programmer programmer) {
        Programmer programmer1 = null;
        try {
            entityManager.getTransaction().begin();
            programmer1 = entityManager.createQuery("from Programmer where id = :id", Programmer.class).setParameter("id", id).getSingleResult();
            programmer1.setFullName(programmer.getFullName());
            programmer1.setEmail(programmer.getEmail());
            programmer1.setStatus(programmer.getStatus());
            programmer1.setLocation(programmer.getLocation());
            programmer1.setDateOfBirth(programmer.getDateOfBirth());
            programmer1.setProjects(programmer.getProjects());
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return programmer1;
    }

    @Override
    public List<Programmer> findProgrammersByCountry(String country) {
        List<Programmer> programmers = null;
        try {
            entityManager.getTransaction().begin();
            programmers = entityManager.createQuery("from Programmer where location=Address.programmer").getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return programmers;
    }

    @Override
    public Programmer findYoungProgrammer() {
        Programmer programmer = null;
        try {
            entityManager.getTransaction().begin();
            programmer = (Programmer) entityManager.createQuery("select p from Programmer p order by dateOfBirth limit 1").getSingleResult();
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return programmer;
    }

    @Override
    public Programmer findOldProgrammer() {
        Programmer programmer = null;
        try {
            entityManager.getTransaction().begin();
            programmer = (Programmer) entityManager.createQuery("select p from Programmer p order by dateOfBirth desc limit 1").getSingleResult();
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return programmer;
    }
}
