/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Teacher;

/**
 *
 * @author sinanjasar
 */
public class TeacherDTO {
    private int id;
    private String name;

    public TeacherDTO(Teacher teacher) {
        this.id = teacher.getId();
        this.name = teacher.getName();
    }

    public TeacherDTO(String name) {
        this.name = name;
    }
    public Teacher map() {
        return new Teacher(name);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        final TeacherDTO other = (TeacherDTO) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
