package polymorphism3;

//import org.springframework.stereotype.Component;
//
//@Component("sony")
public class SonySpeaker implements Speaker {
	
	public SonySpeaker() {
		System.out.println("==> Sony Speaker ����");
	}
	
	public void volumeUp() {
		System.out.println("Sony Speaker---�Ҹ� �ø���.");
	}
	public void volumeDown() {
		System.out.println("Sony Speaker---�Ҹ� ������.");
	}
}
