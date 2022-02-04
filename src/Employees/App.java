package Employees;

import java.io.Console;

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

        ProcessOfApp process = new ProcessOfApp();

        String employeeName = console.readLine("Enter your name. ");

        //Salutation for new coming employee
        System.out.println(process.salutation(employeeName, 1));
       
        // Helper method for UI menu
        process.UImenu(employees, bills, console);

        // Salutation for the leaving employee
        System.out.println(process.salutation(employeeName, 0));
    }


}
