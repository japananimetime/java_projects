<%@page import="java.util.ArrayList"%>
<%@page import="Servlets.Tweet"%>
<%@page import="Servlets.User"%>
<%@page import="java.util.List"%>
<%@page import="Servlets.DBConnection"%>
<%-- 
    Document   : index
    Created on : 12.03.2016, 10:50:15
    Author     : 19350
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
        <body bgcolor="#00CFF9">
        <table width="100%" style="height: 100%;">
            <tr>
                <td align="left" valign="top">
                    <h1>
                        <img src="./19h0k17097jh8png.png" width="420" height="158" alt="Twitter"/>
                    </h1><br>
                    <%  if (request.getSession(false).getAttribute("login")==null){ 
                            out.println("<a href='./login.jsp'>Login</a>/<a href='./register.jsp'>Register</a>");
                        }
                        else{
                            out.println("Hello, "+session.getAttribute("login")+"<br> <form action='logout' method='post'><input type='submit' value='Log Out'></form>");
                        }
                    %>
                </td>
                <td align="right" valign="top">
                    <img src="ad.png" alt="Your Ad Could Be Here"/>
                </td>
            </tr>
            <tr>
                <td colspan="3" align="center">
                    <%  if (request.getSession(false).getAttribute("login")==null){ 
                            out.print("<h2>You need to <a href='./login.jsp'>log-in</a> to see the tweets</h2><br>"+
                            "<h2>Don't have an account yet?<br>"+
                            "<a href='./register.jsp'>Register</a></h2>");
                        }
                        else{
                            out.println("<h3>Here you can read and post your tweets</h3>");
                            out.println("<form action='tweetPost' method='post'><input type='textarea' value='type your tweet here' name='tweetText'><br><input type='submit'></form><br>");
                        }                  
                         out.println("<h3>Your tweets:</h3> <br>");
                       DBConnection db = new DBConnection();
                       ArrayList<Tweet> list = db.getTweets();
                       int uid= Integer.parseInt(session.getAttribute("id").toString());
                        for(int i=(list.size()-1); i>=0; i--){
                           if(list.get(i).getUser_id()==uid){
                                out.println("<form action='edit.jsp' method='post'><h4>"+list.get(i).getText()+"<input type='hidden' value='"+list.get(i).getText()+"' name='tCO'>"+"<input type='hidden' value='"+list.get(i).getTweet_id()+"' name='tID'>"+"</h4><input type='submit' value='Edit'></form><br>");
                           }                           
                       }
                   %>
                </td>
            </tr>
            <tr>
                <td align="right" valign="bottom" colspan="3" height="100%">
                    Made by Nadezhuk Oleg, CS142, IITU
                </td>
            </tr>
        </table>
    </body>
</html>