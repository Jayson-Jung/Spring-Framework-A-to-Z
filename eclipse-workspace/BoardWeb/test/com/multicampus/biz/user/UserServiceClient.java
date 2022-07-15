package com.multicampus.biz.user;

import org.springframework.context.support.GenericXmlApplicationContext;


public class UserServiceClient {

	public static void main(String[] args) {
		GenericXmlApplicationContext container =
				new GenericXmlApplicationContext("business-layer.xml");
		
		// 반드시 클라이언트는 비즈니스 컴포넌트의 인터페이스(리모컨)를 통해 로직 처리를 요청해야 한다.
		UserService userService = (UserService) container.getBean("userService");
		
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test");
		UserVO user = userService.getUser(vo);
		if(user != null) {
			System.out.println(user.getName() + "님 로그인 환영합니다.");
		} else {
			System.out.println("로그인 실패");
		}

	}

}
