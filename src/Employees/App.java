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

        Console console = System.console();
       
        Company company = new Company();

        ProcessOfApp process = new ProcessOfApp();

        String employeeName = console.readLine("Enter your name. ");

        //Salutation for new coming employee
        System.out.println(process.salutation(employeeName, 1));
       
        // Helper method for UI menu
        process.UImenu(company, console);

        // Salutation for the leaving employee
        System.out.println(process.salutation(employeeName, 0));
    }


}
