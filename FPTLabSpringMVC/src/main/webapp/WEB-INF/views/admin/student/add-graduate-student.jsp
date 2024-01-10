<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="dec" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  


<c:url var="postURL" value="/admin/student/save-graduate-student"></c:url> 

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

    <div class="col-12 grid-margin stretch-card">
        <div class="card">
            <div class="card-body">
                <h4 style="margin-top: -15px" class="card-title">Thêm Thông Tin Sinh Viên ID ${studentIdCard}<span style="color: red;">(*)</span></h4>
                <form id="formSubmit" action="${postURL}" method="post" enctype="multipart/form-data">
                  
                     <input id="studentIdCard" class="form-control" type="hidden" name="studentIdCard" value="${studentIdCard}">
                  	
            		<div class="form-group">
                        <label for="">Lựa Chọn Trường <span style="color: red;">(*)</span></label>
                        <select class="form-control" name="schoolId" id="schoolId">
                            <c:forEach var="item" items="${schoolDTOs}">
                              	  <option value="${item.schoolId}">${item.schoolName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    
                    <div class="form-group">
                        <label for="">Lựa Chọn Ngành Tốt Nghiệp <span style="color: red;">(*)</span></label>
                        <select class="form-control" name="branchIdGraduate" id="branchIdGraduate">
                            <c:forEach var="item" items="${branchDTOs}">
                              	  <option value="${item.branchId}">${item.branchName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    
                    <div class="form-group">
                        <label for="">Hệ Tốt Nghiệp <span style="color: red;">(*)</span></label>
                         <input id="graduateProgram" class="form-control" type="text" 
                            name="graduateProgram" placeholder="Hệ Tốt Nghiệp">
                        <span class="text-danger form-message"></span>
                    </div>
                    
                    <div class="form-group">
                        <label for="">Ngày Tốt Nghiệp <span style="color: red;">(*)</span></label>
                         <input id="graduateDate" class="form-control" type="date" 
                            name="graduateDate" placeholder="Ngày Tốt Nghiệp">
                        <span class="text-danger form-message"></span>
                    </div>
                    
                    <div class="form-group">
                        <label for="">Loại Tốt Nghiệp <span style="color: red;">(*)</span></label>
                         <input id="graduateType" class="form-control" type="text" 
                            name="graduateType" placeholder="Loại Tốt Nghiệp">
                        <span class="text-danger form-message"></span>
                    </div>
                   
                  

                    <button type="submit" id="click-submit" class="btn btn-gradient-primary me-2 form-category-submit">Xác Nhận</button>
                </form>
            </div>
        </div>
    </div>
</div>

	
	