package Employees;

import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.security.auth.callback.LanguageCallback;

/**
 * @authors Cuneyt Yildirim && Dany Makhoul && Kyle Verso
 * @description
 * @version
 * @date
 * 
 */
public class App {
    public static void main(String[] args) {
        Employee employee = null;

        Console console = System.console();
        String employeeName = console.readLine("Enter your name. ");
        System.out.println(greetings(employeeName,1));
        System.out.println(createEmptyLine());
        System.out.println("Please select one of the following option!");

        String option = null;
        do {
            option = console.readLine("1. Add a new employee\n2. Add a new bill.\n3. Issue check\n4. exit\n");
            System.out.println(createEmptyLine());
            switch (option) {
                case "1":
                    createEmployee(employee);
                    break;
                case "2":
                    createBill();
                    break;
                case "3":
                    checkIssue();
                    break;
                case "4":
                    displayAllEmployees(employee);
                    break;
                case "5":
                    displayAllBills(employee);
                    break;
            }
        } while (!option.equals("4"));

        // int check = 0;
        // FullTimeEmployee fullemp = new FullTimeEmployee(12, "full1a", "full1b", 32, check);
        // PartTimeEmployee pemp = new PartTimeEmployee(13, "test", "lname", 32, check);
        // Bill bill = new Bill("Hydro", 123, check);

        // System.out.println(pemp.calculateSalary(21, 2));
        // pemp.incerement();
        // System.out.println(pemp.getCheckNumber());
        // fullemp.incerement();
        // System.out.println(fullemp.calculateSalary());
        // System.out.println(fullemp.getCheckNumber());
        // System.out.println(bill.toString());
        System.out.println(greetings(employeeName,0));
    }

    public static void displayAllBills(Employee employee) {
        

    }
    public static void displayAllEmployees(Employee employee) {

        
    }
    public static void checkIssue() {
        Console console = System.console();

        
    }

    public static void createBill() {
        Console console = System.console();
        String nameBill = console.readLine("Enter a bill company! ");
        System.out.println(nameBill);
    }
    
    public static void createEmployee(Employee  employee) {
        Console console = System.console();
        String employeeType = null;
        // String employeeType = console.readLine("Please type of Employee. 'E'/'P' ").toLowerCase();
       //verify to customer add correct letter
        do {
            employeeType = console.readLine("Please type of Employee. 'E'/'P' ").toLowerCase();        
        } while (!employeeType.equals("e") && !employeeType.equals("p"));

        String fname = console.readLine("What is first name of employee?\n");
        String lname = console.readLine("What is last name of employee?\n");
        int age = Integer.parseInt(console.readLine("What is age of " + fname + " " + lname+".\n"));
        int id = Integer.parseInt(console.readLine("What is the id of " + fname + " " + lname+".\n"));
        System.out.println(createEmptyLine());
        //Creating new employee based on his type
        if (employeeType.equals("e")) {
            employee = new PartTimeEmployee(id, fname, lname, age, 13);
            System.out.println(employee.toString());
            System.out.println(createEmptyLine());
            // PartTimeEmployee partTimeEmployee = new PartTimeEmployee(id, fname, lname, age, 12);
        } else {
            employee = new FullTimeEmployee(id, fname, lname, age, 13);
            System.out.println(employee.toString());
            System.out.println(createEmptyLine());
            // FullTimeEmployee fullTimeEmployee = new FullTimeEmployee(id, fname, lname, age, 12);
        } 
        
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
