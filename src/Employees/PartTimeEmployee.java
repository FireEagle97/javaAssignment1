package Employees;

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

    /**
     * 
     * @param hours
     * @param echelon
     * @return
     */
    public double calculateSalary(int hours, int echelon) { // hours should be double 
        return hours * rateSalary[echelon - 1];
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



}
