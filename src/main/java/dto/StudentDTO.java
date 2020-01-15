/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Student;

/**
 *
 * @author sinanjasar
 */
public class StudentDTO {

    private int id;
    private String name;
    private String email;

    public StudentDTO(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.email = student.getEmail();
    }

    public StudentDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Student map() {
        return new Student(name, email);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
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
        final StudentDTO other = (StudentDTO) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
