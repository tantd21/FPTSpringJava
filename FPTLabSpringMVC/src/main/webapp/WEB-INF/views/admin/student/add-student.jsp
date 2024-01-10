<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="dec" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  


<c:url var="postURL" value="/admin/student/save-student"></c:url> 

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
                <h4 style="margin-top: -15px" class="card-title">Thêm Thông Tin Sinh Viên <span style="color: red;">(*)</span></h4>
                <form id="formSubmit" action="${postURL}" method="post" enctype="multipart/form-data">
                
                 <div id="">
                    
                    <div class="form-group">
                        <label for="">Số CMND <span style="color: red;">(*)</span></label>
                         <input id="studentIdCard" class="form-control" type="text" 
                            name="studentIdCard" placeholder="Số CMND">
                        <span class="text-danger form-message"></span>
                    </div>
					
					 <div class="form-group">
                        <label for="">Tên Sinh Viên <span style="color: red;">(*)</span></label>
                         <input id="studentName" class="form-control" type="text" 
                            name="studentName" placeholder="Tên Sinh Viên">
                        <span class="text-danger form-message"></span>
                    </div>
                    
                    <div class="form-group">
                        <label for="">Email Sinh Viên <span style="color: red;">(*)</span></label>
                         <input id="studentEmail" class="form-control" type="text" 
                            name="studentEmail" placeholder="Email Sinh Viên">
                        <span class="text-danger form-message"></span>
                    </div>
				
				     <div class="form-group">
                        <label for="">Số Điện Thoại Sinh Viên <span style="color: red;">(*)</span></label>
                         <input id="studentPhone" class="form-control" type="text" 
                            name="studentPhone" placeholder="Số Điện Thoại Sinh Viên">
                        <span class="text-danger form-message"></span>
                    </div>
                    
                    <div class="form-group">
                        <label for="">Địa Chỉ Sinh Viên <span style="color: red;">(*)</span></label>
                         <input id="studentAddress" class="form-control" type="text" 
                            name="studentAddress" placeholder="Địa Chỉ Sinh Viên">
                        <span class="text-danger form-message"></span>
                    </div>
                    
                    
 				   </div>
                    	

                  
                  <div id="">
                  
                  	<h4 style="margin-top: 15px" class="card-title">Thêm Thông Tin Tốt Nghiệp <span style="color: red;">(*)</span></h4>
                  	
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
                   
                  </div>
                  
                   <div>
                   	<h4 style="margin-top: 15px" class="card-title">Thêm Thông Tin Công Việc</h4>
                   	
                   	<div class="form-group">
                        <label for="">Lựa Chọn Ngành Công Việc</label>
                        <select class="form-control" name="branchIdWork" id="branchIdWork">
                            <c:forEach var="item" items="${branchDTOs}">
                              	  <option value="${item.branchId}">${item.branchName}</option>
                            </c:forEach>
                        </select>
                    </div>
                   	
               		 <div class="form-group">
                        <label for="">Ngày Vào Công Ty</label>
                         <input id="workDateJoin" class="form-control" type="date" 
                            name="workDateJoin" placeholder="Ngày Vào Công Ty">
                        <span class="text-danger form-message"></span>
                    </div>
                    
                     <div class="form-group">
                        <label for="">Tên Công Việc</label>
                         <input id="workName" class="form-control" type="text" 
                            name="workName" placeholder="Tên Công Việc">
                        <span class="text-danger form-message"></span>
                    </div>
                    
                    <div class="form-group">
                        <label for="">Tên Công Ty</label>
                         <input id="workCompanyName" class="form-control" type="text" 
                            name="workCompanyName" placeholder="Tên Công Ty">
                        <span class="text-danger form-message"></span>
                    </div>
                    
                     <div class="form-group">
                        <label for="">Địa Chỉ Công Ty</label>
                         <input id="workCompanyAddress" class="form-control" type="text" 
                            name="workCompanyAddress" placeholder="Địa Chỉ Công Ty">
                        <span class="text-danger form-message"></span>
                    </div>
                    
                    <div class="form-group">
                        <label for="">Thời Gian Làm Việc</label>
                         <input id="workCompanyTime" class="form-control" type="date" 
                            name="workCompanyTime" placeholder="Thời Gian Làm Việc">
                        <span class="text-danger form-message"></span>
                    </div>
                    
                    
                    
                    
                   </div>
                

                    <button type="submit" id="click-submit" class="btn btn-gradient-primary me-2 form-submit">Xác Nhận</button>
                </form>
            </div>
        </div>
    </div>
</div>

    <script>
        Validator({
            form: '#formSubmit',
            errorSelector: '.form-message',
            rules: [
                Validator.isRequired('#studentIdCard', 'Vui lòng trường này'),
                Validator.isNumber('#studentIdCard'),
                Validator.minLength('#studentIdCard',10),
                Validator.maxLength('#studentIdCard',10),
                Validator.isRequired('#studentName', 'Vui lòng trường này'),
                Validator.minLength('#studentName',4),
                Validator.maxLength('#studentName',32),
                Validator.isRequired('#studentEmail', 'Vui lòng trường này'),
                Validator.isEmail('#studentEmail'),
                Validator.isRequired('#studentPhone', 'Vui lòng trường này'),
                Validator.isNumber('#studentPhone'),
                Validator.minLength('#studentPhone',10),
                Validator.maxLength('#studentPhone',10),
                Validator.isRequired('#studentAddress', 'Vui lòng trường này'),
                
                Validator.isRequired('#graduateProgram', 'Vui lòng trường này'),
                Validator.isRequired('#graduateDate', 'Vui lòng trường này'),
                Validator.isRequired('#graduateType', 'Vui lòng trường này'),
            ]
        });

        $('#click-submit').click(function() {
            if (    $('#studentIdCard').val() == ''  || 
            		$('#studentName').val() == ''  || 
            		$('#studentEmail').val() == ''  || 
            		$('#studentPhone').val() == ''  || 
            		$('#studentAddress').val() == ''  || 
            		$('#graduateProgram').val() == ''  || 
            		$('#graduateDate').val() == ''  || 
            		$('#graduateType').val() == ''  || 
            		$('.form-message').text() != '') {
            	
                    $("#formSubmit").submit(function(e) {
                        e.preventDefault();
                        message_toastr("warning","Dữ liệu nhập vào không hợp lệ !")
                    });
            }
        })
    </script>

	
	