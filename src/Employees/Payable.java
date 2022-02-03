package Employees;

public abstract class Payable {
    private static int checkNumber = 10;



    public static int incerement() {
        Payable.checkNumber += 1;
        return Payable.checkNumber;
    }

    public Payable() {
        Payable.checkNumber = incerement();
        
    }


    public int getCheckNumber() {
        return checkNumber;
    }

    public abstract void issueCheck();
}
