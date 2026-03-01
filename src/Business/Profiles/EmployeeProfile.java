/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Profiles;

import Business.Person.Person;

/**
 *
* @author Jianting Dong
 */
public class EmployeeProfile extends Profile {


    private String title;
    private String phone;
    private double salary;

    public EmployeeProfile(Person p) {
        super(p);
    }


    @Override
    public String getRole() {
        return "Admin";
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}