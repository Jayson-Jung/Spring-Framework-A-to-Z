package com.multicampus.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect	//Bean 등록완료하여 @Service 필요 없다.
public class LogAdvice {

	@Before("BoardPointcut.allPointcut()")
	public void printLog(JoinPoint jp) { // Advice method
		
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		System.out.println("<사전 처리> " + method + "() 메소드 ARGS 정보 : " + args[0].toString());
		
	
	}
}
