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
import com.spring.mvcboard.commons.paging.SearchCriteria;

@Controller
@RequestMapping("/article")
public class ArticleController {
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
	private final ArticleService articleService;
	
	@Inject
	public ArticleController(ArticleService articleService) {
		this.articleService = articleService;
		
	}
	
	/***************
	 *게시글 등록
	 ***************/
	//등록 페이지 이동
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String writeGET(){
		
		logger.info("write GET...");
		return "/article/write";
	}
	
	// 등록 처리
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String writePOST(ArticleVO articleVO, RedirectAttributes redirectAttributes) throws Exception{
		
		logger.info("write POST...");
		logger.info(articleVO.toString());
		articleService.create(articleVO);
	
		redirectAttributes.addFlashAttribute("msg", "regSucces");
		
		return "redirect:/article/list";
	}
	
	/***************
	 *게시글 목록
	 ***************/
	//목록 페이지 이동
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) throws Exception{				//해당 메서드에서 뷰(JSP)에 필요한 데이터를 전달하는 용도로 사용되는데 메서드 내에 뷰로 전달할 데이터가 있다면 Model을 파라미터로 선언하는 것이 편리하다.
		
		logger.info("list ...");
		model.addAttribute("articles", articleService.listAll());
		
		
		return "/article/list";
	}
	
	//조회 페이지 이동
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String read(@RequestParam("articleNo") int articleNo, Model model) throws Exception{
		
		logger.info("read ...");
		model.addAttribute("article", articleService.read(articleNo));
		
		return "/article/read";
	}
	
	//수정 페이지 이동
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modifyGET(@RequestParam("articleNo") int articleNo, Model model) throws Exception{
			
		logger.info("modifyGet ...");
		model.addAttribute("article", articleService.read(articleNo));
			
		return "/article/modify";
	}
	
	//수정 처리
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(ArticleVO articleVO, RedirectAttributes redirectAttributes) throws Exception{
				
		logger.info("modifyPost ...");
		articleService.update(articleVO);
		redirectAttributes.addFlashAttribute("msg", "modSucces");
		
		return "redirect:/article/list";
	}
	
	//삭제 처리
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("articleNo") int articleNo, RedirectAttributes redirectAttributes) throws Exception{
					
		logger.info("remove ...");
		articleService.delete(articleNo);
		redirectAttributes.addFlashAttribute("msg", "delSucces");
			
		return "redirect:/article/list";
	}
	
	
	
	 @RequestMapping(value = "/listCriteria", method = RequestMethod.GET)
	 public String listCriteria(Model model, Criteria criteria) throws Exception {
	        
		 logger.info("listCriteria ...");
	     model.addAttribute("articles", articleService.listCriteria(criteria));
	        
	     return "/article/list_criteria";
	        
	 }
	
	//페이징 처리 
	 @RequestMapping(value = "/listPaging", method = RequestMethod.GET)
	 public String listPaging(Model model, Criteria criteria) throws Exception {
	        
		 logger.info("listPaging ...");

	     PageMaker pageMaker = new PageMaker();
	     pageMaker.setCriteria(criteria);
	     pageMaker.setTotalCount(articleService.countArticles(criteria));

	     model.addAttribute("articles", articleService.listCriteria(criteria));
	     model.addAttribute("pageMaker", pageMaker);

	     return "/article/list_paging";
	}

}
