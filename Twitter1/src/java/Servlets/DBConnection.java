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
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "qwerty");
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
                u.setName(rs.getString("name"));
                u.setSurname(rs.getString("surname"));
                u.setEmail(rs.getString("email"));
                list.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public void register(String login,String password,String name,String surname,String email) {
        try {
            String sql = "insert into public.users values('" + name + "','" + surname + "','" + login +
                    "','" + password + "','" + email + "','" + (getId() + 1) +"')";
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void counter(String URI){
        try {
            if(!checkURI(URI)){
                String sql = "insert into public.viewcount values('" + URI + "', '"+(int)(getCounter(URI)+1)+"')";
                ResultSet rs = stmt.executeQuery(sql);
            }
            else{
                String sql = "DELETE FROM public.viewcount where \"URI\"='"+URI+"';INSERT INTO viewcount values('"+URI+"', '"+(int)(getCounter(URI)+1)+"');";
                ResultSet rs = stmt.executeQuery(sql);
            }
        } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
    
    public int getCounter(String URI) {
        int counter=0;
        try {
            String sql = "SELECT viewcount.counter FROM public.viewcount WHERE \"URI\"='"+URI+"';";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                counter = rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return counter;
    }
    
    public boolean checkURI(String URI) {
        try {
            String sql = "SELECT   viewcount.\"URI\" FROM public.viewcount WHERE viewcount.\"URI\"= '"+URI+"';";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            if (rs.getString(1).equals(URI)){
                return true;
            }
            else{
               return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return true;
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
    
    public User authenticate(String login,String password) {
        User u  = null;
        String sql = "select * from public.users where login='" + login + "' AND password='" + password +"'";
        try {
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            u = new User();
            u.setLogin(rs.getString("login"));
            u.setPassword(rs.getString("password"));
            u.setName(rs.getString("name"));
            u.setSurname(rs.getString("surname"));
            u.setEmail(rs.getString("email"));
            u.setId(rs.getInt("id"));
        } catch (SQLException ex) {
            return null;
        }
        return u;
    }
    
    public List<User> getFollowers(int userId){
        List<User> followers = new ArrayList();
        String sql = "select follower_id from followers where user_id = "+userId;
        List<Integer> followerIds = new ArrayList();
        try {
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                followerIds.add(rs.getInt(1));
            }
            for(Integer i: followerIds) {
                followers.add(getUserById(i));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return followers;
    }
    
    public List<User> getFollows(int userId){
        List<User> follows = new ArrayList();
        String sql = "select user_id from followers where follower_id = "+userId;
        List<Integer> followerIds = new ArrayList();
        try {
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                followerIds.add(rs.getInt(1));
            }
            for(Integer i: followerIds) {
                follows.add(getUserById(i));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return follows;
    }
        
    public User getUserById(int id) {
        User u = null;
        try {
            String sql = "Select * from public.users where id = " + id;
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            u = new User();
            u.setId(id);
            u.setEmail(rs.getString("email"));
            u.setLogin(rs.getString("login"));
            u.setName(rs.getString("name"));
            u.setSurname(rs.getString("surname"));
            } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
    
    public Tweet getTweetById(int id) {
        Tweet t = new Tweet();
        try {
            String sql = "Select * from public.tweets where tweet_id='"+id+"'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                t.setText(rs.getString(3));
                t.setTweet_id(rs.getInt(2));
                t.setUser_id(rs.getInt(1));
            }
            } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }
    
    public List<Tweet> getTweetsList(){
        ArrayList<Tweet> list = new ArrayList();
        try {            
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * from public.tweets");
            while(rs.next()) {
                Tweet t = new Tweet();
                t.setText(rs.getString("text"));
                t.setTweet_id(rs.getInt("tweet_id"));
                t.setUser_id(rs.getInt("user_id"));
                list.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    int getMaxTweetId() {
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

    void addTweet(String text, int userId, int tweetId) {
        try {
            String sql = "insert into public.tweets values('" + userId + "','" + tweetId + "','" + text + "')";
            stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void addFoll(int fId, int userId) {
        try {
            String sql = "insert into public.followers values('" + fId + "','" + userId + "')";
            stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean checkFoll(int fId, int userId){
        try {
            String sql = "select * from public.followers where follower_id='" + fId + "' AND user_id='" + userId +"'";            
            stmt.executeQuery(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){           
                if(rs.getInt("user_id")==userId && rs.getInt("follower_id")==fId){
                    return true;
                }
                else{
                    return false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    void addRetweet(int tweetId, int userId, String text) {
        try {
            String sql = "insert into public.retweet values('" + userId + "','" + tweetId + "');"
                    + "insert into public.tweets values('" + userId + "','" + (int)(getMaxTweetId()+1) + "','" + text + "');";
            stmt.executeQuery(sql);            
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void addComment(String text, String tweetId, int userId) {
        
        try {
            String sql = "insert into public.comments values('"+userId+"', '"+(int)(getMaxCommentId(Integer.parseInt(tweetId))+1)+"', '"+tweetId+"', '"+text+"')";
            stmt.executeQuery(sql);            
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    int getMaxCommentId(int tweetId) {
        int id = 0;
        try {
            String sql = "select max(comment_id) from public.comments where tweet_id='"+tweetId+"'";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            id = rs.getInt(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return id;
    }
    
    public List<Comment> getCommentsList(int tweet_id){
        ArrayList<Comment> list = new ArrayList();
        try {            
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * from public.comments where tweet_id='"+tweet_id+"'");
            while(rs.next()) {
                Comment c = new Comment();
                c.setText(rs.getString("text"));
                c.setTweet_id(rs.getInt("tweet_id"));
                c.setUser_id(rs.getInt("user_id"));
                c.setComment_id(rs.getInt("comment_id"));
                list.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
