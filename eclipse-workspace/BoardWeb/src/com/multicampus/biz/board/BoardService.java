package com.multicampus.biz.board;

import java.util.List;

import org.springframework.stereotype.Service;

// 3. Service �������̽�
public interface BoardService {

	// CRUD ����� �޼ҵ� ����
	// �� ���
	void insertBoard(BoardVO vo);

	// �� ����
	void updateBoard(BoardVO vo);

	// �� ����
	void deleteBoard(BoardVO vo);

	// �� �� ��ȸ
	BoardVO getBoard(BoardVO vo);

	// �� ��� �˻�
	List<BoardVO> getBoardList(BoardVO vo);

}