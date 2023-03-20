package com.iit.mp.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iit.mp.dao.BoardDao;
import com.iit.mp.dto.BoardDto;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardDao boardDao;
	
	//AUIGRID
	@RequestMapping(value = "/auiPDF", method = RequestMethod.POST)
	public String PDF(Locale locale, Model model) {
		
		return "export/export"; //export.jsp의 위치
	}
	
	@RequestMapping(value = "/auiEXCEL", method = RequestMethod.POST)
	public String EXCEL(Locale locale, Model model) {
		
		return "export/export"; //export.jsp의 위치
	}
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
	public String boardDetail2(@RequestParam(required = false) Integer pstgNo, Model model){
		//조회수 증가
	    if (pstgNo != null) {
	        boardDao.increaseViewCount(pstgNo);
	    }
		model.addAttribute("boardDetail", boardDao.boardDetail(pstgNo));
		return "board/detail";
	}
	
	//게시판 글쓰기(첨부파일 수정중)
		@RequestMapping(value = "insert", method = RequestMethod.POST)
	/*	public String writeBoard(BoardDto boardDto, MultipartHttpServletRequest req){*/
			public String writeBoard(BoardDto boardDto){
			// 1. 요청 데이터 읽기 (전달인자로 대체)
			
	/*		MultipartFile attach = req.getFile("attach");*/

					/*if (attach != null) { //내용이 있는 경우
						// 2. 데이터 처리
						String path = context.getRealPath("/board-attachments");
						String fileName = attach.getOriginalFilename(); //파일 이름 가져오기
						if (fileName != null && fileName.length() > 0) {
							String uniqueFileName = Util.makeUniqueFileName(fileName);
							
							try {				
								attach.transferTo(new File(path, uniqueFileName));//파일 저장
								
								// 첨부파일 정보를 객체에 저장
								ArrayList<BoardAttachDto> attachments = new ArrayList<>(); // 첨부파일 정보를 저장하는 DTO 객체
								BoardAttachDto attachment = new BoardAttachDto();
								attachment.setAtchFileNm(fileName);
								attachment.setAtchExtnNm(uniqueFileName);
								attachments.add(attachment);
								boardDto.setAttachments(attachments);
								
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}		
			*/
			System.out.println(boardDto);
		    // 게시글 등록
		    boardDao.writeBoard(boardDto);
		    return "redirect:/board/board";
		}
		
		//게시판 리스트 페이지
		@RequestMapping(value = "/board", method = RequestMethod.GET)
		public String board(Model model) {
				List<BoardDto> boardDtoList = boardDao.selectBoard();
				// json 형식으로 변환
				ObjectMapper objectMapper = new ObjectMapper();
				String json = "";
				try {
					json = objectMapper.writeValueAsString(boardDtoList);
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
				model.addAttribute("boards", json);

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
	

