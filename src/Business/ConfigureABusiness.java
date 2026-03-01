/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

*/
package Business;


import Business.Academic.CourseDirectory;
import Business.Academic.EnrollmentDirectory;
import Business.Person.PersonDirectory;
import Business.Person.Person;
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
public class ConfigureABusiness {

	public   static Business initialize() {

        Business business = new Business("Information Systems");

        // Create Persons
        PersonDirectory persondirectory = business.getPersonDirectory();

        // Employee (Admin)
        Person person001 = persondirectory.newPerson("001");
        person001.setName("John Smith");
        person001.setEmail("john@northeastern.edu");
        person001.setDepartment("Administration");

        // Students
        Person person003 = persondirectory.newPerson("123");
        person003.setName("Adam Rollen");
        person003.setEmail("adam@northeastern.edu");
        person003.setDepartment("Information Systems");

        Person person011 = persondirectory.newPerson("124");
        person011.setName("Emily Chen");
        person011.setEmail("emily@northeastern.edu");
        person011.setDepartment("Computer Science");

        Person person012 = persondirectory.newPerson("125");
        person012.setName("Michael Brown");
        person012.setEmail("michael@northeastern.edu");
        person012.setDepartment("Information Systems");

        // Faculty
        Person person005 = persondirectory.newPerson("F001");
        person005.setName("Dr. Sarah Johnson");
        person005.setEmail("sarah.johnson@northeastern.edu");
        person005.setDepartment("Computer Science");

        // Create Profiles
        EmployeeDirectory employeedirectory = business.getEmployeeDirectory();
        EmployeeProfile employeeprofile0 = employeedirectory.newEmployeeProfile(person001);

        StudentDirectory studentdirectory = business.getStudentDirectory();
        StudentProfile studentprofile0 = studentdirectory.newStudentProfile(person003);
        studentprofile0.setHobbies("Reading, Gaming, Basketball");
        studentprofile0.setInterests("Artificial Intelligence, Machine Learning");
        studentprofile0.setAcademicProgress("GPA: 3.75");

        StudentProfile studentprofile1 = studentdirectory.newStudentProfile(person011);
        studentprofile1.setHobbies("Music, Coding, Hiking");
        studentprofile1.setInterests("Web Development, Cloud Computing");
        studentprofile1.setAcademicProgress("GPA: 3.92");

        StudentProfile studentprofile2 = studentdirectory.newStudentProfile(person012);
        studentprofile2.setHobbies("Sports, Photography");
        studentprofile2.setInterests("Data Analytics, Cybersecurity");
        studentprofile2.setAcademicProgress("GPA: 3.45");

        FacultyDirectory facultydirectory = business.getFacultyDirectory();
        FacultyProfile facultyprofile0 = facultydirectory.newFacultyProfile(person005);
        facultyprofile0.setDepartment("Computer Science");
        facultyprofile0.setEmail("sarah.johnson@university.edu");
        facultyprofile0.setPhone("123-456-7890");

        // Create User Accounts
        UserAccountDirectory uadirectory = business.getUserAccountDirectory();
        UserAccount adminAccount = uadirectory.newUserAccount(employeeprofile0, "admin", "admin");
        UserAccount studentAccount = uadirectory.newUserAccount(studentprofile0, "student", "student");
        UserAccount facultyAccount = uadirectory.newUserAccount(facultyprofile0, "faculty", "faculty");

        // Create Courses
        CourseDirectory courseDirectory = business.getCourseDirectory();
        String facultyId = person005.getPersonId();
        courseDirectory.addOrUpdateCourse(facultyId, "INFO5100", "Application Engineering", 4);
        courseDirectory.addOrUpdateCourse(facultyId, "INFO5200", "Database Management", 4);
        courseDirectory.addOrUpdateCourse(facultyId, "INFO5800", "Data Analytics", 4);

        // Create Enrollments and Grades
        EnrollmentDirectory enrollmentDirectory = business.getEnrollmentDirectory();
        String studentId1 = person003.getPersonId();
        String studentId2 = person011.getPersonId();
        String studentId3 = person012.getPersonId();

        enrollmentDirectory.registerStudentForCourse(studentId1, "INFO5100", "Application Engineering", 4);
        enrollmentDirectory.registerStudentForCourse(studentId1, "INFO5200", "Database Management", 4);
        enrollmentDirectory.recordGrade(studentId1, "INFO5100", 3.5, facultyId);
        enrollmentDirectory.recordGrade(studentId1, "INFO5200", 3.0, facultyId);

        enrollmentDirectory.registerStudentForCourse(studentId2, "INFO5100", "Application Engineering", 4);
        enrollmentDirectory.registerStudentForCourse(studentId2, "INFO5200", "Database Management", 4);
        enrollmentDirectory.recordGrade(studentId2, "INFO5100", 4.0, facultyId);
        enrollmentDirectory.recordGrade(studentId2, "INFO5200", 3.8, facultyId);

        enrollmentDirectory.registerStudentForCourse(studentId3, "INFO5100", "Application Engineering", 4);
        enrollmentDirectory.registerStudentForCourse(studentId3, "INFO5800", "Data Analytics", 4);
        enrollmentDirectory.recordGrade(studentId3, "INFO5100", 3.2, facultyId);
        enrollmentDirectory.recordGrade(studentId3, "INFO5800", 3.4, facultyId);

        return business;

    }

}
