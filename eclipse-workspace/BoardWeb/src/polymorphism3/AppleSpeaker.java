package polymorphism3;

//import org.springframework.stereotype.Component;
//
//@Component("apple")
public class AppleSpeaker implements Speaker {
	
	public AppleSpeaker() {
		System.out.println("==> Apple Speaker ����");
	}
	
	public void volumeUp() {
		System.out.println("Apple Speaker---�Ҹ� �ø���.");
	}
	public void volumeDown() {
		System.out.println("Apple Speaker---�Ҹ� ������.");
	}
}
