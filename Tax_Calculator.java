import java.util.Scanner;

public class Tax_Calculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your Income::");
        double n = scan.nextDouble();
        System.out.println("Enter the Deductions::");
        System.out.print("1-Medical Scheme::");
        double a = scan.nextDouble();
        System.out.print("Life Insurance::");
        double b = scan.nextDouble();
        System.out.print("Miscellanous Amount::");
        double c = scan.nextInt();
        double total = (n - a - b - c);
        System.out.println("Toatal amount is::" + total);
        if (total < 500000) {
            System.out.println("No Tax");
        } else if (500000 < total && total < 10000000) {
            // 5% of 2.5 lakhs =12500
            double sum = (12500 + ((n - 500000) * 0.02));
            // 4% cess on the tax(for farmers,education etc)
            double cess = sum * 0.04;
            double sum1 = sum + cess;
            System.out.println("Total Tax You have to pay is::" + sum1);

        } else if (total > 10000000) {
            // 5% of 2.5 lakhs =12500 + 20% of 5lakhs is 1Lakh
            double sum2 = (12500 + 100000 + (n - 10000000) * 0.3);
            // 4% cess on tax(for farmers , Education etc)
            double cess2 = sum2 * 0.04;
            double sum3 = sum2 + cess2;
            System.out.println("Total Tax You have to pay is::" + sum3);
        }
        scan.close();

    }

}
