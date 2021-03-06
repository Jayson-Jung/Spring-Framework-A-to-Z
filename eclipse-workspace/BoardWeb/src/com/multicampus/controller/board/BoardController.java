package com.multicampus.controller.board;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.multicampus.biz.board.BoardService;
import com.multicampus.biz.board.BoardVO;

@Controller
// Model 객체에 "board"라는 이름으로 데이터가 등록될 때, 세션에도 똑같이 등록해라.
@SessionAttributes("board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;	// BoardService 타입의 BoardServiceImpl 객체 할당
	
	@RequestMapping("/insertBoardView.do")
	public String insertBoard() throws Exception {
		return "insertBoard";	
	}
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) throws Exception {
		// 파일 업로드 처리
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			uploadFile.transferTo(new File("C:/DEV/" + uploadFile.getOriginalFilename()));
		}
		// 글 등록 처리
		boardService.insertBoard(vo);
		return "forward:getBoardList.do"; // View 이름 리턴
	}
	
	@RequestMapping("/updateBoard.do")
	// 세션에 "board"라는 이름으로 등록된 데이터가 있다면 우선 vo 변수에 할당해라.
	public String updateBoard(@ModelAttribute("board") BoardVO vo) throws Exception {
		boardService.updateBoard(vo);
		return "forward:getBoardList.do"; // View 이름 리턴
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) throws Exception {
		boardService.deleteBoard(vo);
		return "forward:getBoardList.do"; // View 이름 리턴
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) throws Exception {
		model.addAttribute("board", boardService.getBoard(vo));
		return "getBoard"; // 이동할 화면 정보 저장 (자동 Forwarding)		
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) throws Exception {
			
		//Null Check
		if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		
		// 검색 결과를 model에 저장하면 자동으로 request 내장객체에 등록된다.
		model.addAttribute("boardList", boardService.getBoardList(vo)); // key - value
		return "getBoardList"; // 이동할 화면 정보 저장	(자동 Forwarding)
	}
	
	@RequestMapping("/restAPI.do")
	//Java 객체를 JSON으로 변경
	public @ResponseBody List<BoardVO> restAPI(BoardVO vo) throws Exception {
			
		if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		return boardService.getBoardList(vo); // "/restAPI.do"를 요청한 프로그램쪽으로 검색결과를 리턴한다.
	}
}




 


