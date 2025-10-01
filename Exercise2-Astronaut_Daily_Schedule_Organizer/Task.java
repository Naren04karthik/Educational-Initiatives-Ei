// Task.java
// This class represents a single astronaut's task with attributes like description, time, priority, and completion status.
// It is a simple POJO (Plain Old Java Object) following OOP encapsulation.

import java.time.LocalTime;

public class Task {
    // Task details
    private String description;
    private LocalTime startTime;
    private LocalTime endTime;
    private String priority;
    private boolean isCompleted;

    // Constructor initializes a new task
    public Task(String description, LocalTime startTime, LocalTime endTime, String priority) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
        this.isCompleted = false; // default when task is created
    }

    // Getters
    public String getDescription() { return description; }
    public LocalTime getStartTime() { return startTime; }
    public LocalTime getEndTime() { return endTime; }
    public String getPriority() { return priority; }
    public boolean isCompleted() { return isCompleted; }

    // Mark task as completed
    public void markCompleted() { this.isCompleted = true; }

    // Edit task details
    public void edit(String desc, LocalTime start, LocalTime end, String priority) {
        this.description = desc;
        this.startTime = start;
        this.endTime = end;
        this.priority = priority;
    }

    // String representation for easy printing
    @Override
    public String toString() {
        return startTime + " - " + endTime + ": " + description + 
               " [" + priority + "]" + (isCompleted ? "Completed" : "");
    }
}
