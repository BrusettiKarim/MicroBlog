<%-- 
    Document   : commento
    Created on : 19 apr 2020, 15:26:26
    Author     : Karim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="col-12 col-sm-6 col-md-6 col-xl-7 offset-xl-3 site-form">
            <%@ page import="entity.*" %> 
            <%@ page import="Dao.*" %> 
            <%@ page import="java.util.List" %>
            <% long postId = (long) request.getAttribute("postId"); %>
            <% Post p = PostDAO.findPost(postId); %>
            <div class="card">
                <h2 class="card-title"><% out.print(p.getTitolo()); %></h2> <br>
                <h5 class="card-text"> <% out.print("Utente: "+p.getUtente().getUsername() + "<br> In data: " + p.getDataOra().toString()); %></h5> 
                <p  class="card-text" ><h5><font face="white"> <% out.print(p.getContenuto()); %></font></p></h5>
                <h4>Commenti</h4>
                <div>
                    <% List<Commento> commentiList = (List<Commento>) CommentoDAO.findByPost(p);%>
                    <% for (int j = 0; j < commentiList.size(); j++) { %>
                    <% Commento c = commentiList.get(j); %>
                    <div class="commento">
                        <p> <% out.print("Utente: " + c.getUtente().getUsername() + "<br> In data: " + c.getDataOra().toString()); %></p>
                        <p><font face="white"> <% out.print(c.getContenuto()); %></font></p>
                    </div>
                    <% }%>
                </div>
            </div>
        </div>
                <form id="my-form" action="SaveCommento" method="POST">

                    <input type="hidden" name="postId" value="<%=postId%>">

                    <div class="form-group">
                        <label class="sr-only" for="messages">Last Name</label><textarea class="form-control" rows="8" name="testo" required="" placeholder="Inserisci un commento..."></textarea></div><button class="btn btn-light btn-lg" type="submit" id="form-btn"
                            style="background-color: rgb(41, 58, 78);"><strong>Commenta</strong></button>
                </form>
    </body>
</html>
