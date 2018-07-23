package com.khy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khy.ServiceException;
import com.khy.service.ITransferService;

@RestController
public class TestController {

	@Autowired
	private ITransferService genericTransferService;
	
	@RequestMapping("/test")
	public String test() throws ServiceException{
		genericTransferService.transfer("1001", "2001", 100);
		return "执行完毕";
	}
	
	
}
