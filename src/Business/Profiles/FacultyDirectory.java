/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Profiles;

import Business.Business;
import Business.Person.Person;
import java.util.ArrayList;

/**
 *
 * @author stelladong
 */
public class FacultyDirectory {
Business business;
    ArrayList<FacultyProfile> facultylist;

    public FacultyDirectory(Business b) {
        business = b;
        facultylist = new ArrayList<>();
    }

    public FacultyProfile newFacultyProfile(Person p) {
        FacultyProfile fp = new FacultyProfile(p);
        facultylist.add(fp);
        return fp;
    }

    public FacultyProfile findFaculty(String id) {
        for (FacultyProfile fp : facultylist) {
            if (fp.isMatch(id)) {
                return fp;
            }
        }
        return null;
    }

    public ArrayList<FacultyProfile> getFacultyList() {
        return facultylist;
    }

    public void removeFacultyProfile(FacultyProfile fp) {
        facultylist.remove(fp);
    }
}
    

