// Main class to run the interactive Smart Building Management System
public class Main {
    public static void main(String[] args) {
        Campus campus = SmartBuildingClient.setupCampus();
        SmartBuildingClient.runMenu(campus);
    }
}
