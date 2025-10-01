public class StudentLearningSession {
    private String studentName;
    private LearningStrategy strategy;

    public StudentLearningSession(String studentName) {
        this.studentName = studentName;
    }

    public void setStrategy(LearningStrategy strategy) {
        this.strategy = strategy;
    }

    public void startLearning() {
        if (strategy != null) {
            strategy.learn(studentName);
        } else {
            System.out.println("No learning strategy assigned yet!");
        }
    }
}
