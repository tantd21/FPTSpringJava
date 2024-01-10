<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="dec" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<c:url var="postURL" value="/admin/branch/save-branch"></c:url>

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
                    <span><?php
                    $today = date('d/m/Y');
                    echo $today;
                    ?></span>
                </li>
            </ul>
        </nav>
    </div>

    <div class="col-12 grid-margin stretch-card">
        <div class="card">
            <div class="card-body">
                <h4 style="margin-top: -15px" class="card-title">Thêm Thông Tin Ngành</h4>
				 <form:form id="formSubmit" action="${postURL}" method="post" enctype="multipart/form-data" modelAttribute="BranchDTO">
              
                    <div class="form-group">
                        <label for="">Tên Ngành</label>
                        <form:input path="branchName" cssClass="form-control" id="branchName"/>
                        <span class="text-danger form-message"></span>
                    </div>
                
                    <div class="form-group">
                        <label for="">Loại Ngành</label>
                        <form:input path="branchType" cssClass="form-control" id="branchType"/>
                        <span class="text-danger form-message"></span>
                    </div>
                    
                    <button type="submit"  class="btn btn-gradient-primary me-2 form-category-submit">Xác Nhận</button>
                </form:form>
                
            </div>
        </div>
    </div>
</div>
