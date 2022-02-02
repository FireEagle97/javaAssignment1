package Employees;

public abstract class Payable {
    private static int checkNumber = 0;

    public void incerement() {
        checkNumber += 1;
    }

    public Payable(int checkNumber) {
        Payable.checkNumber = checkNumber;
    }

    public int getCheckNumber() {
        return checkNumber;
    }

    public abstract void issueCheck();

}
