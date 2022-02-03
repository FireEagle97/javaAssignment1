package Employees;

public class Bill extends Payable {

    public int checkNumber;
    private String companyName;
    private double amount;

    /**
     * The constructor method of the class to create an object
     * 
     * @param companyName
     * @param amount
     * @param checknumber
     */
    public Bill(String companyName, double amount) {
        this.companyName = companyName;
        this.amount = amount;
        this.checkNumber = super.getCheckNumber();
        super.incerement();
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
                "The check number of this check is: "+ this.checkNumber ;
    }



}
