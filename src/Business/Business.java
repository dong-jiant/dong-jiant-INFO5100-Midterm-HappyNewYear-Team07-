/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Profiles.EmployeeDirectory;
import Business.Profiles.FacultyDirectory;
import Business.Profiles.StudentDirectory;
import Business.UserAccounts.UserAccountDirectory;


import Business.Academic.CourseDirectory;
import Business.Academic.EnrollmentDirectory;
import Business.Person.PersonDirectory;

/**
 *
 * @author kal bugrara
 */
public class Business {

    String name;

 
    PersonDirectory persondirectory; 
    EmployeeDirectory employeedirectory;
    UserAccountDirectory useraccountdirectory;
    StudentDirectory studentdirectory;
    FacultyDirectory facultydirectory;


    CourseDirectory courseDirectory;
    EnrollmentDirectory enrollmentDirectory;

    public Business(String n) {
        name = n;

        
        persondirectory = new PersonDirectory();
        employeedirectory = new EmployeeDirectory(this);
        useraccountdirectory = new UserAccountDirectory();
        studentdirectory = new StudentDirectory();
        facultydirectory = new FacultyDirectory(this);

        
        courseDirectory = new CourseDirectory();
        enrollmentDirectory = new EnrollmentDirectory();
    }

    
    public PersonDirectory getPersonDirectory() {
        return persondirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return useraccountdirectory;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeedirectory;
    }

    public StudentDirectory getStudentDirectory() {
        return studentdirectory;
    }

    public FacultyDirectory getFacultyDirectory() {
        return facultydirectory;
    }

 
    public CourseDirectory getCourseDirectory() {
        return courseDirectory;
    }

    public EnrollmentDirectory getEnrollmentDirectory() {
        return enrollmentDirectory;
    }
}