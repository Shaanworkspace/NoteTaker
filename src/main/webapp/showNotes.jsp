<%@ page import="org.hibernate.Session" %>
<%@ page import="com.helper.SessionManager" %>
<%@ page import="com.entities.note" %>
<%@ page import="org.hibernate.query.Query" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <%@include file="allJsCss.jsp" %>
    <title>Showing Notes</title>
</head>
<body>
<div class="container">
    <%@include file="navbar.jsp" %>
</div>

<div class="container mt-4">
    <h2>Your Notes</h2>

    <div class="row">
        <div class="col-12">
            <%
                Session s = SessionManager.getFactory().openSession();
                Query q = s.createQuery("from note");
                List<note> list = q.list();
                for (note each : list) {
            %>
            <div class="card mt-3">
                <img class="card-img-top" style="width: 100px" src="images/noteEmoji.png" alt="Card image cap">
                <div class="card-body" style="display: flex; justify-content: center">
                    <h5 class="card-title"><%=each.getTitle()%></h5>
                    <p class="card-text"><%=each.getContent()%></p>
                    <a href="#" class="btn btn-danger">Delete Note</a>
                </div>
            </div>
            <%
                }
                s.close();
            %>

        </div>
    </div>




</div>
</body>
</html>
