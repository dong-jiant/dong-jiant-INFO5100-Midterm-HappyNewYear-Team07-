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
public class CourseDirectory {
    private ArrayList<CourseInfo> courseList;

    public CourseDirectory() {
        courseList = new ArrayList<CourseInfo>();
    }


    public void addOrUpdateCourse(String facultyId,String courseId,String courseName,int credits) {
        if (isBlank(facultyId) || isBlank(courseId) || isBlank(courseName) || credits <= 0) {
            return;
        }

        CourseInfo existing = null;
        for (CourseInfo c : courseList) {
            if (c.getFacultyId().equals(facultyId)
                    && c.getCourseId().equals(courseId)) {
                existing = c;
                break;
            }
        }

        if (existing == null) {
            CourseInfo c = new CourseInfo();
            c.setFacultyId(facultyId);
            c.setCourseId(courseId);
            c.setCourseName(courseName);
            c.setCredits(credits);
            courseList.add(c);
        } else {
            existing.setCourseName(courseName);
            existing.setCredits(credits);
        }
    }

    public ArrayList<CourseInfo> getCoursesForFaculty(String facultyId) {
        ArrayList<CourseInfo> result = new ArrayList<CourseInfo>();
        for (CourseInfo c : courseList) {
            if (c.getFacultyId().equals(facultyId)) {
                result.add(c);
            }
        }
        return result;
    }

    public CourseInfo findCourse(String courseId) {
        for (CourseInfo c : courseList) {
            if (c.getCourseId().equals(courseId)) {
                return c;
            }
        }
        return null;
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}
