/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
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
@WebServlet(name = "FilteredApplications", urlPatterns = {"/FilteredApplications"})
public class FilteredApplications extends HttpServlet {

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
            java.util.Date date = new java.util.Date();
            String month = request.getParameter("FilteredMonth");
            String year = request.getParameter("FilteredYear");
            DBConnection db = new DBConnection();
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
            out.println("                <li>"+db.getName(session.getAttribute("login").toString())+"</li>");
            out.println("                <li><a href='http://japananimetime.ddns.net/Application/Logout'>Выйти</a></li>");
            out.println("            </ul>");
            out.println("        </nav>");
            out.println("");
            out.println("        <!-- Contact -->");
            out.println("        <div class='wrapper style3'>");
            out.println("            <article id='contact' class='container 75%'>");
            out.println("                <header>");
            out.println("                    <h2>Список заявлений</h2>");
            out.println("                    <p>Выберите одно из новых заявлений или отфильтруйте заявления за конкретный месяц</p>");
            out.println("                </header>");
            out.println("                <div>");
            out.println("                    <div class='row'>");
            out.println("                        <div class='12u'>");
            out.println("                            <form method='post' action='http://japananimetime.ddns.net/Application/FilteredApplications'>");
            out.println("                                <div>");
            out.println("                                    <div class='row'>");
            out.println("                                        <div class='6u 12u(mobile)'>");
            out.println("                                            <select required name='FilteredYear'>");
            LinkedList<String> listOfYears = db.getYears();
            for (int i = 0; i < listOfYears.size(); i++) {
                out.println("                                                <option value='" + listOfYears.get(i) + "'>");
                out.println(listOfYears.get(i));
                out.println("                                                </option>");
            }
            out.println("                                            </select>");
            out.println("                                        </div>");
            out.println("                                        <div class='6u 12u(mobile)'>");
            out.println("                                            <select required name='FilteredMonth'>");
            out.println("                                                <option value='1'>");
            out.println("                                                    Январь");
            out.println("                                                </option>");
            out.println("                                                <option value='2'>");
            out.println("                                                    Февраль");
            out.println("                                                </option>");
            out.println("                                                <option value='3'>");
            out.println("                                                    Март");
            out.println("                                                </option>");
            out.println("                                                <option value='4'>");
            out.println("                                                    Апрель");
            out.println("                                                </option>");
            out.println("                                                <option value='5'>");
            out.println("                                                    Май");
            out.println("                                                </option>");
            out.println("                                                <option value='6'>");
            out.println("                                                    Июнь");
            out.println("                                                </option>");
            out.println("                                                <option value='7'>");
            out.println("                                                    Июль>");
            out.println("                                                <option value='8'>");
            out.println("                                                    Август");
            out.println("                                                </option>");
            out.println("                                                <option value='9'>");
            out.println("                                                    Сентябрь");
            out.println("                                                </option>");
            out.println("                                                <option value='10'>");
            out.println("                                                    Октябрь");
            out.println("                                                </option>");
            out.println("                                                <option value='11'>");
            out.println("                                                    Ноябрь");
            out.println("                                                </option>");
            out.println("                                                <option value='12'>");
            out.println("                                                    Декабрь");
            out.println("                                                </option>");
            out.println("                                            </select>");
            out.println("                                        </div>");
            out.println("                                    </div>");
            LinkedList<Application> listOfApplications = db.ApplicationsList(year, month);
            for (int i = 0; i < listOfApplications.size(); i++) {
                Application a = listOfApplications.get(i);
                out.println("                                    <div class='row'>");
                out.println("                                        <div class='12u'>");
                out.println("                                            <a href='http://japananimetime.ddns.net/Application/ShowApplication?number='" + a.getNumber() + "'>Заявление #" + a.getNumber() + "</a>");
                out.println("                                            <br>");
                out.println("                                            Отправленное " + a.getDay() + "." + a.getMonth() + "." + a.getYear() + " от имени");
                out.println("                                            <br>");
                out.println(a.getSurname() + " " + a.getName() + " " + a.getFathername());
                out.println("                                        </div>");
                out.println("                                    </div>");
            }
            out.println("                                </div>");
            out.println("                                <div class='row 200%'>");
            out.println("                                    <div class='12u'>");
            out.println("                                        <ul class='actions'>");
            out.println("                                            <li><input type='submit' value='Отфильтровать' /></li>");
            out.println("                                        </ul>");
            out.println("                                    </div>");
            out.println("                                </div>");
            out.println("                            </form>");
            out.println("                        </div>");
            out.println("                    </div>");
            out.println("                </div>");
            out.println("            </article>");
            out.println("        </div>");
            out.println("        <footer id='footer' style='margin-top: 0px;'>");
            out.println("            <ul style='margin-bottom: 0px;'>");
            out.println("                <li>&copy; Untitled. All rights reserved.</li>");
            out.println("                <li>Design: <a href='http://html5up.net'>HTML5 UP</a></li>");
            out.println("            </ul>");
            out.println("        </footer>");
            out.println("");
            out.println("        <!-- Scripts -->");
            out.println("        <script src='assets/js/jquery.min.js'></script>");
            out.println("        <script src='assets/js/jquery.scrolly.min.js'></script>");
            out.println("        <script src='assets/js/skel.min.js'></script>");
            out.println("        <script src='assets/js/skel-viewport.min.js'></script>");
            out.println("        <script src='assets/js/util.js'></script>");
            out.println("        <!--[if lte IE 8]><script src='assets/js/ie/respond.min.js'></script><![endif]-->");
            out.println("        <script src='assets/js/main.js'></script>");
            out.println("");
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
