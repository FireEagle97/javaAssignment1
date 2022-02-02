package Employees;

public abstract class Employee implements Payable {
    private String firstName;
    private String lastName;
    private String typeOfEmployee;
    private int age;
    private int ID;

    public String getTypeOfEmployee() {
        return typeOfEmployee;
    }


    /**
     * The constructor of the Employee of the abstract class to create an Employee
     * object
     * 
     * @param id
     * @param fname
     * @param lname
     * @param age
     * @param checkNumber
     */
    public Employee(int id, String fname, String lname, int age) {
        this.ID = id;
        this.age = age;
        this.firstName = fname;
        this.lastName = lname;
    }

    public String toString() {
        String employeeInfo = "Your employee info:\n" +
        "Employee's id is: "+this.ID+"\n"+
        "Employee's first name is "+this.firstName+"\n"+
        "Employee's last name is "+this.lastName+"\n"+
        "Employee's age is: " + this.age;
        return employeeInfo;
    }

}
