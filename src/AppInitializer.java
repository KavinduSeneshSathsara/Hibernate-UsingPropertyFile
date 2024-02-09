import config.SessionFactoryConfig;
import entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AppInitializer {
    public static void main(String[] args) {
        Session session = SessionFactoryConfig.getInstance().getSession();

        Transaction transaction = session.beginTransaction();
        Employee employee = new Employee(0001, "Kavindu", "Tangalle", 150000);
        session.save(employee);
        transaction.commit();
        session.close();
    }
}
