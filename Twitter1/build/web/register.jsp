<%--
    Document   : register
    Created on : 23.04.2016, 10:57:44
    Author     : Damir
--%>

<%@page import="Servlets.DBConnection"%>
<%@page import="Servlets.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/style.css" rel="stylesheet">
        <title>Register</title>
    </head>
    <body>
        <div class='wrapper'>
            <header class="header">
                <a href="tweets.jsp"><img src="images/twitter.jpg" alt="" id="image"></a>
                <div id="FilterText">
                    <%
                        if (session.getAttribute("user") != null) {
                            String name = ((User) session.getAttribute("user")).getName();
                            out.println("<a href='profile.jsp'>" + "<h1>" + name + "</h1>" + "</a> <form action='logout' method='post'><input type='submit' value='Log Out'></form>");
                        }
                        DBConnection db=new DBConnection();
                    %>
                </div>
            </header><!-- .header-->
            <div class="middle">
                <main id='registerForm'>
                    <div id='rTezt1'>
                        <form action="register" method="post">
                            <h2> Register on Twitter</h2>
                            <br>Name: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="name"><br>
                            <br>Surname:&nbsp;&nbsp;&nbsp;<input type="text" name="surname"><br>
                            <br>Login:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="login"><br>
                            <br>Password:   <input type="password" name="password"> <br>
                            <br>Email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="email"><br><br>
                            <input type="submit" value="Register">
                        </form>
                    </div>
                </main><!-- .content -->
            </div><!-- .middle-->

            <footer class="footer">
                <div id="fooFilter"><h4>This page was visited <%out.println(db.getCounter(request.getRequestURL().toString()));%><br>  times</h4></div>
                <div id='credits'><h3>Made by Nadezhuk Oleg&nbsp;&nbsp;<br>
                    IITU 2016&nbsp;&nbsp;<br>
                    Group CS142R&nbsp;&nbsp;</h3></div>
            </footer><!-- .footer -->

        </div><!-- .wrapper -->

    </body>
</html>