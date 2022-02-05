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
    public void UImenu(Company company, Console console) {
        createEmptyLine();
        System.out.println("Please select one of the following option!");
        String option = null;


        // Gets from the user a correct information
        do {
            option = console.readLine(
                    "1. Add a new employee\n2. Create Bill\n3. Issue check\n4. Employees info\n5. Bills' history\n6. exit\n");
            createEmptyLine();
            switch (option) {
                //Add a new employee option
                case "1":
                    createEmployee(company, console);
                    break;
                case "2":
                    createBill(company, console);
                    break;
                case "3":
                    company.issueChecks();
                    break;
                case "4":
                    displayAllEmployees(company);
                    break;
                case "5":
                    displayAllBills(company);
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
    public Payable[] createEmployee(Company company, Console console) {
        String employeeType = null;
        Payable[] expenses = company.getExpenses();
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
        // Looking for empty slot in the to add the new employee
        for (int i = 0; i < expenses.length; i++) {
            if (expenses[i] == null) {
                if (employeeType.equals("p")) {
                    expenses[i] = new PartTimeEmployee(id, fname, lname, age);
                }
                else {
                    expenses[i] = new FullTimeEmployee(id, fname, lname, age);
                }
                System.out.println(expenses[i].toString());
                break;
            }
        }
        return expenses;
    }

    /**
     * Creates a bill to paying for the company or employee
     * @param employees
     * @param bills
     * @param console to get information from the user
     */
    public Payable[] createBill(Company company, Console console) {

        Payable[] expenses = company.getExpenses();
        //Gets proper information for the user that what's the bill about
        String nameBill = console
                .readLine("Enter a company name to be billed!\n or if you want an employee payment please enter e/E\n")
                .toLowerCase();
        //To a company payment 
        if (!nameBill.equals("e")) {
            for (int i = 0; i < expenses.length; i++) {
                if (expenses[i] == null) {
                    double amount = Double.parseDouble(console.readLine("Enter a amount of the bill\n"));
                    expenses[i] = new Bill(nameBill, amount);
                    break;
                }
            }
        }
        return expenses;
    }
    // public Payable[] issueCheck(Payable[] expenses, Console console){
    //     //To regular employee payment
    //         //gets employee ID to search for it
    //         int employeeId = Integer
    //                 .parseInt(console.readLine("Enter Id of employee ID to pay his/her monthly pay-check\n"));
    //         for (Payable expense : expenses) {
    //             //Checks given id exist or not
    //             if (expense != null && expense.getID() == employeeId) {
    //                 for (int i = 0; i < expenses.length; i++) {
    //                     //checks first available spot in Bill array
    //                     if (expenses[i] == null) {
    //                         //Checks the employee type to calculate his/her salary and then creates a new Bill object
    //                         // expense = Employee | Bill | null
    //                         if (expenses[i] instanceof PartTimeEmployee) {
    //                             double amount = (expenses[i]).calculateSalary();
    //                             expenses[i] = new Employee(nameBill, amount);
    //                             break;
    //                         } else if(expenses[i] instanceof FullTimeEmployee)
    //                             double amount = employees[i].calculateSalary();
    //                             bills[i] = new Bill(nameBill, amount);
    //                             break;
    //                         }
                            
    //                     }
    //                 }
    //             }
    //             else {
    //                 System.out.println("Does not an employee to provided id");
    //             }
    //         }
    //     return expenses;
    // }

    /**
     * Displays all employees
     * @param employees
     */
    public void displayAllEmployees(Company company) {
        Payable[] expenses = company.getExpenses();
        int employeeCounter = 0;
        int fullTimeCounter = 0;
        int partTimeCounter = 0;
        for (Payable expense : expenses) {
            //Check the bill does exist if the expense is an employee
            if (expense != null) {
                if (expense instanceof FullTimeEmployee) {
                    System.out.println(expense);
                    fullTimeCounter++;
                } else if (expense instanceof PartTimeEmployee) {
                    System.out.println(expense);
                    partTimeCounter++;
                }
                employeeCounter++;
                System.out.println("\n".repeat(2));
            }

        }
        //Display total employees
        System.out.println("Total employees: " + employeeCounter + " | # full time: " + fullTimeCounter + " | # part time: " + partTimeCounter);
    }

    /**
     * Displays all created bills history
     * @param employees
     */
    public void displayAllBills(Company company) {
        Payable[] expenses = company.getExpenses();
        int billCounter = 0;
        for (Payable expense : expenses) {
            //Check the bill does exist and if the expense is a bill
            if (expense != null && expense instanceof Bill) {
                System.out.println(expense);
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
    // public void displayAllEmployees(Payable[] expenses) {
    //     int employeeCounter = 0;
    //     //loop over employees
    //     for (Employee employee : employees) {
    //         //check an employee does exist
    //         if (employee != null) {
    //             employeeCounter += 1;
    //             System.out.println(employee.toString());
    //             System.out.println("\n".repeat(2));
    //         }
    //     }
    //     //Displays total employees number
    //     System.out.println("You have "+employeeCounter+" employees work in your company");
    //     createEmptyLine();
    // }

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
            return "Good bye see you next time " + empName + ", and today is " + today;
        } else {
            return "Hello! " + empName + ", and today is " + today;
        }
    }

    /**
     * Creates empty line for better visualization
     * @return provided a better visual environment
     */
    public static void createEmptyLine() {
        System.out.print("==================================================");
        System.out.println();
        for (int i = 0; i < 4; i++) {
            System.out.println();
        }
    }
        
}
