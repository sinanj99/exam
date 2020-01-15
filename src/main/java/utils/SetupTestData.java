/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entities.SignedUp;
import entities.Student;
import entities.Teacher;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author sinanjasar
 */
public class SetupTestData {

    public static void main(String[] args) {
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
        EntityManager em = emf.createEntityManager();
        Teacher teacher1 = new Teacher("Kurt");
        Teacher teacher2 = new Teacher("Jens");
        Teacher teacher3 = new Teacher("Mogens");
        Teacher teacher4 = new Teacher("Charlotte");
        Teacher teacher5 = new Teacher("Trine");
        Teacher teacher6 = new Teacher("Joachim");
        Student student1 = new Student("Peter", "peter@cphbusiness.dk");
        Student student2 = new Student("Patrick", "patrick@cphbusiness.dk");
        Student student3 = new Student("Sebastian", "sebastian@gcphbusiness.dk");
        Student student4 = new Student("Jannik", "jannik@cphbusiness.dk");
        Student student5 = new Student("Christian", "christian@cphbusiness.dk");
        Student student6 = new Student("Abdul", "abdul@cphbusiness.dk");
        em.getTransaction().begin();
        em.persist(teacher1);
        em.persist(teacher2);
        em.persist(teacher3);
        em.persist(teacher4);
        em.persist(teacher5);
        em.persist(teacher6);
        em.persist(student1);
        em.persist(student2);
        em.persist(student3);
        em.persist(student4);
        em.persist(student5);
        em.persist(student6);
        em.getTransaction().commit();
    }

}
