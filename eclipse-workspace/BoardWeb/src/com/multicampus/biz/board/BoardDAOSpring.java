package com.multicampus.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

// 2. DAO(Data Access Object) Ŭ����
//@Repository
public class BoardDAOSpring implements BoardService, BoardDAO {
	
	@Autowired
	private JdbcTemplate spring;

	// BOARD ���̺� ���� SQL ���ɾ��
	private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values((select nvl(max(seq), 0)+1 from board),?,?,?)";
	private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete board where seq=?";
	private final String BOARD_GET = "select * from board where seq=?";
	private final String BOARD_LIST = "select * from board order by seq desc";

	// CRUD ����� �޼ҵ� ����
	// �� ���
	@Override
	public void insertBoard(BoardVO vo) {
		System.out.println("===> SPRING ������� insertBoard() ��� ó��");
		spring.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}

	// �� ����
	@Override
	public void updateBoard(BoardVO vo) {
		System.out.println("===> SPRING ������� updateBoard() ��� ó��");
		spring.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}

	// �� ����
	@Override
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> SPRING ������� deleteBoard() ��� ó��");
		spring.update(BOARD_DELETE, vo.getSeq());
	}
	
	// �� �� ��ȸ
	@Override
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> SPRING ������� getBoard() ��� ó��");
		Object[] param = {vo.getSeq()};
		return spring.queryForObject(BOARD_GET, param, new BoardRowMapper());
	}

	// �� ��� �˻�
	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> SPRING ������� getBoardList() ��� ó��");
		return spring.query(BOARD_LIST, new BoardRowMapper());
	}
}