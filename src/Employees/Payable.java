package Employees;

public abstract class Payable {
    private static int checknumber = 0;

    public void incerement() {
        checknumber += 1;
    }

    public Payable(int checknumber) {
        this.checknumber = checknumber;
    }

    public int getCheckNumber() {
        return checknumber;
    }

    public abstract void issueCheck();

}
