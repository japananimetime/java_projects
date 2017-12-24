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
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/japanmusic.kz", "postgres", "qwerty");
            stmt = conn.createStatement();
        conn.close();} catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } 
        try {
//           conn.commit();
            conn.close();
        conn.close();} catch (SQLException e) {
           e.printStackTrace();
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
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public void register(String login,String password,String email) {
        try {
            int id=getMaxUserId()+1;
            String sql = "INSERT INTO public.users VALUES('"+login+"', '"+password+"', '"+id+"', '"+email+"')";            
            ResultSet rs = stmt.executeQuery(sql);            
            conn.close();
        } catch (SQLException ex) {            
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getMaxUserId() {
        int id = 0;
        try {
            String sql = "select max(id) from public.users";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            id = rs.getInt(1);
            conn.close();
        conn.close();} catch (SQLException ex) {
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
            conn.close();
        conn.close();} catch (SQLException ex) {
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
            u.setMail(rs.getString("email"));
            u.setId(rs.getInt("id"));
            conn.close();
        conn.close();} catch (SQLException ex) {            
            u.setId(999999);
            return u;
        }
        return u;
    }
    
    public ArrayList<Song> getSongList (){
        String sql = "select * from public.songs";
        ArrayList<Song> list = new ArrayList<Song>();
        try {            
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * from public.songs");
            while(rs.next()) {
                Song s = new Song();
                s.setTitle(rs.getString("title"));
                s.setArtist(rs.getString("artist"));
                s.setAlbum(rs.getString("album"));
                s.setYear(rs.getInt("year"));
                s.setArt(rs.getString("image"));
                s.setGenre(rs.getString("genre"));
                s.setTrackNumber(rs.getInt("number"));
                s.setOST(rs.getBoolean("OST"));
                s.setAddress(rs.getString("address"));
                list.add(s);
            }
            conn.close();
        conn.close();} catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
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
            conn.close();
        conn.close();} catch (SQLException ex) {
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
            conn.close();
        conn.close();} catch (SQLException ex) {
            ex.printStackTrace();
        }
        return counter;
    }
    
    public boolean checkURI(String URI) {
        try {
            String sql = "SELECT   public.viewcount.\"URI\" FROM public.viewcount WHERE public.viewcount.\"URI\"= '"+URI+"';";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            if (rs.getString(1).equals(URI)){
                conn.close();
                return true;
            }
            else{
               conn.close();
               return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return true;
    }
    
    int getLastReleaseId() {
        String sql = "select max(id) from public.releases";
        int id=0;
        try {
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            id =rs.getInt(1);            
        conn.close();} catch (SQLException ex) {

        }
        return id;
    }

    void addRelease(Release release) {
        String sql = "insert into public.releases values('"+release.getTitle()+"', '"+release.getUser_id()+"', '"+"', '0', '0', '"+release.getDescription()+"', '"+release.getImage()+"', '"+release.getId()+"')";
          try {
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();                     
        conn.close();} catch (SQLException ex) {

        }
    }

    void addMessage(Message message) {
        String sql = "insert into public.messages values('"+message.getSenderId()+"', '"+message.getReceiverId()+"', '"+message.getText()+"', '0', '0', '"+maxMessageId()+"')";
          try {
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
        conn.close();} catch (SQLException ex) {

        }
    }

    int maxMessageId() {
        String sql = "select max(id) from public.messages";
        int id=0;
        try {
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            id =rs.getInt(1);
        conn.close();} catch (SQLException ex) {

        }
        return id;
    }

    public ArrayList<Message> showSentMessages(int id){
        String sql = "select * from public.users where sender_id='"+id+"'";
        ArrayList<Message> list=new ArrayList<Message>();
        Message message = new Message();
        try {
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                message.setText(rs.getString("text"));
                message.setSenderId(id);
                message.setReceiverId((rs.getInt("receiver_id")));
                message.setId((rs.getInt("id")));
                list.add(message);
            }
        conn.close();} catch (SQLException ex) {

        }
        return list;
    }
    public ArrayList<Message> showReceivedMessages(int id){
        String sql = "select * from public.users where receiver_id='"+id+"'";
        ArrayList<Message> list=new ArrayList<Message>();
        Message message = new Message();
        try {
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                message.setText(rs.getString("text"));
                message.setSenderId((rs.getInt("sender_id")));
                message.setReceiverId(id);
                message.setId((rs.getInt("id")));
                list.add(message);
            }
        conn.close();} catch (SQLException ex) {

        }
        return list;
    }
       
    public ArrayList<Release> getReleaseList (){
        String sql = "select * from public.releases";
        ArrayList<Release> list = new ArrayList<Release>();
        try {
            ResultSet rs;
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                Release r = new Release();
                r.setUser_id(rs.getInt("user_id"));
                r.setId(rs.getInt("id"));
                r.setImage(rs.getString("image"));
                r.setCommentsAmount(rs.getInt("commentsAmount"));
                r.setTitle(rs.getString("title"));
                r.setDescription(rs.getString("Description"));
                r.setSeen(rs.getInt("seen"));
                list.add(r);
            }
        conn.close();} catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public String getLoginById(int id) {
        String login="";
        String sql = "select login from public.users where id='"+id+"'";
        try {
            ResultSet rs = stmt.executeQuery(sql);
            rs.first();
            login=rs.getString(1);
        }
        catch(SQLException ex){
            
        }
        return login;
    }
    
    void addComment(String text, String releaseId, int userId) {
        
        try {
            String sql = "insert into public.comments values('"+text+"', '"+userId+"', '"+releaseId+"', '"+getMaxCommentId(releaseId)+"');";
            stmt.executeQuery(sql);            
        conn.close();} catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    int getMaxCommentId(String releaseId) {
        int id = 0;
        try {
            String sql = "select max(comment_id) from public.comments where tweet_id='"+releaseId+"'";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            id = rs.getInt(1);
        conn.close();} catch (SQLException ex) {
            ex.printStackTrace();
        }
        return id+1;
    }
    
    public List<Comment> getCommentsList(int release_id){
        ArrayList<Comment> list = new ArrayList();
        try {            
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * from public.comments where release_id='"+release_id+"'");
            while(rs.next()) {
                Comment c = new Comment();
                c.setText(rs.getString("text"));
                c.setReleaseId(rs.getInt("release_id"));
                c.setUserId(rs.getInt("user_id"));
                c.setCommentId(rs.getInt("comment_id"));
                list.add(c);
            }
        conn.close();} catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public User getUserById(int id) {
        User u = null;
        try {
            String sql = "Select * from public.users where id = " + id;
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            u = new User();
            u.setId(id);
            u.setMail(rs.getString("email"));
            u.setLogin(rs.getString("login"));
        } 
        catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
    
    public Release getReleaseById(int id) {
        Release r = new Release();
        try {
            String sql = "Select * from public.releases where id='"+id+"'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                r.setTitle(rs.getString("title"));
                r.setImage(rs.getString("image"));
                r.setDescription(rs.getString("description"));
                r.setUser_id(rs.getInt("user_id"));
                r.setId(id);
                r.setCommentsAmount(rs.getInt("commentsAmount"));
                r.setSeen(rs.getInt("seen"));                
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    public void updateRelease(int releaseId, int seen){
        try {
            String sql = "UPDATE from public.releases SET seen='"+seen+"' where release_id='"+releaseId+"'";
            ResultSet rs = stmt.executeQuery(sql);
        }
        catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}