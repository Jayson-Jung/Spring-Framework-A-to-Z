package polymorphism1;

public class LgTV implements TV{
	public LgTV() {
		System.out.println("===> LgTV ����");
	}
	
	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("LgTV---���� �Ҵ�.");
	}
	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("LgTV---���� ����.");
	}
	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		System.out.println("LgTV---�Ҹ� �ø���.");
	}
	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("LgTV---�Ҹ� ������.");
	}
}