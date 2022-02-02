package Employees;

public class Bill implements Payable {

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

    @Override
    public int getCheckNumber() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void incerementCheckNumber(int previousCheck) {
        // TODO Auto-generated method stub
        previousCheck += 1;
        
    }

}
