package model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "assessment", schema = "public")
public class Assessment extends AbstractBaseEntity {

    private int assessment_value;
    private Person person;
    private Restaurant restaurant;
    private LocalDateTime date_time = LocalDateTime.now();

    public Assessment(int id, int assessment_value, Person person, Restaurant restaurant) {
        super(id);
        this.assessment_value = assessment_value;
        this.person = person;
        this.restaurant = restaurant;
    }

    public Assessment() { }

    @Basic
    @Column(name = "assessment_value")
    public int getAssessment_value() {
        return assessment_value;
    }

    public void setAssessment_value(int assessmentvalue) {
        this.assessment_value = assessmentvalue;
    }

    @Basic
    @Column(name = "date_time",insertable = false,columnDefinition = "timestamp default now()")
    public LocalDateTime getDate_time() {
        return date_time;
    }

    public void setDate_time(LocalDateTime date_time) {
        this.date_time = date_time;
    }

    @ManyToOne
    @JoinColumn(name = "id_person")
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @ManyToOne
    @JoinColumn(name = "id_restaurant")
    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant idrestauranr) {
        this.restaurant = idrestauranr;
    }
}
