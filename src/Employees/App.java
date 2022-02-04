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
        Payable[] expenses  =  new Payable[40];
       
        expenses[0] = new PartTimeEmployee(123, "Tom1", "Brown Part", 64);
        expenses[1] = new FullTimeEmployee(124, "Tess", "Lake Full", 43);
        expenses[2] = new PartTimeEmployee(125, "Nessie", "Lessie Part", 54);
        expenses[3] = new PartTimeEmployee(123, "Tom1", "Brown Part", 64);
        expenses[4] = new FullTimeEmployee(124, "Tess", "Lake Full", 43);
        expenses[5] = new PartTimeEmployee(125, "Nessie", "Lessie Part", 54);
        expenses[6] = new PartTimeEmployee(123, "Tom1", "Brown Part", 64);
        expenses[7] = new FullTimeEmployee(124, "Tess", "Lake Full", 43);
        expenses[8] = new PartTimeEmployee(125, "Nessie", "Lessie Part", 54);
        expenses[9] = new PartTimeEmployee(125, "Nessie", "Lessie Part", 54);

        Console console = System.console();
       

        ProcessOfApp process = new ProcessOfApp();

        String employeeName = console.readLine("Enter your name. ");

        //Salutation for new coming employee
        System.out.println(process.salutation(employeeName, 1));
       
        // Helper method for UI menu
        process.UImenu(expenses, console);

        // Salutation for the leaving employee
        System.out.println(process.salutation(employeeName, 0));
    }


}
