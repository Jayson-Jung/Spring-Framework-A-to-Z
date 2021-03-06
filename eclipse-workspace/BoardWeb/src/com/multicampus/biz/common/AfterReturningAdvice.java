package com.multicampus.biz.common;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import com.multicampus.biz.user.UserVO;

@Aspect // Bean 등록으로  @Service 필요없음.
public class AfterReturningAdvice {
	
	@AfterReturning(pointcut="BoardPointcut.getPointcut()", returning="returnObj")
	public void afterLog(Object returnObj) { // Advice method
		System.out.println("<사후 처리> 비즈니스 메소드 리턴 값 : " + returnObj.toString());
		
		// 만약 비즈니스 메소드가 리턴한 데이터가 UserVO 타입의 객체라면... (즉 getUser() 메소드가 호출됐다면)
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			// 만약 UserVO 객체의 role 변수의 값이 Admin이라면...
			if(user.getRole().equals("Admin")) {
				System.out.println(user.getName() + "관리자님 관리자 페이지로 이동합니다...");
			}
		}
	}
}
