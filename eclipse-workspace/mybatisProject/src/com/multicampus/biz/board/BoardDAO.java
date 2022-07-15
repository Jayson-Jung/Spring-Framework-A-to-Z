package com.multicampus.biz.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.multicampus.biz.util.SqlSessionFactoryBean;

public class BoardDAO {
	private SqlSession mybatis;
	
	public BoardDAO() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}
	
	public void insertBoard(BoardVO vo) {
		
	}

	public void updateBoard(BoardVO vo) {
		
	}

	public void deleteBoard(BoardVO vo) {
		
	}

	public BoardVO getBoard(BoardVO vo) {
		return null;
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		return null;
	}
}
