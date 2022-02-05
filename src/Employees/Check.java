package Employees;

public class Check {
    private static int currentCheckId = 1;
    private int checkId;
    private String payee;
    private double amount;

    public Check(String payee, double amount) {
        this.payee = payee;
        this.checkId = Check.currentCheckId;
        this.amount = amount;
        Check.currentCheckId++; //increment the static check id by 1 so that the next check generated gets the new value
    }

    public String toString() {
        int dollars = (int)this.amount;
        int cents = (int)this.amount*100%100;
        return "check number: " + this.checkId + " amount: $" + this.amount + "\n"
            +"PAY TO THE ORDER OF: " + this.payee.toUpperCase()
            +"\n Pay exactly: " 
            +dollars + " dollars and "
            +cents + "/100";
    }

}
