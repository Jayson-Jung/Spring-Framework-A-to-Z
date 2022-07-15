package com.multicampus.biz.collection;

import java.util.Collection;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionUser {

	public static void main(String[] args) {
		GenericXmlApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		CollectionBean bean = (CollectionBean) container.getBean("addressList");
		Properties collection = bean.getAddressList();
		
		Set<Object> keyList = collection.keySet();
		
		System.out.println("[회원 이름 목록]");
		
		for(Object name : keyList) {
			System.out.println("---> " + name.toString());
		}
		
		System.out.println("[회원 주소 목록]");
		Collection<Object> valueList = collection.values();
		for(Object address : valueList) {
			System.out.println("---> " + address.toString());
		}
	}
}
