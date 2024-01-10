<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <nav class="sidebar sidebar-offcanvas" id="sidebar">
          <ul class="nav">
            <li class="nav-item nav-profile">
              <a href="#" class="nav-link">
                <div class="nav-profile-image">
                  <img src="<c:url value='/template/admin/assets/images/faces/face1.jpg'/>" alt="profile">
                  <span class="login-status online"></span>
                  <!--change to offline or busy as needed-->
                </div>
                <div class="nav-profile-text d-flex flex-column">
                  <span class="font-weight-bold mb-2">Nhân</span>
                  <span class="text-secondary text-small">Project Manager</span>
                </div>
                <i class="mdi mdi-bookmark-check text-success nav-profile-badge"></i>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="<c:url value='/admin/dashboard'/>">
                <span class="menu-title">Dashboard</span>
                <i class="mdi mdi-home menu-icon"></i>
              </a>
            </li>
            
            
            <li class="nav-item">
              <a class="nav-link" data-bs-toggle="collapse" href="#ui-school" aria-expanded="false" aria-controls="ui-basic">
                <span class="menu-title">Quản Lý Trường</span>
                <i class="menu-arrow"></i>
                <i class="mdi mdi-crosshairs-gps menu-icon"></i>
              </a>
              <div class="collapse" id="ui-school">
                <ul class="nav flex-column sub-menu">
                  <li class="nav-item"> <a class="nav-link" href="<c:url value='/admin/school/list-school'/>">Danh Sách Trường</a></li>
                  <li class="nav-item"> <a class="nav-link" href="<c:url value='/admin/school/add-school'/>">Thêm Thông Tin Trường</a></li>
                </ul>
              </div>
            </li>
            
            <li class="nav-item">
              <a class="nav-link" data-bs-toggle="collapse" href="#ui-branch" aria-expanded="false" aria-controls="ui-basic">
                <span class="menu-title">Quản Lý Ngành</span>
                <i class="menu-arrow"></i>
                <i class="mdi mdi-crosshairs-gps menu-icon"></i>
              </a>
              <div class="collapse" id="ui-branch">
                <ul class="nav flex-column sub-menu">
                  <li class="nav-item"> <a class="nav-link" href="<c:url value='/admin/branch/list-branch'/>">Danh Sách Ngành</a></li>
                  <li class="nav-item"> <a class="nav-link" href="<c:url value='/admin/branch/add-branch'/>">Thêm Thông Tin Ngành</a></li>
                </ul>
              </div>
            </li>
            
           <li class="nav-item">
              <a class="nav-link" data-bs-toggle="collapse" href="#ui-student" aria-expanded="false" aria-controls="ui-basic">
                <span class="menu-title">Quản Lý Sinh Viên</span>
                <i class="menu-arrow"></i>
                <i class="mdi mdi-crosshairs-gps menu-icon"></i>
              </a>
              <div class="collapse" id="ui-student">
                <ul class="nav flex-column sub-menu">
                  <li class="nav-item"> <a class="nav-link" href="<c:url value='/admin/student/list-student'/>">Danh Sách Sinh Viên</a></li>
                  <li class="nav-item"> <a class="nav-link" href="<c:url value='/admin/student/add-student'/>">Thêm Thông Tin Sinh Viên</a></li>
                  <li class="nav-item"> <a class="nav-link" href="<c:url value='/admin/student/list-details-student'/>">Truy Vấn Thông Tin SV</a></li>
                </ul>
              </div>
            </li>
        
          </ul>
        </nav>