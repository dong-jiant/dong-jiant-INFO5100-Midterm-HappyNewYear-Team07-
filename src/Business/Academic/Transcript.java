/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Academic;

/**
 *
 * @author mac
 */
public class Transcript {
    StudentProfile student;
    ArrayList<Enrollment> enrollments;

    public Transcript(StudentProfile sp) {
        this.student = sp;
        this.enrollments = new ArrayList<>();
    }

    public void newEnrollment(Course c) {
        Enrollment e = new Enrollment(c);
        enrollments.add(e);
    }
    
    public int getTotalCredits() {
        int sum = 0;
        for (Enrollment e : enrollments) {
            sum += e.getCourse().getCredits();
        }
        return sum;
    }
}