import java.util.ArrayList;

public abstract class Person {

	private static int idCounter=1;
	private String name;
	private final String id;
	
	/**
	 * Constructor for an abstract class with ID for each type of objects. ID consists of first letter of objects class and "0" (it fills  empty space iv serial number of a unit if lower then 100).
	 * @param name
	 */
	
	public Person(String name) {
		super();
		this.name = name;
		this.id=getClass().getSimpleName().charAt(0)
				+ "-" + "0".repeat(nullsNumber(idCounter)) 
				+ idCounter++;
	}
	
	abstract void displayInfo();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}
	
	/**
	 * Method for constructor to create an ID. It counts number of "0" before serial number of unit. 
	 */
	  
	 
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
