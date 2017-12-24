package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
    public DBConnection(){       
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Twitter", "postgres", "qwerty");
            stmt = conn.createStatement();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }                
    }                
    
    public List<User> getUsers() {
        ArrayList<User> list = new ArrayList();
        try {            
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * from public.users");
            while(rs.next()) {
                User u = new User();
                u.setLogin(rs.getString("login"));                
                list.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public void register(String login,String password,String email) {
        try {
            int id=getId()+1;
            String sql = "INSERT INTO public.users (id, login, password, mail) VALUES('"+Integer.toString(id)+"', '"+login+"', '"+password+"', '"+email+"')";            
            stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getId() {
        int id = 0;
        try {
            String sql = "select max(id) from public.users";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            id = rs.getInt(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return id;
    }
    public int getUserId(String login) {
        int id = 0;
        try {
            String sql = "select id from public.users where login='"+login+"'";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            id = rs.getInt(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return id;
    }
    
    public User authenticate(String login,String password) {
        User u  = null;
        String sql = "select * from public.users where login='"+login+"' AND password='"+password+"'";
        try {
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            u = new User();
            u.setLogin(rs.getString("login"));
            u.setPass(rs.getString("password"));            
        } catch (SQLException ex) {
            return null;
        }
        return u;
    }
    public void postTweet(String text, int user_id) {
        try {
            int id=getTweetId()+1;
            String sql = "INSERT INTO public.tweets (text, user_id, tweet_id) VALUES('"+text+"', '"+Integer.toString(user_id)+"', '"+Integer.toString(id)+"')";            
            stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void changeTweet(String newText, int tweet_id) {
        try {
            String sql = "UPDATE public.tweets set text='"+newText+"' where tweet_id='"+tweet_id+"'";            
            stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void removeTweet(int tweet_id) {
        try {
            String sql = "DELETE from public.tweets where tweet_id='"+tweet_id+"'";            
            stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<Tweet> getTweetsList() {
        ArrayList<Tweet> list = new ArrayList();
        try {            
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * from public.tweets");
            while(rs.next()) {
                Tweet t = new Tweet();
                t.setTweet_id(rs.getInt("tweet_id"));
                t.setText(rs.getString("text"));
                t.setUser_id(rs.getInt("user_id"));
                list.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public int getTweetId() {
        int id = 0;
        try {
            String sql = "select max(tweet_id) from public.tweets";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            id = rs.getInt(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return id;
    }
    
}
