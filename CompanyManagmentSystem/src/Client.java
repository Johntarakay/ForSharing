import java.util.ArrayList;
import java.util.Random;

public class Client extends Person{
	
	private String companyName;
	private double[] dailySpending = new double[30];
	static ArrayList<Client> clients = new ArrayList<Client>();
	
	
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

	@Override
	 public void displayInfo() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder("The client "+getName()+". His ID: "+getId()+".\nFrom "
				+getCompanyName()+" company."+"\nDaily spending:\n");
		for (int i = 0; i < dailySpending.length; i++) {
			str.append("Day " + (i + 1) + ": " + String.format("%.0f", dailySpending[i])+". ");
		}
				
				str.append('\n');
				System.out.println(str);
	}
	
	 void InfoClient(String clientName) {
		// TODO Auto-generated method stub
		Client displayClient=findClientName(clientName);
		if (displayClient==null) {
			System.out.println("There's no such client in our base");
			return;
		}
		System.out.println("The client "+this.getName()+". From "
							+this.companyName+" company"+"\n"+dailySpending[28]
							+" "+dailySpending[29]);
		       
	}
			
	static public Client findClientName(String clientName) {
		Client found = null;
		for (Client client: clients) {
			if(client.getName().equalsIgnoreCase(clientName)) {
				found = client;
				break;
			}
		}						
		return found;	
	}
	
	void updateDailySpending(int day, double amount) {
		try {
		if (day<0 || day>dailySpending.length) {
			throw new IllegalArgumentException("Invalid day index. Must be between 1 and " + dailySpending.length + ".");
		}
		if (amount<0) {
			throw new IllegalArgumentException("Amount must be positive number");
		}
		    dailySpending[day] = amount;
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
	
	void populateSpending() {
		for (int i=0; i<dailySpending.length; i++) {
			Random random = new Random();
			dailySpending[i] = random.nextDouble()*1000;
			}
	}
	
	public static void addClient(Client client) {
	        clients.add(client);
	    }
	
	
	
	
	
	
	
	
}
