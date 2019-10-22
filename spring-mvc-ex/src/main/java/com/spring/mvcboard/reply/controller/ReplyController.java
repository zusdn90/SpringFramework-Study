package com.spring.mvcboard.reply.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mvcboard.commons.paging.Criteria;
import com.spring.mvcboard.commons.paging.PageMaker;
import com.spring.mvcboard.reply.domain.ReplyVO;
import com.spring.mvcboard.reply.service.ReplyService;

@RestController
@RequestMapping("/replies")
public class ReplyController {
	
	private final ReplyService replyService;
	
	@Inject
	public ReplyController(ReplyService replyService) {
		this.replyService = replyService;
	}
	
	//댓글 등록 처리 메서드
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody ReplyVO replyVO){
		/*
		 * @RequestBody : 전송된 JSON데이터를 객체로 변환해주는 애너테이션으로 @ModelAttribute와 유사한 역할을 하지만 JSON에서 사용한다는 점이 차이점이다.
		 */
		
		ResponseEntity<String> entity = null;
		
		try{
			replyService.create(replyVO);
			entity = new ResponseEntity<>("regSuccess", HttpStatus.OK);
		} catch(Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	//댓글 목록 메서드
	@RequestMapping(value = "/all/{articleNo}", method = RequestMethod.GET)
	public ResponseEntity<List<ReplyVO>> list(@PathVariable("articleNo") Integer articleNo){	//@PathVariable : URI의 경로에서 원하는 데이터를 추출하는 용도로 사용한다.
		ResponseEntity<List<ReplyVO>> entity = null;
		
		try{
			entity = new ResponseEntity<>(replyService.list(articleNo), HttpStatus.OK);
		} catch(Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	//댓글 수정 메서드
	 @RequestMapping(value = "/{replyNo}", method = {RequestMethod.PUT, RequestMethod.PATCH})
	public ResponseEntity<String> update(@PathVariable("replyNo") Integer replyNo, @RequestBody ReplyVO replyVO){
		ResponseEntity<String> entity = null;
		
		try{
			replyVO.setReplyNo(replyNo);
			replyService.update(replyVO);
			entity = new ResponseEntity<>("modSuccess", HttpStatus.OK);
		}catch (Exception e){
			e.printStackTrace();
            entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	 //댓글 삭제 메서드
	 @RequestMapping(value= "/{replyNo}", method = RequestMethod.DELETE)
	 public ResponseEntity<String> delete(@PathVariable("replyNo") Integer replyNo) {
		 ResponseEntity<String> entity = null;
		 
		 try{
			 replyService.delete(replyNo);
			 entity = new ResponseEntity<>("delSuccess", HttpStatus.OK);
		 }catch (Exception e) {
			 e.printStackTrace();
			 entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		 }
		 return entity;
	 }
	 
	 //댓글 페이징처리
	 public ResponseEntity<Map<String, Object>> listPaging(@PathVariable("articleNo") Integer articleNo,
												   @PathVariable("page") Integer page) {
		 
		 ResponseEntity<Map<String, Object>> entity = null;
		
		 try{
			 Criteria criteria = new Criteria();
			 criteria.setPage(page);
			 
			 List<ReplyVO> replies = replyService.getRepliesPaging(articleNo, criteria);
			 int repliesCount = replyService.countReplies(articleNo);
			 
			 PageMaker pageMaker = new PageMaker();
			 pageMaker.setCriteria(criteria);
			 pageMaker.setTotalCount(repliesCount);
			 
			 Map<String, Object> map = new HashMap<>();
			 map.put("replies", replies);
			 map.put("pageMaker", pageMaker);
			 
			 entity = new ResponseEntity<>(map, HttpStatus.OK);
			 
		 }catch(Exception e){
			 
			 e.printStackTrace();
			 entity = new ResponseEntity<>(HttpStatus.OK);
		 }
		 
		return entity;	
	 }
}
