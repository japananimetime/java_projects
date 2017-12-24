/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

/**
 *
 * @author Hikaro
 */
public class Discipline {    
    private String Name;
    private String Code;
    private int Credits;
    private int Grade;
    private int Term;

    public int getGrade() {
        return Grade;
    }

    public void setGrade(int Grade) {
        this.Grade = Grade;
    }

    public int getTerm() {
        return Term;
    }

    public void setTerm(int Term) {
        this.Term = Term;
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
     * @return the Code
     */
    public String getCode() {
        return Code;
    }

    /**
     * @param Code the Code to set
     */
    public void setCode(String Code) {
        this.Code = Code;
    }

    /**
     * @return the Credits
     */
    public int getCredits() {
        return Credits;
    }

    /**
     * @param Credits the Credits to set
     */
    public void setCredits(int Credits) {
        this.Credits = Credits;
    }
}
