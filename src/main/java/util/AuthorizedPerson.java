//package util;
//
//import model.Person;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//
//public class AuthorizedPerson extends org.springframework.security.core.userdetails.User {
//    private static final long serialVersionUID = 1L;
//    private Person person;
//
//    public AuthorizedPerson(Person person) {
//        super(person.getPerson_name(), person.getPassword(), person.isEnabled(),true,true,true, Arrays.asList());
//        this.person = person;
//    }
//
//    public int getId(){
//        return this.person.getId();
//    }
//
//    public void update(Person newPerson) {
//        this.person = newPerson;
//    }
//
//    public Person getPerson() {
//        return person;
//    }
//
//    @Override
//    public String toString() {
//        return person.toString();
//    }
//}
