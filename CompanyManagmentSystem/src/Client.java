import java.util.ArrayList;
import java.util.Random;

public class Client extends Person {

	private String companyName;
	private double[] dailySpending = new double[30];
	static ArrayList<Client> clients = new ArrayList<Client>();

	/**
	 * Constructor for class Clients. It includes filling for attribute daily spending and adds object to an array list.
	 * @param name
	 * @param companyName
	 */
	public Client(String name, String companyName) {
		super(name);
		this.companyName = companyName;
		populateSpending();
		clients.add(this);

	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public double[] getDailySpending() {
		return dailySpending;
	}

	public void setDailySpending(double[] dailySpending) {
		this.dailySpending = dailySpending;
	}

	public static ArrayList<Client> getClients() {
		return clients;
	}

	public static void setClients(ArrayList<Client> clients) {
		Client.clients = clients;
	}
	
	/**
	 * Method to display info about all clients.
	 */
	@Override
	public void displayInfo() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder("The client " + getName() + ". His ID: " + getId() + ".\nFrom "
				+ getCompanyName() + " company." + "\nDaily spending:\n");
		for (int i = 0; i < dailySpending.length; i++) {
			str.append("Day " + (i + 1) + ": " + String.format("%.0f", dailySpending[i]) + ". ");
		}
		str.append('\n');
		System.out.println(str);
	}
	
	/**
	 * Method helps to give info about single client. 
	 */
	public void infoClient() {
		// TODO Auto-generated method stub
		System.out.println("The client " + this.getName() + ". From " + this.companyName + " company" + "\n"
				+ String.format("%.0f", dailySpending[28]) + " " + String.format("%.0f", dailySpending[29]));

	}

	/**
	 * Helper method  to search clients in an array list by name.
	 * @param clientName
	 * @return
	 */
	static public Client findClientName(String clientName) {
		Client found = null;
		for (Client client : clients) {
			if (client.getName().equalsIgnoreCase(clientName)) {
				found = client;
				break;
			}
		}
		return found;
	}

	/**
	 * /**
	 * Helper method  to search clients in an array list by ID.
	 * @param clientId
	 * @return
	 */
	static public Client findClientId(String clientId) {
		Client found = null;
		for (Client client : clients) {
			if (client.getId().equalsIgnoreCase(clientId)) {
				found = client;
				break;
			}
		}
		return found;
	}

	/**
	 * Simple method to fill each day with daily spending. 
	 * @param day
	 * @param amount
	 */
	void updateDailySpending(int day, double amount) {
		try {
			if (day < 0 || day > dailySpending.length) {
			}
			if (amount < 0) {
			}
			dailySpending[day] = amount;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Error: Invalid day index. Please provide a valid index.");
		} catch (IllegalArgumentException e) {
			System.err.println("Validation error: " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Unexpected error occured: " + e.getMessage());
		}

	}

	/**
	 * Automatically fills days with daily spending
	 */
	void populateSpending() {
		for (int i = 0; i < dailySpending.length; i++) {
			Random random = new Random();
			dailySpending[i] = random.nextDouble() * 1000;
		}
	}

	public static void addClient(Client client) {
		clients.add(client);
	}

}
