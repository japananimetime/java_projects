<%-- 
    Document   : register
    Created on : 12.03.2016, 10:51:29
    Author     : 19350
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                    <form action="register" method="POST">
                        <label for="regLogin">Login</label>
                        <input type="text" name="regLogin"/>
                        <br>
                        <br>
                        <label for="regPass">Password</label>
                        <input type="password" name="regPass"/>
                        <br>            
                        <br>
                        <label for="mail">Mail</label>
                        <input type="text" name="regMail"><br><br>            
                        <input type="submit"/>
                    </form>
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
