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

            //Get

            // Read
            System.out.println("-------------------Read--------------------");

            Session getSession = SessionFactoryConfig
                    .getInstance()
                    .getSession();

            Employee existingEmployee = getSession.get(Employee.class, 1);

            System.out.println("Existing employee : " + existingEmployee);

            System.out.println("----------------------Read Complete---------------------");

            getSession.close();


//            //Update
//
//            System.out.println("---------------------Update-----------------------");
//
//
//            Session updateSession = SessionFactoryConfig.getInstance().getSession();
//            Transaction updateTransaction =
//                   updateSession.beginTransaction();
//
//            Employee existingEmp = updateSession.get(Employee.class, 1);
//
//            existingEmp.setAddress("Colombo");
//            updateSession.update(existingEmp);
//
//            updateTransaction.commit();
//
//            System.out.println("-------------------updated-----------------------");
//
//            updateSession.close();
//
//            //Delete
//
//            System.out.println("------------------------------Delete------------------------");
//
//            Session deleteSession = SessionFactoryConfig.getInstance().getSession();
//
//            Transaction deleteTransaction = deleteSession.beginTransaction();
//
//            Employee deleteEmp = deleteSession.get(Employee.class, 1);
//
//            deleteSession.delete(deleteEmp);
//
//            deleteTransaction.commit();
//
//            System.out.println("---------------------Delete--------------------");
//
//            deleteSession.close();

        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
}
