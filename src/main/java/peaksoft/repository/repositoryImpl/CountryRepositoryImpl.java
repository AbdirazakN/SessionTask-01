package peaksoft.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import peaksoft.config.HiberConfig;
import peaksoft.models.Address;
import peaksoft.models.Country;
import peaksoft.repository.CountryRepository;

import java.sql.SQLException;
import java.util.List;

public class CountryRepositoryImpl implements CountryRepository {
    private EntityManager entityManager = HiberConfig.getEntityManager();
    @Override
    public String saveCountry(Country country) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(country);
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return country.getCountry()+" The saved...";
    }

    @Override
    public String saveMoreCountries(List<Country> countries) {
        try {
            entityManager.getTransaction().begin();
            for (Country country : countries) {
                entityManager.persist(country);
            }
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return countries.get(1)+" The saved...";
    }

    @Override
    public List<Country> getAllCountries() {
        List<Country> countries = null;
        try {
            entityManager.getTransaction().begin();
            countries = entityManager.createQuery("from Country ").getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return countries;
    }

    @Override
    public Country findById(Long id) {
        Country country = null;
        try {
            entityManager.getTransaction().begin();
            country = entityManager.find(Country.class,id);
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return country;
    }

    @Override
    public Country removeById(Long id) {
        Country country = null;
        try {
            entityManager.getTransaction().begin();
            country = entityManager.find(Country.class,id);
            entityManager.remove(country);
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return country;
    }

    @Override
    public String removeAllCountries() {
        int deleteFromAddress = 0;
        try {
            entityManager.getTransaction().begin();
            deleteFromAddress = entityManager.createQuery("delete from Country ").executeUpdate();
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return deleteFromAddress+" country deleted...";
    }

    @Override
    public Country update(Long id, Country country) {
        Country country1 = null;
        try {
            entityManager.getTransaction().begin();
            country1 = entityManager.createQuery("from Country where id = :id", Country.class).setParameter("id", id).getSingleResult();
            country1.setAddresses(country.getAddresses());
            country1.setCountry(country.getCountry());
            country1.setDescription(country.getDescription());
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return country1;
    }

    @Override
    public Country findLongDescription() {
        Country country = null;
        try {
            entityManager.getTransaction().begin();
            country = (Country) entityManager.createQuery("select description from Country order by length(description) desc limit 1").getSingleResult();           //SELECT name FROM names ORDER BY LENGTH(name) DESC LIMIT 1
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return country;
    }

    @Override
    public int findQuantityCountry(String country) {
        int result = 0;
        try {
            entityManager.getTransaction().begin();
            result = entityManager.createQuery("select count(country) from Country where country=country").getFirstResult();
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return result;
    }
}
