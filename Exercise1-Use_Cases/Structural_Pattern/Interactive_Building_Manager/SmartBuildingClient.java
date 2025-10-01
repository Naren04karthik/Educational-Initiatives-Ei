// Client class with user input and menu-driven operations
import java.util.Scanner;

public class SmartBuildingClient {
    private static Scanner sc = new Scanner(System.in);

    public static Campus setupCampus() {
        System.out.print("Enter Campus name: ");
        String campusName = sc.nextLine();
        Campus campus = new Campus(campusName);

        System.out.print("Enter number of Buildings in Campus: ");
        int numBuildings = sc.nextInt();
        sc.nextLine();

        for (int b = 1; b <= numBuildings; b++) {
            System.out.print("Enter name for Building " + b + ": ");
            String bName = sc.nextLine();
            Building building = new Building(bName);

            System.out.print("Enter number of Wings in " + bName + ": ");
            int numWings = sc.nextInt();
            sc.nextLine();

            for (int w = 1; w <= numWings; w++) {
                System.out.print("Enter name for Wing " + w + ": ");
                String wName = sc.nextLine();
                Wing wing = new Wing(wName);

                System.out.print("Enter number of Floors in " + wName + ": ");
                int numFloors = sc.nextInt();
                sc.nextLine();

                for (int f = 1; f <= numFloors; f++) {
                    System.out.print("Enter name for Floor " + f + ": ");
                    String fName = sc.nextLine();
                    Floor floor = new Floor(fName);

                    System.out.print("Enter number of Rooms in " + fName + ": ");
                    int numRooms = sc.nextInt();
                    sc.nextLine();

                    for (int r = 1; r <= numRooms; r++) {
                        System.out.print("Enter Room number: ");
                        String rName = sc.nextLine();
                        Room room = new Room(rName);

                        // Add devices to each room
                        System.out.print("How many Thermostats in Room " + rName + "? ");
                        int t = sc.nextInt();
                        sc.nextLine();
                        for (int i = 1; i <= t; i++) room.addComponent(new SmartThermostat("T" + i));

                        System.out.print("How many LED Lights in Room " + rName + "? ");
                        int l = sc.nextInt();
                        sc.nextLine();
                        for (int i = 1; i <= l; i++) room.addComponent(new LEDLight("L" + i));

                        System.out.print("How many Security Cameras in Room " + rName + "? ");
                        int c = sc.nextInt();
                        sc.nextLine();
                        for (int i = 1; i <= c; i++) room.addComponent(new SecurityCamera("C" + i));

                        System.out.print("How many Fire Alarms in Room " + rName + "? ");
                        int fa = sc.nextInt();
                        sc.nextLine();
                        for (int i = 1; i <= fa; i++) room.addComponent(new FireAlarm("FA" + i));

                        floor.addComponent(room);
                    }
                    wing.addComponent(floor);
                }
                building.addComponent(wing);
            }
            campus.addComponent(building);
        }

        return campus;
    }

    public static void runMenu(Campus campus) {
        while (true) {
            System.out.println("\n--- Smart Building Management Menu ---");
            System.out.println("1. Adjust Temperature");
            System.out.println("2. Toggle Lights");
            System.out.println("3. Enter Energy Saving Mode");
            System.out.println("4. Simulate Fire Emergency");
            System.out.println("5. Show Energy Usage Report");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter target component name: ");
                    String tComp = sc.nextLine();
                    BuildingComponent tempTarget = campus.findByName(tComp);
                    if (tempTarget != null) {
                        System.out.print("Enter temperature change (e.g., -2): ");
                        int delta = sc.nextInt();
                        sc.nextLine();
                        tempTarget.adjustTemperature(delta);
                    } else {
                        System.out.println("Component not found!");
                    }
                    break;

                case 2:
                    System.out.print("Enter target component name: ");
                    String lComp = sc.nextLine();
                    BuildingComponent lightTarget = campus.findByName(lComp);
                    if (lightTarget != null) {
                        System.out.print("Turn lights ON? (true/false): ");
                        boolean on = sc.nextBoolean();
                        sc.nextLine();
                        lightTarget.toggleLights(on);
                    } else {
                        System.out.println("Component not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter target component name for Energy Saving Mode: ");
                    String esComp = sc.nextLine();
                    BuildingComponent esTarget = campus.findByName(esComp);
                    if (esTarget != null) {
                        esTarget.adjustTemperature(-2);
                        esTarget.toggleLights(true);
                    } else {
                        System.out.println("Component not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter room name to simulate fire: ");
                    String rName = sc.nextLine();
                    BuildingComponent fireTarget = campus.findByName(rName);
                    if (fireTarget != null) {
                        fireTarget.evacuate();
                    } else {
                        System.out.println("Room not found!");
                    }
                    break;

                case 5:
                    double usage = campus.getEnergyUsage();
                    System.out.println("Total Energy Usage: " + usage + " kWh");
                    break;

                case 6:
                    System.out.println("Exiting system. Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
