import java.util.Scanner;

class ElectricityBill {
    private String customerName;
    private int unitsConsumed;

    public ElectricityBill(String customerName, int unitsConsumed) {
        this.customerName = customerName;
        this.unitsConsumed = unitsConsumed;
    }

    public double calculateBillAmount() {
        double billAmount = 0.0;
        if (unitsConsumed <= 100) {
            billAmount = unitsConsumed * 1.20;
        } else if (unitsConsumed > 100 && unitsConsumed <= 200) {
            billAmount = 100 * 1.20 + (unitsConsumed - 100) * 2.0;
        } else if (unitsConsumed > 200 && unitsConsumed <= 300) {
            billAmount = 100 * 1.20 + 100 * 2.0 + (unitsConsumed - 200) * 3.0;
        } else {
            billAmount = 100 * 1.20 + 100 * 2.0 + 100 * 3.0 + (unitsConsumed - 300) * 4.0;
        }
        return billAmount;
    }

    public void displayBill() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Units Consumed: " + unitsConsumed);
        System.out.println("Bill Amount: Rs " + calculateBillAmount());
    }
}

public class electricity_billing_system {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter units consumed: ");
        int unitsConsumed = scanner.nextInt();

        ElectricityBill bill = new ElectricityBill(customerName, unitsConsumed);
        bill.displayBill();

        scanner.close();
    }
}
