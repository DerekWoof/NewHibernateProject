import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {
    public static void main( String[] args ) {

        SessionFactory factoryOfParticipants = SessionFactoryManager.getSessionFactory();
        Session session = factoryOfParticipants.openSession();
        Transaction transaction = session.beginTransaction();

        Participant person = new Participant(1, "Zenek", "Zenowski");
        session.save(person);
        Participant person1 = new Participant(2, "Janusz", "Januszowski");
        session.save(person1);

        //Person person2 = session.get(Person.class, 1);

        transaction.commit();
        session.close();

        System.out.println(person + " " + person1);

        factoryOfParticipants.close();

    }
}
