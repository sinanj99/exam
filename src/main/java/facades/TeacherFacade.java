/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dto.TeacherDTO;
import entities.Teacher;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author sinanjasar
 */
public class TeacherFacade {

    private static EntityManagerFactory emf;
    private static TeacherFacade instance;

    private TeacherFacade() {
    }

    public static TeacherFacade getTeacherFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new TeacherFacade();
        }
        return instance;
    }

    public List<TeacherDTO> getAllTeachers() {

        EntityManager em = emf.createEntityManager();
        List<TeacherDTO> teachers = new ArrayList();
        try {
            em.createQuery("SELECT t FROM Teacher t", Teacher.class)
                    .getResultList().forEach(teacher -> {
                        teachers.add(new TeacherDTO(teacher));
                    });
            return teachers;
        } finally {
            em.close();
        }

    }
}
