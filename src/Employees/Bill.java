package Employees;

public class Bill extends Payable {

    public Bill(String companyName, double amount, int checknumber) {
        super(checknumber);
        this.companyName = companyName;
        this.amount = amount;
    }

    private String companyName;
    private double amount;

    // public Bill(String companyName, double amount) {
    // this.companyName = companyName;
    // this.amount = amount;
    // }

    @Override
    public void issueCheck() {
        System.out.println("Part time employee issue check");
    }

    @Override
    public String toString() {
        return "The name of the company name :" + this.companyName + '\n' +
                "The amount of the check: " + this.amount + '\n' +
                " ";
    }

}
