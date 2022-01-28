package Employees;

/**
 * @authors Cuneyt Yildirim && Dany Makhoul && Kyle Verso
 * @description
 * @version
 * @date
 * 
 */

public class PartTimeEmployee extends Employee {

    int[] rateSalary = { 15, 20, 25, 30, 40 };
    int[] echelon = { 1, 2, 3, 4, 5 };

    public PartTimeEmployee(int id, String fname, String lname, int age, int checkNumber) {
        super(id, fname, lname, age, checkNumber);
    }

    public double calculateSalary(int hours, int echelon) {
        return hours * rateSalary[echelon - 1];
    }

    public void issueCheck() {
        System.out.println("Part time employee issue check");
    }

}
