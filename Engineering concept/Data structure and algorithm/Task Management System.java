class Task {

    int taskId;
    String taskName;
    String status;

    Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public String toString() {
        return "Task ID: " + taskId +
               ", Task Name: " + taskName +
               ", Status: " + status;
    }
}

// Node Class
class Node {

    Task task;
    Node next;

    Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

// Singly Linked List
class TaskManagement {

    Node head;

    // Add Task
    public void addTask(Task task) {

        Node newNode = new Node(task);

        if (head == null) {
            head = newNode;
        } else {

            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }

        System.out.println("Task Added Successfully");
    }

    // Search Task
    public void searchTask(int id) {

        Node temp = head;

        while (temp != null) {

            if (temp.task.taskId == id) {
                System.out.println("Task Found");
                System.out.println(temp.task);
                return;
            }

            temp = temp.next;
        }

        System.out.println("Task Not Found");
    }

    // Traverse Tasks
    public void displayTasks() {

        if (head == null) {
            System.out.println("No Tasks Available");
            return;
        }

        Node temp = head;

        System.out.println("\nTask List:");

        while (temp != null) {
            System.out.println(temp.task);
            temp = temp.next;
        }
    }

    // Delete Task
    public void deleteTask(int id) {

        if (head == null) {
            System.out.println("Task List Empty");
            return;
        }

        // Delete first node
        if (head.task.taskId == id) {
            head = head.next;
            System.out.println("Task Deleted Successfully");
            return;
        }

        Node temp = head;

        while (temp.next != null &&
               temp.next.task.taskId != id) {

            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Task Not Found");
        } else {
            temp.next = temp.next.next;
            System.out.println("Task Deleted Successfully");
        }
    }
}

public class Main {

    public static void main(String[] args) {

        TaskManagement manager = new TaskManagement();

        manager.addTask(
                new Task(101, "Design Database", "Pending"));

        manager.addTask(
                new Task(102, "Develop API", "In Progress"));

        manager.addTask(
                new Task(103, "Testing", "Pending"));

        manager.displayTasks();

        System.out.println("\nSearching Task 102:");
        manager.searchTask(102);

        System.out.println("\nDeleting Task 102:");
        manager.deleteTask(102);

        manager.displayTasks();
    }
}