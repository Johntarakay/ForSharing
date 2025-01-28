import java.util.ArrayList;

public abstract class Person {

	private static int idCounter=1;
	private String name;
	private final String id;
	
	public Person(String name) {
		super();
		this.name = name;
		this.id=getClass().getSimpleName().charAt(0)
				+ "-" + "0".repeat(nullsNumber(idCounter)) 
				+ idCounter++;
	}
	
	abstract void displayInfo();
	
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
	
	private int nullsNumber(int number) {
        if (number < 10) {
            return 2;
        } else if (number < 100) {
            return 1;
        } else {
            return 0;
        }
    }


	
}
