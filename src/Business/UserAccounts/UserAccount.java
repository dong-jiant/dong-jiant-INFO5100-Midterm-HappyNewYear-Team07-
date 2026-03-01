/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccounts;

import Business.Profiles.Profile;
import java.util.Date;



/**
 *
* @author Jianting Dong
 */
public class UserAccount {
    
    Profile profile;
    String username;
    String password;
    
    private Date lastAccessTime;
    private Date lastUpdatedTime;   

    public UserAccount (Profile profile, String un, String pw){
        username = un;
        password = pw;
        this.profile = profile;
        lastUpdatedTime = new Date();
         

    }

       public String getPersonId() {
        return profile.getPerson().getPersonId();
    }

    public String getUserLoginName() {
        return username;
    }

    public boolean isMatch(String id) {
        if (getPersonId().equals(id)) return true;
        return false;
    }

    public boolean IsValidUser(String un, String pw) {
        if (username.equalsIgnoreCase(un) && password.equals(pw)) return true;
        else return false;
    }

    public String getRole() {
        return profile.getRole();
    }

    public Profile getAssociatedPersonProfile() {
        return profile;
    }

    public Date getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(Date lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public Date getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(Date lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public void setPassword(String pw) {
        this.password = pw;
        touchLastUpdated(); 
    }

    public void touchLastUpdated() {
        this.lastUpdatedTime = new Date();
    }

    public void touchLastAccess() {
        this.lastAccessTime = new Date();
    }

    @Override
    public String toString() {
        return getPersonId();
    }
}


