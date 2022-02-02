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

    /**
     * 
     * @param id
     * @param fname
     * @param lname
     * @param age
     * @param checkNumber
     */
    public PartTimeEmployee(int id, String fname, String lname, int age, int checkNumber) {
        super(id, fname, lname, age, checkNumber);
    }

    /**
     * 
     * @param hours
     * @param echelon
     * @return
     */
    public double calculateSalary(int hours, int echelon) { // hours should be double 
        return hours * rateSalary[echelon - 1];
    }

    /**
     * 
     */
    public void issueCheck() {
        System.out.println("Part time employee issue check");
    }

}
