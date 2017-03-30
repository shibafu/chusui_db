package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.NewsArticleMaster;
import com.example.repository.NewsArticleMasterRepository;

@Controller
@RequestMapping(value="/infonews")
public class NewsPaperController {

	@Autowired
	NewsArticleMasterRepository namRepo;


	@RequestMapping(value="",method= RequestMethod.GET)
	public String newsDetails(Model model,
			@RequestParam("id") String id ){

		NewsArticleMaster nam = namRepo.findOne(Integer.valueOf(id));
		model.addAttribute("NewsArticle", nam);

		return "newspaper_reffernce/newspaper_details";
	}

}
