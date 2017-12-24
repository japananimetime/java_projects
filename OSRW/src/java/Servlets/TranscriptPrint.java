/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hikaro
 */
@WebServlet(name = "TranscriptPrint", urlPatterns = {"/TranscriptPrint"})
public class TranscriptPrint extends HttpServlet {

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
            DBConnection db = new DBConnection();
            HttpSession session = request.getSession(false);
            if(session.getAttribute("login")==null){
                response.sendRedirect("index.jsp?status=\"incorrect\"");
            }
            String login = (String) session.getAttribute("login");
            Student s = db.ReadStudent(login);
            double totalGPA=0;
            int totalSumOfCredits=0;
            double totalSumOfScore=0;
            out.println("<!DOCTYPE html>");
            out.println("<!--");
            out.println("To change this license header, choose License Headers in Project Properties.");
            out.println("To change this template file, choose Tools | Templates");
            out.println("and open the template in the editor.");
            out.println("-->");
            out.println("<html>");
            out.println("    <head>");
            out.println("        <title>Transcript</title>");
            out.println("        <meta charset='UTF-8'>");
            out.println("        <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("    </head>");
            out.println("    <body>");
            out.println("        <table width='900' align='center' border='1' cellspacing='0' cellpadding='1'>");
            out.println("            <tr>");
            out.println("                <td colspan='9' align='center' style='border-style:hidden'>Transcript</td>");
            out.println("            </tr>");
            out.println("            <tr>");
            out.println("                <td colspan='2' style='border-style:hidden'>First, Second,<br>Middle name:</td>");
            out.println("                <td colspan='3' style='border-style:hidden'><br>" + s.getSurname() + " " + s.getName() + "</td>");
            out.println("                <td colspan='3' style='border-style:hidden'><br>Year of entry</td>");
            out.println("                <td style='border-style:hidden' align='right'><br>" + s.getYear() + "</td>");
            out.println("            </tr>");
            out.println("            <tr>");
            out.println("                <td colspan='2' style='border-style:hidden'><br>Major:</td>");
            out.println("                <td colspan='3' style='border-style:hidden'><br>" + s.getMajor() + "</td>");
            out.println("                <td colspan='3' style='border-style:hidden'></td>");
            out.println("                <td style='border-style:hidden'></td>");
            out.println("            </tr>");
            out.println("            <tr>");
            out.println("                <td colspan='2' style='border-style:hidden'><br>Form of education:</td>");
            String form;
            if (s.isForm()) {
                form = "Full";
            } else {
                form = "Not Full";
            }
            out.println("                <td colspan='3' style='border-style:hidden'><br>" + form + "</td>");
            out.println("                <td colspan='3' style='border-style:hidden'><br>ID:</td>");
            out.println("                <td style='border-style:hidden' align='right'><br>" + login + "</td>");
            out.println("    </tr>");
            out.println("            <tr>");
            out.println("                <td align='center' rowspan='2'>№ п/п</td>");
            out.println("                <td align='center' rowspan='2'>Discipline code</td>");
            out.println("                <td align='center' rowspan='2'>Discipline</td>");
            out.println("                <td align='center' rowspan='2'>Term</td>");
            out.println("                <td align='center' rowspan='2'>Discipline<br>credits</td>");
            out.println("                <td align='center' colspan='3'>Mark</td>");
            out.println("                <td align='center' rowspan='2'>Sum score</td>");
            out.println("            </tr>");
            out.println("            <tr>");
            out.println("               <td align='center'>");
            out.println("                    num.                                ");
            out.println("                </td>");
            out.println("                <td align='center'>");
            out.println("                    letter");
            out.println("                </td>");
            out.println("                <td align='center'>");
            out.println("                    score");
            out.println("                </td> ");
            out.println("            </tr>");
            int year=Integer.parseInt(s.getYear());
            int nextYear=year+1;
            for (int i = 1; i <= 8; i++) {
                if (db.TermExists(login, i)) {
                    LinkedList<Discipline> TermDisList = db.TermDisList(login, i);
                    if (i % 2 != 0) {
                        out.println("<td align='center' colspan='9'>Autumn " + year + "-" + nextYear + "</td>");
                    } else {
                        out.println("<td align='center' colspan='9'>Spring " + year+ "-" + nextYear + "</td>");
                    }

                    int credSum = 0;
                    double scoresSummed = 0;
                    double GPA;
                    double Sum_Score = 0;
                    double score = 0;
                    String letter = null;
                    for (int j = 1; j <= db.TermDisAmount(i, login); j++) {
                        if (TermDisList.get(j - 1).getGrade() >= 95) {
                            letter = "A";
                            score = 4.00;
                        } else if (TermDisList.get(j - 1).getGrade() >= 90) {
                            letter = "A-";
                            score = 3.67;
                        } else if (TermDisList.get(j - 1).getGrade() >= 85) {
                            letter = "B+";
                            score = 3.33;
                        } else if (TermDisList.get(j - 1).getGrade() >= 80) {
                            letter = "B";
                            score = 3.0;
                        } else if (TermDisList.get(j - 1).getGrade() >= 75) {
                            letter = "B-";
                            score = 2.67;
                        } else if (TermDisList.get(j - 1).getGrade() >= 70) {
                            letter = "C+";
                            score = 2.33;
                        } else if (TermDisList.get(j - 1).getGrade() >= 65) {
                            letter = "C";
                            score = 2.0;
                        } else if (TermDisList.get(j - 1).getGrade() >= 60) {
                            letter = "C-";
                            score = 1.67;
                        } else if (TermDisList.get(j - 1).getGrade() >= 55) {
                            letter = "D+";
                            score = 1.33;
                        } else if (TermDisList.get(j - 1).getGrade() >= 50) {
                            letter = "D";
                            score = 1.0;
                        } else if (TermDisList.get(j - 1).getGrade() >= 0) {
                            letter = "F";
                            score = 0;
                        }
                        out.println("<tr>");
                        out.println("   <td align='center'>" + j + "</td>");
                        out.println("   <td align='center'>" + TermDisList.get(j - 1).getCode() + "</td>");
                        out.println("   <td>" + TermDisList.get(j - 1).getName() + "</td>");
                        out.println("   <td align='center'>" + i + "</td>");
                        out.println("   <td align='center'>" + TermDisList.get(j - 1).getCredits() + "</td>");
                        out.println("   <td align='center'>" + TermDisList.get(j - 1).getGrade() + "</td>");
                        out.println("   <td align='center'>" + letter + "</td>");
                        out.println("   <td align='center'>" + score + "</td>");
                        out.println("   <td align='center'>" + score * TermDisList.get(j - 1).getCredits() + "</td>");
                        out.println("</tr>");
                        credSum = credSum + TermDisList.get(j - 1).getCredits();
                        scoresSummed = scoresSummed + score;
                        Sum_Score = Sum_Score + score * TermDisList.get(j - 1).getCredits();
                    }
                    GPA = scoresSummed / db.TermDisAmount(i, login);
                    out.println("<tr>");
                    out.println("<td colspan='2'>GPA for term</td>");
                    String formattedDouble;
                    formattedDouble = new DecimalFormat("#0.00").format(GPA);
                    out.println("<td>" + formattedDouble + "</td>");
                    out.println("<td align='center'>Sum</td>");
                    out.println("<td align='center'>" + credSum + "</td>");
                    out.println("<td align='center'></td>");
                    out.println("<td align='center'></td>");
                    out.println("<td align='center'></td>");
                    String formattedDouble1;
                    formattedDouble1 = new DecimalFormat("#0.00").format(Sum_Score);
                    out.println("<td align='center'>" + formattedDouble1 + "</td>");
                    out.println("</tr>");    
                    totalSumOfScore=totalSumOfScore+Sum_Score;
                    totalSumOfCredits=totalSumOfCredits+credSum;
                }
                if (i % 2 == 0) {
                    
                    year++;
                    nextYear++;
                }
            }
            
            totalGPA=totalSumOfScore/totalSumOfCredits;
            out.println("<tr>");
            out.println("<td colspan='3' align='right'>Total amount for the whole period GPA</td>");
            String formattedDouble;
            formattedDouble = new DecimalFormat("#0.00").format(totalGPA);
            out.println("<td align='center'>" + formattedDouble + "</td>");
            out.println("<td align='center'>" + totalSumOfCredits + "</td>");
            out.println("<td align='center'></td>");
            out.println("<td align='center'></td>");
            out.println("<td align='center'></td>");
            String formattedDouble1;
            formattedDouble1 = new DecimalFormat("#0.00").format(totalSumOfScore);
            out.println("<td align='center'>" + formattedDouble1 + "</td>");
            out.println("</tr>");  
            out.println("</table>");
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
