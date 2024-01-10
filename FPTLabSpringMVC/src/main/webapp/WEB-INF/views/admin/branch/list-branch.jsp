<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="dec" uri="http://www.opensymphony.com/sitemesh/decorator"%>

<c:url var="listURL" value="/admin/branch/list-branch"></c:url>

   <c:if test="${not empty branch.type && not empty branch.message}">
  	<script>
        message_toastr("${branch.type}", "${branch.message}");
    </script>
  </c:if>  

<div class="content-wrapper">
   <div class="page-header">
      <h3 class="page-title">
         <span class="page-title-icon bg-gradient-primary text-white me-2">
         <i class="mdi mdi-crosshairs-gps"></i>
         </span> Quản Lý Ngành
      </h3>
      <nav aria-label="breadcrumb">
         <ul class="breadcrumb">
            <li class="breadcrumb-item active" aria-current="page">
               <i class="mdi mdi-timetable"></i>
               <span>
               <?php
                  $today = date('d/m/Y');
                  echo $today;?>
               </span>
            </li>
         </ul>
      </nav>
   </div>
   <div class="col-lg-12 grid-margin stretch-card">
      <div class="card">
         <div class="card-body">
            <div style="display: flex;justify-content: space-between">
               <div class="card-title col-sm-9">Bảng Danh Sách Ngành</div>
               <div class="col-sm-3">
                  <div class="input-group">
                     <input id="search" type="text" class="form-control" name="search"
                        placeholder="Tìm Kiếm ID">
                     <button type="button" class="btn-md btn-inverse-success btn-icon">
                     <i class="mdi mdi-account-search"></i>
                     </button>
                  </div>
               </div>
            </div>
            <table style="margin-top:20px " class="table table-bordered">
               <thead>
                  <tr>
                     <th> #ID </th>
                     <th>Tên Ngành</th>
                     <th>Loại Ngành</th>
                     <th>Thao Tác</th>
                  </tr>
               </thead>
               
                 
               <tbody>
                 <c:if test="${not empty branch}">
                  <c:forEach var="item" items="${branch.listResult}">
                     <tr>
                        <td>${item.branchId}</td>
                        <td>${item.branchName}</td>
                        <td>${item.branchType}</td>
                    
                        <td>
                        	<c:url var="updateItemURL" value="/admin/branch/edit-branch">
							<c:param name="branchId" value="${item.branchId}"/>
							</c:url>
							
                           <a href="${updateItemURL}">
                           <button type="button" class="btn-sm btn-gradient-info btn-icon-text">
                           <i class="mdi mdi-delete-forever btn-icon-prepend"></i> Chỉnh Sửa </button>
                           </a>
                           </br>
                           <button type="button" class="btn-sm btn-gradient-danger btn-icon-text btn-delete-item mt-2" data-item_id = "${item.branchId}">
                           <i class="mdi mdi-delete-forever btn-icon-prepend"></i> Xóa </button>
                        </td>
                     </tr>
                  </c:forEach>
                 </c:if>  
               </tbody>
            </table>
            <nav class="d-flex justify-content-center pt-4" aria-label="Page navigation">
               <ul class="pagination" id="pagination"></ul>
            </nav>
         </div>
      </div>
   </div>
</div>



<script type="text/javascript">
	var totalPages = ${branch.totalPage};
	var currentPage = ${branch.page};
	var limit = ${branch.limit};
	var page = 1;
   $(function () {
       window.pagObj = $('#pagination').twbsPagination({
           totalPages: totalPages,
           visiblePages: 3,
           startPage: currentPage,
           first:'Đầu',
           prev:'Trước',
           next:'Tiếp',
           last:'Cuối',
           onPageClick: function (event, page) {
        	   page = page;
        	   if (currentPage != page) {			
        		  window.location.href = "${listURL}?page=" + page + "&limit=" + limit;
        		 
				}
           }
       })
   });
   
   $(document).on('click', '.btn-delete-item', function() {
	    var item_id = $(this).data('item_id');
	    message_toastr("warning", 'Xác Nhận Xóa Học Sinh ID ' + item_id +
	        '?<br/><br/><button type="button" class="btn-sm btn-gradient-info btn-rounded btn-fw confirm-delete" data-item_id="' +
	        item_id + '">Xóa</button>');
	});
  $(document).on('click', '.confirm-delete', function() {
	   alert("Nhân chưa Code");
  });
</script>