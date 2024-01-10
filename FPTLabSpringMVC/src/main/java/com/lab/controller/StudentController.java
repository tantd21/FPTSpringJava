package com.lab.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lab.dto.BranchDTO;
import com.lab.dto.GraduateDTO;
import com.lab.dto.SchoolDTO;
import com.lab.dto.StudentDTO;
import com.lab.dto.WorkDTO;
import com.lab.service.IBranchService;
import com.lab.service.IGraduateService;
import com.lab.service.ISchoolService;
import com.lab.service.IStudentService;
import com.lab.service.IWorkService;

@Controller
public class StudentController {
	@Autowired
	IBranchService iBranchService;
	@Autowired
	ISchoolService iSchoolService;
	@Autowired
	IStudentService iStudentService;
	@Autowired
	IWorkService iWorkService;
	@Autowired
	IGraduateService iGraduateService;

	@RequestMapping(value = "admin/student/add-student", method = RequestMethod.GET)
	public ModelAndView addList() {
		ModelAndView mav = new ModelAndView("admin/student/add-student");

		List<SchoolDTO> schoolDTOs = iSchoolService.findAll(null);
		List<BranchDTO> branchDTOs = iBranchService.findAll(null);

		mav.addObject("branchDTOs", branchDTOs);
		mav.addObject("schoolDTOs", schoolDTOs);

		return mav;
	}
	
	@RequestMapping(value = "admin/student/add-work-student", method = RequestMethod.GET)
	public ModelAndView addWorkStudent(HttpServletRequest request,RedirectAttributes redirectAttributes) {
		ModelAndView mav = new ModelAndView("admin/student/add-work-student");
		String studentIdCard = request.getParameter("studentIdCard");
		if(studentIdCard == null || studentIdCard.isEmpty()) {
			redirectAttributes.addFlashAttribute("type", "error");
			redirectAttributes.addFlashAttribute("message", "Tham Số Truyền Vào Không Hợp Lệ !");
			 return new ModelAndView("redirect:/admin/student/list-student");
		}else {			
			List<BranchDTO> branchDTOs = iBranchService.findAll(null);
			mav.addObject("branchDTOs", branchDTOs);
			mav.addObject("studentIdCard", studentIdCard);
			return mav;
		}
	}
	
	@RequestMapping(value = "admin/student/save-work-student", method = RequestMethod.POST, consumes = {
			MediaType.MULTIPART_FORM_DATA_VALUE })
	public String saveWorkStudent(HttpServletResponse response, HttpServletRequest request,
			RedirectAttributes redirectAttributes) throws IOException {

		Long studentIdCard =Long.parseLong(request.getParameter("studentIdCard"));
		StudentDTO studentDTO = iStudentService.findByID(studentIdCard);
		// Lấy giá trị branchIdWork từ request và chuyển đổi sang kiểu Integer
		String branchIdWorkParameter = request.getParameter("branchIdWork");
		if (branchIdWorkParameter != null && !branchIdWorkParameter.isEmpty()) {
		    try {
		        Integer branchIdWork = Integer.parseInt(branchIdWorkParameter);

		        // Kiểm tra nếu branchIdWork hợp lệ
		        if (branchIdWork != null) {
		            // Tìm đối tượng BranchDTO dựa trên branchIdWork
		            BranchDTO branchWork = iBranchService.findByID(branchIdWork);

		            // Kiểm tra giá trị của các trường còn lại trước khi insert
		            String workDateJoin = request.getParameter("workDateJoin");
		            String workName = request.getParameter("workName");
		            String workCompanyName = request.getParameter("workCompanyName");
		            String workCompanyAddress = request.getParameter("workCompanyAddress");
		            String workCompanyTime = request.getParameter("workCompanyTime");

		            if (workDateJoin != null && !workDateJoin.isEmpty() &&
		                workName != null && !workName.isEmpty() &&
		                workCompanyName != null && !workCompanyName.isEmpty() &&
		                workCompanyAddress != null && !workCompanyAddress.isEmpty() &&
		                workCompanyTime != null && !workCompanyTime.isEmpty()) {

		                // Tạo đối tượng WorkDTO và thiết lập giá trị
		                WorkDTO workDTO = new WorkDTO();
		                workDTO.setWorkDateJoin(workDateJoin);
		                workDTO.setWorkName(workName);
		                workDTO.setWorkCompanyName(workCompanyName);
		                workDTO.setWorkCompanyAddress(workCompanyAddress);
		                workDTO.setWorkCompanyTime(workCompanyTime);
		                workDTO.setStudent(studentDTO);
		                workDTO.setBranch(branchWork);

		                // Thực hiện insert
		                workDTO = iWorkService.insert(workDTO);
		            } else {
		                // Xử lý khi thiếu giá trị
		                System.out.println("Thiếu giá trị cần thiết để thực hiện insert.");
		            }
		        }
		    } catch (NumberFormatException e) {
		        // Xử lý nếu không thể chuyển đổi thành Integer
		        e.printStackTrace(); // hoặc có thể thực hiện xử lý khác tùy thuộc vào yêu cầu của bạn
		    }
		} else {
		    // Xử lý khi branchIdWork không được cung cấp
		    System.out.println("Không có giá trị branchIdWork để thực hiện insert.");
		}
		
		redirectAttributes.addFlashAttribute("type", "success");
		redirectAttributes.addFlashAttribute("message", "Thêm Dữ Liệu Thành Công !");
		return "redirect:/admin/student/list-student";

	}
	
	
	@RequestMapping(value = "admin/student/add-graduate-student", method = RequestMethod.GET)
	public ModelAndView addGraduateStudent(HttpServletRequest request,RedirectAttributes redirectAttributes) {
		ModelAndView mav = new ModelAndView("admin/student/add-graduate-student");
		String studentIdCard = request.getParameter("studentIdCard");
		if(studentIdCard == null || studentIdCard.isEmpty()) {
			redirectAttributes.addFlashAttribute("type", "error");
			redirectAttributes.addFlashAttribute("message", "Tham Số Truyền Vào Không Hợp Lệ !");
			 return new ModelAndView("redirect:/admin/student/list-student");
		}else {			
			List<SchoolDTO> schoolDTOs = iSchoolService.findAll(null);
			List<BranchDTO> branchDTOs = iBranchService.findAll(null);
			mav.addObject("branchDTOs", branchDTOs);
			mav.addObject("schoolDTOs", schoolDTOs);
			mav.addObject("studentIdCard", studentIdCard);
			return mav;
		}
	}

	@RequestMapping(value = "admin/student/save-graduate-student", method = RequestMethod.POST, consumes = {
			MediaType.MULTIPART_FORM_DATA_VALUE })
	public String saveGraduateStudent(HttpServletResponse response, HttpServletRequest request,
			RedirectAttributes redirectAttributes) throws IOException {

		Long studentIdCard =Long.parseLong(request.getParameter("studentIdCard"));
		StudentDTO studentDTO = iStudentService.findByID(studentIdCard);
		
		Integer schoolId = Integer.parseInt(request.getParameter("schoolId"));
		Integer branchIdGraduate = Integer.parseInt(request.getParameter("branchIdGraduate"));
		BranchDTO branchGraduate = iBranchService.findByID(branchIdGraduate);
		SchoolDTO schoolDTO = iSchoolService.findByID(schoolId);
		GraduateDTO graduateDTO = new GraduateDTO();
		graduateDTO.setGraduateProgram(request.getParameter("graduateProgram"));
		graduateDTO.setGraduateDate(request.getParameter("graduateDate"));
		graduateDTO.setGraduateType(request.getParameter("graduateType"));
		graduateDTO.setStudent(studentDTO);
		graduateDTO.setBranch(branchGraduate);
		graduateDTO.setSchool(schoolDTO);
		graduateDTO = iGraduateService.insert(graduateDTO);
		
		redirectAttributes.addFlashAttribute("type", "success");
		redirectAttributes.addFlashAttribute("message", "Thêm TTTN ID "+studentDTO.getStudentIdCard() +" Thành Công !");
		return "redirect:/admin/student/list-student";
	}
	
	@RequestMapping(value = "admin/student/save-student", method = RequestMethod.POST, consumes = {
			MediaType.MULTIPART_FORM_DATA_VALUE })
	public String saveList(HttpServletResponse response, HttpServletRequest request,
			RedirectAttributes redirectAttributes) throws IOException {
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setStudentIdCard(Long.parseLong(request.getParameter("studentIdCard")));
		studentDTO.setStudentName(request.getParameter("studentName"));
		studentDTO.setStudentEmail(request.getParameter("studentEmail"));
		studentDTO.setStudentPhone(request.getParameter("studentPhone"));
		studentDTO.setStudentAddress(request.getParameter("studentAddress"));
		studentDTO = iStudentService.insert(studentDTO);
		
		Integer schoolId = Integer.parseInt(request.getParameter("schoolId"));
		Integer branchIdGraduate = Integer.parseInt(request.getParameter("branchIdGraduate"));
		BranchDTO branchGraduate = iBranchService.findByID(branchIdGraduate);
		SchoolDTO schoolDTO = iSchoolService.findByID(schoolId);
		GraduateDTO graduateDTO = new GraduateDTO();
		graduateDTO.setGraduateProgram(request.getParameter("graduateProgram"));
		graduateDTO.setGraduateDate(request.getParameter("graduateDate"));
		graduateDTO.setGraduateType(request.getParameter("graduateType"));
		graduateDTO.setStudent(studentDTO);
		graduateDTO.setBranch(branchGraduate);
		graduateDTO.setSchool(schoolDTO);
		graduateDTO = iGraduateService.insert(graduateDTO);
		
	
		
		// Lấy giá trị branchIdWork từ request và chuyển đổi sang kiểu Integer
		String branchIdWorkParameter = request.getParameter("branchIdWork");
		if (branchIdWorkParameter != null && !branchIdWorkParameter.isEmpty()) {
		    try {
		        Integer branchIdWork = Integer.parseInt(branchIdWorkParameter);

		        // Kiểm tra nếu branchIdWork hợp lệ
		        if (branchIdWork != null) {
		            // Tìm đối tượng BranchDTO dựa trên branchIdWork
		            BranchDTO branchWork = iBranchService.findByID(branchIdWork);

		            // Kiểm tra giá trị của các trường còn lại trước khi insert
		            String workDateJoin = request.getParameter("workDateJoin");
		            String workName = request.getParameter("workName");
		            String workCompanyName = request.getParameter("workCompanyName");
		            String workCompanyAddress = request.getParameter("workCompanyAddress");
		            String workCompanyTime = request.getParameter("workCompanyTime");

		            if (workDateJoin != null && !workDateJoin.isEmpty() &&
		                workName != null && !workName.isEmpty() &&
		                workCompanyName != null && !workCompanyName.isEmpty() &&
		                workCompanyAddress != null && !workCompanyAddress.isEmpty() &&
		                workCompanyTime != null && !workCompanyTime.isEmpty()) {

		                // Tạo đối tượng WorkDTO và thiết lập giá trị
		                WorkDTO workDTO = new WorkDTO();
		                workDTO.setWorkDateJoin(workDateJoin);
		                workDTO.setWorkName(workName);
		                workDTO.setWorkCompanyName(workCompanyName);
		                workDTO.setWorkCompanyAddress(workCompanyAddress);
		                workDTO.setWorkCompanyTime(workCompanyTime);
		                workDTO.setStudent(studentDTO);
		                workDTO.setBranch(branchWork);

		                // Thực hiện insert
		                workDTO = iWorkService.insert(workDTO);
		            } else {
		                // Xử lý khi thiếu giá trị
		                System.out.println("Thiếu giá trị cần thiết để thực hiện insert.");
		            }
		        }
		    } catch (NumberFormatException e) {
		        // Xử lý nếu không thể chuyển đổi thành Integer
		        e.printStackTrace(); // hoặc có thể thực hiện xử lý khác tùy thuộc vào yêu cầu của bạn
		    }
		} else {
		    // Xử lý khi branchIdWork không được cung cấp
		    System.out.println("Không có giá trị branchIdWork để thực hiện insert.");
		}
		
		redirectAttributes.addFlashAttribute("type", "success");
		redirectAttributes.addFlashAttribute("message", "Thêm Dữ Liệu Thành Công !");
		return "redirect:/admin/student/list-student";
	}

	@RequestMapping(value = "admin/student/list-student", method = RequestMethod.GET)
	public ModelAndView showList(Model model, HttpServletRequest request,
			@RequestParam(name = "page", defaultValue = "1", required = true) int page,
			@RequestParam(name = "limit", defaultValue = "5", required = true) int limit) {
		ModelAndView mav = new ModelAndView("admin/student/list-student");
		StudentDTO dto = new StudentDTO();
		dto.setPage(page);
		dto.setLimit(limit);
		dto.setTotalItem(iStudentService.getTotalItem());
		dto.setTotalPage((int) Math.ceil((double) dto.getTotalItem() / dto.getLimit()));
		Pageable pageable = new PageRequest(page - 1, limit);
		String search = request.getParameter("search");
		dto.setType((String) model.asMap().get("type"));
		dto.setMessage((String) model.asMap().get("message"));
		
		if (search == null || search.equals("")) {
			dto.setListResult(iStudentService.findAll(pageable));
		} else {
			List<StudentDTO> studentDTOs = iStudentService.searchStudentByKeyword(search);
			if(studentDTOs.size() > 0) {
				dto.setListResult(studentDTOs);
			}else {
				dto.setType("info");
				dto.setMessage("Không tìm thấy "+search+" Trong Cơ Sở Dữ Liệu !");
			}
		}

		mav.addObject("student", dto);
		return mav;
	}

	@RequestMapping(value = "/admin/student/list-details-student", method = RequestMethod.GET)
	public ModelAndView showListDetails(Model model, HttpServletRequest request,
			@RequestParam(name = "page", defaultValue = "1", required = true) int page,
			@RequestParam(name = "limit", defaultValue = "5", required = true) int limit) {
		ModelAndView mav = new ModelAndView("admin/student/list-details-student");
		StudentDTO dto = new StudentDTO();
		dto.setPage(page);
		dto.setLimit(limit);
		dto.setTotalItem(iStudentService.getTotalItem());
		dto.setTotalPage((int) Math.ceil((double) dto.getTotalItem() / dto.getLimit()));
		Pageable pageable = new PageRequest(page - 1, limit);
		String search = request.getParameter("search");
		
		dto.setType((String) model.asMap().get("type"));
		dto.setMessage((String) model.asMap().get("message"));
		
		if (search == null || search.equals("")) {
			dto.setListResult(iStudentService.findAll(pageable));
		} else {
			List<StudentDTO> studentDTOs = iStudentService.searchStudentDetailsByKeyword(search);
			if(studentDTOs.size() > 0) {
				dto.setListResult(studentDTOs);
			}else {
				dto.setType("info");
				dto.setMessage("Không tìm thấy "+search+" Trong Cơ Sở Dữ Liệu !");
			}
		}
		mav.addObject("student", dto);
		return mav;
	}

}
