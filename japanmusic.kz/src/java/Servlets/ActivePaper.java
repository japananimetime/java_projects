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
public class ActivePaper {
    private String PaperID;
    private String Title;
    private Date DateSubmitted;
    private Date DateReviewsReturned;
    private String Status;
    private String BOKid;

    /**
     * @return the PaperID
     */
    public String getPaperID() {
        return PaperID;
    }

    /**
     * @param PaperID the PaperID to set
     */
    public void setPaperID(String PaperID) {
        this.PaperID = PaperID;
    }

    /**
     * @return the Title
     */
    public String getTitle() {
        return Title;
    }

    /**
     * @param Title the Title to set
     */
    public void setTitle(String Title) {
        this.Title = Title;
    }

    /**
     * @return the DateSubmitted
     */
    public Date getDateSubmitted() {
        return DateSubmitted;
    }

    /**
     * @param DateSubmitted the DateSubmitted to set
     */
    public void setDateSubmitted(Date DateSubmitted) {
        this.DateSubmitted = DateSubmitted;
    }

    /**
     * @return the DateReviewsReturned
     */
    public Date getDateReviewsReturned() {
        return DateReviewsReturned;
    }

    /**
     * @param DateReviewsReturned the DateReviewsReturned to set
     */
    public void setDateReviewsReturned(Date DateReviewsReturned) {
        this.DateReviewsReturned = DateReviewsReturned;
    }

    /**
     * @return the Status
     */
    public String getStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(String Status) {
        this.Status = Status;
    }

    /**
     * @return the BOKid
     */
    public String getBOKid() {
        return BOKid;
    }

    /**
     * @param BOKid the BOKid to set
     */
    public void setBOKid(String BOKid) {
        this.BOKid = BOKid;
    }
}
