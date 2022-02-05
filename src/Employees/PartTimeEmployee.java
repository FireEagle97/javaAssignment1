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

    @Override
    public String getTypeOfEmployee() {
        return typeOfEmployee;
    }




    @Override
    public String toString() {
        String empInfo = super.toString() + "\n" + "Type of employee is :"+this.typeOfEmployee;
    
        return empInfo;
    }

 

    @Override
    public double calculateSalary() { // hours should be double 
        int[] rateSalary = new int[]{ 15, 20, 25, 30, 40 };
        Console console = System.console();
        int echelon = Integer.parseInt(console.readLine("You are paying + " + this.getPayeeName() + " working part time. Enter his/her echelon\n"));
        double hours = Double.parseDouble(console.readLine("Enter his/her hourly works\n"));
        return hours * rateSalary[echelon - 1];
    }

    //pay by his/her salary
    public double pay() {
        return calculateSalary() / 12;
    }


}
