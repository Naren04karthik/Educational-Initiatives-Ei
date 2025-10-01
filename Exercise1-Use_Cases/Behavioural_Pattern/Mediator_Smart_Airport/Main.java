import java.util.Scanner;

// Main simulation for airport operations
public class Main {
    public static void main(String[] args) {
        AirportOperationsCenter mediator = new AirportOperationsCenter();

        // Create all colleagues
        AirTrafficControl atc = new AirTrafficControl("ATC-1", mediator);
        GroundCrew ground = new GroundCrew("GroundTeam-1", mediator);
        GateManager gate = new GateManager("GateManager-1", mediator);
        WeatherStation weather = new WeatherStation("WeatherStation-1", mediator);
        PassengerNotifier notifier = new PassengerNotifier("PassengerNotifier-1", mediator);
        EmergencyResponseTeam emergency = new EmergencyResponseTeam("ERT-1", mediator);

        // Register colleagues with mediator
        mediator.registerColleague(atc);
        mediator.registerColleague(ground);
        mediator.registerColleague(gate);
        mediator.registerColleague(weather);
        mediator.registerColleague(notifier);
        mediator.registerColleague(emergency);

        Scanner sc = new Scanner(System.in);

        // Interactive simulation loop
        while (true) {
            System.out.println("\n--- Smart Airport Operations ---");
            System.out.println("1. Emergency Landing");
            System.out.println("2. Flight Delay");
            System.out.println("3. Weather Alert");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter flight number for emergency landing: ");
                    String flight = sc.nextLine();
                    atc.requestEmergencyLanding(flight);
                }
                case 2 -> {
                    System.out.print("Enter flight number for delay: ");
                    String flight = sc.nextLine();
                    System.out.print("Enter reason for delay: ");
                    String reason = sc.nextLine();
                    atc.reportFlightDelay(flight, reason);
                }
                case 3 -> {
                    System.out.print("Enter weather condition (fog/storm/etc.): ");
                    String condition = sc.nextLine();
                    weather.reportWeather(condition);
                }
                case 4 -> {
                    System.out.println("Exiting simulation...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice, try again!");
            }
        }
    }
}
