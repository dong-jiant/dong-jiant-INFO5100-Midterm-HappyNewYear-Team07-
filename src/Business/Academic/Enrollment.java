/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Academic;

/**
 *
 * @author stelladong
 */
public class Enrollment {
    String studentId;
    String courseId;
    String courseName;
    int credits;
    Double gradePoint;
    String instructorFacultyId;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Double getGradePoint() {
        return gradePoint;
    }

    public void setGradePoint(Double gradePoint) {
        this.gradePoint = gradePoint;
    }

    public String getInstructorFacultyId() {
        return instructorFacultyId;
    }

    public void setInstructorFacultyId(String instructorFacultyId) {
        this.instructorFacultyId = instructorFacultyId;
    }
    
}
