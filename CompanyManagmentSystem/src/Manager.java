import java.util.ArrayList;

public class Manager extends Worker{

	private final static int EXTRA_VACATION_DAYS = 10;
	private int sickDays;
	private static ArrayList<Worker> team = new ArrayList<Worker>();

	public Manager(String name, double[] dailyHours, int vacationDays, double basicSalary, int sickDays) {
		super(name, dailyHours, vacationDays, basicSalary);
		this.sickDays = 0;
	}



	static public Worker findWorkerName(String workerName) {
		Worker found = null;
		for (Worker worker: team) {
			if(worker.getName().equalsIgnoreCase(workerName)) {
				found = worker;
				break;
			}
		}						
		return found;	
	}



	@Override
	double calculatePaycheck() {
		// TODO Auto-generated method stub
		
		
		
		return 0;
		
	}

	



}
