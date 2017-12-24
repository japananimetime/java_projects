
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Servlets.Tweet"%>
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
                    %>
                </div>
            </header><!-- .header-->

            <div class="middle">
                <div id="container">
                    <main class="content">
                        <%  DBConnection db = new DBConnection();
                            List<Tweet> list = db.getTweetsList();%>
                        <%for (int i = list.size() - 1; i >= 0; i--) {%>
                        <div class="tweet">
                            <h2><%  out.println(list.get(i).getText());%></h2>
                            <%  out.println("<table id='tTable'><tr><td class='pUser'><a href = 'follower.jsp?id=" + list.get(i).getUser_id() + "'>"+db.getUserById(list.get(i).getUser_id()).getName()+"</a></td>");%>
                            <%  out.println("<td class='retweet'><form action='retweet' method='post'><a href='comment.jsp?id="+list.get(i).getTweet_id()+"'>Comments</a><br><input type='submit' value='Retweet'><input type='hidden' value='"+list.get(i).getTweet_id()+"' name='rId'></form></td></tr></table>");%>
                        </div>
                        <%}%>
                    </main>
                </div>
                <aside id="right-sidebar">
                    <h1>Add your tweet here</h1>
                    <form action="addTweet" method="post">
                        <input type="text" name="text"><br><br>
                        <input type="submit" value="Submit">
                    </form>
                </aside><!-- .right-sidebar -->


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
