/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

*/
package Business;

import Business.Person.Person;
import Business.Person.PersonDirectory;
import Business.Profiles.EmployeeDirectory;
import Business.Profiles.EmployeeProfile;
import Business.Profiles.StudentDirectory;
import Business.Profiles.StudentProfile;

import Business.UserAccounts.UserAccount;
import Business.UserAccounts.UserAccountDirectory;
import Business.Profiles.FacultyDirectory;
import Business.Profiles.FacultyProfile;


/**
 *
 * @author kal bugrara
 */
class ConfigureABusiness {

     static Business initialize() {

        Business business = new Business("Information Systems");

        // Create Persons
        PersonDirectory persondirectory = business.getPersonDirectory();

        // Employee (Admin)
        Person person001 = persondirectory.newPerson("001");
        person001.setName("John Smith");
        person001.setEmail("john@northeastern.edu");
        person001.setDepartment("Administration");

        // Extra persons
        Person person002 = persondirectory.newPerson("002");
        person002.setName("Gina Montana");

        Person person003 = persondirectory.newPerson("123");   // Student NUID
        person003.setName("Adam Rollen");
        person003.setEmail("adam@northeastern.edu");
        person003.setDepartment("Information Systems");

        Person person005 = persondirectory.newPerson("F001");  // Faculty ID
        person005.setName("Jim Dellon");
        person005.setEmail("jim@northeastern.edu");
        person005.setDepartment("Information Systems");

        Person person006 = persondirectory.newPerson("003");
        person006.setName("Anna Shnider");

        Person person007 = persondirectory.newPerson("004");
        person007.setName("Laura Brown");

        Person person008 = persondirectory.newPerson("005");
        person008.setName("Jack While");

        Person person009 = persondirectory.newPerson("006");
        person009.setName("Fidelity");


        // Create Profiles
        EmployeeDirectory employeedirectory = business.getEmployeeDirectory();
        EmployeeProfile employeeprofile0 = employeedirectory.newEmployeeProfile(person001);

        StudentDirectory studentdirectory = business.getStudentDirectory();
        StudentProfile studentprofile0 = studentdirectory.newStudentProfile(person003);

        FacultyDirectory facultydirectory = business.getFacultyDirectory();
        FacultyProfile facultyprofile0 = facultydirectory.newFacultyProfile(person005);


        // Create User Accounts
        UserAccountDirectory uadirectory = business.getUserAccountDirectory();

        UserAccount adminAccount =
                uadirectory.newUserAccount(employeeprofile0, "admin", "admin");

        UserAccount studentAccount =
                uadirectory.newUserAccount(studentprofile0, "student", "student");

        UserAccount facultyAccount =
                uadirectory.newUserAccount(facultyprofile0, "faculty", "faculty");

        return business;

    }

}
