import java.util.ArrayList;

public class Client extends Person{
	
	private String companyName;
	private double[] dailySpending = new double[30];
	static ArrayList<Client> clients = new ArrayList<Client>();
	
	
	public Client(String name, String companyName, double[] dailySpending) {
		super(name);
		this.companyName = companyName;
		this.dailySpending = dailySpending;
		
	}

	@Override
	void displayInfo(String clientName) {
		// TODO Auto-generated method stub
		Client displayClient=findClientName(clientName);
		if (displayClient==null) {
			System.out.println("There's no such client in our base");
			return;
		}
		System.out.println("The client "+this.getName()+". From "
							+this.companyName+" company"+"\n"+dailySpending[30]);
		       
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
	
	
	void updateDailySpanding(int day,double amout);

	
	
	
	
	
	
}
