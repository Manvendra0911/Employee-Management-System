import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();

        int choice;

        do {

            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            // Add Employee
            if (choice == 1) {

                System.out.print("Enter Employee ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Employee Name: ");
                String employeeName = sc.nextLine();

                System.out.print("Enter Employee Salary: ");
                double salary = sc.nextDouble();

                boolean exists = false;

                for (Employee employee : employees) {

                    if (employee.id == id) {
                        exists = true;
                        break;
                    }
                }

                if (exists) {

                    System.out.println("Employee ID already exists!");

                } else {

                    Employee e1 = new Employee(id, employeeName, salary);

                    employees.add(e1);

                    System.out.println("Employee Added Successfully!");
                }
            }

            // View Employees
            if (choice == 2) {

                if (employees.isEmpty()) {
                    System.out.println("No Employees Found!");
                } else {

                    System.out.println("\nEmployee List:");

                    for (Employee employee : employees) {

                        System.out.println("ID: " + employee.id);
                        System.out.println("Name: " + employee.name);
                        System.out.println("Salary: " + employee.salary);
                        System.out.println();
                    }
                }
            }

            // Search Employee
            if (choice == 3) {

                System.out.print("Enter Employee ID to Search: ");
                int searchId = sc.nextInt();

                boolean found = false;

                for (Employee employee : employees) {

                    if (employee.id == searchId) {

                        System.out.println("\nEmployee Found:");
                        System.out.println("ID: " + employee.id);
                        System.out.println("Name: " + employee.name);
                        System.out.println("Salary: " + employee.salary);

                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Employee Not Found!");
                }
            }

            // Delete Employee
            if (choice == 4) {

                System.out.print("Enter Employee ID to Delete: ");
                int deleteId = sc.nextInt();

                boolean deleted = false;

                for (int i = 0; i < employees.size(); i++) {

                    if (employees.get(i).id == deleteId) {

                        employees.remove(i);
                        deleted = true;

                        System.out.println("Employee Deleted Successfully!");
                        break;
                    }
                }

                if (!deleted) {
                    System.out.println("Employee Not Found!");
                }
            }

            if (choice < 1 || choice > 5) {
                System.out.println("Invalid Choice! Please enter a number between 1 and 5.");
            }

        } while (choice != 5);

        sc.close();
        System.out.println("Program Ended");
    }
}