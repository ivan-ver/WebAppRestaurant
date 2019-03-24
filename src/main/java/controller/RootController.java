package controller;


import model.Dish;
import model.Person;
import model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class RootController extends AbstractController {


    @GetMapping(value = "/rest")
    public String getRest() {
        String result;
        UserDetails userDetails = (UserDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        String role="";
        String email = userDetails.getUsername();
        for (GrantedAuthority authority : userDetails.getAuthorities()){
            role = authority.getAuthority();
        }

        result = role.equals("ROLE_ADMIN") ? "/rest/admin/restaurant_list/"+super.getByEmail(email).getId() :
                "/rest/user/restaurant_list/"+super.getByEmail(email).getId();

        return "redirect:"+result;
    }


    @RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error) {
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Неверный E-mail или пароль!");
        }
        model.setViewName("welcome_page");
        return model;
    }

    @GetMapping("/rest/admin/users_list/{id}")
    public ModelAndView adminUsers(@PathVariable("id") Integer id) {
        ModelAndView model = new ModelAndView();
        model.addObject("name",super.getPersonById(id).getPerson_name());
        model.addObject("id_person",id);
        model.setViewName("admin_users_page");
        return model;
    }

    @GetMapping("/rest/admin/restaurant_list/{id}")
    public ModelAndView adminRestaurants(@PathVariable("id") Integer id) {
        ModelAndView model = new ModelAndView();
        model.addObject("name",super.getPersonById(id).getPerson_name());
        model.addObject("id_person",id);
        model.setViewName("admin_restaurants_page");
        return model;
    }

    @GetMapping("/rest/user/restaurant_list/{id}")
    public ModelAndView userRestaurants(@PathVariable("id") Integer id) {
        ModelAndView model = new ModelAndView();
        model.addObject("name",super.getPersonById(id).getPerson_name());
        model.addObject("id_person",id);
        model.setViewName("user_restaurants_page");
        return model;
    }

}
