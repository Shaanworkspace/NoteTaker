<%--
  Created by IntelliJ IDEA.
  User: Shaan
  Date: 12/22/2024
  Time: 6:14 PM
  To change this template use File | Settings | File Templates.
--%>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <%@include file="allJsCss.jsp" %>
    <title>Add Note Here</title>
</head>
<body>
    <div class="Container">
        <%@include file="navbar.jsp"%>
    </div>
    <div class="Form">
        <h1> Add Your Notes Here</h1>
        <form action="saver" method ="post">
            <div class="form-group">
                <label for="title">Title Of Your Note</label>
                <input
                        name="title"
                        required
                        type="text"
                        class="form-control"
                        id="title"
                        aria-describedby="emailHelp"
                        placeholder="Enter Title Here...">
                <small id="emailHelp" class="form-text text-muted">We'll never share your Personal Notes with anyone else.</small>
            </div>
            <div class="form-group">
                <label for="content">Content Title</label>
                <textarea
                        name="context"
                        style="height: 300px"
                        required
                        class="form-control"
                        placeholder="Enter Your Content Here..."
                        id="content"></textarea>

            </div>
            <div class="submit">
                <button id ="submitButton"type="submit" class="btn btn-primary">Add Note</button>
            </div>

        </form>
    </div>
</body>
</html>