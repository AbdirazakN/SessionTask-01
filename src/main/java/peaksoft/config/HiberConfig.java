package peaksoft.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import peaksoft.models.Address;
import peaksoft.models.Country;
import peaksoft.models.Programmer;
import peaksoft.models.Project;

import java.util.Properties;

public class HiberConfig {
    public static EntityManager getEntityManager(){
        Configuration configuration = new Configuration();
        configuration.setProperty(Environment.DRIVER,"org.postgresql.Driver");
        configuration.setProperty(Environment.URL, "jdbc:postgresql://localhost:5432/postgres02");
        configuration.setProperty(Environment.USER,"postgres");
        configuration.setProperty(Environment.PASS,"postgres00");
        configuration.setProperty(Environment.SHOW_SQL,"true");
        configuration.setProperty(Environment.HBM2DDL_AUTO,"update");
        configuration.setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL9Dialect");

        configuration.addAnnotatedClass(Address.class);
        configuration.addAnnotatedClass(Country.class);
        configuration.addAnnotatedClass(Programmer.class);
        configuration.addAnnotatedClass(Project.class);
        System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<| CONNECTED TO DATABASE... |>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
        return configuration.buildSessionFactory().createEntityManager();
    }

    public static EntityManagerFactory entityManagerFactory(){
        Properties properties = new Properties();
        properties.setProperty(Environment.DRIVER, "org.postgresql.Driver");
        properties.setProperty(Environment.URL, "jdbc:postgresql://localhost:5432/postgres02");
        properties.setProperty(Environment.USER, "postgres");
        properties.setProperty(Environment.PASS, "postgres00");
        properties.setProperty(Environment.HBM2DDL_AUTO, "update");
        properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty(Environment.SHOW_SQL, "true");
        properties.setProperty(Environment.FORMAT_SQL, "true");

        Configuration configuration = new Configuration();
        configuration.addProperties(properties);
        configuration.addAnnotatedClass(Programmer.class);
        configuration.addAnnotatedClass(Address.class);
        configuration.addAnnotatedClass(Country.class);
        configuration.addAnnotatedClass(Project.class);

        return configuration.buildSessionFactory().unwrap(EntityManagerFactory.class);
    }
}
