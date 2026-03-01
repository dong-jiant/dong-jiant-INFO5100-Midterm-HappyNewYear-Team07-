/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Academic;

import java.util.ArrayList;

/**
 *
 * @author Jianting Dong
 */
public class EnrollmentDirectory {

    private ArrayList<Enrollment> enrollmentList;
    private ArrayList<String> submittedAssignments;

    public EnrollmentDirectory() {
        enrollmentList = new ArrayList<Enrollment>();
        submittedAssignments = new ArrayList<String>();
    }


    public void registerStudentForCourse(String studentId,String courseId,String courseName,int credits) {

        if (studentId == null || studentId.trim().equals("")) return;
        if (courseId == null || courseId.trim().equals("")) return;
        if (courseName == null || courseName.trim().equals("")) return;
        if (credits <= 0) return;


        for (Enrollment e : enrollmentList) {
            if (e.getStudentId().equals(studentId)
                    && e.getCourseId().equals(courseId)) {
                return;
            }
        }

        Enrollment e = new Enrollment();
        e.setStudentId(studentId);
        e.setCourseId(courseId);
        e.setCourseName(courseName);
        e.setCredits(credits);
        enrollmentList.add(e);
    }


    public boolean dropStudentCourse(String studentId, String courseId) {
        for (int i = 0; i < enrollmentList.size(); i++) {
            Enrollment e = enrollmentList.get(i);
            if (e.getStudentId().equals(studentId)
                    && e.getCourseId().equals(courseId)) {
                enrollmentList.remove(i);
                return true;
            }
        }
        return false;
    }


    public ArrayList<Enrollment> getEnrollmentsForStudent(String studentId) {
        ArrayList<Enrollment> list = new ArrayList<Enrollment>();
        if (studentId == null) return list;

        for (Enrollment e : enrollmentList) {
            if (studentId.equals(e.getStudentId())) {
                list.add(e);
            }
        }
        return list;
    }


    public boolean recordGrade(String studentId,
                               String courseId,
                               double gradePoint,
                               String facultyId) {

        if (gradePoint < 0.0 || gradePoint > 4.0) {
            return false;
        }

        for (Enrollment e : enrollmentList) {
            if (e.getStudentId().equals(studentId)
                    && e.getCourseId().equals(courseId)) {
                e.setGradePoint(gradePoint);
                e.setInstructorFacultyId(facultyId);
                return true;
            }
        }
        return false;
    }

 
    public int completedCredits(String studentId) {
        int credits = 0;

        for (Enrollment e : enrollmentList) {
            if (studentId.equals(e.getStudentId())
                    && e.getGradePoint() != null
                    && e.getGradePoint() >= 1.0) {
                credits = credits + e.getCredits();
            }
        }
        return credits;
    }


    public ArrayList<String> transcriptLines(String studentId) {
        ArrayList<String> lines = new ArrayList<String>();
        ArrayList<Enrollment> list = getEnrollmentsForStudent(studentId);

        if (list.isEmpty()) {
            lines.add("No enrollment history available.");
            return lines;
        }

        for (Enrollment e : list) {
            String gradeText;
            if (e.getGradePoint() == null) {
                gradeText = "In Progress";
            } else {
                gradeText = String.valueOf(e.getGradePoint());
            }

            String line = e.getCourseId()
                    + " - " + e.getCourseName()
                    + " - " + e.getCredits() + " cr"
                    + " - " + gradeText;
            lines.add(line);
        }

        return lines;
    }


    public ArrayList<String> facultyPerformanceLines(String facultyId) {
        ArrayList<String> lines = new ArrayList<String>();

        for (Enrollment e : enrollmentList) {
            if (facultyId.equals(e.getInstructorFacultyId())
                    && e.getGradePoint() != null) {

                String line = "Student " + e.getStudentId()
                        + " - " + e.getCourseId()
                        + " - GPA: " + e.getGradePoint();
                lines.add(line);
            }
        }

        if (lines.isEmpty()) {
            lines.add("No graded records found for this faculty member.");
        }

        return lines;
    }


    public boolean submitAssignment(String studentId,
                                    String courseId,
                                    String assignmentName) {

        if (studentId == null || studentId.trim().equals("")) return false;
        if (courseId == null || courseId.trim().equals("")) return false;
        if (assignmentName == null || assignmentName.trim().equals("")) return false;


        boolean enrolled = false;
        for (Enrollment e : enrollmentList) {
            if (studentId.equals(e.getStudentId())
                    && courseId.equals(e.getCourseId())) {
                enrolled = true;
                break;
            }
        }
        if (!enrolled) {
            return false;
        }

        String entry = courseId + " - " + assignmentName;
        submittedAssignments.add(studentId + "|" + entry);
        return true;
    }


    public ArrayList<String> getSubmittedAssignments(String studentId) {
        ArrayList<String> result = new ArrayList<String>();
        if (studentId == null) return result;

        for (String s : submittedAssignments) {
            if (s.startsWith(studentId + "|")) {
                String line = s.substring((studentId + "|").length());
                result.add(line);
            }
        }
        return result;
    }

    }

