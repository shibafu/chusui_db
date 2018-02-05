package com.tsugaruweb.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tsugaruweb.entity.NewsArticleMaster;
import com.tsugaruweb.repository.NewsArticleMasterRepository;

@Controller
@RequestMapping(value="/infonews")
public class NewsPaperController {

	@Autowired
	NewsArticleMasterRepository namRepo;


	@RequestMapping(value="/details",method= RequestMethod.GET)
	public String newsDetails(Model model,
			@RequestParam("id") String id ){

		Optional<NewsArticleMaster> nam = namRepo.findById(Integer.valueOf(id));
		NewsArticleMaster result = nam.orElseGet(()->{ return new NewsArticleMaster();});
		model.addAttribute("NewsArticle", result);

		return "newspaper_refference/newspaper_details";
	}

}
