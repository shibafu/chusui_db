package com.example.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/management_console/newspaper_manage")
public class NewsPaperManagementController {

	@RequestMapping(value="")
	public String newspaperTop(){
		return "management_console/newspaper_manage/newspaper_register";
	}
}