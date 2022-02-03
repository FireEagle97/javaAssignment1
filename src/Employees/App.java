package Employees;

import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @authors Cuneyt Yildirim && Dany Makhoul && Kyle Verso
 * @description
 * @version
 * @date
 * 
 */
public class App {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        employees[0] = new PartTimeEmployee(123, "Tom1", "Brown Part", 64);
        employees[1] = new FullTimeEmployee(124, "Tess", "Lake Full", 43);
        employees[2] = new PartTimeEmployee(125, "Nessie", "Lessie Part", 54);

        Console console = System.console();
        Bill[] bills = new Bill[10];

        String employeeName = console.readLine("Enter your name. ");

        //Salutation for new coming employee
        System.out.println(salutation(employeeName, 1));
        //
        System.out.println(createEmptyLine());
        // Helper method for UI menu
        UImenu(employees, bills, console);

        // Salutation for the leaving employee
        System.out.println(salutation(employeeName, 0));
    }

    /**
     * 
     * @param employees
     * @param bills
     * @param console
     */
    public static void UImenu(Employee[] employees, Bill[] bills, Console console) {

        System.out.println("Please select one of the following option!");
        String option = null;

        // Gets from the user a correct information
        do {
            option = console.readLine(
                    "1. Add a new employee\n2. Add a new bill.\n3. Issue check\n4. Employees info\n5. Bills' history\n6. exit\n");
            System.out.println(createEmptyLine());
            switch (option) {
                case "1":
                    employees = createEmployee(employees, console);
                    break;
                case "2":
                    bills = createBill(employees, bills, console);
                    break;
                case "3":
                    checkIssue(console);
                    break;
                case "4":
                    displayAllEmployees(employees);
                    break;
                case "5":
                    displayAllBills(bills);
                    break;
            }
        } while (!option.equals("6"));
    }

    /**
     * Creates and add an array an employee
     * 
     * @param employees
     * @param console
     * @return created employees
     */
    public static Employee[] createEmployee(Employee[] employees, Console console) {
        // Console console = System.console();
        String employeeType = null;

        // verify to customer add correct letter
        do {
            employeeType = console.readLine("Please type of Employee. 'F'/'P' ").toLowerCase();
        } while (!employeeType.equals("f") && !employeeType.equals("p"));

        // Gets employee information
        String fname = console.readLine("What is first name of employee?\n");
        String lname = console.readLine("What is last name of employee?\n");
        int age = Integer.parseInt(console.readLine("What is age of " + fname + " " + lname + ".\n"));
        int id = Integer.parseInt(console.readLine("What is the id of " + fname + " " + lname + ".\n"));
        System.out.println(createEmptyLine());

        // Creating new employee based on his type
        if (employeeType.equals("p")) {
            // Looking for empty slot in the to add the new employee
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] == null) {
                    employees[i] = new PartTimeEmployee(id, fname, lname, age);
                    System.out.println(employees[i].toString());
                    break;
                }
            }
            System.out.println(createEmptyLine());
        } else {
            // Looking for empty slot in the to add the new employee
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] == null) {
                    employees[i] = new FullTimeEmployee(id, fname, lname, age);
                    System.out.println(employees[i].toString());
                    break;
                }
            }

            System.out.println(createEmptyLine());
        }

        return employees;
    }

    /**
     * Checks the any issue about the check
     * 
     * @param console
     */
    public static void checkIssue(Console console) {

    }

    /**
     * Creates a bill to paying for the company or employee
     * @param employees
     * @param bills
     * @param console to get information from the user
     */
    public static Bill[] createBill(Employee[] employees, Bill[] bills, Console console) {

        String nameBill = console
                .readLine("Enter a company name to be billed! if the employee payment please enter F/f\n")
                .toLowerCase();
        if (!nameBill.equals("f")) {
            for (int i = 0; i < bills.length; i++) {
                if (bills[i] == null) {
                    int amount = Integer.parseInt(console.readLine("Enter a amount of the bill\n"));
                    bills[i] = new Bill(nameBill, amount);
                    break;
                }
            }

        } else {
            int employeeId = Integer
                    .parseInt(console.readLine("Enter Id of employee ID to pay his/her monthly pay-check\n"));
            for (Employee employee : employees) {
                if (employee != null && employee.getID() == employeeId) {
                    for (int i = 0; i < bills.length; i++) {
                        if (bills[i] == null) {
                            int amount = Integer.parseInt(console.readLine("Enter a amount of the bill\n"));
                            bills[i] = new Bill(employee.getFirstName() + ' ' + employee.getLastName(), amount);
                            break;
                        }
                    }

                }
            }

        }
        return bills;
    }

    /**
     * Displays all bill history
     * 
     * @param employees
     */
    public static void displayAllBills(Bill[] bills) {
        for (Bill bill : bills) {
            if (bill != null) {
                System.out.println(bill.toString());
            }
        }
    }

    /**
     * Display all employees information
     * 
     * @param employees
     */
    public static void displayAllEmployees(Employee[] employees) {
        // int employeeCounter = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                // employeeCounter +=1;
                System.out.println(employee.toString());
                System.out.println("\n".repeat(2));
            }
        }
        // System.out.println("You have "+employeeCounter+" employees work in your
        // company");
        System.out.println(createEmptyLine());
    }

    /**
     * Salutation for employee
     * 
     * @param empName
     * @param exitcode
     * @return Based on the situation creates for the user a salutation message
     * 
     */
    public static String salutation(String empName, int exitcode) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String today = sdf.format(date);
        if (exitcode == 0) {
            return "God bye see you next time " + empName + ", and today is " + today;
        } else {
            return "Hello! " + empName + ", and today is " + date;
        }
    }

    /**
     * Creates empty line for better visualization
     * 
     * @return
     */
    public static String createEmptyLine() {
        String emptyLines = "=================";
        for (int i = 0; i < 3; i++) {
            emptyLines += "\n";
        }
        emptyLines += "=================";
        return emptyLines;
    }
}
