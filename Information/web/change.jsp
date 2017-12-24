<%-- 
    Document   : change
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
        <title>Change the info</title>
    </head>
    <body style="margin:0">
        <form action='change' method='post'>
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
                            request.setAttribute("rs", info);
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
                                        out.println("<br><input name='photo' value=" + info.getString("photo") + "'><br>");
                                    %>
                                    To change photo, provide the direct link into the input.  
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
                                        <tr>
                                            <td width='50%'>
                                                Password
                                            </td>
                                            <td>
                                                <%
                                                    out.println("<input type='password' name='password' value=" + info.getString("password") + ">");
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
                                                        out.println("<input name='homestate' value=" + info.getString("homestate") + ">");
                                                    } else {
                                                        out.println("<input name='homestate'>");
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
                                                        out.println("<input name='homeregion' value=" + info.getString("homeregion") + ">");
                                                    } else {
                                                        out.println("<input name='homeregion'>");
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
                                                        out.println("<input name='homecity' value=" + info.getString("homecity") + ">");
                                                    } else {
                                                        out.println("<input name='homecity'>");
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
                                                        out.println("<input name='homedistrict' value=" + info.getString("homedistrict") + ">");
                                                    } else {
                                                        out.println("<input name='homedistrict'>");
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
                                                        out.println("<input name='homestreet' value=" + info.getString("homestreet") + ">");
                                                    } else {
                                                        out.println("<input name='homestreet'>");
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
                                                        out.println("<input name='homebldnumber' value=" + info.getString("homebldnumber") + ">");
                                                    } else {
                                                        out.println("<input name='homebldnumber'>");
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
                                                        out.println("<input name='homeapartment' value=" + info.getString("homeapartment") + ">");
                                                    } else {
                                                        out.println("<input name='homeapartment'>");
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
                                                        out.println("<input name='district' value=" + info.getString("district") + ">");
                                                    } else {
                                                        out.println("<input name='district'>");
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
                                                        out.println("<input name='street' value=" + info.getString("street") + ">");
                                                    } else {
                                                        out.println("<input name='street'>");
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
                                                        out.println("<input name='bldnumber' value=" + info.getString("bldnumber") + ">");
                                                    } else {
                                                        out.println("<input name='bldnumber'>");
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
                                                        out.println("<input name='apartment' value=" + info.getString("apartment") + ">");
                                                    } else {
                                                        out.println("<input name='apartment'>");
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
                                                        out.println("<input name='homenumber' value=" + info.getString("homenumber") + ">");
                                                    } else {
                                                        out.println("<input name='homenumber'>");
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
                                                        out.println("<input name='mobilenumber' value=" + info.getString("mobilenumber") + ">");
                                                    } else {
                                                        out.println("<input name='mobilenumber'>");
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
                                                        out.println("<input name='mail' value=" + info.getString("mail") + ">");
                                                    } else {
                                                        out.println("<input name='mail'>");
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
                                                        out.println("<input name='mothername' value=" + info.getString("mothername") + ">");
                                                    } else {
                                                        out.println("<input name='mothername'>");
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
                                                        out.println("<input name='mothersurname' value=" + info.getString("mothersurname") + ">");
                                                    } else {
                                                        out.println("<input name='mothersurname'>");
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
                                                        out.println("<input name='mothermiddlename' value=" + info.getString("mothermiddlename") + ">");
                                                    } else {
                                                        out.println("<input name='mothermiddlename'>");
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
                                                        out.println("<input name='motherphonehome' value=" + info.getString("motherphonehome") + ">");
                                                    } else {
                                                        out.println("<input name='motherphonehome'>");
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
                                                        out.println("<input name='motherphonemobile' value=" + info.getString("motherphonemobile") + ">");
                                                    } else {
                                                        out.println("<input name='motherphonemobile'>");
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
                                                        out.println("<input name='mothermail' value=" + info.getString("mothermail") + ">");
                                                    } else {
                                                        out.println("<input name='mothermail'>");
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
                                                        out.println("<input name='fathername' value=" + info.getString("fathername") + ">");
                                                    } else {
                                                        out.println("<input name='fathername'>");
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
                                                        out.println("<input name='fathersurname' value=" + info.getString("fathersurname") + ">");
                                                    } else {
                                                        out.println("<input name='fathersurname'>");
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
                                                        out.println("<input name='fathermiddlename' value=" + info.getString("fathermiddlename") + ">");
                                                    } else {
                                                        out.println("<input name='fathermiddlename'>");
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
                                                        out.println("<input name='fatherphonehome' value=" + info.getString("fatherphonehome") + ">");
                                                    } else {
                                                        out.println("<input name='fatherphonehome'>");
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
                                                        out.println("<input name='fatherphonemobile' value=" + info.getString("fatherphonemobile") + ">");
                                                    } else {
                                                        out.println("<input name='fatherphonemobile'>");
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
                                                        out.println("<input name='fathermail' value=" + info.getString("fathermail") + ">");
                                                    } else {
                                                        out.println("<input name='fathermail'>");
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
                                                        out.println("<input name='iin' value=" + info.getString("iin") + ">");
                                                    } else {
                                                        out.println("<input name='iin'>");
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
                                                        out.println("<input name='verdocnum' value=" + info.getString("verdocnum") + ">");
                                                    } else {
                                                        out.println("<input name='verdocnum'>");
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
                                                        out.println("<input name='verdocorg' value=" + info.getString("verdocorg") + ">");
                                                    } else {
                                                        out.println("<input name='verdocorg'>");
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
                                                        out.println("<input name='verdocdatebegin' value=" + info.getString("verdocdatebegin") + ">");
                                                    } else {
                                                        out.println("<input name='verdocdatebegin'>");
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
                                                        out.println("<input name='verdocdateend' value=" + info.getString("verdocdateend") + ">");
                                                    } else {
                                                        out.println("<input name='verdocdateend'>");
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
                                                    out.println("<input name='court' value=" + info.getInt("court") + ">");
                                                %>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                Years in jail  
                                            </td>
                                            <td>
                                                <%
                                                    out.println("<input name='court' value=" + info.getInt("yearsinjail") + ">");
                                                %>
                                            </td>
                                        </tr>
                                    </table> 
                                </td>
                            </tr>
                        </table>
                        <br>
                        <input type="submit" value="Submit" style="margin-bottom: 10px">
                    </td>
                </tr>
                <tr bgcolor='#CFCFCF'>
                    <td colspan='2' align='center'>
                        <h3>Made by Shinrai Hikaro aka japananimetime</h3>
                    </td>
                </tr>   
            </table>   
        </form>
    </body>
</html>
