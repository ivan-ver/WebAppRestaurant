package util;


import model.AbstractBaseEntity;
import model.Assessment;
import model.Restaurant;
import model.RestaurantTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repository.HibernateSessionFactory.SessionFactoryAssessmentRepo;
import repository.HibernateSessionFactory.SessionFactoryRestaurantRepo;

import java.util.*;

@Component
public class Util {

    @Autowired
    private SessionFactoryRestaurantRepo restaurantRepo;

    private Double CalcMeanAssesment(Set<Assessment> assessments){
        return assessments
                .stream()
                .mapToInt(Assessment::getAssessment_value)
                .average()
                .orElse(0.0);
    }

    public List<RestaurantTo> CreateRestaurantToList (List<Restaurant> restaurants){
        List<RestaurantTo> restaurantToList = new ArrayList<>();
        for (Restaurant r : restaurants){
            restaurantToList.add(new RestaurantTo(
                    r.getId(),
                    r.getDishes(),
                    r.getRestaurant_name(),
                    CalcMeanAssesment(r.getAssessments())));
        }
        return restaurantToList;
    }

    public Assessment search(Assessment assessment){
        Set<Assessment> assessments = restaurantRepo.getByID(assessment
                .getRestaurant()
                .getId()).getAssessments();
        for (Assessment a : assessments){
            if (a.getPerson().getId() == assessment.getPerson().getId()){
                assessment.setId(a.getId());
                break;
            }
        }
        return assessment;
    }
}
