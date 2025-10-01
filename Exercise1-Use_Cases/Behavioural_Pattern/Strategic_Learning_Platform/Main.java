import java.util.Scanner;

public class Main {

    public static LearningStrategy decideStrategy(
            String preference, double quizPerformance, int engagement, double completionRate,
            int attentionSpan, int confidence, int motivation, int stress, String goal, int timeAvailable) {

        if (stress > 7) {
            return new KinestheticLearningStrategy();
        } else if (preference.equalsIgnoreCase("video") || quizPerformance < 0.5) {
            return new VisualLearningStrategy();
        } else if (preference.equalsIgnoreCase("audio")) {
            return new AuditoryLearningStrategy();
        } else if (preference.equalsIgnoreCase("group") || motivation < 5) {
            return new SocialLearningStrategy();
        } else if (preference.equalsIgnoreCase("independent") || confidence > 7) {
            return new SelfPacedLearningStrategy();
        } else if (goal.equalsIgnoreCase("exam") && timeAvailable < 2) {
            return new SelfPacedLearningStrategy();
        } else if (goal.equalsIgnoreCase("project") && engagement < 15) {
            return new KinestheticLearningStrategy();
        } else if (attentionSpan < 10) {
            return new KinestheticLearningStrategy();
        } else {
            return new VisualLearningStrategy(); // default fallback
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        // Initial inputs
        System.out.print("Enter quiz performance (0-1): ");
        double quizPerformance = sc.nextDouble();

        System.out.print("Enter engagement time (minutes): ");
        int engagement = sc.nextInt();

        System.out.print("Enter completion rate (0-1): ");
        double completionRate = sc.nextDouble();

        System.out.print("Enter preferred content type (text/video/audio/group/independent): ");
        String preference = sc.next();

        System.out.print("Enter attention span (minutes before distraction): ");
        int attentionSpan = sc.nextInt();

        System.out.print("Enter confidence level (1-10): ");
        int confidence = sc.nextInt();

        System.out.print("Enter motivation level (1-10): ");
        int motivation = sc.nextInt();

        System.out.print("Enter stress level (1-10): ");
        int stress = sc.nextInt();

        System.out.print("Enter learning goal (exam/job/project/curiosity): ");
        String goal = sc.next();

        System.out.print("Enter time available per day (hours): ");
        int timeAvailable = sc.nextInt();

        StudentLearningSession session = new StudentLearningSession(name);

        // First strategy decision
        session.setStrategy(decideStrategy(preference, quizPerformance, engagement, completionRate,
                attentionSpan, confidence, motivation, stress, goal, timeAvailable));

        System.out.println("\n--- Adaptive Learning Session Start ---");
        session.startLearning();

        // Simulate mid-session reevaluation
        System.out.println("\n--- Mid-session Evaluation ---");
        System.out.print("Update stress level (1-10): ");
        stress = sc.nextInt();
        System.out.print("Update motivation level (1-10): ");
        motivation = sc.nextInt();
        System.out.print("Update quiz performance (0-1): ");
        quizPerformance = sc.nextDouble();

        // Switch strategy dynamically
        session.setStrategy(decideStrategy(preference, quizPerformance, engagement, completionRate,
                attentionSpan, confidence, motivation, stress, goal, timeAvailable));

        System.out.println("\n--- Updated Learning Strategy ---");
        session.startLearning();

        sc.close();
    }
}
