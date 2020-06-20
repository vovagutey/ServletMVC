<%@ page import="dao.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Hutei Volodymyr
  Date: 03.04.2020
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Hello, world!</title>
</head>
<body background="https://i.pinimg.com/originals/a6/fb/db/a6fbdb25681d3b8bb5c7cdd76fd8a590.jpg">


<div class="container-fluid">
    <div class="row">
        <div class="col-9"></div>
        <div class="col-2" style="font-size: 30px;text-align: center; color: green; background-color: orange;">
            <%=((User)session.getAttribute("user")).getLogin()%>
        </div>
    </div>
</div>

<div class="container-fluid">
    <div class="row">
        <div class="col-3">
            <div class="btn-group dropright">
                <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
                        aria-expanded="false">
                    Name
                </button>
                <div class="dropdown-menu" style="background-color: green;">
                    <button type="button" class="btn btn-warning">vegeterian</button>
                    <button type="button" class="btn btn-warning">for men</button>

                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-3">
            <div class="btn-group dropright">
                <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
                        aria-expanded="false">
                    Size
                </button>
                <div class="dropdown-menu" style="background-color: green;">
                    <button type="button" class="btn btn-warning">30cm</button>
                    <button type="button" class="btn btn-warning">40cm</button>
                </div>

            </div>
        </div>
    </div>
</div>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</body>
</html>