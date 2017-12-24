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
public class Student {

    private String name;
    private String Surname;
    private String Major;
    private String Year;
    private boolean Form;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the Surname
     */
    public String getSurname() {
        return Surname;
    }

    /**
     * @param Surname the Surname to set
     */
    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    /**
     * @return the Major
     */
    public String getMajor() {
        return Major;
    }

    /**
     * @param Major the Major to set
     */
    public void setMajor(String Major) {
        this.Major = Major;
    }

    /**
     * @return the Year
     */
    public String getYear() {
        return Year;
    }

    /**
     * @param Year the Year to set
     */
    public void setYear(String Year) {
        this.Year = Year;
    }

    /**
     * @return the Form
     */
    public boolean isForm() {
        return Form;
    }

    /**
     * @param Form the Form to set
     */
    public void setForm(boolean Form) {
        this.Form = Form;
    }
}
