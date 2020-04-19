<%@page import="Dao.CommentoDAO"%>
<%@page import="Dao.PostDAO"%>
<!DOCTYPE html>
<html h1="dmiadmia">

    <head>

    </head>

    <body>
        <div>
            <%@ page import="entity.*" %> 
            <%@ page import="dao.*" %> 
            <%@ page import="java.util.List" %>

            <% List<Post> postList = PostDAO.findPostEntities(); %>
            <% for (int i = 0; i < postList.size(); i++) { %>  
                <% Post p = postList.get(i);%>
                <div class="card">
                    <h1 class="card-title"><% out.print(p.getTitolo()); %></h1> <br>
                    <p class="card-text"> <% out.print(p.getUtente().getUsername() + " " + p.getDataOra().toString()); %></p>
                    <p class="card-text"> <% out.print(p.getContenuto()); %></p>
                     <h4>Commenti</h4>
                     
                     <div>
                         <% List<Commento> commentiList = (List<Commento>) CommentoDAO.findByPost(p);%>
                        <% for (int j = 0; j < commentiList.size(); j++) { %>
                        <% Commento c = commentiList.get(j); %>
                        <div class="commento">
                            <p> <% out.print(c.getUtente().getUsername() + " " + c.getDataOra().toString()); %></p>
                            <p> <% out.print(c.getContenuto()); %></p>
                     </div>
                      <% } %>
                      <form action="CommentoServlet">
                         <% long postId = p.getId();%>
                        <input type="hidden" name="postId" value="<%=postId%>">
                        <button class="btn btn-light btn-lg" type="submit" style="background-color: rgb(875, 145, 69);">Commenta</button>
                      </form>
                </div>
        </div>
                   
          <% }%>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
        <script src="assets/js/bs-animation.js"></script>
        <script src="assets/js/GradeJS-the-preview-image-do-not-reflect-the-effect-1.js"></script>
        <script src="assets/js/GradeJS-the-preview-image-do-not-reflect-the-effect.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/js/swiper.jquery.min.js"></script>
        <script src="assets/js/Image-slider-carousel-With-arrow-buttons.js"></script>
        <script src="assets/js/Simple-Slider.js"></script>
    </body>

</html>