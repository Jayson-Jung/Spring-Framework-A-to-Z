package polymorphism3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV{
	@Autowired	// Type Injection
	private Speaker speaker;
	
	public LgTV() {
		System.out.println("===> LgTV 생성");
	}
	
	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("LgTV---전원 켠다.");
	}
	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("LgTV---전원 끈다.");
	}
	@Override
	public void volumeUp() {
		speaker.volumeUp();
	}
	@Override
	public void volumeDown() {
		speaker.volumeDown();
	}
}
