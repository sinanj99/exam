/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Course;

/**
 *
 * @author sinanjasar
 */
public class CourseDTO {
    private int id;
    private String courseName;
    private String description;

    public CourseDTO(Course course) {
        this.id = course.getId();
        this.courseName = course.getCourseName();
        this.description = course.getDescription();
    }

    public CourseDTO(String courseName, String description) {
        this.courseName = courseName;
        this.description = description;
    }
    
    public Course map() {
        return new Course(courseName,description);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final CourseDTO other = (CourseDTO) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
