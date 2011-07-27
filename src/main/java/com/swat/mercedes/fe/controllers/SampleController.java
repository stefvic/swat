package com.swat.mercedes.fe.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleController {
    static final Logger logger = LoggerFactory.getLogger(SampleController.class);
    @RequestMapping("/account")
    public ModelAndView account(){
	logger.debug("Some testing here!");
	ModelAndView account = new ModelAndView("account");
	account.addObject("account", "Sample Message");
	return account;
    }
}
