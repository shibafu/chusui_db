//package com.tsugaruweb.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.tsugaruweb.entity.NewsArticleMaster;
//import com.tsugaruweb.repository.NewsArticleMasterRepository;
//
//@Controller
//@RequestMapping(value="/infonews")
//public class NewsPaperController {
//
//	@Autowired
//	NewsArticleMasterRepository namRepo;
//
//
//	@RequestMapping(value="/details",method= RequestMethod.GET)
//	public String newsDetails(Model model,
//			@RequestParam("id") String id ){
//
//		NewsArticleMaster nam = namRepo.findOne(Integer.valueOf(id));
//		model.addAttribute("NewsArticle", nam);
//
//		return "newspaper_refference/newspaper_details";
//	}
//
//}
