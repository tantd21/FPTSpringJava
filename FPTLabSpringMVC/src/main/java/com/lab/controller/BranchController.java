package com.lab.controller;

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

import com.lab.dto.BranchDTO;
import com.lab.service.IBranchService;

@Controller
public class BranchController {

	@Autowired
	IBranchService iBranchService;

	@RequestMapping(value = "admin/branch/list-branch", method = RequestMethod.GET)
	public ModelAndView showList(Model model,
			@RequestParam(name = "page", defaultValue = "1", required = true) int page,
			@RequestParam(name = "limit", defaultValue = "5", required = true) int limit) {
		ModelAndView mav = new ModelAndView("admin/branch/list-branch");
		BranchDTO dto = new BranchDTO();
		dto.setPage(page);
		dto.setLimit(limit);
		dto.setTotalItem(iBranchService.getTotalItem());
		dto.setTotalPage((int) Math.ceil((double) dto.getTotalItem() / dto.getLimit()));
		Pageable pageable = new PageRequest(page - 1, limit);
		dto.setListResult(iBranchService.findAll(pageable));
		dto.setType((String) model.asMap().get("type"));
		dto.setMessage((String) model.asMap().get("message"));
		mav.addObject("branch", dto);

		for (int i = 0; i < dto.getListResult().size(); i++) {

			if (dto.getListResult().get(i).getWorkList().size() != 0) {
				System.out.println(dto.getListResult().get(i).getWorkList().get(0).getWorkCompanyName());
			}

		}

		return mav;
	}

	@RequestMapping(value = "admin/branch/add-branch", method = RequestMethod.GET)
	public ModelAndView addList(@ModelAttribute("BranchDTO") BranchDTO branchDTO) {
		ModelAndView mav = new ModelAndView("admin/branch/add-branch");
		return mav;
	}

	@RequestMapping(value = "admin/branch/save-branch", method = RequestMethod.POST, consumes = {
			MediaType.MULTIPART_FORM_DATA_VALUE })
	public String saveList(@ModelAttribute("BranchDTO") BranchDTO branchDTO, RedirectAttributes redirectAttributes,
			BindingResult bindingResult, HttpServletResponse response, HttpServletRequest request) {
		if (bindingResult.getErrorCount() == 0) {
			branchDTO = iBranchService.insert(branchDTO);
			redirectAttributes.addFlashAttribute("type", "success");
			redirectAttributes.addFlashAttribute("message", "Thêm Dữ Liệu Thành Công !");

		} else {
			redirectAttributes.addFlashAttribute("type", "error");
			redirectAttributes.addFlashAttribute("message", "Thêm Dữ Liệu Thất Bại !");
		}
		return "redirect:/admin/student/list-branch";
	}
}
