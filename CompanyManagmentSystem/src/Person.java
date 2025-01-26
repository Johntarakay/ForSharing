import java.util.ArrayList;

public abstract class Person {

	private static int idCounter=0;
	private String name;
	private final String id;
	
	public Person(String name) {
		super();
		this.name = name;
		this.id="ID"+(idCounter++);
	}
	
	abstract void displayInfo(String name);
	
	//static void resetAllDays (ArrayList<Worker> workers) {
	//}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	
}
