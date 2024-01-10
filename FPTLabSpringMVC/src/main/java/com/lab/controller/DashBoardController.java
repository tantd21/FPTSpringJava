package com.lab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class DashBoardController {
	 @RequestMapping(value = "/", method = RequestMethod.GET)
	   public RedirectView firstPage() {
		 	RedirectView redirectView = new RedirectView();
	        redirectView.setUrl("admin/dashboard");
	        return redirectView;
	  }
	
	 @RequestMapping(value = "admin/dashboard", method = RequestMethod.GET)
	   public ModelAndView homePage() {
	      ModelAndView mav = new ModelAndView("admin/dashboard/dashboard");
	      return mav;
	  }
}
