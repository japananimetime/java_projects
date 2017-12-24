/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;
import Servlets.DBConnection;


/**
 *
 * @author 19452
 */
public class Release {
    private String title;
    private int user_id;
    private int id;
    private int seen;
    private int commentsAmount;
    private String image;
    private String description;
    
    private DBConnection db = new DBConnection();

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeen() {
        return seen;
    }

    public void setSeen(int seen) {
        this.seen = seen;
    }

    public int getCommentsAmount() {
        return commentsAmount;
    }

    public void setCommentsAmount(int commentsAmount) {
        this.commentsAmount = commentsAmount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    @Override
    public String toString() {
        return "<table><tr><td>"+title+"</td></tr><tr><td  class = 'releaseImage'><img src='"+image+"'></td></tr><tr<td>"+description+"</td></tr><tr><td align='left'>Posted by: "+user_id+"</td><td align='right'>"+commentsAmount+" comments<br>"+"Seen by"+ seen+"people</td></tr></table>";
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }   
    
}
