<%--
  Created by IntelliJ IDEA.
  User: pr1yanka
  Date: 02/12/19
  Time: 4:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Home Page">
    <title>Home</title>

    <!-- Bootstrap core CSS -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/album.css" rel="stylesheet">

    <!-- jQuery -->
    <script src="jquery/jquery.min.js" type="text/javascript"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>

</head>

<body class="text-center">

    <%@include file="/menu/home_menu.jsp" %>


    <main role="main">

        <section class="jumbotron text-center">
            <div class="container">
                <p class="lead text-muted">Welcome to Hortonworks Ambari Cluster Services.<br>
                Select the required data source to get started!!</p>
            </div>
        </section>

        <div class="album py-5 bg-light">
            <div class="container">

                <div class="row">
                    <div class="col-md-4">
                        <div class="card mb-4 shadow-sm">
                            <div class="card-body">
                                <img src="images/pentaho.png" alt="Pentaho Service" style="height:180px">
                                <p class="card-text">Click here to view, upload and download Exampad data.</p>
                                <div class="d-flex justify-content-between align-items-center">
                                    <div class="btn-group">
                                        <a href="manageData" class="btn btn-sm btn-outline-secondary stretched-link">View</a>
                                        <a href="manageData" class="btn btn-sm btn-outline-secondary">Edit</a>
                                    </div>
                                    <small class="text-muted">9 mins</small>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="card mb-4 shadow-sm">
                            <div class="card-body">
                                <img src="images/kibana.png" alt="Kibana Service" style="height:180px">
                                <p class="card-text">Click here to view, upload and download Minro lake infrastructure data.</p>
                                <div class="d-flex justify-content-between align-items-center">
                                    <div class="btn-group">
                                        <a href="manageData" class="btn btn-sm btn-outline-secondary stretched-link">View</a>
                                        <a href="manageData" class="btn btn-sm btn-outline-secondary">Edit</a>
                                    </div>
                                    <small class="text-muted">9 mins</small>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="card mb-4 shadow-sm">
                            <div class="card-body">
                                <img src="images/tableau.jpeg" alt="Tableau Service" style="height:180px">
                                <p class="card-text">Click here to view, upload and download AICTE data.</p>
                                <div class="d-flex justify-content-between align-items-center">
                                    <div class="btn-group">
                                        <a href="manageData" class="btn btn-sm btn-outline-secondary stretched-link">View</a>
                                        <a href="manageData" class="btn btn-sm btn-outline-secondary">Edit</a>
                                    </div>
                                    <small class="text-muted">9 mins</small>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
</body>
</html>
