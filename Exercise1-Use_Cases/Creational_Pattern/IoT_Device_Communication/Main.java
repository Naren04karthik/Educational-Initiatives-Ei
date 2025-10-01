import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hub hub = new Hub();

        System.out.println("Welcome to Smart Home Hub - IoT Device Manager!\n");

        System.out.print("Please enter the device ID: ");
        String id = sc.nextLine();

        System.out.print("Enter the device name: ");
        String name = sc.nextLine();

        System.out.println("Select the communication protocol for this device:");
        System.out.println("1) Zigbee (Low-power mesh)");
        System.out.println("2) WiFi (High-bandwidth internet)");
        System.out.println("3) Bluetooth (Short-range, low-energy)");
        System.out.print("Your choice: ");
        int choice = sc.nextInt();

        Device.Protocol protocol = (choice == 1) ? Device.Protocol.ZIGBEE :
                                   (choice == 2) ? Device.Protocol.WIFI : Device.Protocol.BLUETOOTH;

        Device device = new Device(id, name, protocol);

        System.out.println("\nDetecting device... " + device.getName() + " identified as " + protocol + " device.\n");

        System.out.println("Initializing connection and preparing the device...");
        hub.connectAndSend(device, "temperature=25.6");

        System.out.println("\nAll done! The device " + device.getName() + " is now connected and ready to use.\n");
        System.out.println("Thank you for using Smart Home Hub.");

        sc.close();
    }
}
