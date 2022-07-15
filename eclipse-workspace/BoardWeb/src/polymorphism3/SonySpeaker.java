package polymorphism3;

//import org.springframework.stereotype.Component;
//
//@Component("sony")
public class SonySpeaker implements Speaker {
	
	public SonySpeaker() {
		System.out.println("==> Sony Speaker 积己");
	}
	
	public void volumeUp() {
		System.out.println("Sony Speaker---家府 棵赴促.");
	}
	public void volumeDown() {
		System.out.println("Sony Speaker---家府 郴赴促.");
	}
}
