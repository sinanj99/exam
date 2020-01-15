/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.SignedUp;

/**
 *
 * @author sinanjasar
 */
public class SignedUpDTO {
    private int id;
    private int grade;
    private String passedDate;
    private StudentDTO studentDTO;
    private CourseDTO courseDTO;

    public SignedUpDTO(SignedUp signedUp) {
        this.id = signedUp.getId();
        this.grade = signedUp.getGrade();
        this.passedDate = signedUp.getPassedDate();
        this.studentDTO = new StudentDTO(signedUp.getStudent());
    }

    public SignedUpDTO(int grade, String passedDate) {
        this.grade = grade;
        this.passedDate = passedDate;
    }
    public SignedUp map() {
        return new SignedUp(grade,passedDate,studentDTO.map());
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public CourseDTO getCourseDTO() {
        return courseDTO;
    }

    public void setCourseDTO(CourseDTO courseDTO) {
        this.courseDTO = courseDTO;
    }

    public String getPassedDate() {
        return passedDate;
    }

    public void setPassedDate(String passedDate) {
        this.passedDate = passedDate;
    }

    public StudentDTO getStudentDTO() {
        return studentDTO;
    }

    public void setStudentDTO(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final SignedUpDTO other = (SignedUpDTO) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
