package controller;

import model.Assessment;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/rest/user/assessment")
public class UserAssessmentController extends AbstractController {


    @PostMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void vote(@RequestParam("id") Integer id,
                     @RequestParam("assessment_value") Integer assessment_value,
                     @RequestParam("id_restaurant") Integer id_restaurant,
                     @RequestParam("id_person") Integer id_person) {
        Assessment assessment = new Assessment();

        assessment.setAssessment_value(assessment_value);
        assessment.setRestaurant(super.getRestaurantByID(id_restaurant));
        assessment.setPerson(super.getPersonById(id_person));
        super.saveOrUpdateAssessment(assessment);
    }
}
