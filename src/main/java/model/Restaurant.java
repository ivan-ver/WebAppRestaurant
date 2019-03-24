package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "restaurant", schema = "public")
public class Restaurant extends AbstractBaseEntity{

    private Set<Dish> dishes;
    private String restaurant_name;
    private Set<Assessment> assessments;
//    private Float mean_assessment;

    public Restaurant(int id, Set<Dish> dishes, String restaurant_name, Set<Assessment> assessments) {
        super(id);
        this.dishes = dishes;
        this.restaurant_name = restaurant_name;
        this.assessments = assessments;
//        this.mean_assessment = mean_assessment;
    }

    public Restaurant() {}

    @Basic
    @Column(name = "restaurant_name")
    public String getRestaurant_name() {
        return restaurant_name;
    }

    public void setRestaurant_name(String restaurantname) {
        this.restaurant_name = restaurantname;
    }


//    @Basic
//    @Column(name = "mean_assessment", nullable = false, insertable = false, columnDefinition = "float4 default 0")
//    public Float getMean_assessment() {
//        return mean_assessment;
//    }
//
//    public void setMean_assessment(Float mean_assessment) {
//        this.mean_assessment = mean_assessment;
//    }


    @OneToMany(mappedBy = "restaurant", fetch = FetchType.EAGER)//, cascade = CascadeType.ALL)
    public Set<Assessment> getAssessments() {
        return assessments;
    }

    public void setAssessments(Set<Assessment> assessments) {
        this.assessments = assessments;
    }

    @OneToMany(mappedBy = "dish_restaurant",  fetch = FetchType.EAGER)//, cascade = CascadeType.ALL)
    public Set<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(Set<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "dishes=" + dishes +
                ", restaurant_name='" + restaurant_name + '\'' +
                ", assessments=" + assessments +
//                ", mean_assessment=" + mean_assessment +
                '}';
    }
}
