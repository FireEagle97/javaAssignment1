package Employees;

public class FullTimeEmployee extends Employee {

    /**
     * @authors Cuneyt Yildirim && Dany Makhoul && Kyle Verso
     * @description
     * @version
     * @date
     * 
     */

    final double salary = 84000.0;

    public FullTimeEmployee(int id, String fname, String lname, int age, int checkNumber) {
        super(id, fname, lname, age, checkNumber);
    }

    public double calculateSalary() {
        return (salary) / 12;
    }

    public void issueCheck() {
        System.out.println("Full time employee issue check");
    }

}
