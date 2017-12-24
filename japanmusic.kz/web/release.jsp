<%@page import="Servlets.Song"%>
<%@page import="Servlets.Comment"%>
<%@page import="Servlets.Release"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Servlets.DBConnection"%>
<%DBConnection db = new DBConnection();%>
<html>
    <head>
        <title>JapanMusic.kz</title>
        <meta charset='UTF-8'>
        <meta name='viewport' content='width=device-width, initial-scale=1.0'>
        <link href='./style.css' rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <table id='Main_Table'>
            <tr>
                <td>
                    <table width ='100%'>
                        <tr>
                            <td id='logoTD'>
                                <a href='index.jsp'>
                                    <img src='Images/logo.jpg' width='600' height='100' alt='logo'>
                                </a>
                            </td>
                            <td id='loginFormTD'>
                                <%  if (request.getSession(false).getAttribute("login") == null) {
                                        out.println("<details><summary>Login</summary><form action='login' method='post'>Your Login<input type='text' name='login'><br>"
                                                + "Password <input type='password' name='pass'><br>" + "<input type='submit' value='Enter'></form></details><a href='./registration.jsp'>Register</a>");
                                    } else {
                                        out.println("<a href='profile.jsp'>" + session.getAttribute("login") + "</a><br> <form action='logout' method='post'><input type='submit' value='Log Out'></form>");
                                    }

                                    int id = Integer.parseInt(request.getParameter("id"));
                                    Release r = db.getReleaseById(id);
                                    List<Comment> list = db.getCommentsList(id);
                                    r.setSeen(db.getCounter((request.getRequestURL()).toString()));
                                    db.updateRelease(id, db.getCounter((request.getRequestURL()).toString()));
                                %>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td id='headerPanel'>
                    <table width ='100%' id='headerPanelTable'>
                        <tr>
                            <td class='panelElements'>
                                <a href='profile.jsp'>Your profile</a>&nbsp;&nbsp;
                                <a href='forum.jsp'>Forum</a>&nbsp;&nbsp;
                                <a href="chat.jsp">Private message</a><br><br>
                                <form action='search' method='post'>
                                    <input type='text' id='search' name='searchText'><input type='submit' value='Search'>
                                </form>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr >
                <td>
                    <table id='general'>
                        <tr>
                            <td id='leftPanel'>
                                <table >
                                    <tr>
                                        <td id='Categories'>
                                            <ul>
                                                <li>
                                                    <a href='ost.jsp'> Anime OST</a>
                                                </li>
                                                <li>
                                                    <a href='artists.jsp'>Artists</a>
                                                </li>
                                                <li>
                                                    Genres<br>
                                                    <ul>
                                                        <li>
                                                            <a href='pop.jsp'> Pop</a>
                                                        </li>
                                                        <li>
                                                            <a href='rock.jsp'> Rock</a>
                                                        </li>
                                                        <li>
                                                            <a href='metal.jsp'> Metal</a>
                                                        </li>
                                                    </ul>
                                                </li>
                                            </ul>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                            <td id='main' width='47%'>
                                <table>                                    
                                    <tr>
                                        <td>
                                            <h1><%out.println(r.getTitle());%></h1>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td align="center">
                                            <%out.println("<img src='" + r.getImage() + "'>");%>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td align="center">
                                            <h3><%out.println(r.getDescription());%></h3>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <%
                                                ArrayList<Song> songList = db.getSongList();
                                                for(int i=(songList.size()-1); i>=0; i--){
                                                    out.println("<audio controls class='songs'><source src='"+songList.get(i).getAddress()+"' type='audio/mpeg'>Your browser does not support the <code>audio</code> tag.</audio> "+songList.get(i).getTitle()+"<br>");
                                                }
                                            %>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td align="left">
                                            <%out.println(db.getLoginById(r.getUser_id()));%>
                                        </td>
                                        <td align="right">
                                            <%out.println("<br>");%>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td id="commentForm">
                                            <form action='addComment' method='post'>
                                                <input type="text" name ='text'>
                                                <input type="hidden" name="relId" value="<%out.println(id);%>">
                                                <input type='submit' value='Add comment'>
                                            </form>
                                            <%
                                                for (int i = list.size() - 1; i >= 0; i--) {
                                            %>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="comment">
                                            <table>
                                                <tr>
                                                    <td>
                                                        <%
                                                            out.println("<h3>"+list.get(i).getText()+"</h3>");
                                                        %>                                                            
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        <%
                                                            out.println(db.getUserById(list.get(i).getUserId()).getLogin());
                                                        %>
                                                    </td>
                                                </tr>
                                            </table>
                                            <%
                                                }
                                            %>
                                        </td>
                                    </tr>                                    
                                </table>
                            </td>

                            <td id='rightPanel' width='20%'>
                                <table >
                                    <tr>
                                        <td>
                                            Radio
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Forum block
                                        </td>
                                    </tr>
                                    <tr>
                                        Song of a day
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
    </body>
</html>
