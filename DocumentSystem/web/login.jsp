<%-- 
    Document   : index
    Created on : 29.04.2017, 1:21:36
    Author     : Hikaro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<!--
        Miniport by HTML5 UP
        html5up.net | @ajlkn
        Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
    <head>
        <title>Project</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
        <link rel="stylesheet" href="assets/css/main.css" />
        <!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
        <!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
    </head>
    <body style="background-color: #000;">
        <!-- Nav -->
        <nav id="nav">
            <ul class="container">
                <li><a href="http://japananimetime.ddns.net/Application/login.jsp">Войти</a></li>
            </ul>
        </nav>

        <!-- Contact -->
        <div class="wrapper style3">
            <article id="contact" class="container 75%">
                <header>
                    <h2>Вход в личный кабинет</h2>
                    <p>Введите свои логин и пароль для того чтобы получить доступ к личном кабинету</p>
                </header>
                <div>
                    <div class="row">
                        <div class="12u">
                            <form method="post" action="http://japananimetime.ddns.net/Application/Cabinet">
                                <div>
                                    <%
                                        if (request.getParameter("status") != null) {
                                            out.println("<div class='row'><div class='12u'>Неверный логин или пароль</div></div>");
                                        } else {

                                        }
                                    %>
                                    <div class="row">
                                        <div class="12u">
                                            <input type="text" name="login" id="login" placeholder="Логин" required/>
                                        </div>                                        
                                    </div>
                                    <div class="row">
                                        <div class="12u">

                                        </div>
                                    </div>						
                                    <div class="row">
                                        <div class="12u">
                                            <input type="password" name="password" id="password" placeholder="Пароль" required/>
                                        </div>
                                    </div>                                    
                                    <div class="row 200%">
                                        <div class="12u">
                                            <ul class="actions">
                                                <li><input type="submit" value="Войти" /></li>
                                                <li><input type="reset" value="Очистить" class="alt" /></li>
                                            </ul>
                                        </div>
                                    </div>                                    
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </article>
        </div>			
        <footer id="footer" style="margin-top: 0px;">
            <ul style="margin-bottom: 0px;">
                <li>&copy; Untitled. All rights reserved.</li>
                <li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
            </ul>
        </footer>			

        <!-- Scripts -->
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/js/jquery.scrolly.min.js"></script>
        <script src="assets/js/skel.min.js"></script>
        <script src="assets/js/skel-viewport.min.js"></script>
        <script src="assets/js/util.js"></script>
        <!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
        <script src="assets/js/main.js"></script>

    </body>
</html>
