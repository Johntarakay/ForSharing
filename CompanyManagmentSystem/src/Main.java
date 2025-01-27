import java.text.DecimalFormat;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Пример значений для ежедневных часов работы
        double[] dailyHours = {8.5, 7.0, 9.0, 8.0, 10.0, 7.5, 8.0, 8.5, 9.5, 7.0, 8.0, 8.0, 8.0, 8.0, 10.0};

        // Создание объекта RegularWorker
        RegularWorker regularWorker = new RegularWorker("John", 3000.0, 10, dailyHours);

        // Расчет зарплаты с учетом бонуса за переработку
        double paycheck = regularWorker.calculatePaycheck(3000.0, 8.0);
        DecimalFormat df = new DecimalFormat("#.00");
        String formattedPaycheck = df.format(paycheck);
        System.out.println("Paycheck for " + regularWorker.getName() + ": " + formattedPaycheck);
			
		
      
	}

}
