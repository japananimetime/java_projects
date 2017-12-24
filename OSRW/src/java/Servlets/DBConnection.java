/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hikaro
 */
public class DBConnection {
    Connection conn;
    Statement stmt;
    public DBConnection(){
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/OSRW", "postgres", "qwerty");
            stmt = conn.createStatement();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }                
    }
    
//    public List<User> getUsers() {
//        ArrayList<User> list = new ArrayList();
//        try {            
//            ResultSet rs;
//            rs = stmt.executeQuery("SELECT * from users");
//            while(rs.next()) {
//                User u = new User();
//                u.setLogin(rs.getString("login"));
//                u.setName(rs.getString("name"));
//                u.setSurname(rs.getString("surname"));
//                list.add(u);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return list;
//    }
    
    public LinkedList<String> getStudentIDs() {
        LinkedList<String> IDs=new LinkedList();        
        try {
            String sql = "SELECT \"ID\"	FROM public.\"Students\";";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                IDs.add(rs.getString("ID"));
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return IDs;
    }
    
//    public User authenticate(String login,String password) {
//        User u  = null;
//        String sql = "select * from users where login='" + login + "' AND password='" + password +"'";
//        try {
//            ResultSet rs = stmt.executeQuery(sql);
//            rs.next();
//            u = new User();
//            u.setLogin(rs.getString("login"));
//            u.setPassword(rs.getString("password"));
//            u.setName(rs.getString("name"));
//            u.setSurname(rs.getString("surname"));
//        } catch (SQLException ex) {
//            return null;
//        }
//        return u;
//    } 
    public Student ReadStudent(String StudID) {
        try {
            String sql = "SELECT \"ID\", \"Name\", \"Surname\", \"Major\", \"Form\", \"Year\", \"Password\" FROM public.\"Students\"WHERE \"ID\"='"+StudID+"'";
            ResultSet rs = stmt.executeQuery(sql);
            Student s=new Student();
            while (rs.next()) {
                s.setName(rs.getString("Name"));
                s.setSurname(rs.getString("Surname"));
                s.setMajor(rs.getString("Major"));
                s.setYear(rs.getString("Year"));
                s.setForm(rs.getBoolean("Form"));
            }
            rs.close();            
            return s;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean login(String ID, String Password) {
        try {
            String sql ="SELECT \"Major\" FROM public.\"Students\" WHERE \"ID\"='"+ID+"' AND \"Password\"='"+Password+"';";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            if(rs.getString("Major").length()>0){
                rs.close();
                return true;
            }
            else{
                rs.close();
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean TermExists(String ID, int term) {
        try {
            String sql ="SELECT count(*) FROM public.\"Grades\" where \"StudID\"='"+ID+"' AND \"Term\"="+term+";";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            if(rs.getInt(1)>0){
                return true;
            }
            else return false;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public int MaxTerm(String ID) {        
            try {        
                String sql ="SELECT MAX(\"Term\") FROM public.\"Grades\" WHERE \"StudID\"="+ID;
                ResultSet rs = stmt.executeQuery(sql);
                
                    rs.next();
                    rs.getInt("Term");
                          
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
            return 0;
    }
    public int TermDisAmount(int term, String ID){
        try {
            String sql ="SELECT count(*) FROM public.\"Grades\" where \"StudID\"='"+ID+"' AND \"Term\"="+term+";";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;        
    }
    public LinkedList<Discipline> TermDisList(String ID, int term){
        try {
            String sql ="SELECT \"Code\", \"Name\", \"Credits\", \"Value\" FROM public.\"Disciplines\" JOIN public.\"Grades\" ON public.\"Disciplines\".\"ID\" = public.\"Grades\".\"DisID\" WHERE \"StudID\"='"+ID+"' AND \"Term\"="+term;
            ResultSet rs = stmt.executeQuery(sql);            
            LinkedList<Discipline> list=new LinkedList();
            while(rs.next()){
                Discipline d=new Discipline();
                d.setCode(rs.getString("Code"));
                d.setCredits(rs.getInt("Credits"));
                d.setGrade(rs.getInt("Value"));
                d.setName(rs.getString("Name"));
                d.setTerm(term);
                list.add(d);                
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
        public LinkedList<Discipline> DisList(String ID){
        try {
            String sql ="SELECT \"Code\", \"Name\", \"Credits\", \"Value\" FROM public.\"Disciplines\" JOIN public.\"Grades\" ON public.\"Disciplines\".\"ID\" = public.\"Grades\".\"DisID\" WHERE \"StudID\"='"+ID+"'";
            ResultSet rs = stmt.executeQuery(sql);            
            LinkedList<Discipline> list=new LinkedList();
            while(rs.next()){
                Discipline d=new Discipline();
                d.setGrade(rs.getInt("Value"));
                d.setName(rs.getString("Name"));
                list.add(d);                
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void CloseDB() {
        try {
            conn.close();
            stmt.close();            
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
