package polymorphism3;

//import org.springframework.stereotype.Component;
//
//@Component("apple")
public class AppleSpeaker implements Speaker {
	
	public AppleSpeaker() {
		System.out.println("==> Apple Speaker 积己");
	}
	
	public void volumeUp() {
		System.out.println("Apple Speaker---家府 棵赴促.");
	}
	public void volumeDown() {
		System.out.println("Apple Speaker---家府 郴赴促.");
	}
}
