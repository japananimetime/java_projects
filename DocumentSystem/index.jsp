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
                    <h2>Заявление</h2>
                    <p>Введите данные в поля ниже для того чтобы подать заявление</p>
                </header>
                <div>
                    <div class="row">
                        <div class="12u">
                            <form method="post" action="http://japananimetime.ddns.net/Application/App" accept-charset="UTF-8">
                                <div>
                                    <div class="row">
                                        <div class="6u 12u(mobile)">
                                            <input type="text" name="name" id="name" placeholder="Имя" required/>
                                        </div>
                                        <div class="6u 12u(mobile)">
                                            <input type="text" name="surname" id="surname" placeholder="Фамилия" required/>
                                        </div>
                                        <div class="6u 12u(mobile)">
                                            <input type="text"  name="fathername" id="fathername" placeholder="Отчество" required/>
                                        </div>
                                        <div class="6u 12u(mobile)">
                                            <input type="text" name="phone" id="phone" placeholder="Телефон" required/>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="12u">
                                            <select required name="faculty">
                                                <option value="CS">
                                                    5B060200-Computer Science
                                                </option>
                                                <option  value="IS">
                                                    5B070500-Infomation systems
                                                </option>
                                                <option value="RET">
                                                    5B071900-Radioelectronics
                                                </option>
                                                <option value="MCM">
                                                    5B070500-Mathematical and Computer Modelling
                                                </option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="6u 12u(mobile)">
                                            <select required name="course">
                                                <option value="1">
                                                    1 курс
                                                </option>
                                                <option value="2">
                                                    2 курс
                                                </option>
                                                <option value="3">
                                                    3 курс
                                                </option>
                                                <option value="4">
                                                    4 курс
                                                </option>
                                            </select>											
                                        </div>
                                        <div class="6u 12u(mobile)">
                                            <input type="text" name="group" id="group" placeholder="Группа" required/>																							
                                        </div>
                                    </div>								
                                    <div class="row">
                                        <div class="12u">
                                            <select required name="type">
                                                <option value="1">
                                                    Допуск к учебным занятиям и сдаче академической разницы 
                                                </option>
                                                <option value="2">
                                                    Зачислить в число студентов дневного отделения
                                                </option>
                                                <option value="3">
                                                    Зачислить в число студентов заочного отделения
                                                </option>
                                                <option value="4">
                                                    Восстановить в число студентов дневного отделения
                                                </option>
                                                <option value="5">
                                                    Восстановить в число студентов заочного отделения
                                                </option>
                                                <option value="6">
                                                    Отчислить из числа студентов дневного отделения 
                                                </option>
                                                <option value="7">
                                                    Отчислить из числа студентов заочного отделения 
                                                </option>
                                                <option value="8">
                                                    Оставить на повторный год обучения дневного отделения 
                                                </option>
                                                <option value="9">
                                                    Оставить на повторный год обучения заочного отделения 
                                                </option>
                                            </select>
                                        </div>
                                    </div>
                                    <%
                                        // This scriptlet declares and initializes "date"
                                        System.out.println( "Evaluating date now" );
                                        java.util.Date date = new java.util.Date();
                                        out.print("<input type='hidden' value='"+date.getDate()+"' name='day'>");
                                        out.print("<input type='hidden' value='"+(date.getMonth()+1)+"' name='month'>");
                                        out.print("<input type='hidden' value='"+(date.getYear()+1900)+"' name='year'>");
                                    %>
                                    <div class="row 200%">
                                        <div class="12u">
                                            <ul class="actions">
                                                <li><input type="submit" value="Продолжить" /></li>
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
