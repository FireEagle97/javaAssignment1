package Employees;

public abstract class Payable {
    private static int checkNumber = 10;

    public Payable() {
        Payable.checkNumber = incerement();
        
    }

    public static int incerement() {
        Payable.checkNumber += 1;
        return Payable.checkNumber;
    }

    public int getCheckNumber() {
        return checkNumber;
    }
    public abstract int getID();
    public abstract void issueCheck();
}
