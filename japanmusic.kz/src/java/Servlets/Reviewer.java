/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.sql.Date;

/**
 *
 * @author Hikaro
 */
public class Reviewer {
private String ReviewerID;
private String Name;
private String Email;
private String Role;
private String BOKinterest;
private Date LatestRequested;
private Date LatestReturned;

    /**
     * @return the ReviewerID
     */
    public String getReviewerID() {
        return ReviewerID;
    }

    /**
     * @param ReviewerID the ReviewerID to set
     */
    public void setReviewerID(String ReviewerID) {
        this.ReviewerID = ReviewerID;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @return the Role
     */
    public String getRole() {
        return Role;
    }

    /**
     * @param Role the Role to set
     */
    public void setRole(String Role) {
        this.Role = Role;
    }

    /**
     * @return the BOKinterest
     */
    public String getBOKinterest() {
        return BOKinterest;
    }

    /**
     * @param BOKinterest the BOKinterest to set
     */
    public void setBOKinterest(String BOKinterest) {
        this.BOKinterest = BOKinterest;
    }

    /**
     * @return the LatestRequested
     */
    public Date getLatestRequested() {
        return LatestRequested;
    }

    /**
     * @param LatestRequested the LatestRequested to set
     */
    public void setLatestRequested(Date LatestRequested) {
        this.LatestRequested = LatestRequested;
    }

    /**
     * @return the LatestReturned
     */
    public Date getLatestReturned() {
        return LatestReturned;
    }

    /**
     * @param LatestReturned the LatestReturned to set
     */
    public void setLatestReturned(Date LatestReturned) {
        this.LatestReturned = LatestReturned;
    }
}
