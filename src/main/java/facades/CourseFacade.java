/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dto.CourseDTO;
import errorhandling.AlreadyExistsException;
import entities.Course;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author sinanjasar
 */
public class CourseFacade {
    private static EntityManagerFactory emf;
    private static CourseFacade instance;
    
    private CourseFacade(){}
    
    public static CourseFacade getCourseFacade (EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CourseFacade();
        }
        return instance;
    }
    public CourseDTO addCourse(CourseDTO courseDTO){
        EntityManager em = emf.createEntityManager();
        Course course = courseDTO.map();
        checkCourse(course, em);
        em.getTransaction().begin();
        em.persist(course);
        em.getTransaction().commit();
        return new CourseDTO(course);
    }
    public List<CourseDTO> getAllCourses() {
        EntityManager em = emf.createEntityManager();
        List<CourseDTO> courses = new ArrayList();
        try {
            em.createQuery("SELECT c FROM Course c", Course.class)
                    .getResultList().forEach(course -> {
                        courses.add(new CourseDTO(course));
                    });
            return courses;
        } finally {
            em.close();
        }
    }
    private void checkCourse(Course course, EntityManager em) {
        TypedQuery<Course> c = em.createQuery("SELECT c FROM Course c WHERE "
                + "c.courseName = :name", Course.class
        );
        c.setParameter("name", course.getCourseName());
        if (!c.getResultList().isEmpty()) {
            throw new AlreadyExistsException("The provided course already exists",400);
//            course.setCourse(course.getSingleResult());
        }
    }
}
