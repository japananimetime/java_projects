/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 19452
 */
public class DBConnection {
    Connection conn;
    Statement stmt;
    public DBConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/iitu", "postgres", "qwerty");
            stmt = conn.createStatement();            
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ResultSet getstudentprofileinfo(String id){
        try{
            ResultSet rs;            
            rs = stmt.executeQuery("SELECT     studentaddress.id,     studentaddress.district,     studentaddress.bldnumber,     studentaddress.street,     studentaddress.apartment,     studentaddress.homestate,     studentaddress.homeregion,     studentaddress.homeapartment,     studentaddress.homebldnumber,     studentaddress.homedistrict,     studentaddress.homecity,     studentaddress.homestreet,     studentcommunications.homenumber,     studentcommunications.mobilenumber,     studentcommunications.mail,     studentdocs.id,     studentdocs.iin,     studentdocs.verdocnum,     studentdocs.verdocorg,     studentdocs.verdocdatebegin,     studentdocs.verdocdateend,     studentedproc.faculty,     studentedproc.s_group,     studentmain.firstname,     studentmain.lastname,     studentmain.firstnamelat,     studentmain.lastnamelat,     studentmain.adoptionyear,     studentmain.password,     studentpersonal.birth,     studentpersonal.sex,     studentpersonal.court,     studentpersonal.photo,     studentpersonal.yearsinjail,     studentrelationships.mothername,     studentrelationships.mothersurname,     studentrelationships.mothermiddlename,     studentrelationships.motherphonehome,     studentrelationships.motherphonemobile,     studentrelationships.mothermail,     studentrelationships.fathername,     studentrelationships.fathersurname,     studentrelationships.fathermiddlename,     studentrelationships.fatherphonehome,     studentrelationships.fatherphonemobile,     studentrelationships.fathermail  FROM     public.studentaddress,     public.studentdocs,     public.studentcommunications,     public.studentedproc,     public.studentmain,     public.studentpersonal,     public.studentrelationships  WHERE    public.studentmain.id="+id);
            for (int i=0; i<Integer.parseInt(id); i++){    
                rs.next();
            }
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
    public HashMap<String, String> getstudentprofileinfo1(String id){
        StudentInfo info = null;
        try{
            ResultSet rs;            
            rs = stmt.executeQuery("SELECT     studentaddress.id,     studentaddress.district,     studentaddress.bldnumber,     studentaddress.street,     studentaddress.apartment,     studentaddress.homestate,     studentaddress.homeregion,     studentaddress.homeapartment,     studentaddress.homebldnumber,     studentaddress.homedistrict,     studentaddress.homecity,     studentaddress.homestreet,     studentcommunications.homenumber,     studentcommunications.mobilenumber,     studentcommunications.mail,     studentdocs.id,     studentdocs.iin,     studentdocs.verdocnum,     studentdocs.verdocorg,     studentdocs.verdocdatebegin,     studentdocs.verdocdateend,     studentedproc.faculty,     studentedproc.s_group,     studentmain.firstname,     studentmain.lastname,     studentmain.firstnamelat,     studentmain.lastnamelat,     studentmain.adoptionyear,     studentmain.password,     studentpersonal.birth,     studentpersonal.sex,     studentpersonal.court,     studentpersonal.photo,     studentpersonal.yearsinjail,     studentrelationships.mothername,     studentrelationships.mothersurname,     studentrelationships.mothermiddlename,     studentrelationships.motherphonehome,     studentrelationships.motherphonemobile,     studentrelationships.mothermail,     studentrelationships.fathername,     studentrelationships.fathersurname,     studentrelationships.fathermiddlename,     studentrelationships.fatherphonehome,     studentrelationships.fatherphonemobile,     studentrelationships.fathermail  FROM     public.studentaddress,     public.studentdocs,     public.studentcommunications,     public.studentedproc,     public.studentmain,     public.studentpersonal,     public.studentrelationships  WHERE    public.studentmain.id="+id);
            rs.next();
            ResultSetMetaData rsmd= rs.getMetaData();
            HashMap<String, String> row = new HashMap(rsmd.getColumnCount());
            for(int i=1; i<=rsmd.getColumnCount(); ++i){           
                row.put(rsmd.getColumnName(i),rs.getString(i));
            }
            return row;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }

    public void updatestudentprofileinfo(String id, String parameterValue, String parameterName, String tableName){
        try {
            stmt.executeUpdate("UPDATE "+tableName+" SET "+parameterName+"='"+parameterValue+"' WHERE id="+id);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public StudentInfo authenticate(String login, String password){
        StudentInfo s  = null;
        String sql = "select id, firstname,lastname from studentmain where id='" + login + "' AND password='" + password +"'";
        try {
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            s = new StudentInfo();
            s.setName(rs.getString("firstname"));
            s.setSurname(rs.getString("lastname"));
            s.setId(login);
        } catch (SQLException ex) {
            return null;
        }
        return s;
    }
}
