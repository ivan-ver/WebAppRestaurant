package controller;

import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import service.AssessmentServiceImpl;
import service.DishServiceImpl;
import service.RestaurantServiceImpl;
import service.PersonServiceImpl;

import java.util.List;
import java.util.Set;


public abstract class AbstractController {

    @Autowired
    private RestaurantServiceImpl restaurantService;
    @Autowired
    private DishServiceImpl dishService;
    @Autowired
    private PersonServiceImpl personService;
    @Autowired
    private AssessmentServiceImpl assessmentService;

    //RESTAURANTS
    List<RestaurantTo> getAllRestaurantsTo(){
        return restaurantService.getAll();
    }
    void saveOrUpdateRestaurant(Restaurant r){
        restaurantService.saveOrUpdate(r);
    }
    void RestaurantDelete(Integer id){
        restaurantService.delete(id);
    }
    Restaurant getRestaurantByID(Integer id){
        return restaurantService.getByID(id);
    }
    //DISHES
    Dish getDishById (Integer id){
        return dishService.getByID(id);
    }
    void saveOrUpdateDish(Dish d){
        dishService.saveOrUpdate(d);
    }
    void deleteDish(Integer id){
        dishService.delete(id);
    }
    List<Dish> getAllDishes(){
        return dishService.getAll();
    }

    //PERSONS
    List<Person> getAllPersons(){
        return personService.getAll();
    }
    void saveOrUpdatePerson(Person p){

        personService.saveOrUpdate(p);
    }
    Person getByEmail (String email){
        return personService.getByEmail(email);
    }
    Person getPersonById (Integer id){
        return personService.getByID(id);
    }

    //ASSESSMENTS

    void saveOrUpdateAssessment(Assessment assessment){
        assessmentService.saveOrUpdate(assessment);
    }

}
