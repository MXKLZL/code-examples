package example.ramdon.stuff;

public class SetterInConstructor {
		
	private int value;
	
	public SetterInConstructor() {
		setter();
	}
	
	public void setter() {
		System.out.println("I am a setter");
		value = 214;
	}
	
	public static void main(String args[]) {
		Child c = new Child();
	}
}

class Child extends SetterInConstructor {
	
	private int value;
	
	public Child() {
		super();
	}
	
	@Override
	public void setter() {
		System.out.println("I am a setter, and haha");
		value = 999;
	}
}
