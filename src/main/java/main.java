import model.Assessment;
import model.Person;
import model.Restaurant;
import org.hibernate.Session;
import repository.HibernateSessionFactory.HibernateSessionFactory;
import repository.HibernateSessionFactory.SessionFactoryPersonRepo;

import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) {
        HibernateSessionFactory hsf = new HibernateSessionFactory();
//        SessionFactoryPersonRepo sf = new SessionFactoryPersonRepo(hsf);
//        Person person = sf.getByEmail("wer@qwer.ty");
//        Person person = sf.getByID(100029);
//        System.out.println(person.getPerson_name());
//        System.out.println(person.getEmail());

//        List<Integer> ass = Arrays.asList(1,2,3,4,5,6);
//        Double res = ass.stream()
//        .mapToInt(x -> x)
//        .average()
//        .orElse(0.0);
//        System.out.println(res);


        Session session = hsf.getSession();
        List<Restaurant> restaurants = null;
        try {
            session.beginTransaction();
            restaurants = session.createQuery("FROM Restaurant").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.flush();
        session.close();

    }
}
