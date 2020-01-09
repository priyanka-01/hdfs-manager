<%--
  Created by IntelliJ IDEA.
  User: pr1yanka
  Date: 02/12/19
  Time: 8:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Home Page">
    <title>Manage Data</title>

    <!-- Bootstrap core CSS -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/album.css" rel="stylesheet">

    <!-- jQuery -->
    <script src="jquery/jquery.min.js" type="text/javascript"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>

    <!-- DataTables -->
    <link rel="stylesheet" type="text/css" href="datatables/datatables.css"/>
    <script type="text/javascript" src="datatables/datatables.js"></script>

    <!-- Custom Styles-->
    <link href="css/manageData.css" rel="stylesheet">

</head>
<body>

<%@include file="/menu/home_menu.jsp" %>

 <div class="container">
     <br><br>
     <h3>Directory</h3>
     <br>
    <form class="form-signin" method="POST" enctype="multipart/form-data" >
        <div class="form-row align-items-center">
            <div class="col-sm-6 my-1">
            <div class="custom-file">
            <input type="file" class="custom-file-input" id="addFile" name="addFile">
            <label class="custom-file-label" for="addFile">Upload File</label>
            </div>
            </div>
            <div class="col-auto my-1">
            <button type="submit" class="btn btn-success">Upload</button>
            </div>
        </div>
    </form>

     <div class="container mt-4">
         <table id="student_data" class="table table-striped table-bordered">
             <thead>
             <tr>
                 <th>S.No.</th>
                 <th>User Name</th>
                 <th>File</th>
                 <th>Date</th>
                 <th>Download</th>
             </tr>
             </thead>
             <tbody></tbody>
         </table>
     </div>
 </div>
</body>
</html>
