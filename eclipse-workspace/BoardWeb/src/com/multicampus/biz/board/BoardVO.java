package com.multicampus.biz.board;

import java.sql.Date;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

// 1. VO(Value Object) 클래스
//@Getter
//@Setter
//@EqualsAndHashCode
//@ToString
@Data
public class BoardVO {
	
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;
	
	// 검색 관련 변수
	private String searchCondition;
	private String searchKeyword;
	
	// 파일 업로드 관련 변수
	private MultipartFile uploadFile;

	@JsonIgnore
	public String getSearchCondition() {
		return searchCondition;
	}

	@JsonIgnore
	public String getSearchKeyword() {
		return searchKeyword;
	}

	@JsonIgnore
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	
	
}
