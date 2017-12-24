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
                            out.print("<form action='login' method='post'>Login<input type='text' name='login'><br><br>"+
                            "Password <input type='password' name='pass'><br>"+
                            "<input type='submit' value='Submit'>");
                        }
                        else{
                            out.println("<h2>Welcome back, "+request.getSession(false).getAttribute("login")+"<h2><br>");
                            out.println("<h3>Press <a href='tweets.jsp'>here</a> to show your tweets</h3><br>");
                        }
                    %>                    
                </td>
            </tr>      <tr>
                <td align="right" valign="bottom" colspan="3" height="100%">
                    Made by Nadezhuk Oleg, CS142, IITU
                </td>
            </tr>      
        </table>
    </body>
</html>

