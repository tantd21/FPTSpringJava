package com.lab.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lab.dto.SchoolDTO;
import com.lab.service.ISchoolService;

@Controller
public class SchoolController {
		@Autowired
		ISchoolService iSchoolService;
		
	   @RequestMapping(value = "admin/school/add-school", method = RequestMethod.GET)
	   public ModelAndView addList(@ModelAttribute("SchoolDTO") SchoolDTO schoolDTO ) {
	      ModelAndView mav = new ModelAndView("admin/school/add-school");
	      return mav;
	   }
	   
	   @RequestMapping(value = "admin/school/save-school", method = RequestMethod.POST,consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	   public String saveList(@ModelAttribute("SchoolDTO") SchoolDTO schoolDTO,
			   BindingResult bindingResult,
			   HttpServletResponse response,
			   HttpServletRequest request,
			   RedirectAttributes redirectAttributes) {
		   if(bindingResult.getErrorCount() == 0) {
			   schoolDTO = iSchoolService.insert(schoolDTO);
				   redirectAttributes.addFlashAttribute("type", "success");
				   redirectAttributes.addFlashAttribute("message", "Thêm Dữ Liệu Thành Công !");
				   
		   }else {
			   redirectAttributes.addFlashAttribute("type", "error");
			   redirectAttributes.addFlashAttribute("message", "Thêm Dữ Liệu Thất Bại !");
		   }
		   return "redirect:/admin/school/list-school";
	   }
	   
		 @RequestMapping(value = "admin/school/list-school", method = RequestMethod.GET)
		   public ModelAndView showList(
				   Model model,
				   @RequestParam(name="page",defaultValue = "1" ,required = true) int page , 
				   @RequestParam(name="limit",defaultValue = "5" ,required = true) int limit) {
		      ModelAndView mav = new ModelAndView("admin/school/list-school");
		      SchoolDTO dto = new SchoolDTO();
		      dto.setPage(page);
		      dto.setLimit(limit);
		      dto.setTotalItem(iSchoolService.getTotalItem());
		      dto.setTotalPage((int) Math.ceil((double) dto.getTotalItem() / dto.getLimit()));
		      Pageable pageable = new PageRequest(page - 1, limit);
		      dto.setListResult(iSchoolService.findAll(pageable));
		      dto.setType((String)model.asMap().get("type"));
		      dto.setMessage((String)model.asMap().get("message"));
		  	  mav.addObject("school", dto);
		      return mav;
		}
}
