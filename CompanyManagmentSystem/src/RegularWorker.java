import java.util.ArrayList;

public class RegularWorker extends Worker {

	private final static int START_SICK_DAYS = 15;
	private int sickDays;
	private static ArrayList<Worker> workers = new ArrayList<Worker>();
	
	public RegularWorker(String name, double basicSalary, int vacationDays, int sickDays, double[] dailyHours) {
		super(name, basicSalary);
		this.sickDays = START_SICK_DAYS;
		setDailyHours(dailyHours);
	}

	@Override
	//counting paycheck by finding cost of 1 working hour and multiplying for overtime. 
	double calculatePaycheck(double basicSalary, double threshold) {
		// TODO Auto-generated method stub
		double paycheck = 0; 
		try {
			if(basicSalary<0) {
				throw new IllegalArgumentException("Wrong input: salary can't be below zero");
			} 
			else { 
				double overtime = calculateOvertime(threshold);
				double bonus = (basicSalary/26/8)*overtime;
				paycheck=basicSalary+bonus;
				return paycheck;
				}
		}
			catch (IllegalArgumentException e) { 
			System.err.println("Validation error: "+e.getMessage());
			}
			catch (Exception e) {
		        System.err.println("Unexpected error occured: "+e.getMessage());
			}
		return paycheck;
				
	}
	
	//Checking overtime and adding bonus for this.
	public double calculateOvertime(double threshold) {
        double totalOvertime = 0;
        for (double hours : getDailyHours()) {
            if (hours > threshold) {
                totalOvertime += (hours - threshold);
            }
        }
        return totalOvertime;
    }
	
	boolean takeSickDays(int days) {
		if(this.sickDays>0) {
			return true;
		} else {
			System.out.println("There's no sick days left.");
			return false;
		}
	}
	
	@Override
	
	public void displayInfo(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetAllDays(ArrayList<Worker> workers) {
		// TODO Auto-generated method stub
		this.sickDays=START_SICK_DAYS;
		setVacationDays(getDefaultVacationDays());
	}

	
	
}
