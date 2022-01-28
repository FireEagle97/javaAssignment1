package Employees;

public abstract class Employee extends Payable {
    private String firstName;
    private String lastName;
    private int age;
    private int ID;

    public Employee(int id, String fname, String lname, int age, int checkNumber) {
        super(checkNumber);
        this.ID = id;
        this.age = age;
        this.firstName = fname;
        this.lastName = lname;
    }

}
