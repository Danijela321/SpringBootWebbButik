package com.webbutik.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller

public class FirstController {
	@RequestMapping("/home.html")
	public ModelAndView firstPage() {
		Date dateAndTime = new Date();
		return new ModelAndView("welcome", "dateAndTime" , dateAndTime);

	}
}




