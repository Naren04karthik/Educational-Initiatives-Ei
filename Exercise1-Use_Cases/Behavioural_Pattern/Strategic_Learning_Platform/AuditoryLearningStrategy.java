public class AuditoryLearningStrategy implements LearningStrategy {
    @Override
    public void learn(String studentName) {
        System.out.println(studentName + " is learning through Auditory methods (podcasts, verbal explanations).");
    }
}
