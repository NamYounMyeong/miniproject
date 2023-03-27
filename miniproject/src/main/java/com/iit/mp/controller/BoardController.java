package com.iit.mp.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iit.mp.common.Util;
import com.iit.mp.dao.BoardDao;
import com.iit.mp.dto.AttachmentDto;
import com.iit.mp.dto.BoardDto;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardDao boardDao;
	
	//게시판 글쓰기 페이지
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write(){
		return "board/write";
	}
	
	//임시 게시판 리스트 페이지
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String boardList(){
		
		return "board/list";
	}
	
		
	//게시글 상세페이지
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public String boardDetail2(@RequestParam int pstgNo, Model model, HttpSession session){
	    //세션에 조회한 게시글 번호 리스트가 없으면 생성
	    if(session.getAttribute("viewedPstgNos") == null) {
	        session.setAttribute("viewedPstgNos", new ArrayList<Integer>());
	    }
	    
	    //게시글 조회시 세션에 저장된 게시글 번호 리스트에서 조회한 게시글 번호가 있는지 확인
	    List<Integer> viewedPstgNos = (List<Integer>) session.getAttribute("viewedPstgNos");
	    if(!viewedPstgNos.contains(pstgNo)) {
	        //조회수 증가 및 세션에 조회한 게시글 번호 추가
	        boardDao.increaseViewCount(pstgNo);
	        viewedPstgNos.add(pstgNo);
	        session.setAttribute("viewedPstgNos", viewedPstgNos);
	    }
	    
	    model.addAttribute("boardDetail", boardDao.boardDetail(pstgNo));
	    return "board/detail";
	}
	
	//게시판 글쓰기
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String writeBoard(BoardDto board, MultipartHttpServletRequest req) {
	    MultipartFile attach = req.getFile("files");
	    if (attach != null && !attach.isEmpty()) {
	        // 1. 파일 업로드 처리
	        try {
	            /*ServletContext context = req.getServletContext();*/
	            /*String uploadPath = context.getRealPath("C:\\attach");*/
	            String uploadPath = "C:\\attach"; //컴퓨터에 저장되는 파일 업로드 경로
	            String originalFilename = attach.getOriginalFilename(); // 고유 파일명
	            String savedFilename = Util.makeUniqueFileName(originalFilename); // 변환되어 저장되는 파일명
	            File uploadFile = new File(uploadPath, savedFilename);
	            attach.transferTo(uploadFile);

	            // 2. 첨부파일 정보 저장
	            ArrayList<AttachmentDto> attachments = new ArrayList<>();
	            AttachmentDto attachment = new AttachmentDto();
	            attachment.setAtchFileNm(savedFilename);
	            attachment.setAtchExtnNm(originalFilename);
	            attachments.add(attachment);
	            board.setAttachments(attachments);

	        } catch (IOException e) {
	            e.printStackTrace(); // 개발 용도로 사용
	        }
	    }

	    boardDao.writeBoard(board, board.getAttachments().get(0));
	    return "redirect:/board/board";
	}



		//게시판 리스트 페이지
		@RequestMapping(value = "/board", method = RequestMethod.GET)
		public String board(Model model) {
			
				List<BoardDto> boardDtoList = boardDao.selectBoard();
				// json 형식으로 변환
				ObjectMapper objectMapper = new ObjectMapper(); //ObjectMapper 클래스를 사용하여 객체를 JSON 문자열로 변환
				String json = "";
				try { //변환 중 오류가 발생하면 예외 처리
					json = objectMapper.writeValueAsString(boardDtoList);
				} catch (JsonProcessingException e) {
					e.printStackTrace(); 
					
				}
				model.addAttribute("boards", json);//Model 객체에 JSON,"boards" 문자열을 추가

				return "board/board";
			}
		
		//게시글 수정페이지
		@RequestMapping(value = "edit", method = RequestMethod.GET)
		public String boardEdit(@RequestParam int pstgNo, Model model){
			model.addAttribute("boardDetail", boardDao.boardDetail(pstgNo));		 
			return "board/edit";
		}
		
		//게시글 수정하기
		@RequestMapping(value = "edit", method = RequestMethod.POST)
		public String boardUpdate(@RequestParam int pstgNo, BoardDto boardDto) {
		try {
				boardDao.boardUpdate(boardDto);
		} catch (NullPointerException e) {
				e.printStackTrace();
		}
		return "redirect:/board/detail?pstgNo="+pstgNo;
		}
		
		//게시글 삭제
		@RequestMapping(value = "boardDelete", method = RequestMethod.GET)
		public String deleteBoard(int pstgNo){
			boardDao.deleteBoard(pstgNo);
			return "redirect:/board/board";
		}
		
		// 게시글 답변
		@RequestMapping(value = "replyWrite", method = RequestMethod.GET)
		public String boardReply(@RequestParam int pstgNo, Model model) {
			model.addAttribute("pstgNo", pstgNo);
			    return "board/replyWrite";
		}
		// 게시글 답변작성
		@RequestMapping(value = "replyToBoard", method = RequestMethod.POST)
		public String replyToBoard(BoardDto boardDto, Model model) {
			boardDao.insertReplyWrite(boardDto);
		    System.out.println(boardDto);
		    return "redirect:/board/board";
		}
	
}
	

