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
                    %>            
            </div>
	</header><!-- .header-->

	<div class="middle">

            <div id='error'><h1>There is no such a page you requested</h1></div>

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
