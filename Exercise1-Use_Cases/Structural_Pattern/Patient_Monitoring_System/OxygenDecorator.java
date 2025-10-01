

import java.util.Scanner;

public class OxygenDecorator extends MonitorDecorator {
    private int oxygenLevel; // %

    public OxygenDecorator(PatientMonitor monitor, Scanner sc) {
        super(monitor);
        System.out.print("Enter Oxygen Level (%): ");
        this.oxygenLevel = sc.nextInt();
        sc.nextLine();
    }

    @Override
    public void monitor() {
        super.monitor();
        System.out.println("Adding Oxygen Level monitoring: " + oxygenLevel + "%");
    }

    @Override
    public void evaluate() {
        super.evaluate();
        System.out.print("Oxygen condition: ");
        if (oxygenLevel < 90) {
            System.out.println("Low oxygen! Immediate attention required.");
        } else {
            System.out.println("Oxygen level normal.");
        }
    }
}
