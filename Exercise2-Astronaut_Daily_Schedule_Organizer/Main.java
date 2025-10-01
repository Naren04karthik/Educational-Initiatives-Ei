// Main.java
// Entry point for the program.
// Provides menu-driven console UI for astronaut schedule management.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Get singleton instance of ScheduleManager
        ScheduleManager manager = ScheduleManager.getInstance();

        // Attach conflict observer for notifications
        manager.addObserver(new ConflictObserver());

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        // Menu loop (controlled by "running" flag, not while(true))
        while (running) {
            System.out.println("\n--- Astronaut Daily Schedule Organizer ---");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. Edit Task");
            System.out.println("4. Mark Task Completed");
            System.out.println("5. View All Tasks");
            System.out.println("6. View Tasks by Priority");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter description: ");
                        String desc = sc.nextLine();
                        System.out.print("Enter start time (HH:mm): ");
                        String start = sc.nextLine();
                        System.out.print("Enter end time (HH:mm): ");
                        String end = sc.nextLine();
                        System.out.print("Enter priority (High/Medium/Low): ");
                        String priority = sc.nextLine();
                        Task task = TaskFactory.createTask(desc, start, end, priority);
                        manager.addTask(task);
                        System.out.println("Task added successfully.No conflicts.");
                    }
                    case 2 -> {
                        System.out.print("Enter description to remove: ");
                        manager.removeTask(sc.nextLine());
                        System.out.println("Task removed successfully.");
                    }
                    case 3 -> {
                        System.out.print("Enter existing task description to edit: ");
                        String oldDesc = sc.nextLine();
                        System.out.print("Enter new description: ");
                        String desc = sc.nextLine();
                        System.out.print("Enter start time (HH:mm): ");
                        String start = sc.nextLine();
                        System.out.print("Enter end time (HH:mm): ");
                        String end = sc.nextLine();
                        System.out.print("Enter priority (High/Medium/Low): ");
                        String priority = sc.nextLine();
                        Task newTask = TaskFactory.createTask(desc, start, end, priority);
                        manager.editTask(oldDesc, newTask);
                        System.out.println("Task edited successfully.");
                    }
                    case 4 -> {
                        System.out.print("Enter description to mark completed: ");
                        manager.markTaskCompleted(sc.nextLine());
                        System.out.println("Task marked completed.");
                    }
                    case 5 -> {
                        if (manager.viewTasks().isEmpty()) {
                            System.out.println("No tasks scheduled for the day.");
                        } else {
                            manager.viewTasks().forEach(System.out::println);
                        }
                    }
                    case 6 -> {
                        System.out.print("Enter priority (High/Medium/Low): ");
                        String priority = sc.nextLine();
                        var tasks = manager.viewTasksByPriority(priority);
                        if (tasks.isEmpty()) {
                            System.out.println("No tasks with priority " + priority + ".");
                        } else {
                            tasks.forEach(System.out::println);
                        }
                    }
                    case 7 -> running = false;
                    default -> System.out.println("Invalid choice. Try again.");
                }
            } catch (CustomException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        sc.close();
        System.out.println("Exiting Astronaut Schedule Organizer. Goodbye!");
    }
}
