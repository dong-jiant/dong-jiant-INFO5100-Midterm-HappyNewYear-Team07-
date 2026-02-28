/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

/**
 *
 * @author 
 */
public class Person {

    private String id;
    private String name;
    private String email;
    private String department;

    public Person(String id) {
        this.id = id;
    }

    public String getPersonId() {
        return id;
    }

    public void setPersonId(String id) {
        this.id = id;
    }

    // --- new fields ---
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public boolean isMatch(String id) {
        return getPersonId().equals(id);
    }


    @Override
    public String toString() {
        return getPersonId();
    }
}