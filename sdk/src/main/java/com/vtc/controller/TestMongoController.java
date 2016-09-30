package com.vtc.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vtc.mongorepository.AccountRepository;


@Controller
public class TestMongoController {
	private static final Logger log = Logger.getLogger(TestMongoController.class);
	
	@Autowired
	AccountRepository accountRepository;

	@RequestMapping(value = "/users", method = RequestMethod.GET)  
    public String getCustomerList(ModelMap model) {  
        model.addAttribute("customerList", accountRepository.findAll());  
        return "output";  
    }  
}
