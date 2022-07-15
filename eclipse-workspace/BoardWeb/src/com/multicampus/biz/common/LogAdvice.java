package com.multicampus.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect	//Bean ��ϿϷ��Ͽ� @Service �ʿ� ����.
public class LogAdvice {

	@Before("BoardPointcut.allPointcut()")
	public void printLog(JoinPoint jp) { // Advice method
		
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		System.out.println("<���� ó��> " + method + "() �޼ҵ� ARGS ���� : " + args[0].toString());
		
	
	}
}
