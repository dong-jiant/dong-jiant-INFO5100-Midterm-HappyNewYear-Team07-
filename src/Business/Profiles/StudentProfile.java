/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Profiles;

import Business.Person.Person;


/**
 *
 * @author Yiru Chen
 */

public class StudentProfile extends Profile {

    Person person;
    private String hobbies;
    private String interests;
    private String academicProgress;

    public StudentProfile(Person p) {
        super(p);
        this.person = p;
        this.hobbies = "";
        this.interests = "";
        this.academicProgress = "On Track";
    }

    @Override
    public String getRole() {
        return "Student";
    }

    @Override
    public boolean isMatch(String id) {
        return person.getPersonId().equals(id);
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getAcademicProgress() {
        return academicProgress;
    }

    public void setAcademicProgress(String academicProgress) {
        this.academicProgress = academicProgress;
    }
}