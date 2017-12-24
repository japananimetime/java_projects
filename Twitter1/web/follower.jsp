<%--
    Document   : index
    Created on : 23.04.2016, 10:39:40
    Author     : Damir
--%>

<%@page import="java.util.List"%>
<%@page import="Servlets.DBConnection"%>
<%@page import="Servlets.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Twitter</title>
        <link href="./css/style.css" rel="stylesheet">
    </head>

    <body>

        <div class="wrapper">

            <header class="header">
                <a href="tweets.jsp"><img src="images/twitter.jpg" alt="" id="image"></a>
                <div id="FilterText">
                    <%
                        if (session.getAttribute("user") != null) {
                            String name = ((User) session.getAttribute("user")).getName();
                            out.println("<a href='profile.jsp'>" + "<h1>" + name + "</h1>" + "</a> <form action='logout' method='post'><input type='submit' value='Log Out'></form>");
                        } else {
                            response.sendRedirect("index.jsp");
                        }
                        int id = Integer.parseInt(request.getParameter("id"));
                        DBConnection db = new DBConnection();
                        User u = db.getUserById(id);
                    %>
                </div>
            </header><!-- .header-->

            <div class="middle">
                <div id="container">
                    <main class="content">
                        <div id="profile">
                            <h2>Name: <% out.println(u.getName());%><br><br></h2>
                            <h2>Surname: <% out.println(u.getSurname());%></h2>
                            <h2>Login: <% out.println(u.getLogin());%></h2>
                            <h2>Mail address: <% out.println(u.getEmail());%>
                        </div>
                    </main><!-- .content -->
                </div><!-- .container-->

                <aside id="right-sidebar">
                    <%
                        List<User> list = db.getFollowers(u.getId());
                    %>
                    <h2>Follows: <br></h2>
                        <%
                            for (User user : list) {
                                out.println("<a href = 'follower.jsp?id=" + user.getId() + "'>" + user.getName() + " " + user.getSurname() + "</a>");
                                out.println("<br>");
                            }
                        %>
                        <%List<User> list1 = db.getFollows(u.getId());%>
                    <h2>Followers: <br></h2>
                        <%
                            for (User user : list1) {
                                out.println("<a href = 'follower.jsp?id=" + user.getId() + "'>" + user.getName() + " " + user.getSurname() + "</a>");
                                out.println("<br>");
                            }
                        %>
                    <br>
                    <br>
                    <%
                        if (!db.checkFoll(id, (((User) session.getAttribute("user")).getId()))) {
                            if(u.getId()!=((User)session.getAttribute("user")).getId()){
                                out.println("<form action='bFoll' method='post'><input type='hidden' value='" + id + "' name = 'id'><input type='submit' value='Follow'></form>");
                            }
                        }
                    %>
                </aside>
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
