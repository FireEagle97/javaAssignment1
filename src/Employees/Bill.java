package Employees;

public class Bill implements Payable {

    private int id;
    private String companyName;
    private double amount;

    /**
     * The constructor method of the class to create an object
     * 
     * @param companyName
     * @param amount
     */
    public Bill(int id, String companyName, double amount) {
        this.id = id;
        this.companyName = companyName;
        this.amount = amount;
    }

    public double pay() {
        return this.amount;
    }

    public String getCompanyName() {
        return this.companyName;
    }

}
