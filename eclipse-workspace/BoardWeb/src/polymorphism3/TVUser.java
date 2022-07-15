package polymorphism3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		
		// 1.  ������ �����̳ʸ� �����Ѵ�.
		GenericXmlApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2.  ������ �����̳ʷκ��� ����� ��ü�� �˻�(Lookup)�Ѵ�.
		TV tv = (TV) container.getBean("tv");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		// 3. ������ �����̳ʸ� �����Ѵ�.
		container.close();
	}

}