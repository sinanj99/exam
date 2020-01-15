/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dto.ClassDTO;
import dto.CourseDTO;
import dto.SignedUpDTO;
import dto.TeacherDTO;
import entities.SignedUp;
import entities.Teacher;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author sinanjasar
 */
public class SignedUpFacade {

    private static EntityManagerFactory emf;
    private static SignedUpFacade instance;

    private SignedUpFacade() {
    }

    public static SignedUpFacade getSignedUpFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new SignedUpFacade();
        }
        return instance;
    }

    public List<SignedUpDTO> getAllSignedUps() {
        EntityManager em = emf.createEntityManager();
        List<SignedUpDTO> signedUps = new ArrayList();
        try {
            em.createQuery("SELECT s FROM SignedUp s", SignedUp.class)
                    .getResultList().forEach(signedUp -> {
                        signedUps.add(new SignedUpDTO(signedUp));
                    });
            return signedUps;
        } finally {
            em.close();
        }
    }

    public List<SignedUpDTO> getSignedUps(String studentName) {
        EntityManager em = emf.createEntityManager();
        List<SignedUpDTO> signedUps = new ArrayList();
        try {
            em.createQuery("SELECT s FROM SignedUp s WHERE s.student.name = :studentName", SignedUp.class)
                    .setParameter("studentName", studentName)
                    .getResultList().forEach(signedUp -> {
                        SignedUpDTO signedUpDTO = new SignedUpDTO(signedUp);
                        signedUpDTO.setCourseDTO(new CourseDTO(signedUp.getClass_().getCourse()));
                        signedUps.add(signedUpDTO);
                    });
            return signedUps;
        } finally {
            em.close();
        }
    }
}
