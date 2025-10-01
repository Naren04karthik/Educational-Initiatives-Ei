import java.util.Scanner;

public class BloodSugarDecorator extends MonitorDecorator {
    private int sugarLevel; // mg/dL

    public BloodSugarDecorator(PatientMonitor monitor, Scanner sc) {
        super(monitor);
        System.out.print("Enter Blood Sugar (mg/dL): ");
        this.sugarLevel = sc.nextInt();
        sc.nextLine();
    }

    @Override
    public void monitor() {
        super.monitor();
        System.out.println("Adding Blood Sugar monitoring: " + sugarLevel + " mg/dL");
    }

    @Override
    public void evaluate() {
        super.evaluate();
        System.out.print("Blood Sugar condition: ");
        if (sugarLevel < 80 || sugarLevel > 140) {
            System.out.println("Abnormal sugar level detected!");
        } else {
            System.out.println("Blood sugar normal.");
        }
    }
}
