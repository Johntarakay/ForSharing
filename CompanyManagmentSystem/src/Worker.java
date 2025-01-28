import java.util.ArrayList;
import java.util.Random;

public abstract class Worker extends Person {

	private final static int START_VACATION_DAYS = 10;
	private double[] dailyHours;
	private int vacationDays;
	private double basicSalary;
			
	public Worker(String name, double basicSalary) {
		super(name);
		this.dailyHours = new double [30];
		this.vacationDays = getDefaultVacationDays();
		this.basicSalary = basicSalary;
	}	
	
	abstract double calculatePaycheck(double basicSalary, double bonus);

		
	@Override
	public abstract void displayInfo(); 
	
	public int getDefaultVacationDays() {
		
		return START_VACATION_DAYS;
	}
	
	protected void resetAllDays(ArrayList<Worker> workers) {
		setVacationDays(START_VACATION_DAYS); 		
	}
	
	
	
	void logHours(int day, double hours) {
		try {
			if (day<0 || day>=dailyHours.length) {
				throw new IllegalArgumentException("Invalid day index. Must be between 1 and " + dailyHours.length + ".");
			}
			if (hours<0 || hours>24) {
				throw new IllegalArgumentException("Hours must be a positive number, but not bigger then 24");
			}
			    dailyHours[day] = hours;
			} catch (ArrayIndexOutOfBoundsException e) {
	        System.err.println("Error: Invalid day index. Please provide a valid index.");
			}
			catch (IllegalArgumentException e) {
			      System.err.println("Validation error: "+e.getMessage());
			}
			catch (Exception e) {
		        System.err.println("Unexpected error occured: "+e.getMessage());
			}
			        
		}
	
	void populateHours() {
		for (int i=0; i<dailyHours.length; i++) {
			Random random = new Random();
			dailyHours[i] = 8+random.nextDouble()*(24-8);
			}
		}
	
	void resetHours(int day1) {
		try{
			if (day1<0||day1>dailyHours.length) {
				throw new IllegalArgumentException("Input can't be less then zero or bigger then 30");
			}
				
			logHours(day1,0);
		}catch(IllegalArgumentException e) {
			System.err.println("Error: Invalid day index. Please provide a valid index.");
		}catch (Exception e) {
	        System.err.println("Unexpected error occured: "+e.getMessage());
		}
		
	}
	
	void resetAllHours() {
		for (int i=0; i<dailyHours.length; i++) {
			logHours(i,0);
			}
		}
	
	
	boolean takeVacationDays(int days) {
		if(this.vacationDays>0) {
			return true;
		} else {
			System.err.println("There's no vacation days left.");
			return false;
		}
	}

	public double[] getDailyHours() {
		return dailyHours;
	}

	public void setDailyHours(double[] dailyHours) {
		this.dailyHours = dailyHours;
	}

	public int getVacationDays() {
		return vacationDays;
	}

	public void setVacationDays(int vacationDays) {
		this.vacationDays = vacationDays;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}


	public static int getStartVacationDays() {
		return START_VACATION_DAYS;
	}
	
	
	
	
}
