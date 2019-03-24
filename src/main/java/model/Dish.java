package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = Dish.DELETE_BY_RESTAURANT_ID,
                query = "DELETE FROM Dish d WHERE d.dish_restaurant=:id")
})

@Entity
@Table(name = "dish", schema = "public")
public class Dish extends AbstractBaseEntity {
    public static final String DELETE_BY_RESTAURANT_ID = "Dish.delete_by_restaurant_id";

    private String dish_name;
    private Long dish_price;
    private Restaurant dish_restaurant;


    public Dish(int id, String dish_name, Long dish_price, Restaurant dish_restaurant) {
        super(id);
        this.dish_name = dish_name;
        this.dish_price = dish_price;
        this.dish_restaurant = dish_restaurant;
    }

    public Dish() {}


    @Basic
    @Column(name = "dish_name")
    public String getDish_name() {
        return dish_name;
    }

    public void setDish_name(String dish_name) {
        this.dish_name = dish_name;
    }


    @Basic
    @Column(name = "dish_price")
    public Long getDish_price() {
        return dish_price;
    }

    public void setDish_price(Long dish_price) {
        this.dish_price = dish_price;
    }

    @ManyToOne//(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_restaurant",nullable=false)
    @NotNull
    @JsonIgnore
    public Restaurant getDish_restaurant() {
        return dish_restaurant;
    }

    public void setDish_restaurant(Restaurant restaurant) {
        this.dish_restaurant = restaurant;
    }
}
