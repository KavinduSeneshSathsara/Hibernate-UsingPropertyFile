import config.SessionFactoryConfig;
import embedded.NameIdentifier;
import entity.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AppInitializer {
    public static void main(String[] args) {
        try {
            //save

            System.out.println("----------------save----------------");

            Session session = SessionFactoryConfig
                    .getInstance()
                    .getSession();

            Transaction transaction = session.beginTransaction();

            Employee employee = new Employee();

            employee.setId(1);

            NameIdentifier nameIdentifier = new NameIdentifier();

            nameIdentifier.setFirstName("kavindu");
            nameIdentifier.setMiddleName("senesh");
            nameIdentifier.setLastName("sathsara");

            employee.setName(nameIdentifier);
            employee.setAddress("Tangalle");
            employee.setSalary(300000);

            session.save(employee);

            transaction.commit();

            System.out.println("---------------------saved--------------------");

            session.close();

        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
}
