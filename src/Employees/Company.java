package Employees;

public class Company {
    
    private Payable[] expenses;

    public Company() {
        this.expenses = new Payable[40];
        initializeEmployees();
    }


    private void initializeEmployees() {
        // this.expenses[0] = new PartTimeEmployee(123, "Tom1", "Part Jake", 64);
        // this.expenses[1] = new FullTimeEmployee(124, "Tess", "Lake Full", 43);
        // this.expenses[2] = new PartTimeEmployee(125, "Nessie", "Ahksan Part", 54);
        // this.expenses[3] = new PartTimeEmployee(123, "Tom1", "Brown Part", 64);
        // this.expenses[4] = new FullTimeEmployee(124, "Tess", "Full Nagi", 43);
        // this.expenses[5] = new PartTimeEmployee(125, "Nessie", "Lessie Part", 54);
        // this.expenses[6] = new FullTimeEmployee(123, "Tom1", "Full Ad", 64);
        // this.expenses[7] = new FullTimeEmployee(124, "Tess", "Lake Full", 43);
        // this.expenses[8] = new PartTimeEmployee(125, "Nessie", "Part Jett", 54);
        this.expenses[9] = new FullTimeEmployee(125, "Nessie", "January Full", 54);
    }

    public Payable[] getExpenses() {
        return this.expenses;
    }

    /**
     * Writes checks to each expense, either employees and/or bills
     */
    public void issueChecks() {
        for (Payable expense : this.expenses) {
            if (expense != null) {
                double amountPaid = expense.pay();
                Check issuedCheck = new Check(expense.getPayeeName(), amountPaid);
                System.out.println(issuedCheck);
            }
            
        }
        System.out.println("checks issued!");
    }
}
