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

/**
 *
 * @author Hikaro
 */
@WebServlet(name = "TranscriptShow", urlPatterns = {"/TranscriptShow"})
public class TranscriptShow extends HttpServlet {

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
            String login = request.getSession(false).getAttribute("login").toString();
            if (login == null) {
                response.sendRedirect("index.jsp?status='incorrect'");
            }
            DBConnection db = new DBConnection();
            Student s = db.ReadStudent(login);
            LinkedList<Discipline> DisList = db.DisList(login);
            out.println("<!DOCTYPE html>");
            out.println("<html lang='en'>");
            out.println("<head>");
            out.println("	<meta charset='utf-8' />");
            out.println("	<title>Grades</title>        ");
            out.println("	<meta name='description' content=''>");
            out.println("	<meta name='author' content=''>");
            out.println("	<meta name='HandheldFriendly' content='true'>");
            out.println("	<meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1'>");
            out.println("	<meta name='viewport' content='width=device-width, initial-scale=1, maximum-scale=1'>");
            out.println("	<!-- Import CSS -->");
            out.println("	<link rel='stylesheet' href='css/main.css'>");
            out.println("	<link href='//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css' rel='stylesheet'>");
            out.println("	<script src='js/jquery.min.js'></script>");
            out.println("	<script src='js/jquery.easing.min.js'></script>");
            out.println("	<script src='js/jquery.scrollto.min.js'></script>");
            out.println("	<script src='js/slabtext.min.js'></script>");
            out.println("	<script src='js/jquery.nav.js'></script>");
            out.println("	<script src='js/main.js'></script>");
            out.println("</head>");
            out.println("<!-- To change color change the class 'color-1' to 'color-2, color-3 ... color-6' -->");
            out.println("<body class='home color-4'>");
            out.println("	<div id='header'>");
            out.println("		<div class='container'>");
            out.println("");
            out.println("			<div class='row'>");
            out.println("");
            out.println("					<i id='nav-button' class='icon-circle-arrow-down'></i>");
            out.println("					<h2 id='logo'><a href='index.html'><img src='logo1-300x133.png' width='110' height='47' alt=''></a></h2>");
            out.println("				");
            out.println("");
            out.println("				<div id='top-nav' class=''>");
            out.println("					<ul id='fixed-nav'>");
            out.println("						<li class='current'><a href='#'>Grades</a></li>");
            out.println("						<li><a href='http://www.iitu.kz/article/show/id/139'>About Us</a></li>");
            out.println("						<li><a href='http://www.iitu.kz/article/show/id/213'>Contact Us</a></li>");
            out.println("					</ul>");
            out.println("				</div>");
            out.println("");
            out.println("			</div>");
            out.println("		</div>");
            out.println("	</div><!-- End Header -->");
            out.println("	<!-- About Us section -->");
            out.println("	<div class='section' id='aboutus'>");
            out.println("		<div class='container'>");
            out.println("			<div class='content'>");
            out.println("				<div class='row''>");
            out.println("                                       <form action='/OSRW/Transcript' method='POST'>");
            out.println("                                         <input type='hidden' value='1' name='print'>");
            out.println("                                        <button type='submit' class='btn btn-primary'>Version for print</button>");
            out.println("                                    </form>");
            out.println("                               </div>");
            out.println("				<div class='row'>");
            out.println("					<div class='span12'>");
            out.println("						<div class='title'>");
            out.println("							<h2>" + s.getSurname() + " " + s.getName() + "</h2>");
            out.println("							<div class='hr hr-small hr-center'><span class='hr-inner'></span></div>");
            if (Math.random() > 0.5) {
                out.println("							<p>People who don’t work hard don’t have the right to be envious of the people with talent. People fail because they don’t understand the hard work necessary to be successful.</p>");
            } else {
                out.println("							<p>Hard work betrays none, but dreams betray many.</p>");
            }
            out.println("");
            out.println("						</div>");
            out.println("					</div>");
            out.println("				</div>");
            out.println("			</div>");
            out.println("		</div>");
            out.println("	</div>");
            String letter = null;
            double score = 0;
            int itr = 0;
            out.println("	<div width='100%'>");
            out.println("		<div class='container'>");
            out.println("			<div class='content'>");
//            out.println("                           <div class='row' style='padding: 5%;'>");
            for (int i = DisList.size() - 1; i >= 0; i--) {
                if (itr % 3 == 0) {
                    out.println("                      <div class='row'>");
                }
                out.println("                               <div class='span4 i-block'>");
                out.println("                                   <p class='text-center'><h3>" + DisList.get(i).getName() + "</h3></p>");
                out.println("                                   <p class='text-center'><h5>Grade: " + DisList.get(i).getGrade() + "%</h5></p>");
                if (DisList.get(i).getGrade() >= 95) {
                    letter = "A";
                    score = 4.00;
                } else if (DisList.get(i).getGrade() >= 90) {
                    letter = "A-";
                    score = 3.67;
                } else if (DisList.get(i).getGrade() >= 85) {
                    letter = "B+";
                    score = 3.33;
                } else if (DisList.get(i).getGrade() >= 80) {
                    letter = "B";
                    score = 3.0;
                } else if (DisList.get(i).getGrade() >= 75) {
                    letter = "B-";
                    score = 2.67;
                } else if (DisList.get(i).getGrade() >= 70) {
                    letter = "C+";
                    score = 2.33;
                } else if (DisList.get(i).getGrade() >= 65) {
                    letter = "C";
                    score = 2.0;
                } else if (DisList.get(i).getGrade() >= 60) {
                    letter = "C-";
                    score = 1.67;
                } else if (DisList.get(i).getGrade() >= 55) {
                    letter = "D+";
                    score = 1.33;
                } else if (DisList.get(i).getGrade() >= 50) {
                    letter = "D";
                    score = 1.0;
                } else if (DisList.get(i).getGrade() >= 0) {
                    letter = "F";
                    score = 0;
                }
                out.println("                                   <p class='text-center'><h5>Letter: " + letter + "</h5></p>");
                out.println("                                   <p class='text-center'><h5>Point: " + score + "</h5></p>");
                out.println("                               </div>");
                itr++;
                if (itr % 3 == 0) {
                    out.println("                       </div> ");
                }
            }
            out.println("			</div>");
            out.println("		</div>");
            out.println("	</div>");
            out.println("");

            out.println("	<!-- End About US -->");
            out.println("	<div id='footer'>");
            out.println("		OSRW Transcript Project made by Nadezhuk Oleg, Zhankulov Daniyar, Tolesh Batyrzhan, Akhmetov Damir");
            out.println("	</div>");
            out.println("</body>");
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
