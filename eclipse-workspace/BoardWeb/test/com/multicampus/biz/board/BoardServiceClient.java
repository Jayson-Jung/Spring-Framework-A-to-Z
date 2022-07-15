package com.multicampus.biz.board;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		GenericXmlApplicationContext container = 
			new GenericXmlApplicationContext("business-layer.xml");
		
		// �ݵ�� Ŭ���̾�Ʈ�� ����Ͻ� ������Ʈ�� �������̽�(������)�� ���� ���� ó���� ��û�ؾ� �Ѵ�.
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		BoardVO vo = new BoardVO();
		vo.setSeq(999);
		vo.setTitle("�׽�Ʈ ����");
		vo.setWriter("�׽���");
		vo.setContent("�׽�Ʈ ����......");
		boardService.insertBoard(vo);
		List<BoardVO> boardList = boardService.getBoardList(vo);
		
		for (BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}

}