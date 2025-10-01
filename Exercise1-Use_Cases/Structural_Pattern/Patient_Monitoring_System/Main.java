import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of patients to monitor: ");
        int numPatients = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 1; i <= numPatients; i++) {
            System.out.println("\n--- Patient " + i + " ---");
            System.out.print("Enter patient name: ");
            String name = sc.nextLine();

            PatientMonitor monitor = new BasicVitals(name);

            System.out.println("Select additional monitoring features (comma separated):");
            System.out.println("1. ECG");
            System.out.println("2. Oxygen Level");
            System.out.println("3. Heart Rate");
            System.out.println("4. Blood Sugar");
            System.out.print("Your choices: ");
            String[] choices = sc.nextLine().split(",");

            for (String choice : choices) {
                switch (choice.trim()) {
                    case "1": monitor = new ECGDecorator(monitor, sc); break;
                    case "2": monitor = new OxygenDecorator(monitor, sc); break;
                    case "3": monitor = new HeartRateDecorator(monitor, sc); break;
                    case "4": monitor = new BloodSugarDecorator(monitor, sc); break;
                }
            }

            System.out.println("\n=== Patient Monitoring Details for " + name + " ===");
            monitor.monitor();
            System.out.println("\n=== Patient Evaluation for " + name + " ===");
            monitor.evaluate();
        }

        sc.close();
        System.out.println("\nAll patients monitored successfully!");
    }
}
