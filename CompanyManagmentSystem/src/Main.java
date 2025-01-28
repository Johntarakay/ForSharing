import java.text.DecimalFormat;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		new RegularWorker("John", 3000.0);
		new Client("Steve", "Tefal");

        //Checking attributes and methods of an object.
//        double paycheck = regularWorker.calculatePaycheck(3000.0, 8.0);
//        DecimalFormat df = new DecimalFormat("#.00");
//        String formattedPaycheck = df.format(paycheck);
//        System.out.println("Paycheck for " + regularWorker.getName() + ": " + formattedPaycheck);
//			
//        double[] dailyHours = regularWorker.getDailyHours();
//        for (int i = 0; i < dailyHours.length; i++) {
//        	String formattedHour = String.format("%.1f", dailyHours[i]);
//            System.out.println("Day " + (i + 1) + ": " + formattedHour);
//        }
        
		for (Client client : Client.getClients()) {
            client.displayInfo();}
            
//        for (Client client : Client.getClients()) {
//                client.displayInfo(client.getName());
//        }
        
        for (RegularWorker worker : RegularWorker.getWorkers()) {
            worker.displayInfo();
    }
	}	
}