/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Class;
import entities.SignedUp;
import entities.Teacher;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sinanjasar
 */
public class ClassDTO {

    private int id;
    private String semester;
    private int maxNumbOfStudents;
    private CourseDTO courseDTO;
    private List<TeacherDTO> teacherDTOs = new ArrayList();
    private List<SignedUpDTO> signedUpDTOs = new ArrayList();

    public ClassDTO(Class class_) {
        this.id = class_.getId();
        this.semester = class_.getSemester();
        this.maxNumbOfStudents = class_.getMaxNumbOfStudents();
        this.courseDTO = new CourseDTO(class_.getCourse());
        for (Teacher t : class_.getTeachers()) {
            teacherDTOs.add(new TeacherDTO(t));
        }
        for (SignedUp s : class_.getSignedUps()) {
            signedUpDTOs.add(new SignedUpDTO(s));
        }
    }

    public ClassDTO(String semester, int maxNumbOfStudents, CourseDTO courseDTO, List<TeacherDTO> teachers, List<SignedUpDTO> signedUps) {
        this.semester = semester;
        this.maxNumbOfStudents = maxNumbOfStudents;
        this.courseDTO = courseDTO;
        this.teacherDTOs = teachers;
        this.signedUpDTOs = signedUps;
    }

    public Class map() {
        List<Teacher> teachers = new ArrayList();
        teacherDTOs.forEach(teacher -> teachers.add(teacher.map()));
        List<SignedUp> signedUps = new ArrayList();
        signedUpDTOs.forEach(signedUp -> signedUps.add(signedUp.map()));
        return new Class(semester, maxNumbOfStudents, courseDTO.map(), teachers, signedUps);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSemester() {
        return semester;
    }

    public CourseDTO getCourseDTO() {
        return courseDTO;
    }

    public void setCourseDTO(CourseDTO courseDTO) {
        this.courseDTO = courseDTO;
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

    public List<TeacherDTO> getTeacherDTOs() {
        return teacherDTOs;
    }

    public void setTeacherDTOs(List<TeacherDTO> teacherDTOs) {
        this.teacherDTOs = teacherDTOs;
    }

    public List<SignedUpDTO> getSignedUpDTOs() {
        return signedUpDTOs;
    }

    public void setSignedUpDTOs(List<SignedUpDTO> signedUpDTOs) {
        this.signedUpDTOs = signedUpDTOs;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClassDTO other = (ClassDTO) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
