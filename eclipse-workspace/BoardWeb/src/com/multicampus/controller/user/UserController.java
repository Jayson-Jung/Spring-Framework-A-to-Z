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
		System.out.println("---> �α��� ȭ������ �̵�");
		vo.setId("aaa");
		vo.setPassword("aaa");
		// Command ��ü�� �ڵ����� request ���� ��ü�� ��ϵȴ�.
		// ���� forwarding�� JSP ���Ͽ��� Command ��ü�� ����� �����͸� ����� �� �ִ�.
		return "login";	
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) throws Exception {
		System.out.println("---> �α��� ���� ó��");
		if(vo.getId() == null || vo.getId().equals("")) {
			throw new IllegalArgumentException("���̵�� �ʼ� �׸�.");
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