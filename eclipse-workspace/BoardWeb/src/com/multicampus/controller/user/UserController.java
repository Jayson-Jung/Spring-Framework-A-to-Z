package com.multicampus.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.multicampus.biz.user.UserDAO;
import com.multicampus.biz.user.UserVO;

@Controller
public class UserController {

	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String login(@ModelAttribute("user") UserVO vo) throws Exception {
		System.out.println("---> 로그인 화면으로 이동");
		vo.setId("aaa");
		vo.setPassword("aaa");
		// Command 객체는 자동으로 request 내장 객체에 등록된다.
		// 따라서 forwarding된 JSP 파일에서 Command 객체에 등록한 데이터를 사용할 수 있다.
		return "login";	
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) throws Exception {
		System.out.println("---> 로그인 인증 처리");
		if(vo.getId() == null || vo.getId().equals("")) {
			throw new IllegalArgumentException("아이디는 필수 항목.");
		}
		UserVO user = userDAO.getUser(vo);
		
		if(user != null) {
			session.setAttribute("user", user);			
			return "forward:getBoardList.do";
		} else return "login";		
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();		
		return "forward:/";		
	}

}
