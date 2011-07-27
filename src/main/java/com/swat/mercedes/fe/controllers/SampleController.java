package com.swat.mercedes.fe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleController {
    @RequestMapping("/account")
    public ModelAndView account(){
	ModelAndView account = new ModelAndView("account");
	account.addObject("account", "Sample Message");
	return account;
    }
}
