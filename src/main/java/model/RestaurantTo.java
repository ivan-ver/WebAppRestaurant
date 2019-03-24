package model;

import java.util.List;
import java.util.Set;

public class RestaurantTo extends AbstractBaseEntity {

    private Set<Dish> dishes;
    private String restaurant_name;
    private Double meanAssessment;

    public RestaurantTo(int id, Set<Dish> dishes, String restaurant_name, Double meanAssessment) {
        super(id);
        this.dishes = dishes;
        this.restaurant_name = restaurant_name;
        this.meanAssessment = meanAssessment;
    }

    public Set<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(Set<Dish> dishes) {
        this.dishes = dishes;
    }

    public String getRestaurant_name() {
        return restaurant_name;
    }

    public void setRestaurant_name(String restaurant_name) {
        this.restaurant_name = restaurant_name;
    }

    public Double getMeanAssessment() {
        return meanAssessment;
    }

    public void setMeanAssessment(Double meanAssessment) {
        this.meanAssessment = meanAssessment;
    }
}
