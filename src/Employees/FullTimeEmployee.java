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
    private String typeOfEmployee;


    /**
     * 
     * @param id
     * @param fname
     * @param lname
     * @param age
     * @param checkNumber
     */
    public FullTimeEmployee(int id, String fname, String lname, int age) {
        super(id, fname, lname, age);
        this.typeOfEmployee = "Full Time";
    }

    /**
     * Calculates full time employee's fixed salary
     * @return monthly salary of the current employee
     */
   

    /**
     * 
     */
    public void issueCheck() {
        System.out.println("Full time employee issue check");
    }

    /**
     * @return type of employee
     */
    public String getTypeOfEmployee() {
        return typeOfEmployee;
    }

    @Override
    public int getCheckNumber() {
        return 0;
    }


    @Override
    public String toString() {
        String empInfo = super.toString() +
                "\n" +
        "Type of employee is :"+this.typeOfEmployee;
    
        return empInfo;
    }

    @Override
    public double calculateSalary() {
        // TODO Auto-generated method stub
        return 0;
    }


}
