package controller;
import model.Assessment;
import model.Restaurant;
import model.RestaurantTo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/rest/admin/restaurant","/rest/user/restaurant","/getrestaurants"})
public class RestaurantController extends AbstractController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RestaurantTo> GetAll() {
        List<RestaurantTo> list;
        list = super.getAllRestaurantsTo();
        return list;
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) {
        super.RestaurantDelete(id);
    }

    @Override
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    Restaurant getRestaurantByID(@PathVariable("id") Integer id) {
        return super.getRestaurantByID(id);
    }


    @PostMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void createOrUpdate(@RequestParam("id") Integer id,
                               @RequestParam("restaurant_name") String restaurant_name) {
        Restaurant restaurant = new Restaurant();
        if (id != null) {
            restaurant = getRestaurantByID(id);
        }
        restaurant.setRestaurant_name(restaurant_name);
        super.saveOrUpdateRestaurant(restaurant);
    }
}
