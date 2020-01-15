/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dto.ClassDTO;
import dto.CourseDTO;
import dto.SignedUpDTO;
import dto.StudentDTO;
import entities.Class;
import entities.SignedUp;
import entities.Student;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import utils.EMF_Creator;

/**
 *
 * @author sinanjasar
 */
public class StudentFacade {
    private static EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
    private static StudentFacade instance;

    private StudentFacade() {
    }

    public static StudentFacade getStudentFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new StudentFacade();
        }
        return instance;
    }

    public List<StudentDTO> getAllStudents() {
        EntityManager em = emf.createEntityManager();
        List<StudentDTO> students = new ArrayList();
        try {
            em.createQuery("SELECT s FROM Student s", Student.class)
                    .getResultList().forEach(student -> {
                        students.add(new StudentDTO(student));
                    });
            return students;
        } finally {
            em.close();
        }
    }
}
