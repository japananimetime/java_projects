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
@WebServlet(name = "App", urlPatterns = {"/App"})
public class App extends HttpServlet {

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
            request.setCharacterEncoding("UTF-8");
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

            if (type.equals("1")) {
//                out.println("qwerty");
                request.getRequestDispatcher("/ApplicationReview").forward(request, response);
            } else if (type.equals("2")) {
                request.getRequestDispatcher("/ApplicationReview").forward(request, response);
            } else if (type.equals("3")) {
                request.getRequestDispatcher("/ApplicationReview").forward(request, response);
            } else if (type.equals("4")) {
                request.getRequestDispatcher("/ApplicationReview").forward(request, response);
            } else if (type.equals("5")) {
                request.getRequestDispatcher("/ApplicationReview").forward(request, response);
            } else if (type.equals("6")) {
                out.println("<!DOCTYPE HTML>");
                out.println("<!--");
                out.println("	Miniport by HTML5 UP");
                out.println("	html5up.net | @ajlkn");
                out.println("	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)");
                out.println("-->");
                out.println("<html>");
                out.println("	<head>");
                out.println("		<title>Miniport by HTML5 UP</title>");
                out.println("		<meta charset='utf-8' />");
                out.println("		<meta name='viewport' content='width=device-width, initial-scale=1' />");
                out.println("		<!--[if lte IE 8]><script src='assets/js/ie/html5shiv.js'></script><![endif]-->");
                out.println("		<link rel='stylesheet' href='assets/css/main.css' />");
                out.println("		<!--[if lte IE 8]><link rel='stylesheet' href='assets/css/ie8.css' /><![endif]-->");
                out.println("		<!--[if lte IE 9]><link rel='stylesheet' href='assets/css/ie9.css' /><![endif]-->");
                out.println("	</head>");
                out.println("	<body style='background-color: #000;'>");
                out.println("		<!-- Nav -->");
                out.println("        <nav id='nav'>");
                out.println("            <ul class='container'>");
                out.println("                <li><a href='http://japananimetime.ddns.net/Applicationhttp://japananimetime.ddns.net/Application/login.jsp'>Войти</a></li>");
                out.println("            </ul>");
                out.println("        </nav>");
                out.println("");
                out.println("		<!-- Contact -->");
                out.println("			<div class='wrapper style3'>");
                out.println("				<article id='contact' class='container 75%'>");
                out.println("					<header>");
                out.println("						<h2>Дополнительные данные</h2>");
                out.println("						<p>Введите данные в поля ниже для того чтобы подать заявление</p>");
                out.println("					</header>");
                out.println("					<div>");
                out.println("						<div class='row'>");
                out.println("							<div class='12u'>");
                out.println("								<form method='post' action='http://japananimetime.ddns.net/Application/ApplicationReview'>");
                out.println("									<div>");
                out.println("										<div class='row'>											");
                out.println("											<div class='6u 12u(mobile)'>");
                out.println("                                                                                       <input type='hidden' value='" + name + "' name='name'>");
                out.println("                                                                                       <input type='hidden' value='" + surname + "' name='surname'>");
                out.println("                                                                                       <input type='hidden' value='" + fathername + "' name='fathername'>");
                out.println("                                                                                       <input type='hidden' value='" + phone + "' name='phone'>");
                out.println("                                                                                       <input type='hidden' value='" + faculty + "' name='faculty'>");
                out.println("                                                                                       <input type='hidden' value='" + course + "' name='course'>");
                out.println("                                                                                       <input type='hidden' value='" + group + "' name='group'>");
                out.println("                                                                                       <input type='hidden' value='" + type + "' name='type'>");
                out.println("                                                                                       <input type='hidden' value='" + day + "' name='day'>");
                out.println("                                                                                       <input type='hidden' value='" + month + "' name='month'>");
                out.println("                                                                                       <input type='hidden' value='" + year + "' name='year'>");
                out.println("                                                                               </div>	");
                out.println("										</div>		");
                out.println("										<div class='row'>											");
                out.println("											<div class='12u'>");
                out.println("												<input type='text' name ='reason' placeholder='В связи с'>");
                out.println("											</div>	");
                out.println("										</div>										");
                out.println("										</div>");
                out.println("										<div class='row 200%'>");
                out.println("											<div class='12u'>");
                out.println("												<ul class='actions'>");
                out.println("													<li><input type='submit' value='Продолжить' /></li>");
                out.println("													<li><input type='reset' value='Очистить' class='alt' /></li>");
                out.println("												</ul>");
                out.println("											</div>");
                out.println("										</div>");
                out.println("									</div>");
                out.println("								</form>");
                out.println("							</div>");
                out.println("						</div>");
                out.println("					</div>");
                out.println("					</article>");
                out.println("			</div>			");
                out.println("			<footer id='footer' style='margin-top: 0px;'>");
                out.println("				<ul style='margin-bottom: 0px;'>");
                out.println("					<li>&copy; Untitled. All rights reserved.</li>");
                out.println("					<li>Design: <a href='http://html5up.net'>HTML5 UP</a></li>");
                out.println("				</ul>");
                out.println("			</footer>			");
                out.println("");
                out.println("		<!-- Scripts -->");
                out.println("			<script src='assets/js/jquery.min.js'></script>");
                out.println("			<script src='assets/js/jquery.scrolly.min.js'></script>");
                out.println("			<script src='assets/js/skel.min.js'></script>");
                out.println("			<script src='assets/js/skel-viewport.min.js'></script>");
                out.println("			<script src='assets/js/util.js'></script>");
                out.println("			<!--[if lte IE 8]><script src='assets/js/ie/respond.min.js'></script><![endif]-->");
                out.println("			<script src='assets/js/main.js'></script>");
                out.println("");
                out.println("	</body>");
                out.println("</html>");
            } else if (type.equals("7")) {
                out.println("<!DOCTYPE HTML>");
                out.println("<!--");
                out.println("	Miniport by HTML5 UP");
                out.println("	html5up.net | @ajlkn");
                out.println("	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)");
                out.println("-->");
                out.println("<html>");
                out.println("	<head>");
                out.println("		<title>Miniport by HTML5 UP</title>");
                out.println("		<meta charset='utf-8' />");
                out.println("		<meta name='viewport' content='width=device-width, initial-scale=1' />");
                out.println("		<!--[if lte IE 8]><script src='assets/js/ie/html5shiv.js'></script><![endif]-->");
                out.println("		<link rel='stylesheet' href='assets/css/main.css' />");
                out.println("		<!--[if lte IE 8]><link rel='stylesheet' href='assets/css/ie8.css' /><![endif]-->");
                out.println("		<!--[if lte IE 9]><link rel='stylesheet' href='assets/css/ie9.css' /><![endif]-->");
                out.println("	</head>");
                out.println("	<body style='background-color: #000;'>");
                out.println("		<!-- Nav -->");
                out.println("        <nav id='nav'>");
                out.println("            <ul class='container'>");
                out.println("                <li><a href='http://japananimetime.ddns.net/Application/login.jsp'>Войти</a></li>");
                out.println("            </ul>");
                out.println("        </nav>");
                out.println("");
                out.println("		<!-- Contact -->");
                out.println("			<div class='wrapper style3'>");
                out.println("				<article id='contact' class='container 75%'>");
                out.println("					<header>");
                out.println("						<h2>Дополнительные данные</h2>");
                out.println("						<p>Введите данные в поля ниже для того чтобы подать заявление</p>");
                out.println("					</header>");
                out.println("					<div>");
                out.println("						<div class='row'>");
                out.println("							<div class='12u'>");
                out.println("								<form method='post' action='http://japananimetime.ddns.net/Application/ApplicationReview'>");
                out.println("									<div>");
                out.println("										<div class='row'>											");
                out.println("											<div class='6u 12u(mobile)'>");
                out.println("                                                                                       <input type='hidden' value='" + name + "' name='name'>");
                out.println("                                                                                       <input type='hidden' value='" + surname + "' name='surname'>");
                out.println("                                                                                       <input type='hidden' value='" + fathername + "' name='fathername'>");
                out.println("                                                                                       <input type='hidden' value='" + phone + "' name='phone'>");
                out.println("                                                                                       <input type='hidden' value='" + faculty + "' name='faculty'>");
                out.println("                                                                                       <input type='hidden' value='" + course + "' name='course'>");
                out.println("                                                                                       <input type='hidden' value='" + group + "' name='group'>");
                out.println("                                                                                       <input type='hidden' value='" + type + "' name='type'>");
                out.println("                                                                                       <input type='hidden' value='" + day + "' name='day'>");
                out.println("                                                                                       <input type='hidden' value='" + month + "' name='month'>");
                out.println("                                                                                       <input type='hidden' value='" + year + "' name='year'>");
                out.println("                                                                               </div>	");
                out.println("										</div>		");
                out.println("										<div class='row'>											");
                out.println("											<div class='12u'>");
                out.println("												<input type='text' name ='reason' placeholder='В связи с'>");
                out.println("											</div>	");
                out.println("										</div>										");
                out.println("										</div>");
                out.println("										<div class='row 200%'>");
                out.println("											<div class='12u'>");
                out.println("												<ul class='actions'>");
                out.println("													<li><input type='submit' value='Продолжить' /></li>");
                out.println("													<li><input type='reset' value='Очистить' class='alt' /></li>");
                out.println("												</ul>");
                out.println("											</div>");
                out.println("										</div>");
                out.println("									</div>");
                out.println("								</form>");
                out.println("							</div>");
                out.println("						</div>");
                out.println("					</div>");
                out.println("					</article>");
                out.println("			</div>			");
                out.println("			<footer id='footer' style='margin-top: 0px;'>");
                out.println("				<ul style='margin-bottom: 0px;'>");
                out.println("					<li>&copy; Untitled. All rights reserved.</li>");
                out.println("					<li>Design: <a href='http://html5up.net'>HTML5 UP</a></li>");
                out.println("				</ul>");
                out.println("			</footer>			");
                out.println("");
                out.println("		<!-- Scripts -->");
                out.println("			<script src='assets/js/jquery.min.js'></script>");
                out.println("			<script src='assets/js/jquery.scrolly.min.js'></script>");
                out.println("			<script src='assets/js/skel.min.js'></script>");
                out.println("			<script src='assets/js/skel-viewport.min.js'></script>");
                out.println("			<script src='assets/js/util.js'></script>");
                out.println("			<!--[if lte IE 8]><script src='assets/js/ie/respond.min.js'></script><![endif]-->");
                out.println("			<script src='assets/js/main.js'></script>");
                out.println("");
                out.println("	</body>");
                out.println("</html>");
            } else if (type.equals("8")) {
                out.println("<!DOCTYPE HTML>");
                out.println("<!--");
                out.println("	Miniport by HTML5 UP");
                out.println("	html5up.net | @ajlkn");
                out.println("	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)");
                out.println("-->");
                out.println("<html>");
                out.println("	<head>");
                out.println("		<title>Miniport by HTML5 UP</title>");
                out.println("		<meta charset='utf-8' />");
                out.println("		<meta name='viewport' content='width=device-width, initial-scale=1' />");
                out.println("		<!--[if lte IE 8]><script src='assets/js/ie/html5shiv.js'></script><![endif]-->");
                out.println("		<link rel='stylesheet' href='assets/css/main.css' />");
                out.println("		<!--[if lte IE 8]><link rel='stylesheet' href='assets/css/ie8.css' /><![endif]-->");
                out.println("		<!--[if lte IE 9]><link rel='stylesheet' href='assets/css/ie9.css' /><![endif]-->");
                out.println("	</head>");
                out.println("	<body style='background-color: #000;'>");
                out.println("		<!-- Nav -->");
                out.println("        <nav id='nav'>");
                out.println("            <ul class='container'>");
                out.println("                <li><a href='http://japananimetime.ddns.net/Application/login.jsp'>Войти</a></li>");
                out.println("            </ul>");
                out.println("        </nav>");
                out.println("");
                out.println("		<!-- Contact -->");
                out.println("			<div class='wrapper style3'>");
                out.println("				<article id='contact' class='container 75%'>");
                out.println("					<header>");
                out.println("						<h2>Дополнительные данные</h2>");
                out.println("						<p>Введите данные в поля ниже для того чтобы подать заявление</p>");
                out.println("					</header>");
                out.println("					<div>");
                out.println("						<div class='row'>");
                out.println("							<div class='12u'>");
                out.println("								<form method='post' action='http://japananimetime.ddns.net/Application/ApplicationReview'>");
                out.println("									<div>");
                out.println("										<div class='row'>											");
                out.println("                                                                                       <input type='hidden' value='" + name + "' name='name'>");
                out.println("                                                                                       <input type='hidden' value='" + surname + "' name='surname'>");
                out.println("                                                                                       <input type='hidden' value='" + fathername + "' name='fathername'>");
                out.println("                                                                                       <input type='hidden' value='" + phone + "' name='phone'>");
                out.println("                                                                                       <input type='hidden' value='" + faculty + "' name='faculty'>");
                out.println("                                                                                       <input type='hidden' value='" + course + "' name='course'>");
                out.println("                                                                                       <input type='hidden' value='" + group + "' name='group'>");
                out.println("                                                                                       <input type='hidden' value='" + type + "' name='type'>");
                out.println("                                                                                       <input type='hidden' value='" + day + "' name='day'>");
                out.println("                                                                                       <input type='hidden' value='" + month + "' name='month'>");
                out.println("                                                                                       <input type='hidden' value='" + year + "' name='year'>");
                out.println("											<div class='12u'>											");
                out.println("													<input type='text' name ='yearadd' placeholder='Год'>");
                out.println("											</div>");
                out.println("										</div>		");
                out.println("										<div class='row'>											");
                out.println("											<div class='12u'>");
                out.println("												<input type='text' name ='reason' placeholder='В связи с'>");
                out.println("											</div>	");
                out.println("										</div>										");
                out.println("												<!--<textarea name='message' id='message' placeholder='Текст заявления' required></textarea>-->											");
                out.println("										</div>");
                out.println("										<div class='row 200%'>");
                out.println("											<div class='12u'>");
                out.println("												<ul class='actions'>");
                out.println("													<li><input type='submit' value='Продолжить' /></li>");
                out.println("													<li><input type='reset' value='Очистить' class='alt' /></li>");
                out.println("												</ul>");
                out.println("											</div>");
                out.println("										</div>");
                out.println("									</div>");
                out.println("								</form>");
                out.println("							</div>");
                out.println("						</div>");
                out.println("					</div>");
                out.println("					</article>");
                out.println("			</div>			");
                out.println("			<footer id='footer' style='margin-top: 0px;'>");
                out.println("				<ul style='margin-bottom: 0px;'>");
                out.println("					<li>&copy; Untitled. All rights reserved.</li>");
                out.println("					<li>Design: <a href='http://html5up.net'>HTML5 UP</a></li>");
                out.println("				</ul>");
                out.println("			</footer>			");
                out.println("");
                out.println("		<!-- Scripts -->");
                out.println("			<script src='assets/js/jquery.min.js'></script>");
                out.println("			<script src='assets/js/jquery.scrolly.min.js'></script>");
                out.println("			<script src='assets/js/skel.min.js'></script>");
                out.println("			<script src='assets/js/skel-viewport.min.js'></script>");
                out.println("			<script src='assets/js/util.js'></script>");
                out.println("			<!--[if lte IE 8]><script src='assets/js/ie/respond.min.js'></script><![endif]-->");
                out.println("			<script src='assets/js/main.js'></script>");
                out.println("");
                out.println("	</body>");
                out.println("</html>");
            } else if (type.equals("9")) {
                out.println("<!DOCTYPE HTML>");
                out.println("<!--");
                out.println("	Miniport by HTML5 UP");
                out.println("	html5up.net | @ajlkn");
                out.println("	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)");
                out.println("-->");
                out.println("<html>");
                out.println("	<head>");
                out.println("		<title>Miniport by HTML5 UP</title>");
                out.println("		<meta charset='utf-8' />");
                out.println("		<meta name='viewport' content='width=device-width, initial-scale=1' />");
                out.println("		<!--[if lte IE 8]><script src='assets/js/ie/html5shiv.js'></script><![endif]-->");
                out.println("		<link rel='stylesheet' href='assets/css/main.css' />");
                out.println("		<!--[if lte IE 8]><link rel='stylesheet' href='assets/css/ie8.css' /><![endif]-->");
                out.println("		<!--[if lte IE 9]><link rel='stylesheet' href='assets/css/ie9.css' /><![endif]-->");
                out.println("	</head>");
                out.println("	<body style='background-color: #000;'>");
                out.println("		<!-- Nav -->");
                out.println("        <nav id='nav'>");
                out.println("            <ul class='container'>");
                out.println("                <li><a href='http://japananimetime.ddns.net/Application/login.jsp'>Войти</a></li>");
                out.println("            </ul>");
                out.println("        </nav>");
                out.println("");
                out.println("		<!-- Contact -->");
                out.println("			<div class='wrapper style3'>");
                out.println("				<article id='contact' class='container 75%'>");
                out.println("					<header>");
                out.println("						<h2>Дополнительные данные</h2>");
                out.println("						<p>Введите данные в поля ниже для того чтобы подать заявление</p>");
                out.println("					</header>");
                out.println("					<div>");
                out.println("						<div class='row'>");
                out.println("							<div class='12u'>");
                out.println("								<form method='post' action='http://japananimetime.ddns.net/Application/ApplicationReview'>");
                out.println("									<div>");
                out.println("										<div class='row'>											");
                out.println("                                                                                       <input type='hidden' value='" + name + "' name='name'>");
                out.println("                                                                                       <input type='hidden' value='" + surname + "' name='surname'>");
                out.println("                                                                                       <input type='hidden' value='" + fathername + "' name='fathername'>");
                out.println("                                                                                       <input type='hidden' value='" + phone + "' name='phone'>");
                out.println("                                                                                       <input type='hidden' value='" + faculty + "' name='faculty'>");
                out.println("                                                                                       <input type='hidden' value='" + course + "' name='course'>");
                out.println("                                                                                       <input type='hidden' value='" + group + "' name='group'>");
                out.println("                                                                                       <input type='hidden' value='" + type + "' name='type'>");
                out.println("                                                                                       <input type='hidden' value='" + day + "' name='day'>");
                out.println("                                                                                       <input type='hidden' value='" + month + "' name='month'>");
                out.println("                                                                                       <input type='hidden' value='" + year + "' name='year'>");
                out.println("											<div class='12u'>											");
                out.println("													<input type='text' name ='yearadd' placeholder='Год'>");
                out.println("											</div>");
                out.println("										</div>		");
                out.println("										<div class='row'>											");
                out.println("											<div class='12u'>");
                out.println("												<input type='text' name ='reason' placeholder='В связи с'>");
                out.println("											</div>	");
                out.println("										</div>										");
                out.println("												<!--<textarea name='message' id='message' placeholder='Текст заявления' required></textarea>-->											");
                out.println("										</div>");
                out.println("										<div class='row 200%'>");
                out.println("											<div class='12u'>");
                out.println("												<ul class='actions'>");
                out.println("													<li><input type='submit' value='Продолжить' /></li>");
                out.println("													<li><input type='reset' value='Очистить' class='alt' /></li>");
                out.println("												</ul>");
                out.println("											</div>");
                out.println("										</div>");
                out.println("									</div>");
                out.println("								</form>");
                out.println("							</div>");
                out.println("						</div>");
                out.println("					</div>");
                out.println("					</article>");
                out.println("			</div>			");
                out.println("			<footer id='footer' style='margin-top: 0px;'>");
                out.println("				<ul style='margin-bottom: 0px;'>");
                out.println("					<li>&copy; Untitled. All rights reserved.</li>");
                out.println("					<li>Design: <a href='http://html5up.net'>HTML5 UP</a></li>");
                out.println("				</ul>");
                out.println("			</footer>			");
                out.println("");
                out.println("		<!-- Scripts -->");
                out.println("			<script src='assets/js/jquery.min.js'></script>");
                out.println("			<script src='assets/js/jquery.scrolly.min.js'></script>");
                out.println("			<script src='assets/js/skel.min.js'></script>");
                out.println("			<script src='assets/js/skel-viewport.min.js'></script>");
                out.println("			<script src='assets/js/util.js'></script>");
                out.println("			<!--[if lte IE 8]><script src='assets/js/ie/respond.min.js'></script><![endif]-->");
                out.println("			<script src='assets/js/main.js'></script>");
                out.println("");
                out.println("	</body>");
                out.println("</html>");            
            }
            else if(!type.equals("1")||!type.equals("2")||!type.equals("3")||!type.equals("4")||!type.equals("5")||!type.equals("6")||!type.equals("7")||!type.equals("8")||!type.equals("9")){
                out.println("Type not defined");
            }
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
