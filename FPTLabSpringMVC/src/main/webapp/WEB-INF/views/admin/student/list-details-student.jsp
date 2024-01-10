<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="dec" uri="http://www.opensymphony.com/sitemesh/decorator"%>

<c:url var="listURL" value="/admin/student/list-details-student"></c:url>

   <c:if test="${not empty student.type && not empty student.message}">
  	<script>
        message_toastr("${student.type}", "${student.message}");
    </script>
  </c:if>  

<div class="content-wrapper">
   <div class="page-header">
      <h3 class="page-title">
         <span class="page-title-icon bg-gradient-primary text-white me-2">
         <i class="mdi mdi-crosshairs-gps"></i>
         </span> Quản Lý Sinh Viên
      </h3>
      <nav aria-label="breadcrumb">
         <ul class="breadcrumb">
            <li class="breadcrumb-item active" aria-current="page">
               <i class="mdi mdi-timetable"></i>
               <span></span>
            </li>
         </ul>
      </nav>
   </div>
   <div class="col-lg-12 grid-margin stretch-card">
      <div class="card">
         <div class="card-body">
            <div style="display: flex;justify-content: space-between">
               <div class="card-title col-sm-9">Bảng Danh Sách Sinh Viên</div>
               <div class="col-sm-3">
                 <form id="formSubmit" action="${listURL}" method="get" enctype="multipart/form-data">
                  <div class="input-group">
                     <input id="search" type="text" class="form-control" name="search"
                        placeholder="Tìm Kiếm CMND Hoặc Tên">
                     <button type="submit" class="btn-md btn-inverse-success btn-icon">
                     <i class="mdi mdi-account-search"></i>
                     </button>
                  </div>
                  </form>
               </div>
            </div>
<%--             <table style="margin-top:20px " class="table table-bordered">
               <thead>
                  <tr>
                     <th> #ID CMND </th>
                     <th>Tên Sinh Viên</th>
                     <th>Mã - Tên Ngành TN</th>
                     <th>Mã - Tên Trường</th>
                     <th>Mã - Tên Ngành CV</th>
                     <th>Tên Công Ty</th>
                     <th>Thời Gian Làm Việc</th>
                  </tr>
               </thead>
               
                 
               <tbody>
                 <c:if test="${not empty student}">
                  <c:forEach var="item" items="${student.listResult}">
                     <tr>
                        <td>${item.studentIdCard}</td>
                        <td>${item.studentName}</td>
                        <td>${item.graduateList[0].branch.branchId} - ${item.graduateList[0].branch.branchName}</td>
                        <td>${item.graduateList[0].school.schoolId} - ${item.graduateList[0].school.schoolName}</td>
                     
                        <c:choose>
            			<c:when test="${item.workList ne null and item.workList.size() > 0}">
                          <td>${item.workList[0].branch.branchId} - ${item.workList[0].branch.branchName}</td>
                          <td>${item.workList[0].workCompanyName}</td>
                          <td>${item.workList[0].workCompanyTime}</td>
                         </c:when>
            			<c:otherwise>
             			  <td></td>
                          <td></td>
                          <td></td>
                       </c:otherwise>
        			</c:choose>
                     </tr>
                  </c:forEach>
                 </c:if>  
               </tbody>
            </table> --%>
            
   <table style="margin-top:20px" class="table table-bordered">
   <thead>
      <tr>
         <th> #ID CMND </th>
         <th>Tên Sinh Viên</th>
         <th>Mã - Tên Ngành TN</th>
         <th>Mã - Tên Trường</th>
         <th>Mã - Tên Ngành CV</th>
         <th>Tên Công Ty</th>
         <th>Thời Gian Làm Việc</th>
      </tr>
   </thead>
   <tbody>
      <c:if test="${not empty student}">
         <c:forEach var="item" items="${student.listResult}">
            <tr>
               <td>${item.studentIdCard}</td>
               <td>${item.studentName}</td>
               <c:choose>
                  <c:when test="${item.graduateList ne null and item.graduateList.size() > 0}">
                     <td>
                        <c:forEach var="graduate" items="${item.graduateList}">
                        	 <br>
                           ${graduate.branch.branchId} - ${graduate.branch.branchName}<br/>
                        </c:forEach>
                     </td>
                     <td>
                        <c:forEach var="graduate" items="${item.graduateList}">
                           <br>
                           ${graduate.school.schoolId} - ${graduate.school.schoolName}<br/>
                        </c:forEach>
                     </td>
                  </c:when>
                  <c:otherwise>
                     <td></td>
                     <td></td>
                  </c:otherwise>
               </c:choose>

               <c:choose>
                  <c:when test="${item.workList ne null and item.workList.size() > 0}">
                     <td>
                        <c:forEach var="work" items="${item.workList}">
                        	 <br>
                           ${work.branch.branchId} - ${work.branch.branchName}<br/>
                        </c:forEach>
                     </td>
                     <td>
                        <c:forEach var="work" items="${item.workList}">
                        	 <br>
                           ${work.workCompanyName}<br/>
                        </c:forEach>
                     </td>
                     <td>
                        <c:forEach var="work" items="${item.workList}">
                        	 <br>
                           ${work.workCompanyTime}<br/>
                        </c:forEach>
                     </td>
                  </c:when>
                  <c:otherwise>
                     <td></td>
                     <td></td>
                     <td></td>
                  </c:otherwise>
               </c:choose>
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
	var totalPages = ${student.totalPage};
	var currentPage = ${student.page};
	var limit = ${student.limit};
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