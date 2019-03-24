package controller;

import model.Person;
import model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping(value = "/rest/admin/users")
public class AdminUserController extends AbstractController {


    @Autowired
    @Qualifier(value = "bcryptBean")
    private BCryptPasswordEncoder passwordEncoder;




    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> GetAll() {
        return super.getAllPersons();
    }

    @Override
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    Person getPersonById(@PathVariable("id") Integer id) {
        return super.getPersonById(id);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void createOrUpdate(@RequestParam("id") Integer id,
                               @RequestParam("person_name") String person_name,
                               @RequestParam("email") String email,
                               @RequestParam("status") String status,
                               @RequestParam("password") String password,
                               @RequestParam("repassword") String repassword) {

        Person person = new Person();
        if (id != null)
            person.setId(id);
        person.setPerson_name(person_name);
        person.setEmail(email);
        person.setStatus(status);
        person.setPassword(passwordEncoder.encode(password));
        super.saveOrUpdatePerson(person);
    }
}
