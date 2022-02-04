package Employees;

import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProcessOfApp {
      

    /**
     * Displays a menu to get user's request
     * @param employees
     * @param bills
     * @param console
     */
    public void UImenu(Employee[] employees, Bill[] bills, Console console) {
createEmptyLine();
        System.out.println("Please select one of the following option!");
        String option = null;

        // Gets from the user a correct information
        do {
            option = console.readLine(
                    "1. Add a new employee\n2. Add a new bill.\n3. Issue check\n4. Employees info\n5. Bills' history\n6. exit\n");
            createEmptyLine();
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
     * @param employees
     * @param console to get information from the user
     * @return created employees
     */
    public Employee[] createEmployee(Employee[] employees, Console console) {
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
        createEmptyLine();

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
            createEmptyLine();
        } else {
            // Looking for empty slot in the to add the new employee
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] == null) {
                    employees[i] = new FullTimeEmployee(id, fname, lname, age);
                    System.out.println(employees[i].toString());
                    break;
                }
            }
            createEmptyLine();
        }
        return employees;
    }

    /**
     * Checks the any issue about the check
     * @param console to get information from the user
     */
    public static void checkIssue(Console console) {

    }

    /**
     * Creates a bill to paying for the company or employee
     * @param employees
     * @param bills
     * @param console to get information from the user
     */
    public Bill[] createBill(Employee[] employees, Bill[] bills, Console console) {
        //Gets proper information for the user that what's the bill about
        String nameBill = console
                .readLine("Enter a company name to be billed!\nif you want an employee payment please enter e/E\n")
                .toLowerCase();
        //To a company payment 
        if (!nameBill.equals("e")) {
            for (int i = 0; i < bills.length; i++) {
                if (bills[i] == null) {
                    double amount = Double.parseDouble(console.readLine("Enter a amount of the bill\n"));
                    bills[i] = new Bill(nameBill, amount);
                    break;
                }
            }
        }
        //To regular employee payment
        else {
            //gets employee ID to search for it
            int employeeId = Integer
                    .parseInt(console.readLine("Enter Id of employee ID to pay his/her monthly pay-check\n"));
            for (Employee employee : employees) {
                //Checks given id exist or not
                if (employee != null && employee.getID() == employeeId) {
                    for (int i = 0; i < bills.length; i++) {
                        //checks first available spot in Bill array
                        if (bills[i] == null) {
                            //Checks the employee type to calculate his/her salary and then creates a new Bill object
                            if (employees[i] instanceof PartTimeEmployee) {
                                double amount = employees[i].calculateSalary();
                                bills[i] = new Bill(nameBill, amount);
                                break;
                            } else {
                                double amount = employees[i].calculateSalary();
                                bills[i] = new Bill(nameBill, amount);
                                break;
                            }
                        }
                    }
                }
                else {
                    System.out.println("Does not an employee to provided id");
                }
            }
        }
        return bills;
    }

    /**
     * Displays all created bills history
     * @param employees
     */
    public void displayAllBills(Bill[] bills) {
        int billCounter = 0;
        for (Bill bill : bills) {
            //Check the bill does exist or not
            if (bill != null) {
                System.out.println(bill.toString());
                billCounter++;
                System.out.println("\n".repeat(2));
            }
        }
        //Display total bills number
        System.out.println("You have processed total "+billCounter+" bills");
    }

    /**
     * Display all employees information
     * @param employees 
     */
    public void displayAllEmployees(Employee[] employees) {
        int employeeCounter = 0;
        //loop over employees
        for (Employee employee : employees) {
            //check an employee does exist
            if (employee != null) {
                employeeCounter += 1;
                System.out.println(employee.toString());
                System.out.println("\n".repeat(2));
            }
        }
        //Displays total employees number
        System.out.println("You have "+employeeCounter+" employees work in your company");
        createEmptyLine();
    }

    /**
     * Salutation for employee
     * @param empName
     * @param exitcode
     * @return Based on the situation creates for the user a salutation message
     */
    public String salutation(String empName, int exitcode) {
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
     * @return provided a better visual environment
     */
    public static void createEmptyLine() {
        for (int j = 0; j < 50; j++) {
            System.out.print("=");
        }
        System.out.println();
        for (int i = 0; i < 4; i++) {
            System.out.println();
        }
    }
        
}
