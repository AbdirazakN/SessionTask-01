package peaksoft.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import peaksoft.config.HiberConfig;
import peaksoft.models.Address;
import peaksoft.repository.AddressRepository;

import java.util.List;

public class AddressRepositoryImpl implements AddressRepository,AutoCloseable {
//    private EntityManagerFactory entityManagerFactory = HiberConfig.entityManagerFactory();
    private EntityManager entityManager = HiberConfig.getEntityManager();
    @Override
    public String saveAddress(Address address) {
        try {
//            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(address);
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return address.getRegionName()+" The saved...";
    }

    @Override
    public String saveMoreAddresses(List<Address> addresses) {
        try {
            entityManager.getTransaction().begin();
            for (Address address : addresses) {
                entityManager.persist(address);
            }
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return " The saved...";
    }

    @Override
    public List<Address> getAllAddresses() {
        List<Address> addresses = null;
        try {
            entityManager.getTransaction().begin();
            addresses = entityManager.createQuery("from Address").getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return addresses;
    }

    @Override
    public Address findById(Long id) {
        Address address = null;
        try {
            entityManager.getTransaction().begin();
            address = entityManager.createQuery("select a from Address a where id = :id", Address.class).setParameter("id",id).getSingleResult();
//            address = entityManager.find(Address.class,id);
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return address;
    }

    @Override
    public Address removeById(Long id) {
        Address address = null;
        try {
            entityManager.getTransaction().begin();
            address = entityManager.createQuery("select a from Address a where id = :id", Address.class).setParameter("id",id).getSingleResult();
            entityManager.createQuery("delete from Address where id = :id", Address.class).setParameter("id",id);

//            address = entityManager.find(Address.class,id);
//            entityManager.remove(address);          // With remove method
            entityManager.getTransaction().commit();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
            entityManager.close();
        }
        return address;
    }

    @Override
    public String removeAllAddresses() {
        int deleteFromAddress = 0;
        try {
            entityManager.getTransaction().begin();
            deleteFromAddress = entityManager.createQuery("delete from Address").executeUpdate();
            entityManager.getTransaction().commit();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
            entityManager.close();
        }
        return deleteFromAddress+" address deleted...";
    }

    @Override
    public Address update(Long id, Address address) {
        Address address2 = null;
        try {
            entityManager.getTransaction().begin();
            address2 = entityManager.createQuery("from Address where id = :id", Address.class).setParameter("id", id).getSingleResult();
            address2.setRegionName(address.getRegionName());
            address2.setStreet(address.getStreet());
            address2.setHomeNumber(address.getHomeNumber());
            address2.setCountry(address.getCountry());
            address2.setProgrammer(address.getProgrammer());
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return address2;
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
    }
}
