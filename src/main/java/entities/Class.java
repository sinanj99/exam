/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author sinanjasar
 */
@Entity
public class Class implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String semester;
    private int maxNumbOfStudents;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Course course;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Teacher> teachers;
    @OneToMany(mappedBy = "class_", cascade = CascadeType.PERSIST)
    private List<SignedUp> signedUps;

    public Class() {
    }

    public Class(String semester, int maxNumbOfStudents, Course course, List<Teacher> teachers,
            List<SignedUp> signedUps) {
        this.semester = semester;
        this.maxNumbOfStudents = maxNumbOfStudents;
        this.course = course;
        this.teachers = teachers;
        this.signedUps = signedUps;
    }

    public Class(int id, String semester, int maxNumbOfStudents, Course course) {
        this.id = id;
        this.semester = semester;
        this.maxNumbOfStudents = maxNumbOfStudents;
        this.course = course;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<SignedUp> getSignedUps() {
        return signedUps;
    }

    public void setSignedUps(List<SignedUp> signedUps) {
        this.signedUps = signedUps;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getMaxNumbOfStudents() {
        return maxNumbOfStudents;
    }

    public void setMaxNumbOfStudents(int maxNumbOfStudents) {
        this.maxNumbOfStudents = maxNumbOfStudents;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "entities.Class[ id=" + id + " ]";
    }

}
