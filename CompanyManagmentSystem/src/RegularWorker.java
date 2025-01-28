import java.text.DecimalFormat;
import java.util.ArrayList;

public class RegularWorker extends Worker {

	private final static int START_SICK_DAYS = 15;
	private int sickDays;
	private static ArrayList<RegularWorker> workers = new ArrayList<RegularWorker>();

	public RegularWorker(String name, double basicSalary) {
		super(name, basicSalary);
		this.sickDays = START_SICK_DAYS;
		populateHours();
		getStartVacationDays();
		workers.add(this);
	}

	@Override
	// counting paycheck by finding cost of 1 working hour and multiplying for
	// overtime.
	double calculatePaycheck(double basicSalary, double threshold) {
		// TODO Auto-generated method stub
		double paycheck = 0;
		try {
			if (basicSalary < 0) {
				throw new IllegalArgumentException("Wrong input: salary can't be below zero");
			} else {
				double overtime = calculateOvertime(threshold);
				double bonus = (basicSalary / 26 / 8) * overtime;
				paycheck = basicSalary + bonus;
				return paycheck;
			}
		} catch (IllegalArgumentException e) {
			System.err.println("Validation error: " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Unexpected error occured: " + e.getMessage());
		}
		return paycheck;

	}

	// Checking overtime and adding bonus for this.
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
		if (days > START_SICK_DAYS) {
			System.err.println("There's not enough sickdays left for " + getName());
			return false;
		}
		if (days < 0) {
			System.out.println("Number of sickdays must be positive");
			return false;
		}
		if (sickDays - days < 0) {
			System.err.println("There's not enough sickdays left for " + getName());
			return false;
		}
		sickDays -= days;
		return true;
	}

	public static ArrayList<RegularWorker> getWorkers() {
		return workers;
	}

	public static void setWorkers(ArrayList<RegularWorker> workers) {
		RegularWorker.workers = workers;
	}

	public int getSickDays() {
		return sickDays;
	}

	public void setSickDays(int sickDays) {
		this.sickDays = sickDays;
	}

	@Override
	public void displayInfo() {
		// TODO Auto-generated method stub

		double[] dailyHours = getDailyHours();
		StringBuilder str = new StringBuilder("\n");

		double paycheck = calculatePaycheck(getBasicSalary(), 8.0);
		DecimalFormat df = new DecimalFormat("#.00");
		String formattedPaycheck = df.format(paycheck);
		str.append("The worker " + getName() + ". His ID: " + getId() + "." + "\n" + "His paycheck: "
				+ formattedPaycheck + "\n" + "His statistics of working hours are: ");
		for (int i = 0; i < dailyHours.length; i++) {
			str.append("Day " + (i + 1) + ": "+String.format("%.0f", getDailyHours()[i])+ ". ");
		}
		System.out.println(str);
	}

	
	@Override
	public void resetAllDays(ArrayList<Worker> workers) {
		// TODO Auto-generated method stub
		this.sickDays = START_SICK_DAYS;
		setVacationDays(getDefaultVacationDays());
	}

}
