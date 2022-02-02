package Employees;

public class Bill extends Payable {

    private String companyName;
    private double amount;

    /**
     * The constructor method of the class to create an object
     * 
     * @param companyName
     * @param amount
     * @param checknumber
     */
    public Bill(String companyName, double amount, int checknumber) {
        super(checknumber);
        this.companyName = companyName;
        this.amount = amount;
    }

    /**
     * 
     */
    @Override
    public void issueCheck() {
        System.out.println("Part time employee issue check");
    }

    /**
     * 
     */
    @Override
    public String toString() {
        return "The name of the company name :" + this.companyName + '\n' +
                "The amount of the check: " + this.amount + '\n' +
                " ";
    }

}
