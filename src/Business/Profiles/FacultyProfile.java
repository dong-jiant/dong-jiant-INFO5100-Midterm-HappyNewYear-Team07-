/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Profiles;

import Business.Person.Person;

/**
* @author Jianting Dong
 */
public class FacultyProfile extends Profile {

    Person person;

    public FacultyProfile(Person p) {
        super(p);
        person = p;
    }

    @Override
    public String getRole() {
        return "Faculty";
    }

    public boolean isMatch(String id) {
        return person.getPersonId().equals(id);
    }

    public Person getPerson() {
        return person;
    }
}