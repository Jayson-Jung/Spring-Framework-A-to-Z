package com.multicampus.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

// 2. DAO(Data Access Object) 클래스
//@Repository
public class BoardDAOSpring implements BoardService, BoardDAO {
	
	@Autowired
	private JdbcTemplate spring;

	// BOARD 테이블 관련 SQL 명령어들
	private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values((select nvl(max(seq), 0)+1 from board),?,?,?)";
	private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete board where seq=?";
	private final String BOARD_GET = "select * from board where seq=?";
	private final String BOARD_LIST = "select * from board order by seq desc";

	// CRUD 기능의 메소드 구현
	// 글 등록
	@Override
	public void insertBoard(BoardVO vo) {
		System.out.println("===> SPRING 기반으로 insertBoard() 기능 처리");
		spring.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}

	// 글 수정
	@Override
	public void updateBoard(BoardVO vo) {
		System.out.println("===> SPRING 기반으로 updateBoard() 기능 처리");
		spring.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}

	// 글 삭제
	@Override
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> SPRING 기반으로 deleteBoard() 기능 처리");
		spring.update(BOARD_DELETE, vo.getSeq());
	}
	
	// 글 상세 조회
	@Override
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> SPRING 기반으로 getBoard() 기능 처리");
		Object[] param = {vo.getSeq()};
		return spring.queryForObject(BOARD_GET, param, new BoardRowMapper());
	}

	// 글 목록 검색
	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> SPRING 기반으로 getBoardList() 기능 처리");
		return spring.query(BOARD_LIST, new BoardRowMapper());
	}
}
