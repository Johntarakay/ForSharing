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
	
	public void resetAllDays() {
		setVacationDays(START_VACATION_DAYS); 		
	}
	
	/**
	 * Method allows to log working hours per any day. 
	 * @param day
	 * @param hours
	 */
	
	public void logHours(int day, double hours) {
		try {
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
	
	/**
	 * Method automatically fills an array dailyHours(day and hours per day).
	 */
	public void populateHours() {
		for (int i=0; i<dailyHours.length; i++) {
			Random random = new Random();
			dailyHours[i] = 8+random.nextDouble()*(24-8);
			}
		}
	
	/**
	 * Method take to 0 all days in array. 
	 */
	void resetAllHours() {
		for (int i=0; i<dailyHours.length; i++) {
			logHours(i,0);
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
