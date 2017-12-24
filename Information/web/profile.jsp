<%-- 
    Document   : Profile_change
    Created on : 04.12.2016, 2:24:10
    Author     : Hikaro
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="Servlets.DBConnection"%>
<%@page import="Servlets.StudentInfo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
    </head>
    <body style="margin:0">
        <table width='100%' cellspacing='0'>
            <tr bgcolor='#CFCFCF'>
                <td>
                    <img src="Images/logo1-300x133.png" width='110' height='47' alt=""/>
                </td>
                <td align='right' valign='top' style="padding:1% 1% 0 0">
                    <%
                        DBConnection db = new DBConnection();
                        ResultSet info;
                        info = db.getstudentprofileinfo(session.getAttribute("id").toString());
                        out.println(info.getString("lastnamelat") + " " + info.getString("firstnamelat"));
                        out.println("<form action='logout' method='post'><input type='submit' value='Logout'></form>");
                    %>
                </td>
            </tr>
            <tr>
                <td width=40% valign='top' align='center'>
                    <table align="right" width="50%">
                        <tr>
                            <td>
                                <%
                                      out.println("<br><br><img src='" + info.getString("photo") + "' alt=''/><br>");
                                %>
                            </td>
                        </tr>
                    <tr>
                            <td align="center">
                                 <%
                                    out.println(info.getString("id") + "<br>");
                                %>
                            </td>
                        </tr>
                        <tr>
                            <td align="center">
                                <%
                                    out.println(info.getString("lastnamelat") + " " + info.getString("firstnamelat"));
                                %>                                
                            </td>
                        </tr>
                        <tr>
                            <td align="center">
                                <form action="change.jsp" method="post">
                                    <button type="submit">
                                        Change the Information
                                    </button>
                                </form>
                            </td>
                        </tr>
                    </table>

                   
                        
                </td>
                <td>
                    <table width='100%'>
                        <tr>
                            <td>
                                <h2>Basic Information</h2>
                            </td>
                        </tr>
                        <tr>
                            <td>          
                                <table width='400px'>
                                    <tr>
                                        <td width='50%'>
                                            Date of birth
                                        </td>
                                        <td>
                                            <%
                                                if (info.getString("birth") != (null)) {
                                                    out.println(info.getString("birth"));

                                                } else {
                                                    out.println(" ");

                                                }
                                            %>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Sex
                                        </td>
                                        <td>
                                            <%
                                                if (info.getString("sex") != (null)) {
                                                    out.println(info.getString("sex"));

                                                } else {
                                                    out.println(" ");

                                                }
                                            %>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Faculty
                                        </td>
                                        <td>
                                            <%
                                                if (info.getString("faculty") != (null)) {
                                                    out.println(info.getString("faculty"));

                                                } else {
                                                    out.println(" ");

                                                }
                                            %>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Group
                                        </td>
                                        <td>
                                            <%
                                                if (info.getString("s_group") != (null)) {
                                                    out.println(info.getString("s_group"));

                                                } else {
                                                    out.println(" ");

                                                }
                                            %>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Year of Adoption
                                        </td>
                                        <td>
                                            <%
                                                if (info.getString("adoptionyear") != (null)) {
                                                    out.println(info.getString("adoptionyear"));
                                                } else {
                                                    out.println(" ");
                                                }
                                            %>
                                        </td>
                                    </tr>
                                </table>                                       
                            </td>                                
                        </tr>
                        <tr>
                            <td>
                                <h2>Address of Origin</h2>
                            </td>                            
                        </tr>
                        <tr>
                            <td>
                                <table width='400px'>
                                    <tr>
                                        <td width='50%'>
                                            State
                                        </td>
                                        <td>
                                            <%
                                                if (info.getString("homestate") != (null)) {
                                                    out.println(info.getString("homestate"));
                                                } else {
                                                    out.println(" ");
                                                }
                                            %>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Region
                                        </td>
                                        <td>
                                            <%
                                                if (info.getString("homeregion") != (null)) {
                                                    out.println(info.getString("homeregion"));
                                                } else {
                                                    out.println(" ");
                                                }
                                            %>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            City
                                        </td>
                                        <td>
                                            <%
                                                if (info.getString("homecity") != (null)) {
                                                    out.println(info.getString("homecity"));
                                                } else {
                                                    out.println(" ");
                                                }
                                            %>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            District
                                        </td>
                                        <td>
                                            <%
                                                if (info.getString("homedistrict") != (null)) {
                                                    out.println(info.getString("homedistrict"));
                                                } else {
                                                    out.println(" ");
                                                }
                                            %>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Street
                                        </td>
                                        <td>
                                            <%
                                                if (info.getString("homestreet") != (null)) {
                                                    out.println(info.getString("homestreet"));
                                                } else {
                                                    out.println(" ");
                                                }
                                            %>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Number of house
                                        </td>
                                        <td>
                                            <%
                                                if (info.getString("homebldnumber") != (null)) {
                                                    out.println(info.getString("homebldnumber"));
                                                } else {
                                                    out.println(" ");
                                                }
                                            %>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Apartment
                                        </td>
                                        <td>
                                            <%
                                                if (info.getString("homeapartment") != (null)) {
                                                    out.println(info.getString("homeapartment"));
                                                } else {
                                                    out.println(" ");
                                                }
                                            %>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <h2>Address of living in Almaty</h2>
                            </td>                            
                        </tr>
                        <tr>
                            <td>
                                <table width='400px'>
                                    <tr>
                                        <td width="50%">
                                            District
                                        </td>
                                        <td>
                                            <%
                                                if (info.getString("district") != (null)) {
                                                    out.println(info.getString("district"));

                                                } else {
                                                    out.println(" ");
                                                }
                                            %>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Street
                                        </td>
                                        <td>
                                            <%
                                                if (info.getString("street") != (null)) {
                                                    out.println(info.getString("street"));

                                                } else {
                                                    out.println(" ");
                                                }
                                            %>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Number of house
                                        </td>
                                        <td>
                                            <%
                                                if (info.getString("bldnumber") != (null)) {
                                                    out.println(info.getString("bldnumber"));

                                                } else {
                                                    out.println(" ");

                                                }
                                            %>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Apartment
                                        </td>
                                        <td>
                                            <%
                                                if (info.getString("apartment") != (null)) {
                                                    out.println(info.getString("apartment"));
                                                } else {
                                                    out.println(" ");
                                                }
                                            %>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <h2>Connection</h2>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <table width='400px'>
                                    <tr>
                                        <td width='50%'>
                                            Home Number
                                        </td>
                                        <td>
                                            <%
                                                if (info.getString("homenumber") != null) {
                                                    out.println(info.getString("homenumber"));
                                                } else {
                                                    out.println(" ");
                                                }
                                            %>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Mobile Number
                                        </td>
                                        <td>
                                            <%
                                                if (info.getString("mobilenumber") != (null)) {
                                                    out.println(info.getString("mobilenumber"));
                                                } else {
                                                    out.println(" ");
                                                }
                                            %>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Mail
                                        </td>
                                        <td>
                                            <%
                                                if (info.getString("mail") != (null)) {
                                                    out.println(info.getString("mail"));
                                                } else {
                                                    out.println(" ");
                                                }
                                            %>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>                            
                        <tr>
                            <td>
                                <h2>Relationships</h2>                                
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <table width='400px'>
                                    <tr>
                                        <td width='50%'>
                                            Mother's name
                                        </td>
                                        <td>
                                            <%
                                                if (info.getString("mothername") != (null)) {
                                                    out.println(info.getString("mothername"));
                                                } else {
                                                    out.println(" ");
                                                }
                                            %>
                                        </td>
                                    <tr>
                                        <td>
                                            Mother's surname       
                                        </td>
                                        <td>
                                            <%
                                                if (info.getString("mothersurname") != (null)) {
                                                    out.println(info.getString("mothersurname"));
                                                } else {
                                                    out.println(info.getString("mothersurname"));
                                                }
                                            %>
                                        </td>
                                    <tr>
                                        <td>
                                            Mother's middle name   

                                        </td>
                                        <td>
                                            <%
                                                if (info.getString("mothermiddlename") != (null)) {
                                                    out.println(info.getString("mothermiddlename"));
                                                } else {
                                                    out.println(" ");
                                                }
                                            %>	
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Mother's home number   

                                        </td>
                                        <td>
                                            <%
                                                if (info.getString("motherphonehome") != (null)) {
                                                    out.println(info.getString("motherphonehome"));
                                                } else {
                                                    out.println(" ");
                                                }
                                            %>
                                        </td>
                                    <tr>
                                        <td>
                                            Mother's mobile number 

                                        </td>
                                        <td>
                                            <%
                                                if (info.getString("motherphonemobile") != (null)) {
                                                    out.println(info.getString("motherphonemobile"));
                                                } else {
                                                    out.println(" ");
                                                }
                                            %>
                                        </td>
                                    <tr>
                                        <td>
                                            Mother's e-mail address

                                        </td>
                                        <td>
                                            <%
                                                if (info.getString("mothermail") != (null)) {
                                                    out.println(info.getString("mothermail"));
                                                } else {
                                                    out.println(" ");
                                                }
                                            %>
                                        </td>
                                    <tr>
                                        <td>
                                            Father's name          

                                        </td>
                                        <td>
                                            <%
                                                if (info.getString("fathername") != (null)) {
                                                    out.println(info.getString("fathername"));
                                                } else {
                                                    out.println(" ");
                                                }
                                            %>
                                        </td>
                                    <tr>
                                        <td>
                                            Father's surname       

                                        </td>
                                        <td>
                                            <%
                                                if (info.getString("fathersurname") != (null)) {
                                                    out.println(info.getString("fathersurname"));
                                                } else {
                                                    out.println(" ");
                                                }
                                            %>
                                        </td>
                                    <tr>
                                        <td>
                                            Father's middle name   

                                        </td>
                                        <td>
                                            <%
                                                if (info.getString("fathermiddlename") != (null)) {
                                                    out.println(info.getString("fathermiddlename"));
                                                } else {
                                                    out.println(" ");
                                                }
                                            %>
                                        </td>
                                    <tr>
                                        <td>
                                            Father's home number   

                                        </td>
                                        <td>
                                            <%
                                                if (info.getString("fatherphonehome") != (null)) {
                                                    out.println(info.getString("fatherphonehome"));
                                                } else {
                                                    out.println(" ");
                                                }
                                            %>
                                        </td>
                                    <tr>
                                        <td>
                                            Father's mobile number 
                                        </td>
                                        <td>
                                            <%
                                                if (info.getString("fatherphonemobile") != (null)) {
                                                    out.println(info.getString("fatherphonemobile"));
                                                } else {
                                                    out.println(" ");
                                                }
                                            %>
                                        </td>
                                    <tr>
                                        <td>
                                            Father's e-mail address
                                        </td>
                                        <td>
                                            <%
                                                if (info.getString("fathermail") != (null)) {
                                                    out.println(info.getString("fathermail"));
                                                } else {
                                                    out.println(" ");
                                                }
                                            %>
                                        </td>
                                </table>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <h2>Documents</h2>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <table width='400px'>
                                    <tr>
                                        <td width='50%'>
                                            IIN
                                        </td>
                                        <td>
                                            <%
                                                if (info.getString("iin") != (null)) {
                                                    out.println(info.getString("iin"));
                                                } else {
                                                    out.println(" ");
                                                }
                                            %>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Verification card number
                                        </td>
                                        <td>
                                            <%
                                                if (info.getString("verdocnum") != (null)) {
                                                    out.println(info.getString("verdocnum"));
                                                } else {
                                                    out.println(" ");
                                                }
                                            %>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Organization that issued verification card
                                        </td>
                                        <td>
                                            <%
                                                if (info.getString("verdocorg") != (null)) {
                                                    out.println(info.getString("verdocorg"));
                                                } else {
                                                    out.println(" ");
                                                }
                                            %>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            verification card issue date
                                        </td>
                                        <td>
                                            <%
                                                if (info.getDate("verdocdatebegin") != (null)) {
                                                    out.println(info.getDate("verdocdatebegin"));
                                                } else {
                                                    out.println(" ");
                                                }
                                            %>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            verification card expiration date
                                        </td>
                                        <td>
                                            <%
                                                if (info.getDate("verdocdateend").toString() != (null)) {
                                                    out.println(info.getDate("verdocdateend"));
                                                } else {
                                                    out.println(" ");
                                                }
                                            %>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <h2>Other</h2>                                
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <table width='400px'>
                                    <tr>
                                        <td width='50%'>
                                            Number of convictions
                                        </td>
                                        <td>
                                            <%
                                                out.println(info.getInt("court"));
                                            %>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Years in jail  
                                        </td>
                                        <td>
                                            <%
                                                out.println(info.getInt("yearsinjail"));
                                            %>
                                        </td>
                                    </tr>
                                </table> 
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr bgcolor='#CFCFCF'>
                <td colspan='2' align='center'>
                    <h3>Made by Shinrai Hikaro aka japananimetime</h3>
                </td>
            </tr>                
        </table>         
    </body>
</html>
