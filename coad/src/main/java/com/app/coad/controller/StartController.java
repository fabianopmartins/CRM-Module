package com.app.coad.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class StartController {

	@RequestMapping(value = "/inicio", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("/index");
		return mv;
	}
}