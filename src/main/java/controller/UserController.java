package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import service.ServiceRest;
@Controller
public class UserController {
    @Autowired
    private ServiceRest service;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView get() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("users", service.getAll());
        modelAndView.setViewName("users_page");
        return modelAndView;
    }
}
