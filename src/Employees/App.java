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

        Console console = System.console();
        String employeeName = console.readLine("Enter your name. ");

        //Greetings for Hello
        System.out.println(greetings(employeeName, 1));
        //
        System.out.println(createEmptyLine());
        //Helper method for UI menu
        UImenu(employees, console);
       
        //Greetings for good bye!
        System.out.println(greetings(employeeName, 0));
    }

    
    public static void UImenu(Employee[] employees, Console console) {

        System.out.println("Please select one of the following option!");
        String option = null;

        //Gets from the user a correct information
        do {
            option = console.readLine(
                    "1. Add a new employee\n2. Add a new bill.\n3. Issue check\n4. Employees info\n5. Bills' history\n6. exit\n");
            System.out.println(createEmptyLine());
            switch (option) {
                case "1":
                    employees = createEmployee(employees);
                    break;
                case "2":
                    createBill();
                    break;
                case "3":
                    checkIssue();
                    break;
                case "4":
                    displayAllEmployees(employees);
                    break;
                case "5":
                    displayAllBills(employees);
                    break;
            }
        } while (!option.equals("6"));
    }



    public static void displayAllBills(Employee[] employees) {
        

    }

    public static void displayAllEmployees(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee != null) {

                System.out.println(employee.toString());
                createEmptyLine();
            }
        }

        
    }
    public static void checkIssue() {
        Console console = System.console();

        
    }

    public static void createBill() {
        Console console = System.console();
        String nameBill = console.readLine("Enter a bill company! ");
        System.out.println(nameBill);
    }
    
    public static Employee[] createEmployee(Employee[] employees) {
        Console console = System.console();
        String employeeType = null;

        //verify to customer add correct letter
        do {
            employeeType = console.readLine("Please type of Employee. 'F'/'P' ").toLowerCase();        
        } while (!employeeType.equals("f") && !employeeType.equals("p"));

        //Gets employee information
        String fname = console.readLine("What is first name of employee?\n");
        String lname = console.readLine("What is last name of employee?\n");
        int age = Integer.parseInt(console.readLine("What is age of " + fname + " " + lname+".\n"));
        int id = Integer.parseInt(console.readLine("What is the id of " + fname + " " + lname+".\n"));
        System.out.println(createEmptyLine());
       
        //Creating new employee based on his type
        if (employeeType.equals("p")) {
            //Looking for empty slot in the to add the new employee 
            for (int i = 0; i < employees.length;i++) {
                if (employees[i] == null) {
                    employees[i] = new PartTimeEmployee(id, fname, lname, age);
                    System.out.println(employees[i].toString());
                    break;
                }
            }
            System.out.println(createEmptyLine());
        } else {
            //Looking for empty slot in the to add the new employee 
            for (int i = 0;i< employees.length;i++) {
                if (employees[i] == null) {
                    employees[i] = new FullTimeEmployee(id, fname, lname, age);
                    System.out.println(employees[i].toString());
                    break;
                }
            }
            
            System.out.println(createEmptyLine());
        }
        // for (Employee employee : employees) {
        //     System.out.println(employee.toString());
        // }

        return employees;
    }
    public static void menu() {
      

    }
    
    public static String greetings(String empName,int exitcode) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String today = sdf.format(date);
        if (exitcode == 0) {
            return "God bye see you next time " + empName + ", and today is " + date;        
        } else {
            return "Hello! " + empName + ", and today is " + date;
        }
    }
    
    public static String createEmptyLine() {
        String emptyLines = "=================";
        for (int i = 0; i < 3; i++) {
            emptyLines += "\n";
        }
        emptyLines += "=================";
        return emptyLines;
    }
}
