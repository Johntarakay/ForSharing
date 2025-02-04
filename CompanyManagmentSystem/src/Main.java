import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {
	
	// There wasn't a goal to make option to create a new managers, so I decided to make it manually without scan. 
	public static Manager m1 = new Manager("John Seana", 12000);
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Creating first objects to check and start methods.
		new RegularWorker("Boba", 1000);
		new RegularWorker("John", 3000.0);
		new RegularWorker("Helena", 6000.0);
		new RegularWorker("Bob", 3000.0);
		new Client("Steve Wonder", "Tefal");
		new Client("John MacQueen", "20th Fox");
		new Client("Kent Eastwood", "Ocean Eagle");
		new Client("Bobe Dolan", "Silent gitar");
		
		
		
		m1.addTeamMember("John", 3000);
		m1.addTeamMember("Helena", 6000);
		
		/**
		 * User menu with list of all main methods to work with
		 */
		try (Scanner scan = new Scanner(System.in);){ 
			printOntions();
			String answer = scan.nextLine();
			while (!answer.equalsIgnoreCase("Exit") && !answer.equalsIgnoreCase("0")) {
				switch (answer) {
				case "1":
					for (Client client : Client.getClients()) {
						client.displayInfo();
					}
					break;
				case "2":
					for (RegularWorker worker : RegularWorker.getWorkers()) {
						worker.displayInfo();
					}
					break;
				case "3":
					clientSearch(scan);

					break;
				case "4":
					addingWorkerToTeam(scan);
					
					break;
				case "5":
					 searchWorkerWithId(scan);
					
					break;
				case "6":
					resetAllDays();
					break;
				case "7":
					resetAllWorkingHours();
					break;
				case "8":
					resetClientsSpending();
					break;
				case "9":
					LogWorkingHours(scan);
					break;
				case "10":
					takeSickDays(scan);
					break;
				case "11":
					takeVacation(scan);
					break;
				case "0":
					break;
				default:
					System.out.println("Invalid option. Please try again.");
				}
				answer = scan.nextLine();
			}
			scan.close();
		}
	}

	/**
	 * Method that takes response from user to take a vacation for a worker. Uses helper methods to find worker by an ID and getters and setters to change number of days left.
	 * @param scan
	 */
	private static void takeVacation(Scanner scan) {
		// TODO Auto-generated method stub
		try{
		System.out.println("Enter worker's ID: ");
		String scanWorkerId = scan.nextLine();
		RegularWorker worker = RegularWorker.findWorkerById(scanWorkerId);	
		if (worker==null) {
			System.out.println("There's no such worker in our base");
			System.out.println("\nReturning to the main menu");
			return;
		} 
		if(worker.getVacationDays() == 0){
			System.out.println("This worker don't have vacation days left");
			System.out.println("\nReturning to the main menu");
			return;
		}
		System.out.println("How many days you want to take?");
		int days = scan.nextInt();
		if (days<0){
			System.out.println("The number of vacation days must be positive");
			System.out.println("\nReturning to the main menu");
			return;
		}
		scan.nextLine();
		if (worker.takeVacationDays(days)) {
			worker.setVacationDays(worker.getVacationDays()-days);
			System.out.println("You have "+worker.getVacationDays()+" days left");
			System.out.println("\nReturning to the main menu");
		} else {
			System.out.println("There're not enough days for vacation left");
			System.out.println("\nReturning to the main menu");
			return;
		}
		}catch (IllegalArgumentException e) { 
			System.err.println(e.getMessage()); 
			} 
		catch (Exception e) { 
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	/**
	 * Method that takes response from user to take a sick days for a worker. Uses helper methods to find worker by an ID and getters and setters to change number of days left.
	 * @param scan
	 */
	private static void takeSickDays(Scanner scan) {
		// TODO Auto-generated method stub
		try{
		System.out.println("Enter worker's ID: ");
		String scanWorkerId = scan.nextLine();
		RegularWorker worker = RegularWorker.findWorkerById(scanWorkerId);	
		if (worker==null) {
			System.out.println("There's no such worker in our base");
			System.out.println("\nReturning to the main menu");
			return;
		} 
		System.out.println("How many days you want to take?");
		int days = scan.nextInt();
		if (days<0){
			System.out.println("The number of sick days must be positive");
		}
		scan.nextLine();
		if (worker.takeSickDays(days)) {
			worker.setSickDays(worker.getSickDays()-days);
			System.out.println("You have "+worker.getSickDays()+" days left");
			System.out.println("\nReturning to the main menu");
		} else {
			System.out.println("\nReturning to the main menu");
		}
		}catch (IllegalArgumentException e) { 
			System.err.println(e.getMessage()+ ""); 
			} 
		catch (Exception e) { 
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
		
	}

	/**
	 * Resets all days (vacation and sick days)
	 */
	private static void resetAllDays() {
		// TODO Auto-generated method stub
		for (RegularWorker worker : RegularWorker.getWorkers()) {
			worker.resetAllDays();
		}
			
	}

	/**
	 * Methods take from user info to fill worker's working hours.
	 * @param scan
	 */
	private static void LogWorkingHours(Scanner scan) {
		// TODO Auto-generated method stub
		
		try {
			System.out.println("Enter worker's ID: ");
			String scanWorkerId = scan.nextLine();
			RegularWorker worker = RegularWorker.findWorkerById(scanWorkerId);
			if(worker == null) {
				System.out.println("The ID is empty, or there's no such worker in our team!");
				System.out.println("\nReturning to the main menu");
				return;}
			System.out.println("Which day you want to log?");
			int day = scan.nextInt();
			if (day<0||day>=worker.getDailyHours().length){
				System.out.println("The number of days must be positive and lower than 30");
				System.out.println("\nReturning to the main menu");
				return;
			}
			System.out.println("How many hours you want to log?");
			int hours = scan.nextInt();
			scan.nextLine();
			if (hours<0||hours>24){
				System.out.println("The number of hours must be positive and lower then 24");
				System.out.println("\nReturning to the main menu");
				return;
			}
				worker.logHours(day, hours);
				System.out.println("You successfully logged working hours");
				System.out.println("\nReturning to the main menu");
			}  
			catch (IllegalArgumentException e) { 
				System.err.println(e.getMessage()); 
				} 
			catch (Exception e) { 
				System.err.println("An unexpected error occurred: " + e.getMessage());
			}
		
	}
	/**
	 * Resetting client's daily spending
	 */
	private static void resetClientsSpending() {
		// TODO Auto-generated method stub
		for (Client client : Client.getClients()) {
			double[] dailySpending = client.getDailySpending();
			for (int i = 0; i < client.getDailySpending().length; i++) {
				dailySpending[i] = 0;
			}
			client.setDailySpending(dailySpending); 
			System.out.println("\nJob is done! Returning to the main menu");
		}
	}
	
	/**
	 * Resetting working hours for all workers.
	 */
	private static void resetAllWorkingHours() {
		// TODO Auto-generated method stub
		for (RegularWorker worker : RegularWorker.getWorkers()) {
			worker.resetAllHours();
			System.out.println("\nJob is done! Returning to the main menu");
		}
	}

	/**
	 * Searching client with his ID and displaying info.
	 * @param scan
	 */
	private static void clientSearch(Scanner scan) {
		// TODO Auto-generated method stub
		System.out.println("Enter clients ID: ");
		try {
			String scanClientId = scan.nextLine();
			Client client = Client.findClientId(scanClientId);
			if (client == null) {
				System.out.println("There's no such client in our base");
				System.out.println("\nReturning to the main menu");
			} else {
				client.infoClient();
				System.out.println("\nJob is done! Returning to the main menu");
			}
		} catch (IllegalArgumentException e) {
			System.err.println("Validation error: " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Unexpected error occured: " + e.getMessage());
		}
	}
	
	/**
	 * Searching worker with his ID and displaying info.
	 * @param scan
	 */
	private static void searchWorkerWithId(Scanner scan) {
		System.out.println("Enter worker's ID: ");
		try {
		String scanWorkerId = scan.nextLine();
		RegularWorker worker = RegularWorker.findWorkerById(scanWorkerId);	
		if(worker == null) {
			System.out.println("The name is empty, or there's no such worker in our team!");
			System.out.println("\nReturning to the main menu");
			return;
			}
			worker.displayInfo();
			 
		}  
		catch (IllegalArgumentException e) { 
			System.err.println(e.getMessage()); 
			} 
		catch (Exception e) { 
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	/**
	 * Displaying info about all clients and workers, except teams and manager.
	 */
	private static void displayInfo() {
		for (Client client : Client.getClients()) {
			client.displayInfo();
		}
		for (RegularWorker worker : RegularWorker.getWorkers()) {
			worker.displayInfo();
		}
	}
	/**
	 * Adding a new worker to a team.
	 * @param scan
	 */
	private static void addingWorkerToTeam(Scanner scan) {
		try {
		System.out.println("Enter worker's name: ");
		String scanWorkerName = scan.nextLine();
		System.out.println("Enter worker's basic salary.");
		String scanWorkerSalary = scan.nextLine();
		double doubleSalary = Double.parseDouble(scanWorkerSalary);
		if(doubleSalary<0) {
			System.out.println("Salary can't be below zero!");
			System.out.println("\nReturning to the main menu");
			return;
		}else if (m1.findWorkerName(scanWorkerName) != null) {
			System.out.println("The worker is already in team!");
			System.out.println("\nReturning to the main menu");
			return;
		}
		m1.addTeamMember(scanWorkerName, doubleSalary);
		System.out.println("The worker was successfuly added!");
		System.out.println("\nReturning to the main menu");
		}  
		catch (IllegalArgumentException e) { 
			System.out.println(e.getMessage()); 
			} 
		catch (Exception e) { 
			System.out.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	
	/***
	 * Options for main menu. 
	 */
	private static void printOntions() {
		// TODO Auto-generated method stub
		System.out.println("""
				Welcome to the Company managment system! 
				Choose an option: 
				\t1 - Show all clients 
				\t2 - Show all workers 
				\t3 - Find client by ID
				\t4 - Add worker to a team 
				\t5 - Find worker by ID 
				\t6 - Reset all sick and vacation days
				\t7 - Reset all working hours
				\t8 - Update daily spending of clients 
				\t9 - Log working hours
				\t10 - Take sick days off
				\t11 - Take a vaсation
				\t0 - Exit
				""");
	}

}