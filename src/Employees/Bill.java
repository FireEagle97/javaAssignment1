package Employees;

public class Bill implements Payable {

    // private int id;
    private String companyName;
    private double amount;

    /**
     * The constructor method of the class to create an object
     * 
     * @param companyName
     * @param amount
     */
    public Bill(String companyName, double amount) {
        // this.id = id;
        this.companyName = companyName;
        this.amount = amount;
    }

    public double pay() {
        return this.amount;
    }

    public String getPayeeName() {
        return this.companyName;
    }

    /**
     * 
     */
    @Override
    public String toString() {
        return "The name of the company name :" + this.companyName + '\n' +
                "The amount to pay: $" + this.amount;
    }

}
