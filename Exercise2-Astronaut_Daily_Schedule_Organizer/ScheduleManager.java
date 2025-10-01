
// ScheduleManager.java
// Singleton Pattern - Only one instance of schedule manager exists.
// Manages all tasks, validates conflicts, provides CRUD operations.

import java.util.*;
import java.util.logging.Logger;

public class ScheduleManager {
    private static ScheduleManager instance; // Singleton instance
    private final List<Task> tasks;          // List of tasks
    private final List<Observer> observers;  // List of observers (e.g., conflict notifier)
    private static final Logger logger = LoggerUtil.getLogger(ScheduleManager.class.getName());

    // Private constructor ensures only one instance is created
    private ScheduleManager() {
        tasks = new ArrayList<>();
        observers = new ArrayList<>();
    }

    // Public method to get singleton instance
    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    // Add observer (like conflict notifications)
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Notify all observers
    private void notifyObservers(String message) {
        for (Observer o : observers) {
            o.notify(message);
        }
    }

    // Add a new task with conflict validation
    public void addTask(Task task) throws CustomException {
        for (Task t : tasks) {
            // Check for overlap
            boolean overlap = !(task.getEndTime().isBefore(t.getStartTime()) || 
                                task.getStartTime().isAfter(t.getEndTime()));
            if (overlap) {
                String msg = "Task conflicts with existing task \"" + t.getDescription() + "\".";
                logger.warning(msg);
                notifyObservers(msg);
                throw new CustomException(msg);
            }
        }
        tasks.add(task);
        tasks.sort(Comparator.comparing(Task::getStartTime)); // Sort tasks by start time
        logger.info("Task added: " + task.getDescription());
    }

    // Remove a task
    public void removeTask(String description) throws CustomException {
        Optional<Task> task = tasks.stream()
                .filter(t -> t.getDescription().equalsIgnoreCase(description))
                .findFirst();
        if (task.isPresent()) {
            tasks.remove(task.get());
            logger.info("Task removed: " + description);
        } else {
            throw new CustomException("Task not found.");
        }
    }

    // Edit an existing task
    public void editTask(String oldDesc, Task newTask) throws CustomException {
        removeTask(oldDesc);   // First remove the old task
        addTask(newTask);      // Then add the new task
    }

    // Mark a task as completed
    public void markTaskCompleted(String description) throws CustomException {
        for (Task t : tasks) {
            if (t.getDescription().equalsIgnoreCase(description)) {
                t.markCompleted();
                logger.info("Task marked completed: " + description);
                return;
            }
        }
        throw new CustomException("Task not found.");
    }

    // View all tasks
    public List<Task> viewTasks() {
        return tasks;
    }

    // View tasks filtered by priority
    public List<Task> viewTasksByPriority(String priority) {
        List<Task> filtered = new ArrayList<>();
        for (Task t : tasks) {
            if (t.getPriority().equalsIgnoreCase(priority)) {
                filtered.add(t);
            }
        }
        return filtered;
    }
}
