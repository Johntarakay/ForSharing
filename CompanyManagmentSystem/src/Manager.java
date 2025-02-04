import java.util.ArrayList;

public class Manager extends Worker {

	private final static int EXTRA_VACATION_DAYS = 10;
	private ArrayList<Worker> team;
	
	/**
	 * Constructor that creates a manager with a team.
	 * @param name
	 * @param basicSalary
	 */
	public Manager(String name, double basicSalary) {
		super(name, basicSalary);
		this.team = new ArrayList<>();
	}
	
	/**
	 * This method helps to find a worker with a name.
	 * @param workerName
	 * @return
	 */
	public Worker findWorkerName(String workerName) {
		Worker found = null;
		for (Worker worker : team) {
			if (worker.getName().equalsIgnoreCase(workerName)) {
				found = worker;
				break;
			}
		}
		return found;
	}
	
	/**
	 * An implement method, that sums salary and bonus for manager. 
	 */
	@Override
	double calculatePaycheck(double basicSalary, double bonus) {
		// TODO Auto-generated method stub
		double paycheck = 0;
		try {
			if (basicSalary < 0) {
				throw new IllegalArgumentException("Wrong input: salary can't be below zero");
			} else {
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
	
	/**
	 * Method adds workers to a team.
	 * @param worker
	 * @param basicSalary
	 */
	public void addTeamMember(String worker, double basicSalary) {
		try {
			if (worker.isBlank()) {
				System.out.println("The name is empty. Try again!");
				return;
			} else if (findWorkerName(worker) != null) {
				System.out.println("The worker is already in team");
				return;
			} else {
				Manager newWorker = new Manager(worker, basicSalary);
				team.add(newWorker);
			}
		} catch (IllegalArgumentException e) {
			System.err.println("Validation error: " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Unexpected error occured: " + e.getMessage());
		}

	}
	
	/**
	 * Method to display members of a team.
	 */
	public void displayTeam() {
		System.out.println("Team managed by " + getName() + ":");
		for (Worker worker : team) {
			System.out.println("- " + worker.getName() + " with basic salary: " + worker.getBasicSalary());
		}
	}

	
	@Override
	public void displayInfo() {
		// TODO Auto-generated method stub
		
	}

}
