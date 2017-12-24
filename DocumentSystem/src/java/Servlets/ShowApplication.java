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
import javax.servlet.http.HttpSession;

/**
 *
 * @author 19452
 */
@WebServlet(name = "ShowApplication", urlPatterns = {"/ShowApplication"})
public class ShowApplication extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession(false);
            if (session.getAttribute("login") == null) {
                response.sendRedirect("login.jsp?status=\"denied\"");
            }
            if (request.getParameter("number")== null || request.getParameter("number").isEmpty()) {
                out.println("Пожалуйса вернитесь к списку и выберите заявление");
            }
            DBConnection db=new DBConnection();
            String number= request.getParameter("number");
            db.updateCount(number);
            Application a=db.getApplication(number);
            out.println("<!DOCTYPE HTML>");
            out.println("<!--");
            out.println("        Miniport by HTML5 UP");
            out.println("        html5up.net | @ajlkn");
            out.println("        Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)");
            out.println("-->");
            out.println("<html>");
            out.println("    <head>");
            out.println("        <title>Заявление №"+a.getNumber()+"</title>");
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
            out.println("                <li>"+db.getName(session.getAttribute("login").toString())+"</li>");
            out.println("                <li><a href='http://japananimetime.ddns.net/Application/Logout'>Выйти</a></li>");
            out.println("            </ul>");
            out.println("        </nav>");
            out.println("");
            out.println("        <!-- Contact -->");
            out.println("        <div class='wrapper style3'>");
            out.println("            <header>");
            out.println("                    <p><img src='logo.png'></p>");
            out.println("                    <h3>МЕЖДУНАРОДНЫЙ УНИВЕРСИТЕТ ИНФОРМАЦИОННЫХ ТЕХНОЛОГИЙ</h3>");
            out.println("            </header>");
            out.println("            <article id='contact' class='container 75%'>");
            out.println("                    <div class='row'>");
            out.println("                        <div class='6u 12u(mobile)'>");
            out.println("                            <br>");
            out.println("                        </div>");
            out.println("                        <div class='6u 12u(mobile)' style='text-align: justify;'>											");
            out.println("                            <b>Ректору АО « МУИТ»<br>");
            out.println("                            д.э.н., профессору Шыныбекову Д.А.<br>");
            out.println("                            от студента " + a.getCourse() + " курса,<br>");
            out.println("                            дневного отделения  специальности <br>");
            out.println("                            " + a.getFaculty() + "<br>");
            out.println("                            группы " + a.getGroup() + "  <br>");
            out.println("                            " + a.getSurname() + " " + a.getName() + " " + a.getFathername() + "<br>");
            out.println("                            Контактные тел.:" + a.getPhone() + "<br>");
            out.println("");                        
            out.println("                        <b></div>");
            out.println("                    </div>");
            if (a.getType().equals("1")) {

                out.println("						<div class='row'>");
                out.println("							<div class='12u'>");
                out.println("								ЗАЯВЛЕНИЕ<br>");
                out.println("								<br>");
                out.println("								Прошу Вас дать допуск к учебным занятиям и сдаче академической разницы по специальности  " + a.getFaculty() + " " + a.getCourse() + " курса дневного отделения.");
                out.println("							</div>");
                out.println("						</div>");
            } else if (a.getType().equals("2")) {

                out.println("						<div class='row'>");
                out.println("							<div class='12u'>");
                out.println("								ЗАЯВЛЕНИЕ<br>");
                out.println("								<br>");
                out.println("								Прошу Вас зачислить меня в число студентов " + a.getCourse() + " курса дневного отделения по специальности " + a.getFaculty() + ".<br><br>");
                out.println("							</div>");
                out.println("						</div>");
                out.println("					");
            } else if (a.getType().equals("3")) {

                out.println("						<div class='row'>");
                out.println("							<div class='12u'>");
                out.println("								ЗАЯВЛЕНИЕ<br>");
                out.println("								<br>");
                out.println("								Прошу Вас зачислить меня в число студентов " + a.getCourse() + " курса заочного отделения по специальности " + a.getFaculty() + ".");
                out.println("                			</div>");
                out.println("                		</div>");
                out.println("					");
            } else if (a.getType().equals("4")) {

                out.println("						<div class='row'>");
                out.println("                			<div class='12u'>");
                out.println("                			ЗАЯВЛЕНИЕ<br>");
                out.println("							<br>");
                out.println("							Прошу Вас восстановить меня в число студентов " + a.getCourse() + " курса дневного отделения по специальности " + a.getFaculty() + ".");
                out.println("							</div>");
                out.println("						</div>");
                out.println("					");
            } else if (a.getType().equals("5")) {

                out.println("						<div class='row'>");
                out.println("							<div class='12u'>");
                out.println("								ЗАЯВЛЕНИЕ<br>");
                out.println("								<br>");
                out.println("								Прошу Вас восстановить меня в число студентов " + a.getCourse() + " курса заочного отделения по специальности " + a.getFaculty() + ".");
                out.println("							</div>");
                out.println("						</div>");
            } else if (a.getType().equals("6")) {

                out.println("						<div class='row'>");
                out.println("							<div class='12u'>");
                out.println("								ЗАЯВЛЕНИЕ<br>");
                out.println("								<br>");
                out.println("								Прошу Вас отчислить меня из числа студентов " + a.getCourse() + " курса дневного отделения по специальности " + a.getFaculty() + " " + a.getReason() + ".");
                out.println("							</div>");
                out.println("						</div>");
            } else if (a.getType().equals("7")) {

                out.println("						<div class='row'>");
                out.println("							<div class='12u'>");
                out.println("								ЗАЯВЛЕНИЕ<br>");
                out.println("								<br>");
                out.println("								Прошу Вас отчислить меня из числа студентов " + a.getCourse() + " курса заочного отделения по специальности " + a.getFaculty() + " " + a.getReason() + ".");
                out.println("							</div>");
                out.println("						</div>");
            } else if (a.getType().equals("8")) {

                out.println("						<div class='row'>");
                out.println("							<div class='12u'>");
                out.println("								ЗАЯВЛЕНИЕ<br>");
                out.println("								<br>");
                out.println("								Прошу Вас оставить меня на повторный год обучения по специальности " + a.getFaculty() + "  дневного отделения  в " + a.getYearadd() + " учебном году, в связи с " + a.getReason() + ".");
                out.println("							</div>");
                out.println("						</div>");
            } else if (a.getType().equals("9")) {

                out.println("						<div class='row'>");
                out.println("							<div class='12u'>");
                out.println("								ЗАЯВЛЕНИЕ<br>");
                out.println("								<br>");
                out.println("								Прошу Вас оставить меня на повторный " + a.getCourse() + " курс обучения  в " + a.getYearadd() + " учебном году  по специльности " + a.getFaculty() + " заочного отделения  в связи  в " + a.getYearadd() + " учебном году, в связи с " + a.getReason() + " на платной основе.");
                out.println("							</div>");
                out.println("						</div>");
            }
            out.println("						<div class='row' align='left'>");
            out.println("							<div class='6u 12u(mobile)'>");
            out.println("								Просмотрено: "+a.getCount()+"<br>");
            out.println("							</div>");
            out.println("						</div>");            
            out.println("						<div class='row' align='left'>");
            out.println("							<div class='6u 12u(mobile)'>");
            if(a.getR()==1){
                out.println("								Ректор: Одобрил");
            }            
            else if(a.getR()==-1){
                out.println("								Ректор: Не одобрил");
            }
            else if(a.getR()==0){
                out.println("								Ректор: Не смотрел");
            }
            out.println("							</div>");
            out.println("						</div>");
            out.println("						<div class='row' align='left'>");
            out.println("							<div class='6u 12u(mobile)'>");
            if(a.getP()==1){
                out.println("								Проректор: Одобрил");
            }            
            else if(a.getP()==-1){
                out.println("								Проректор: Не одобрил");
            }
            else if(a.getP()==0){
                out.println("								Проректор: Не смотрел");
            }
            out.println("							</div>");
            out.println("						</div>");
            out.println("						<div class='row' align='left'>");
            out.println("							<div class='6u 12u(mobile)'>");
            if(a.getD()==1){
                out.println("								Декан: Одобрил");
            }            
            else if(a.getD()==-1){
                out.println("								Декан: Не одобрил");
            }
            else if(a.getD()==0){
                out.println("								Декан: Не смотрел");
            }
            out.println("							</div>");
            out.println("						</div>");  
            out.println("						<div class='row' align='left'>");
            out.println("							<div class='6u 12u(mobile)'>");
            if(a.getO()==1){
                out.println("								Офис-регистратор: Одобрил");
            }            
            else if(a.getO()==-1){
                out.println("								Офис-регистратор: Не одобрил");
            }
            else if(a.getO()==0){
                out.println("								Офис-регистратор: Не смотрел");
            }
            out.println("							</div>");
            out.println("						</div>");
            out.println("                    <div class='row 200%'><div class='12u'>                ");
            out.println("                            <form method='post' action='http://japananimetime.ddns.net/Application/ApplicationApprove'> ");
            out.println("                                    <input type='hidden' name='number' value='"+number+"' />");
            out.println("                                <ul class='actions'> ");
            out.println("                                    <li><input type='submit' name='approve' value='Одобрить' /></li> ");
            out.println("                                    <li><input type='submit' name='deny' value='Не одобрять' class='alt' /></li> ");
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
            db.CloseDB();
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
