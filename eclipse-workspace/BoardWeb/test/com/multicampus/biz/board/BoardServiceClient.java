package com.multicampus.biz.board;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		GenericXmlApplicationContext container = 
			new GenericXmlApplicationContext("business-layer.xml");
		
		// 반드시 클라이언트는 비즈니스 컴포넌트의 인터페이스(리모컨)를 통해 로직 처리를 요청해야 한다.
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		BoardVO vo = new BoardVO();
		vo.setSeq(999);
		vo.setTitle("테스트 제목");
		vo.setWriter("테스터");
		vo.setContent("테스트 내용......");
		boardService.insertBoard(vo);
		List<BoardVO> boardList = boardService.getBoardList(vo);
		
		for (BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}

}
