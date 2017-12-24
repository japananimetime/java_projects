<%-- 
    Document   : index
    Created on : 23.04.2016, 10:39:40
    Author     : Damir
--%>

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
                        if(session.getAttribute("user")!=null){
                            String name=((User)session.getAttribute("user")).getName();
                            out.println("<a href='profile.jsp'>"+"<h1>"+name+"</h1>"+"</a> <form action='logout' method='post'><input type='submit' value='Log Out'></form>");
                        }
                        DBConnection db=new DBConnection();
                    %>            
            </div>
                
	</header><!-- .header-->

	<div class="middle">

		<div class="container">
			<main class="content">
                            <h1>Welcome to Twitter.</h1>

                            <h3>Connect with your friends — and other fascinating people. Get in-the-moment updates on the things that interest you. And watch events unfold, in real time, from every angle.</h3>
			</main><!-- .content -->
		</div><!-- .container-->

		<aside class="right-sidebar">
                    <div id="rTezt">
                        <form action="login" method="post">
                            <h2> Log-in or <a href="./register.jsp">register</a></h2>
                            <br>Login:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="login"><br>
                            <br>Password:   <input type="password" name="password"> <br><br>
                            <input type="submit" value="Log-in">
                        </form>
                    </div>
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
