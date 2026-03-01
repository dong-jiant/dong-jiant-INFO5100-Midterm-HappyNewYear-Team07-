/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Academic;

import Business.Profiles.StudentProfile;
import java.util.ArrayList;
/**
 *
 * @author Yiru Chen
 */
public class Transcript {
    private StudentProfile student;
    private ArrayList<Enrollment> enrollments;

    public Transcript(StudentProfile sp) {
        this.student = sp;
        this.enrollments = new ArrayList<>();
    }

    public void addEnrollment(Enrollment e) {
        if (e != null) {
            enrollments.add(e);
        }
    }


    public ArrayList<Enrollment> getEnrollments() {
        return enrollments;
    }


    public int getTotalCredits() {
        int sum = 0;
        for (Enrollment e : enrollments) {
            if (e.getGradePoint() != null && e.getGradePoint() >= 1.0) {
                sum += e.getCredits();
            }
        }
        return sum;
    }
}