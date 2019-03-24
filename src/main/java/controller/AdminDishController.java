package controller;
import model.Dish;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/admin/dish")
public class AdminDishController extends AbstractController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Dish> GetAll() {
        return super.getAllDishes();
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) {
        super.deleteDish(id);
    }

    @Override
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    Dish getDishById(@PathVariable("id") Integer id) {
        return super.getDishById(id);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void createOrUpdate(@RequestParam("id") Integer id,
                               @RequestParam("dish_name") String dish_name,
                               @RequestParam("dish_price") Long dish_price,
                               @RequestParam("id_restaurant") Integer id_restaurant) {
        Dish dish = new Dish();
        if (id != null) {
            dish = getDishById(id);
        }
        dish.setDish_name(dish_name);
        dish.setDish_price(dish_price);
        dish.setDish_restaurant(super.getRestaurantByID(id_restaurant));
        super.saveOrUpdateDish(dish);
    }

}
