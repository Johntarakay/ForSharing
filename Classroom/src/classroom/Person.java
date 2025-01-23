package classroom;

abstract public class Person {
	protected String name;
	final int MAX_AGE = 120;
	private static int COUNT = 0;
	
	public Person(String name) {
		COUNT++;
		this.name = name;
	}
	
	public static void print() {
		System.out.println("There are "+COUNT+" people in the program");
	}
	
	abstract public void something();
	
	public void me(int num) {
		System.out.println("Hi I'm "+this.name);
		this.safe();
	}
	
	private void safe() {
		System.out.println("Complicated method");
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public static int getCount() {
		return Person.COUNT;
	}
}
