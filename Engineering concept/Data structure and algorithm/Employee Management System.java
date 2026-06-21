class Employee {

    int employeeId;
    String name;
    String position;
    double salary;

    Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + employeeId +
               ", Name: " + name +
               ", Position: " + position +
               ", Salary: " + salary;
    }
}

class EmployeeManagement {

    Employee[] employees = new Employee[10];
    int count = 0;

    // Add Employee
    public void addEmployee(Employee e) {

        if (count < employees.length) {
            employees[count] = e;
            count++;
            System.out.println("Employee Added Successfully");
        } else {
            System.out.println("Array is Full");
        }
    }

    // Search Employee
    public void searchEmployee(int id) {

        for (int i = 0; i < count; i++) {

            if (employees[i].employeeId == id) {
                System.out.println("Employee Found");
                System.out.println(employees[i]);
                return;
            }
        }

        System.out.println("Employee Not Found");
    }

    // Display Employees
    public void displayEmployees() {

        if (count == 0) {
            System.out.println("No Employees Available");
            return;
        }

        System.out.println("\nEmployee Records:");

        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete Employee
    public void deleteEmployee(int id) {

        int index = -1;

        for (int i = 0; i < count; i++) {

            if (employees[i].employeeId == id) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Employee Not Found");
            return;
        }

        for (int i = index; i < count - 1; i++) {
            employees[i] = employees[i + 1];
        }

        employees[count - 1] = null;
        count--;

        System.out.println("Employee Deleted Successfully");
    }
}

public class Main {

    public static void main(String[] args) {

        EmployeeManagement manager = new EmployeeManagement();

        // Add Employees
        manager.addEmployee(new Employee(101, "Sethu", "Developer", 50000));
        manager.addEmployee(new Employee(102, "Arun", "Tester", 40000));
        manager.addEmployee(new Employee(103, "Rahul", "Manager", 70000));

        // Display Employees
        manager.displayEmployees();

        // Search Employee
        System.out.println("\nSearching Employee with ID 102:");
        manager.searchEmployee(102);

        // Delete Employee
        System.out.println("\nDeleting Employee with ID 102:");
        manager.deleteEmployee(102);

        // Display After Deletion
        manager.displayEmployees();
    }
}