package Employees;

import java.io.Console;

/**
 * @authors Cuneyt Yildirim && Dany Makhoul && Kyle Verso
 * @description
 * @version
 * @date
 * 
 */

public class PartTimeEmployee extends Employee {
    private String typeOfEmployee;

    int[] rateSalary = { 15, 20, 25, 30, 40 };
    int[] echelon = { 1, 2, 3, 4, 5 };

    /**
     * 
     * @param id
     * @param fname
     * @param lname
     * @param age
     * @param checkNumber
     */
    public PartTimeEmployee(int id, String fname, String lname, int age) {
        super(id, fname, lname, age);
        this.typeOfEmployee = "Part Time";
    }

 

    
    public void issueCheck() {
        System.out.println("Part time employee issue check");
    }

    @Override
    public String getTypeOfEmployee() {
        return typeOfEmployee;
    }


    @Override
    public int getCheckNumber() {
        return 0;
    }


    @Override
    public String toString() {
        String empInfo = super.toString() + "\n" + "Type of employee is :"+this.typeOfEmployee;
    
        return empInfo;
    }

 

    @Override
    public double calculateSalary() { // hours should be double 
        Console console = System.console();
        int echelon = Integer.parseInt(console.readLine("Enter his/her echelon\n"));
        double hours = Double.parseDouble(console.readLine("Enter his/her hourly works\n"));
        return hours * rateSalary[echelon - 1];
    }



}
