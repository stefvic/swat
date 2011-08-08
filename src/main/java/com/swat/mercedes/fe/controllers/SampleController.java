package com.swat.mercedes.fe.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.swat.mercedes.fe.entities.User;

@Controller
@SessionAttributes
public class SampleController {
    static final Logger logger = LoggerFactory.getLogger(SampleController.class);
    
    @RequestMapping(method=RequestMethod.GET, value="/accountSingUpPage")
    public ModelAndView account(){
	logger.debug("===== Inside account method =====");
	ModelAndView account = new ModelAndView("createAccount");
	account.addObject("User", new User());
	return account;
    }
    
    
    @RequestMapping(method=RequestMethod.POST, value="/creatingUser")
    public ModelAndView createdUser(@Valid @ModelAttribute("User") User user, BindingResult result){
	logger.debug("===== Inside creatingUser =====");
	if(result.hasErrors()){
	    logger.debug("===== Create UserForm contains errors =====");
	    ModelAndView account = new ModelAndView("createAccount");
	    return account;
	}
	ModelAndView createdUserMV = new ModelAndView("accountCreated");
	return createdUserMV;
    }
}
