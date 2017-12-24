<%--
    Document   : index
    Created on : 23.04.2016, 10:39:40
    Author     : Damir
--%>

<%@page import="Servlets.Comment"%>
<%@page import="Servlets.Tweet"%>
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
                    %>
                </div>
            </header><!-- .header-->

            <div class="middle">
                <div id="container">
                    <main class="content">
                        <div id="profile">
                            <%Tweet t=db.getTweetById(id);%>
                            <div class="tweet">
                                <h2>
                                    <%  out.println(t.getText());%>
                                </h2>
                                <%  out.println("<table id='tTable'><tr><td class='pUser'><a href = 'follower.jsp?id=" + t.getUser_id() + "'>"+db.getUserById(t.getUser_id()).getName()+"</a></td>");%>
                                <%  out.println("<td class='retweet'><form action='retweet' method='post'><br><input type='submit' value='Retweet'><input type='hidden' value='"+t.getTweet_id()+"' name='rId'></form></td></tr></table>");%>
                                <form action="addComment" method="post">
                                    <input type="text" name ="text">
                                    <% out.println("<input type='hidden' name='TweetId' value='"+t.getTweet_id()+"'>");%>
                                    <input type="submit" value="Add Comment">
                                </form>
                            </div>
                        </div>
                    </main><!-- .content -->
                </div><!-- .container-->

                <aside id="right-sidebar">
                    <div class="comment">
                        <% 
                           List<Comment> list=db.getCommentsList(t.getTweet_id());
                           for (int i = (list.size() - 1); i >= 0; i--) {
                        %>
                        <h3><% out.println(list.get(i).getText());%></h3>
                        <% out.println("<table id='tTable'><tr><td class='pUser'><a href = 'follower.jsp?id=" + list.get(i).getUser_id() + "'>"+db.getUserById(list.get(i).getUser_id()).getName()+"</a></td>");%>
                        <%}%>
                    </div>                    
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
