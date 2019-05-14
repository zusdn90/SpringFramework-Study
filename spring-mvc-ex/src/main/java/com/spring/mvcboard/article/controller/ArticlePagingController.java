package com.spring.mvcboard.article.controller;


import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.mvcboard.article.domain.ArticleVO;
import com.spring.mvcboard.article.service.ArticleService;
import com.spring.mvcboard.commons.paging.Criteria;
import com.spring.mvcboard.commons.paging.PageMaker;

@Controller
@RequestMapping("/paging")
public class ArticlePagingController {

	private static final Logger logger = LoggerFactory.getLogger(ArticlePagingController.class);
	
	private final ArticleService articleService;
	
	@Inject
	public ArticlePagingController(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	/***************
	 *게시글 등록
	 ***************/
	//등록 페이지 이동
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String writeGET(){
		
		logger.info("paging write GET...");
		return "/article/paging/write";
	}
	
	// 등록 처리
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String writePOST(ArticleVO articleVO, RedirectAttributes redirectAttributes) throws Exception{
		
		logger.info("paging write POST...");
		logger.info(articleVO.toString());
		articleService.create(articleVO);
	
		redirectAttributes.addFlashAttribute("msg", "regSucces");
		
		return "redirect:/article/paging/list";
	}
	
	/***************
	 *게시글 목록
	 ***************/
	
	//페이징 목록 
	@RequestMapping(value = "/listPaging", method = RequestMethod.GET)
	 public String listPaging(Model model, Criteria criteria) throws Exception {		//해당 메서드에서 뷰(JSP)에 필요한 데이터를 전달하는 용도로 사용되는데 메서드 내에 뷰로 전달할 데이터가 있다면 Model을 파라미터로 선언하는 것이 편리하다.
		        
		logger.info("Paging list()...");

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(articleService.countArticles(criteria));

		model.addAttribute("articles", articleService.listCriteria(criteria));
		model.addAttribute("pageMaker", pageMaker);

		return "/article/paging/list";
	}
	
	//조회 페이지 이동
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String read(@RequestParam("articleNo") int articleNo,
					   @ModelAttribute("criteria") Criteria criteria,				  
					   Model model) throws Exception{
		
		logger.info("paging read() called ...");
		model.addAttribute("article", articleService.read(articleNo));
		
		return "/article/paging/read";
	}
	
	//수정 페이지 이동
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modifyGET(@RequestParam("articleNo") int articleNo,
			 				@ModelAttribute("criteria") Criteria criteria,
			 				Model model) throws Exception{
			
		
		logger.info("paging modifyGet() called ...");
		model.addAttribute("article", articleService.read(articleNo));
			
		return "/article/paging/modify";
	}
	
	//수정 처리
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(ArticleVO articleVO, 
							 Criteria criteria,
			                 RedirectAttributes redirectAttributes) throws Exception{
				
		logger.info("paging modifyPost() called ...");
		articleService.update(articleVO);
		redirectAttributes.addFlashAttribute("page", criteria.getPage());
		redirectAttributes.addFlashAttribute("PerPageNum", criteria.getPerPageNum());
		redirectAttributes.addFlashAttribute("msg", "modSucces");
		
		return "redirect:/article/paging/list";
	}
	
	//삭제 처리
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("articleNo") int articleNo, 
											    Criteria criteria,		
						RedirectAttributes redirectAttributes) throws Exception{
					
		
		logger.info("paging remove() called ...");
		articleService.delete(articleNo);
		redirectAttributes.addFlashAttribute("page", criteria.getPage());
		redirectAttributes.addFlashAttribute("PerPageNum", criteria.getPerPageNum());
		redirectAttributes.addFlashAttribute("msg", "delSuccess");
			
		return "redirect:/article/paging/list";
	}	
	
	
}
