
public abstract class Worker extends Person {

	private final static int START_VACATION_DAYS = 10;
	private double[] dailyHours;
	private int vacationDays;
	private double basicSalary;
	
	public Worker(String name, double[] dailyHours, int vacationDays, double basicSalary) {
		super(name);
		this.dailyHours = new double [30];
		this.vacationDays = 0;
		this.basicSalary = basicSalary;
	}	
	
	abstract double calculatePaycheck();

	@Override
	void displayInfo(String name) {
		// TODO Auto-generated method stub
		if (Manager.findWorkerName(name)==null) {
			System.out.println("There's no such worker in the company.");
		} else {
			System.out.println("The worker "+this.getName()+". His basic salary is "+this.basicSalary
								+".\n Vacation days remained: "+this.vacationDays);
		}
		
	}
	
	void logHours(int day, double hours) {
		try {
			if (day<0 || day>dailyHours.length) {
				throw new IllegalArgumentException("Invalid day index. Must be between 1 and " + dailyHours.length + ".");
			}
			if (hours<0 || hours>24) {
				throw new IllegalArgumentException("Hours must be a positive number, but not bigger then 24");
			}
			    dailyHours[day] = hours;
			} catch (ArrayIndexOutOfBoundsException e) {
	        System.out.println("Error: Invalid day index. Please provide a valid index.");
			}
			catch (IllegalArgumentException e) {
			      System.out.println("Validation error: "+e.getMessage());
			}
			catch (Exception e) {
		        System.out.println("Unexpected error occured: "+e.getMessage());
			}
			        
		}
	boolean takeVacationDays(int days) {
		if(this.vacationDays>0) {
			return true;
		} else {
			System.out.println("There's no vacation days left.");
			return false;
		}
	}
	
	
}
