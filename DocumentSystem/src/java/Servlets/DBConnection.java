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
 * @author 19452
 */
public class DBConnection {

    Connection conn;
    Statement stmt;

    public DBConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Application", "postgres", "qwerty");
            stmt = conn.createStatement();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean login(String login, String password) {
        try {
            String sql = "SELECT \"Name\" FROM public.\"Management\" where \"Login\"='" + login.toLowerCase() + "' AND \"Password\"='" + password + "';";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            if (rs.getString("Name").length() > 0) {
                rs.close();
                return true;
            } else {
                rs.close();
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void placeApplication(Application a) {
        try {
            String sql = "INSERT INTO public.\"Messages\" (\"Number\", \"Name\", \"Surname\", \"FatherName\", \"Course\", \"Faculty\", \"Group\", \"Type\", \"Day\", \"Month\", \"Year\", \"AdditionalYear\", \"Reason\", \"Rektor\", \"Prorektor\", \"Dekan\", \"Office\", \"Phone\", \"Count\") VALUES (" + a.getNumber() + ", '" + a.getName() + "','" + a.getSurname() + "', '" + a.getFathername() + "', '" + a.getCourse() + "', '" + a.getFaculty() + "', '" + a.getGroup() + "', '" + a.getType() + "', '" + a.getDay() + "', '" + a.getMonth() + "', '" + a.getYear() + "', '" + a.getYearadd() + "', '" + a.getReason() + "', 0, 0, 0, 0, " + a.getPhone() + ", 0);";
            ResultSet rs = stmt.executeQuery(sql);
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateCount(String n) {
        try {
            String sql = "UPDATE public.\"Messages\" SET \"Count\"=" + (getViewCount(n) + 1) + " WHERE \"Number\"=" + n + ";";
            ResultSet rs = stmt.executeQuery(sql);
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getViewCount(String n) {
        try {
            String sql = "SELECT \"Count\" FROM public.\"Messages\" WHERE \"Number\"=" + n + ";";
            int Count;
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            Count = rs.getInt(1);
            rs.close();
            return Count;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int getMaxNumber() {
        try {
            String sql = "SELECT MAX(\"Number\") FROM public.\"Messages\"";
            int number;
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            number = rs.getInt(1);
            rs.close();
            return number;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public String getName(String login) {
        try {
            String sql = "SELECT \"Name\" FROM public.\"Management\" WHERE \"Login\"='" + login + "';";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            return rs.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return " ";
    }

    public LinkedList<Application> ApplicationsList(String year, String month) {
        try {
            String sql = "SELECT \"Number\", \"Name\", \"Surname\", \"FatherName\", \"Day\" FROM public.\"Messages\" WHERE \"Month\"='" + month + "' AND \"Year\"='" + year + "';";
            ResultSet rs = stmt.executeQuery(sql);
            LinkedList<Application> list = new LinkedList();
            while (rs.next()) {
                Application a = new Application(rs.getInt("Number") - 1);
                a.setName(rs.getString("Name"));
                a.setSurname(rs.getString("Surname"));
                a.setFathername(rs.getString("FatherName"));
                a.setDay(rs.getString("Day"));
                a.setMonth(month);
                a.setYear(year);
                list.add(a);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void ApproveR(String n) {
        try {
            String sql = "UPDATE public.\"Messages\" SET \"Rektor\"=1 WHERE \"Number\"=" + n + ";";
            ResultSet rs = stmt.executeQuery(sql);
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ApproveP(String n) {
        try {
            String sql = "UPDATE public.\"Messages\" SET \"Prorektor\"=1 WHERE \"Number\"=" + n + ";";
            ResultSet rs = stmt.executeQuery(sql);
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ApproveD(String n) {
        try {
            String sql = "UPDATE public.\"Messages\" SET \"Dekan\"=1 WHERE \"Number\"=" + n + ";";
            ResultSet rs = stmt.executeQuery(sql);
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ApproveO(String n) {
        try {
            String sql = "UPDATE public.\"Messages\" SET \"Office\"=1 WHERE \"Number\"=" + n + ";";
            ResultSet rs = stmt.executeQuery(sql);
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void DisApproveR(String n) {
        try {
            String sql = "UPDATE public.\"Messages\" SET \"Rektor\"=-1 WHERE \"Number\"=" + n + ";";
            ResultSet rs = stmt.executeQuery(sql);
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void DisApproveP(String n) {
        try {
            String sql = "UPDATE public.\"Messages\" SET \"Prorektor\"=-1 WHERE \"Number\"=" + n + ";";
            ResultSet rs = stmt.executeQuery(sql);
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void DisApproveD(String n) {
        try {
            String sql = "UPDATE public.\"Messages\" SET \"Dekan\"=-1 WHERE \"Number\"=" + n + ";";
            ResultSet rs = stmt.executeQuery(sql);
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void DisApproveO(String n) {
        try {
            String sql = "UPDATE public.\"Messages\" SET \"Office\"=-1 WHERE \"Number\"=" + n + ";";
            ResultSet rs = stmt.executeQuery(sql);
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Application getApplication(String number) {
        try {
            String sql = "SELECT \"Name\", \"Surname\", \"FatherName\", \"Course\", \"Faculty\", \"Group\", \"Type\", \"Day\", \"Month\", \"Year\", \"AdditionalYear\", \"Reason\", \"Rektor\", \"Prorektor\", \"Dekan\", \"Office\", \"Phone\", \"Count\" FROM public.\"Messages\" WHERE \"Number\"=" + number + ";";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            Application a = new Application(Integer.parseInt(number) - 1);
            a.setName(rs.getString("Name"));
            a.setSurname(rs.getString("Surname"));
            a.setFathername(rs.getString("FatherName"));
            a.setCourse(rs.getString("Course"));
            a.setFaculty(rs.getString("Faculty"));
            a.setGroup(rs.getString("Group"));
            a.setType(rs.getString("Type"));
            a.setDay(rs.getString("Day"));
            a.setMonth(rs.getString("Month"));
            a.setYear(rs.getString("Year"));
            a.setYearadd(rs.getString("AdditionalYear"));
            a.setReason(rs.getString("Reason"));
            a.setPhone(rs.getString("Phone"));
            a.setR(rs.getInt("Rektor"));
            a.setP(rs.getInt("Prorektor"));
            a.setD(rs.getInt("Dekan"));
            a.setO(rs.getInt("Office"));
            a.setCount(rs.getInt("Count"));
            rs.close();
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public LinkedList<String> getYears() {
        try {
            String sql = "SELECT DISTINCT \"Year\" FROM public.\"Messages\";";
            ResultSet rs = stmt.executeQuery(sql);
            LinkedList<String> list = new LinkedList();
            while (rs.next()) {
                list.add(rs.getString("Year"));
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
