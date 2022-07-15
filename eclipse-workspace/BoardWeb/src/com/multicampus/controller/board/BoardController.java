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
// Model ��ü�� "board"��� �̸����� �����Ͱ� ��ϵ� ��, ���ǿ��� �Ȱ��� ����ض�.
@SessionAttributes("board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;	// BoardService Ÿ���� BoardServiceImpl ��ü �Ҵ�
	
	@RequestMapping("/insertBoardView.do")
	public String insertBoard() throws Exception {
		return "insertBoard";	
	}
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) throws Exception {
		// ���� ���ε� ó��
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			uploadFile.transferTo(new File("C:/DEV/" + uploadFile.getOriginalFilename()));
		}
		// �� ��� ó��
		boardService.insertBoard(vo);
		return "forward:getBoardList.do"; // View �̸� ����
	}
	
	@RequestMapping("/updateBoard.do")
	// ���ǿ� "board"��� �̸����� ��ϵ� �����Ͱ� �ִٸ� �켱 vo ������ �Ҵ��ض�.
	public String updateBoard(@ModelAttribute("board") BoardVO vo) throws Exception {
		boardService.updateBoard(vo);
		return "forward:getBoardList.do"; // View �̸� ����
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) throws Exception {
		boardService.deleteBoard(vo);
		return "forward:getBoardList.do"; // View �̸� ����
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) throws Exception {
		model.addAttribute("board", boardService.getBoard(vo));
		return "getBoard"; // �̵��� ȭ�� ���� ���� (�ڵ� Forwarding)		
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) throws Exception {
			
		//Null Check
		if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		
		// �˻� ����� model�� �����ϸ� �ڵ����� request ���尴ü�� ��ϵȴ�.
		model.addAttribute("boardList", boardService.getBoardList(vo)); // key - value
		return "getBoardList"; // �̵��� ȭ�� ���� ����	(�ڵ� Forwarding)
	}
	
	@RequestMapping("/restAPI.do")
	//Java ��ü�� JSON���� ����
	public @ResponseBody List<BoardVO> restAPI(BoardVO vo) throws Exception {
			
		if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		return boardService.getBoardList(vo); // "/restAPI.do"�� ��û�� ���α׷������� �˻������ �����Ѵ�.
	}
}




 

