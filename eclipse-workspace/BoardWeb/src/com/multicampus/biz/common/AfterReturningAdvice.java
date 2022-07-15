package com.multicampus.biz.common;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import com.multicampus.biz.user.UserVO;

@Aspect // Bean �������  @Service �ʿ����.
public class AfterReturningAdvice {
	
	@AfterReturning(pointcut="BoardPointcut.getPointcut()", returning="returnObj")
	public void afterLog(Object returnObj) { // Advice method
		System.out.println("<���� ó��> ����Ͻ� �޼ҵ� ���� �� : " + returnObj.toString());
		
		// ���� ����Ͻ� �޼ҵ尡 ������ �����Ͱ� UserVO Ÿ���� ��ü���... (�� getUser() �޼ҵ尡 ȣ��ƴٸ�)
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			// ���� UserVO ��ü�� role ������ ���� Admin�̶��...
			if(user.getRole().equals("Admin")) {
				System.out.println(user.getName() + "�����ڴ� ������ �������� �̵��մϴ�...");
			}
		}
	}
}
