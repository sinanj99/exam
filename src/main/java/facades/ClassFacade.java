/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dto.ClassDTO;
import dto.CourseDTO;
import entities.Class;
import entities.Course;
import entities.Student;
import entities.Teacher;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author sinanjasar
 */
public class ClassFacade {

    private static EntityManagerFactory emf;
    private static ClassFacade instance;

    private ClassFacade() {
    }

    public static ClassFacade getClassFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new ClassFacade();
        }
        return instance;
    }

    public ClassDTO addClass(ClassDTO classDTO) {
        EntityManager em = emf.createEntityManager();
        Class class_ = classDTO.map();
        class_.getSignedUps().forEach(s -> s.setClass_(class_));
        checkCourse(class_, em);
        checkTeachers(class_, em);
        checkStudents(class_, em);
        em.getTransaction().begin();
        em.persist(class_);
        em.getTransaction().commit();
        return new ClassDTO(class_);
    }

    private void checkCourse(Class class_, EntityManager em) {
        TypedQuery<Course> course = em.createQuery("SELECT c FROM Course c WHERE "
                + "c.courseName = :name", Course.class
        );
        course.setParameter("name", class_.getCourse().getCourseName());
        if (!course.getResultList().isEmpty()) {
            class_.setCourse(course.getSingleResult());
        }
    }

    private void checkTeachers(Class class_, EntityManager em) {
        List<Teacher> teachers = class_.getTeachers();
        for (int i = 0; i < teachers.size(); i++) {
            TypedQuery<Teacher> teacher = em.createQuery("SELECT t FROM Teacher t WHERE t.name = :name", Teacher.class)
                    .setParameter("name", teachers.get(i).getName());
            if (!teacher.getResultList().isEmpty()) {
                teachers.remove(i);
                teachers.add(teacher.getSingleResult());
            }
        }
    }

    private void checkStudents(Class class_, EntityManager em) {
        List<Student> students = new ArrayList();
        class_.getSignedUps().forEach(s -> students.add(s.getStudent()));
        for (int i = 0; i < students.size(); i++) {
            TypedQuery<Student> student = em.createQuery("SELECT s FROM Student s WHERE s.name = :name", Student.class)
                    .setParameter("name", students.get(i).getName());
            if (!student.getResultList().isEmpty()) {
                students.remove(i);
                students.add(student.getSingleResult());
            }
        }
    }

    public List<ClassDTO> getAllClasses() {
        EntityManager em = emf.createEntityManager();
        List<ClassDTO> classes = new ArrayList();
        try {
            em.createQuery("SELECT c FROM Class c", Class.class)
                    .getResultList().forEach(class_ -> {
                        classes.add(new ClassDTO(class_));
                    });
            return classes;
        } finally {
            em.close();
        }
    }

    public ClassDTO getClassById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return new ClassDTO(em.find(Class.class, id));
        } finally {
            em.close();
        }
    }

    public ClassDTO editClass(ClassDTO classDTO) {
        EntityManager em = emf.createEntityManager();
        Class class_ = classDTO.map();
        class_.setId(classDTO.getId());
        try {
            em.getTransaction().begin();
            em.merge(class_);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new ClassDTO(class_);
    }
}
