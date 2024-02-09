package config;

import entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SessionFactoryConfig {
    private static SessionFactoryConfig factoryConfig;
    private SessionFactoryConfig(){}

    public static SessionFactoryConfig getInstance(){
        return (null == factoryConfig) ? factoryConfig = new SessionFactoryConfig() : factoryConfig;
    }

    public Session getSession() {
        try {
            Properties properties = new Properties();
            InputStream inputStream = SessionFactoryConfig.class.getClassLoader().getResourceAsStream("hibernate.properties");
            properties.load(inputStream);
            Configuration configuration = new org.hibernate.cfg.Configuration();
            configuration.setProperties(properties);

            configuration.addAnnotatedClass(Employee.class);
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            return sessionFactory.openSession();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
