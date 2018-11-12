import repository.HibernateImpl;

public class main {
    public static void main(String[] args) {
//        ApplicationContext ctx =
//                new ClassPathXmlApplicationContext("WEB-INF/spring-config.xml");
//        DBrepository uc =  ctx.getBean(DBrepository.class);
//
//        uc.getAll();
    HibernateImpl df = new HibernateImpl();
    df.getAll().forEach(x -> System.out.println(x));

    }
}
