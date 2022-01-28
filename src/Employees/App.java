package Employees;

/**
 * @authors Cuneyt Yildirim && Dany Makhoul && Kyle Verso
 * @description
 * @version
 * @date
 * 
 */
public class App {
    public static void main(String[] args) {

        int check = 0;
        FullTimeEmployee fullemp = new FullTimeEmployee(12, "full1a", "full1b", 32, check);
        PartTimeEmployee pemp = new PartTimeEmployee(13, "test", "lname", 32, check);
        Bill bill = new Bill("Hydro", 123, check);

        System.out.println(pemp.calculateSalary(21, 2));
        pemp.incerement();
        System.out.println(pemp.getCheckNumber());
        fullemp.incerement();
        System.out.println(fullemp.calculateSalary());
        System.out.println(fullemp.getCheckNumber());
        System.out.println(bill.toString());
    }
}
