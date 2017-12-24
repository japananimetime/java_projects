/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "change", urlPatterns = {"/change"})
public class ChangeServlet extends HttpServlet {

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
            HttpSession session = request.getSession(true);
            DBConnection db = new DBConnection();
            HashMap<String, String> row = db.getstudentprofileinfo1(session.getAttribute("id").toString());
//            out.println(row.get("district"));
            if (row.get("district") != null) {
                if (!row.get("district").equals(request.getParameter("district"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("district"), "district", "studentaddress");
                }
            } else {
                String district = " ";
                if (!district.equals(request.getParameter("district"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("district"), "district", "studentaddress");
                }
            }
            if (row.get("bldnumber") != null) {
                if (!row.get("bldnumber").equals(request.getParameter("bldnumber"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("bldnumber"), "bldnumber", "studentaddress");
                }
            } else {
                String bldnumber = " ";
                if (!bldnumber.equals(request.getParameter("bldnumber"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("bldnumber"), "bldnumber", "studentaddress");
                }
            }

            if (row.get("street") != null) {
                if (!row.get("street").equals(request.getParameter("street"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("street"), "street", "studentaddress");
                }
            } else {
                String street = " ";
                if (!street.equals(request.getParameter("street"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("street"), "street", "studentaddress");
                }
            }

            if (row.get("apartment") != null) {
                if (!row.get("apartment").equals(request.getParameter("apartment"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("apartment"), "apartment", "studentaddress");
                }
            } else {
                String apartment = " ";
                if (!apartment.equals(request.getParameter("apartment"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("apartment"), "apartment", "studentaddress");
                }
            }
            if (row.get("homestate") != null) {
                if (!row.get("homestate").equals(request.getParameter("homestate"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("homestate"), "homestate", "studentaddress");
                }
            } else {
                String homestate = " ";
                if (!homestate.equals(request.getParameter("homestate"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("homestate"), "homestate", "studentaddress");
                }
            }
            if (row.get("homeregion") != null) {
                if (!row.get("homeregion").equals(request.getParameter("homeregion"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("homeregion"), "homeregion", "studentaddress");
                }
            } else {
                String homeregion = " ";
                if (!homeregion.equals(request.getParameter("homeregion"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("homeregion"), "homeregion", "studentaddress");
                }
            }
            if (row.get("homeapartment") != null) {
                if (!row.get("homeapartment").equals(request.getParameter("homeapartment"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("homeapartment"), "homeapartment", "studentaddress");
                }
            } else {
                String homeapartment = " ";
                if (!homeapartment.equals(request.getParameter("homeapartment"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("homeapartment"), "homeapartment", "studentaddress");
                }
            }
            if (row.get("homebldnumber") != null) {
                if (!row.get("homebldnumber").equals(request.getParameter("homebldnumber"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("homebldnumber"), "homebldnumber", "studentaddress");
                }
            } else {
                String homebldnumber = " ";
                if (!homebldnumber.equals(request.getParameter("homebldnumber"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("homebldnumber"), "homebldnumber", "studentaddress");
                }
            }
            if (row.get("homedistrict") != null) {
                if (!row.get("homedistrict").equals(request.getParameter("homedistrict"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("homedistrict"), "homedistrict", "studentaddress");
                }
            } else {
                String homedistrict = " ";
                if (!homedistrict.equals(request.getParameter("homedistrict"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("homedistrict"), "homedistrict", "studentaddress");
                }
            }
            if (row.get("homecity") != null) {
                if (!row.get("homecity").equals(request.getParameter("homecity"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("homecity"), "homecity", "studentaddress");
                }
            } else {
                String homecity = " ";
                if (!homecity.equals(request.getParameter("homecity"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("homecity"), "homecity", "studentaddress");
                }
            }
            if (row.get("homestreet") != null) {
                if (!row.get("homestreet").equals(request.getParameter("homestreet"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("homestreet"), "homestreet", "studentaddress");
                }
            } else {
                String homestreet = " ";
                if (!homestreet.equals(request.getParameter("homestreet"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("homestreet"), "homestreet", "studentaddress");
                }
            }
            if (row.get("homenumber") != null) {
                if (!row.get("homenumber").equals(request.getParameter("homenumber"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("homenumber"), "homenumber", "studentcommunications");
                }
            } else {
                String homenumber = " ";
                if (!homenumber.equals(request.getParameter("homenumber"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("homenumber"), "homenumber", "studentcommunications");
                }
            }
            if (row.get("mobilenumber") != null) {
                if (!row.get("mobilenumber").equals(request.getParameter("mobilenumber"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("mobilenumber"), "mobilenumber", "studentcommunications");
                }
            } else {
                String mobilenumber = " ";
                if (!mobilenumber.equals(request.getParameter("mobilenumber"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("mobilenumber"), "mobilenumber", "studentcommunications");
                }
            }
            if (row.get("mail") != null) {
                if (!row.get("mail").equals(request.getParameter("mail"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("mail"), "mail", "studentcommunications");
                }
            } else {
                String mail = " ";
                if (!mail.equals(request.getParameter("mail"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("mail"), "mail", "studentcommunications");
                }
            }
            if (row.get("iin") != null) {
                if (!row.get("iin").equals(request.getParameter("iin"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("iin"), "iin", "studentdocs");
                }
            } else {
                String iin = " ";
                if (!iin.equals(request.getParameter("iin"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("iin"), "iin", "studentdocs");
                }
            }
            if (row.get("verdocnum") != null) {
                if (!row.get("verdocnum").equals(request.getParameter("verdocnum"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("verdocnum"), "verdocnum", "studentdocs");
                }
            } else {
                String verdocnum = " ";
                if (!verdocnum.equals(request.getParameter("verdocnum"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("verdocnum"), "verdocnum", "studentdocs");
                }
            }
            if (row.get("verdocorg") != null) {
                if (!row.get("verdocorg").equals(request.getParameter("verdocorg"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("verdocorg"), "verdocorg", "studentdocs");
                }
            } else {
                String verdocorg = " ";
                if (!verdocorg.equals(request.getParameter("verdocorg"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("verdocorg"), "verdocorg", "studentdocs");
                }
            }
            if (row.get("verdocdatebegin") != null) {
                if (!row.get("verdocdatebegin").equals(request.getParameter("verdocdatebegin"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("verdocdatebegin"), "verdocdatebegin", "studentdocs");
                }
            } else {
                String verdocdatebegin = " ";
                if (!verdocdatebegin.equals(request.getParameter("verdocdatebegin"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("verdocdatebegin"), "verdocdatebegin", "studentdocs");
                }
            }
            if (row.get("verdocdateend") != null) {
                if (!row.get("verdocdateend").equals(request.getParameter("verdocdateend"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("verdocdateend"), "verdocdateend", "studentdocs");
                }
            } else {
                String verdocdateend = " ";
                if (!verdocdateend.equals(request.getParameter("verdocdateend"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("verdocdateend"), "verdocdateend", "studentdocs");
                }
            }
            if (row.get("password") != null) {
                if (!row.get("password").equals(request.getParameter("password"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("password"), "password", "studentpersonal");
                }
            } else {
                String password = " ";
                if (!password.equals(request.getParameter("password"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("password"), "password", "studentpersonal");
                }
            }
            if (row.get("photo") != null) {
                if (!row.get("photo").equals(request.getParameter("photo"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("photo"), "photo", "studentpersonal");
                }
            } else {
                String photo = " ";
                if (!photo.equals(request.getParameter("photo"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("photo"), "photo", "studentpersonal");
                }
            }
            if (row.get("yearsinjail") != null) {
                if (!row.get("yearsinjail").equals(request.getParameter("yearsinjail"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("yearsinjail"), "yearsinjail", "studentpersonal");
                }
            } else {
                String yearsinjail = " ";
                if (!yearsinjail.equals(request.getParameter("yearsinjail"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("yearsinjail"), "yearsinjail", "studentpersonal");
                }
            }
            if (row.get("court") != null) {
                if (!row.get("court").equals(request.getParameter("court"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("court"), "court", "studentpersonal");
                }
            } else {
                String court = " ";
                if (!court.equals(request.getParameter("court"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("court"), "court", "studentpersonal");
                }
            }
            if (row.get("mothername") != null) {
                if (!row.get("mothername").equals(request.getParameter("mothername"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("mothername"), "mothername", "studentrelationships");
                }
            } else {
                String mothername = " ";
                if (!mothername.equals(request.getParameter("mothername"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("mothername"), "mothername", "studentrelationships");
                }
            }
            if (row.get("mothersurname") != null) {
                if (!row.get("mothersurname").equals(request.getParameter("mothersurname"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("mothersurname"), "mothersurname", "studentrelationships");
                }
            } else {
                String mothersurname = " ";
                if (!mothersurname.equals(request.getParameter("mothersurname"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("mothersurname"), "mothersurname", "studentrelationships");
                }
            }
            if (row.get("mothermiddlename") != null) {
                if (!row.get("mothermiddlename").equals(request.getParameter("mothermiddlename"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("mothermiddlename"), "mothermiddlename", "studentrelationships");
                }
            } else {
                String mothermiddlename = " ";
                if (!mothermiddlename.equals(request.getParameter("mothermiddlename"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("mothermiddlename"), "mothermiddlename", "studentrelationships");
                }
            }
            if (row.get("motherphonehome") != null) {
                if (!row.get("motherphonehome").equals(request.getParameter("motherphonehome"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("motherphonehome"), "motherphonehome", "studentrelationships");
                }
            } else {
                String motherphonehome = " ";
                if (!motherphonehome.equals(request.getParameter("motherphonehome"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("motherphonehome"), "motherphonehome", "studentrelationships");
                }
            }
            if (row.get("motherphonemobile") != null) {
                if (!row.get("motherphonemobile").equals(request.getParameter("motherphonemobile"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("motherphonemobile"), "motherphonemobile", "studentrelationships");
                }
            } else {
                String motherphonemobile = " ";
                if (!motherphonemobile.equals(request.getParameter("motherphonemobile"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("motherphonemobile"), "motherphonemobile", "studentrelationships");
                }
            }
            if (row.get("mothermail") != null) {
                if (!row.get("mothermail").equals(request.getParameter("mothermail"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("mothermail"), "mothermail", "studentrelationships");
                }
            } else {
                String mothermail = " ";
                if (!mothermail.equals(request.getParameter("mothermail"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("mothermail"), "mothermail", "studentrelationships");
                }
            }
            if (row.get("fathername") != null) {
                if (!row.get("fathername").equals(request.getParameter("fathername"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("fathername"), "fathername", "studentrelationships");
                }
            } else {
                String fathername = " ";
                if (!fathername.equals(request.getParameter("fathername"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("fathername"), "fathername", "studentrelationships");
                }
            }
            if (row.get("fathersurname") != null) {
                if (!row.get("fathersurname").equals(request.getParameter("fathersurname"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("fathersurname"), "fathersurname", "studentrelationships");
                }
            } else {
                String fathersurname = " ";
                if (!fathersurname.equals(request.getParameter("fathersurname"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("fathersurname"), "fathersurname", "studentrelationships");
                }
            }
            if (row.get("fathermiddlename") != null) {
                if (!row.get("fathermiddlename").equals(request.getParameter("fathermiddlename"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("fathermiddlename"), "fathermiddlename", "studentrelationships");
                }
            } else {
                String fathermiddlename = " ";
                if (!fathermiddlename.equals(request.getParameter("fathermiddlename"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("fathermiddlename"), "fathermiddlename", "studentrelationships");
                }
            }
            if (row.get("fatherphonehome") != null) {
                if (!row.get("fatherphonehome").equals(request.getParameter("fatherphonehome"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("fatherphonehome"), "fatherphonehome", "studentrelationships");
                }
            } else {
                String fatherphonehome = " ";
                if (!fatherphonehome.equals(request.getParameter("fatherphonehome"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("fatherphonehome"), "fatherphonehome", "studentrelationships");
                }
            }
            if (row.get("fatherphonemobile") != null) {
                if (!row.get("fatherphonemobile").equals(request.getParameter("fatherphonemobile"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("fatherphonemobile"), "fatherphonemobile", "studentrelationships");
                }
            } else {
                String fatherphonemobile = " ";
                if (!fatherphonemobile.equals(request.getParameter("fatherphonemobile"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("fatherphonemobile"), "fatherphonemobile", "studentrelationships");
                }
            }
            if (row.get("fathermail") != null) {
                if (!row.get("fathermail").equals(request.getParameter("fathermail"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("fathermail"), "fathermail", "studentrelationships");
                }
            } else {
                String fathermail = " ";
                if (!fathermail.equals(request.getParameter("fathermail"))) {
                    db.updatestudentprofileinfo(session.getAttribute("id").toString(), request.getParameter("fathermail"), "fathermail", "studentrelationships");
                }
            }
            response.sendRedirect("profile.jsp");
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
