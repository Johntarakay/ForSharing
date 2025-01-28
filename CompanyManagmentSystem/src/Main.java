import java.text.DecimalFormat;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		new RegularWorker("John", 3000.0);
		new RegularWorker("Helena", 6000.0);
		new RegularWorker("Bob", 3000.0);
		new Client("Steve Wonder", "Tefal");
		new Client("John MacQueen", "20th Fox");
		Manager m1 = new Manager("John Seana", 12000);
		
		m1.addTeamMember("John", 3000);
		m1.addTeamMember("Helena", 6000);
        
		for (Client client : Client.getClients()) {
            client.displayInfo();
            }
            
        for (RegularWorker worker : RegularWorker.getWorkers()) {
            worker.displayInfo();
        }
        
		
        
	}	
}