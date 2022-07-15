package com.multicampus.biz.user;

import org.springframework.context.support.GenericXmlApplicationContext;


public class UserServiceClient {

	public static void main(String[] args) {
		GenericXmlApplicationContext container =
				new GenericXmlApplicationContext("business-layer.xml");
		
		// �ݵ�� Ŭ���̾�Ʈ�� ����Ͻ� ������Ʈ�� �������̽�(������)�� ���� ���� ó���� ��û�ؾ� �Ѵ�.
		UserService userService = (UserService) container.getBean("userService");
		
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test");
		UserVO user = userService.getUser(vo);
		if(user != null) {
			System.out.println(user.getName() + "�� �α��� ȯ���մϴ�.");
		} else {
			System.out.println("�α��� ����");
		}

	}

}
