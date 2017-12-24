/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 19452
 */
@WebServlet(name = "ApplicationReview", urlPatterns = {"/ApplicationReview"})
public class ApplicationReview extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            request.setCharacterEncoding("UTF-8");
            /* TODO output your page here. You may use following sample code. */
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String fathername = request.getParameter("fathername");
            String phone = request.getParameter("phone");
            String faculty = request.getParameter("faculty");
            String course = request.getParameter("course");
            String group = request.getParameter("group");
            String type = request.getParameter("type");
            String day = request.getParameter("day");
            String month = request.getParameter("month");
            String year = request.getParameter("year");
            String yearadd = request.getParameter("yearadd");
            String reason = request.getParameter("reason");
            if (faculty.equals("CS")) {
                faculty = "Computer Science";
            } else if (faculty.equals("IS")) {
                faculty = "Information Systems";
            } else if (faculty.equals("RET")) {
                faculty = "Radioelectronics";
            }
            out.println("<!DOCTYPE HTML>");
            out.println("<!--");
            out.println("        Miniport by HTML5 UP");
            out.println("        html5up.net | @ajlkn");
            out.println("        Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)");
            out.println("-->");
            out.println("<html>");
            out.println("    <head>");
            out.println("        <title>Miniport by HTML5 UP</title>");
            out.println("        <meta charset='utf-8' />");
            out.println("        <meta name='viewport' content='width=device-width, initial-scale=1' />");
            out.println("        <!--[if lte IE 8]><script src='assets/js/ie/html5shiv.js'></script><![endif]-->");
            out.println("        <link rel='stylesheet' href='assets/css/main.css' />");
            out.println("        <!--[if lte IE 8]><link rel='stylesheet' href='assets/css/ie8.css' /><![endif]-->");
            out.println("        <!--[if lte IE 9]><link rel='stylesheet' href='assets/css/ie9.css' /><![endif]-->");
            out.println("    </head>");
            out.println("    <body style='background-color: #000;'>");
            out.println("        <!-- Nav -->");
            out.println("        <nav id='nav'>");
            out.println("            <ul class='container'>");
            out.println("                <li><a href='http://japananimetime.ddns.net/Application/login.jsp'>Войти</a></li>");
            out.println("            </ul>");
            out.println("        </nav>");
            out.println("");
            out.println("        <!-- Contact -->");
            out.println("        <div class='wrapper style3'>");
            out.println("            <article id='contact' class='container 75%'>");
            out.println("                <header>");
            out.println("                    <h2>Предпросмотр</h2>");
            out.println("                    <p>Проверьте введённые данные</p>");
            out.println("                </header>");
            out.println("                    <div class='row'>");
            out.println("                        <div class='6u 12u(mobile)'>");
            out.println("                            <br>");
            out.println("                        </div>");
            out.println("                        <div class='6u 12u(mobile)' style='text-align: justify;'>											");
            out.println("                            Ректору АО « МУИТ»<br>");
            out.println("                            д.э.н., профессору Шыныбекову Д.А.<br>");
            out.println("                            от студента " + course + " курса,<br>");
            out.println("                            дневного отделения  специальности <br>");
            out.println("                            " + faculty + "<br>");
            out.println("                            группы " + group + "  <br>");
            out.println("                            " + surname + " " + name + " " + fathername + "<br>");
            out.println("                            Контактные тел.:" + phone + "<br>");
            out.println("");
            out.println("                        </div>");
            out.println("                    </div>");
            if (type.equals("1")) {

                out.println("						<div class='row'>");
                out.println("							<div class='12u'>");
                out.println("								ЗАЯВЛЕНИЕ<br>");
                out.println("								<br>");
                out.println("								Прошу Вас дать допуск к учебным занятиям и сдаче академической разницы по специальности  " + faculty + " " + course + " курса дневного отделения.");
                out.println("							</div>");
                out.println("						</div>");
            } else if (type.equals("2")) {

                out.println("						<div class='row'>");
                out.println("							<div class='12u'>");
                out.println("								ЗАЯВЛЕНИЕ<br>");
                out.println("								<br>");
                out.println("								Прошу Вас зачислить меня в число студентов " + course + " курса дневного отделения по специальности " + faculty + ".<br><br>");
                out.println("							</div>");
                out.println("						</div>");
                out.println("					");
            } else if (type.equals("3")) {

                out.println("						<div class='row'>");
                out.println("							<div class='12u'>");
                out.println("								ЗАЯВЛЕНИЕ<br>");
                out.println("								<br>");
                out.println("								Прошу Вас зачислить меня в число студентов " + course + " курса заочного отделения по специальности " + faculty + ".");
                out.println("                			</div>");
                out.println("                		</div>");
                out.println("					");
            } else if (type.equals("4")) {

                out.println("						<div class='row'>");
                out.println("                			<div class='12u'>");
                out.println("                			ЗАЯВЛЕНИЕ<br>");
                out.println("							<br>");
                out.println("							Прошу Вас восстановить меня в число студентов " + course + " курса дневного отделения по специальности " + faculty + ".");
                out.println("							</div>");
                out.println("						</div>");
                out.println("					");
            } else if (type.equals("5")) {

                out.println("						<div class='row'>");
                out.println("							<div class='12u'>");
                out.println("								ЗАЯВЛЕНИЕ<br>");
                out.println("								<br>");
                out.println("								Прошу Вас восстановить меня в число студентов " + course + " курса заочного отделения по специальности " + faculty + ".");
                out.println("							</div>");
                out.println("						</div>");
            } else if (type.equals("6")) {

                out.println("						<div class='row'>");
                out.println("							<div class='12u'>");
                out.println("								ЗАЯВЛЕНИЕ<br>");
                out.println("								<br>");
                out.println("								Прошу Вас отчислить меня из числа студентов " + course + " курса дневного отделения по специальности " + faculty + " " + reason + ".");
                out.println("							</div>");
                out.println("						</div>");
            } else if (type.equals("7")) {

                out.println("						<div class='row'>");
                out.println("							<div class='12u'>");
                out.println("								ЗАЯВЛЕНИЕ<br>");
                out.println("								<br>");
                out.println("								Прошу Вас отчислить меня из числа студентов " + course + " курса заочного отделения по специальности " + faculty + " " + reason + ".");
                out.println("							</div>");
                out.println("						</div>");
            } else if (type.equals("8")) {

                out.println("						<div class='row'>");
                out.println("							<div class='12u'>");
                out.println("								ЗАЯВЛЕНИЕ<br>");
                out.println("								<br>");
                out.println("								Прошу Вас оставить меня на повторный год обучения по специальности " + faculty + "  дневного отделения  в " + yearadd + " учебном году, в связи с " + reason + ".");
                out.println("							</div>");
                out.println("						</div>");
            } else if (type.equals("9")) {

                out.println("						<div class='row'>");
                out.println("							<div class='12u'>");
                out.println("								ЗАЯВЛЕНИЕ<br>");
                out.println("								<br>");
                out.println("								Прошу Вас оставить меня на повторный " + course + " курс обучения  в " + yearadd + " учебном году  по специльности " + faculty + " заочного отделения  в связи  в " + yearadd + " учебном году, в связи с " + reason + " на платной основе.");
                out.println("							</div>");
                out.println("						</div>");
            }
            out.println("                    <div class='row 200%'><div class='12u'>                ");
            out.println("                            <form method='post' action='http://japananimetime.ddns.net/Application/ApplicationSend'> ");
            out.println("                                <input type='hidden' value='" + name + "' name='name'>");
            out.println("                                <input type='hidden' value='" + surname + "' name='surname'>");
            out.println("                                <input type='hidden' value='" + fathername + "' name='fathername'>");
            out.println("                                <input type='hidden' value='" + phone + "' name='phone'>");
            out.println("                                <input type='hidden' value='" + faculty + "' name='faculty'>");
            out.println("                                <input type='hidden' value='" + course + "' name='course'>");
            out.println("                                <input type='hidden' value='" + group + "' name='group'>");
            out.println("                                <input type='hidden' value='" + type + "' name='type'>");
            out.println("                                <input type='hidden' value='" + day + "' name='day'>");
            out.println("                                <input type='hidden' value='" + month + "' name='month'>");
            out.println("                                <input type='hidden' value='" + year + "' name='year'>");
            out.println("                                <input type='hidden' value='" + yearadd + "' name='year'>                                ");
            out.println("                                <input type='hidden' value='" + reason + "' name='year'>");
            out.println("                                <ul class='actions'> ");
            out.println("                                    <li><input type='submit' value='Отправить' /></li> ");
            out.println("                                    <li><input type='reset' value='Очистить' class='alt' /></li> ");
            out.println("                                </ul>");
            out.println("                            </form> ");
            out.println("                        </div>");
            out.println("					</div>");
            out.println("			</article>");
            out.println("		</div>			");
            out.println("		<footer id='footer' style='margin-top: 0px;'>");
            out.println("			<ul style='margin-bottom: 0px;'>");
            out.println("				<li>&copy; Untitled. All rights reserved.</li>");
            out.println("				<li>Design: <a href='http://html5up.net'>HTML5 UP</a></li>");
            out.println("			</ul>");
            out.println("		</footer>");
            out.println("		<!-- Scripts -->");
            out.println("		<script src='assets/js/jquery.min.js'></script>");
            out.println("		<script src='assets/js/jquery.scrolly.min.js'></script>");
            out.println("		<script src='assets/js/skel.min.js'></script>");
            out.println("		<script src='assets/js/skel-viewport.min.js'></script>");
            out.println("		<script src='assets/js/util.js'></script>");
            out.println("		<!--[if lte IE 8]><script src='assets/js/ie/respond.min.js'></script><![endif]-->");
            out.println("		<script src='assets/js/main.js'></script>");
            out.println("    </body>");
            out.println("</html>");        
    }
}

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
/**
 * Handles the HTTP <code>GET</code> method.
 *
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException if an I/O error occurs
 */
@Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
        public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
