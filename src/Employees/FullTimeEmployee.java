package Employees;

/**
 * @authors Cuneyt Yildirim && Dany Makhoul && Kyle Verso
 * @description
 * @version
 * @date
 * 
 */
public class FullTimeEmployee extends Employee {

    final double salary = 84000.0;

    /**
     * 
     * @param id
     * @param fname
     * @param lname
     * @param age
     * @param checkNumber
     */
    public FullTimeEmployee(int id, String fname, String lname, int age, int checkNumber) {
        super(id, fname, lname, age, checkNumber);
    }

    /**
     * 
     * @return
     */
    public double calculateSalary() {
        return (salary) / 12;
    }

    /**
     * 
     */
    public void issueCheck() {
        System.out.println("Full time employee issue check");
    }

}
