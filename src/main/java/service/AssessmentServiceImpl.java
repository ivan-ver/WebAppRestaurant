package service;

import model.AbstractBaseEntity;
import model.Assessment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.HibernateSessionFactory.SessionFactoryAssessmentRepo;
import util.Util;

import java.util.List;
@Service
public class AssessmentServiceImpl implements ServiceRest {

    private final SessionFactoryAssessmentRepo assessmentRepo;
    private final Util util;


    @Autowired
    public AssessmentServiceImpl(SessionFactoryAssessmentRepo assessmentRepo, Util util, Util util1) {
        this.assessmentRepo = assessmentRepo;
        this.util = util1;
    }


    @Override
    public List<?> getAll() {
        return null;
    }

    @Override
    public Assessment getByID(Integer id) {
        return assessmentRepo.getByID(id);
    }

    @Override
    public void saveOrUpdate(AbstractBaseEntity o) {
        Assessment assessment = util.search((Assessment)o);
        
        assessmentRepo.saveOrUpdate(assessment);
    }

    @Override
    public void delete(Integer id) {

    }

}
