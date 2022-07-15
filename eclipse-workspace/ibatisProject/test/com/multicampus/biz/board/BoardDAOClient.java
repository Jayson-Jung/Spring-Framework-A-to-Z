package com.multicampus.biz.board;

import java.util.List;

public class BoardDAOClient {

	public static void main(String[] args) throws Exception {
		BoardVO vo = new BoardVO();
		vo.setTitle("iBatis �׽�Ʈ");
		vo.setWriter("�׽���");
		vo.setContent("iBatis �׽�Ʈ���Դϴ�...");
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(vo);
		
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		for(BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}

}
