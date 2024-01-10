<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="dec" uri="http://www.opensymphony.com/sitemesh/decorator"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Quản Trị Hệ Thống</title>
    <!--bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"></script>
    
    <!-- plugins:css -->
    <link rel="stylesheet" href="<c:url value='/template/admin/assets/vendors/mdi/css/materialdesignicons.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/template/admin/assets/vendors/css/vendor.bundle.base.css'/>">
    <!-- endinject -->
    <!-- Plugin css for this page -->
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <!-- endinject -->
    <!-- Layout styles -->
    <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/style.css'/>">
    <!-- End layout styles -->
    <link rel="shortcut icon" href="<c:url value='/template/admin/assets/images/favicon.ico'/>" />
    <!-- Validator -->
    <script src="<c:url value='/template/admin/assets/js/validator.js'/>"></script>
   <!--  Toastr Css -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
   <!--  Js Toast -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script> 
    <script>
        function message_toastr(type, content) {
            toastr.options = {
                "closeButton": true,
                "debug": true,
                "newestOnTop": false,
                "progressBar": true,
                "positionClass": "toast-top-right",
                "preventDuplicates": true,
                "showDuration": "300",
                "hideDuration": "1000",
                "timeOut": "5000",
                "extendedTimeOut": "1000",
                "showEasing": "swing",
                "hideEasing": "linear",
                "showMethod": "fadeIn",
                "hideMethod": "fadeOut"
            };
            toastr[type](content);
        }
    </script>
  </head>
  <body>
    <div class="container-scroller">
      <!-- partial:partials/_navbar.html -->
      <!-- header -->
         <%@include file="/commom/admin/header.jsp" %>
      <!-- endheader -->
      <!-- partial -->
      <div class="container-fluid page-body-wrapper">
        <!-- partial:partials/_sidebar.html -->
        <!-- menu -->
			 <%@include file="/commom/admin/menu.jsp" %>
        <!-- endmenu -->
        <!-- partial -->
        <div class="main-panel">
          
          <dec:body/>
          
          <!-- content-wrapper ends -->
          <!-- partial:partials/_footer.html -->
          <!-- footer -->
    		<%@include file="/commom/admin/footer.jsp" %>
          <!-- endfooter -->
          <!-- partial -->
        </div>
        <!-- main-panel ends -->
      </div>
      <!-- page-body-wrapper ends -->
    </div>
    <!-- container-scroller -->
    <!-- plugins:js -->
    <script src="<c:url value='/template/admin/assets/vendors/js/vendor.bundle.base.js'/>"></script>
    <!-- endinject -->
    <!-- Plugin js for this page -->
    <script src="<c:url value='/template/admin/assets/vendors/chart.js/Chart.min.js'/>"></script>
    <script src="<c:url value='/template/admin/assets/js/jquery.cookie.js'/>" type="text/javascript"></script>
    <!-- End plugin js for this page -->
    <!-- inject:js -->
    <script src="<c:url value='/template/admin/assets/js/off-canvas.js'/>"></script>
    <script src="<c:url value='/template/admin/assets/js/hoverable-collapse.js'/>"></script>
    <script src="<c:url value='/template/admin/assets/js/misc.js'/>"></script>
    <!-- endinject -->
    <!-- Custom js for this page -->
    <script src="<c:url value='/template/admin/assets/js/dashboard.js'/>"></script>
    <script src="<c:url value='/template/admin/assets/js/todolist.js'/>"></script>
    <!-- End custom js for this page -->
  	<!--   Pagination  -->
  	<script src="<c:url value='/template/admin/assets/js/jquery.twbsPagination.js'/>"></script>
  	<!--   Endpagination  -->
  </body>
</html>