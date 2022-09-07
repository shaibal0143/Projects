
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Mess {
    String name;
    String Department;
    int amountPaid;
    int amountDues;

    public Mess(String name, String Department, int amountPaid) {
        this.name = name;
        this.Department = Department;
        this.amountPaid = amountPaid;
        this.amountDues = 1700 - amountPaid;
    }

    public static void main(String[] args) {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Welcome to RM PG ");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Rules for Joining in RM PG ");
        System.out.println("-----------------------------------------------------------------------------");
        System.out
                .println("Monthly Expense for Each Person is Rs1700\nYou Have to Work on Date Which is Assign to You.");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Total Number of PG Members : ");
        int totalMember = sc.nextInt();
        sc.nextLine();
        Mess[] member = new Mess[totalMember];
        String name, Dept;
        int amount;
        for (int i = 0; i < totalMember; i++) {
            System.out.println("Enter Detail of " + (int) (i + 1) + " Member");
            System.out.print("Enter Name : ");
            name = sc.nextLine();
            System.out.print("Enter Department : ");
            Dept = sc.nextLine();
            System.out.print("Enter Amount Paid : ");
            amount = sc.nextInt();
            sc.nextLine();
            member[i] = new Mess(name, Dept, amount);
            System.out.println();
        }
        while (true) {
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("Press 1 for To get Details of Whole Month ");
            System.out.println("Press 2 for To get Details of Who will Work Today");
            System.out.println("Press 3 for To get Details of Any PG Member");
            System.out.println("Press 4 for To get Details of All PG Member");
            System.out.println("Press 0 For Exit");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.print("Enter Choice : ");
            int choose = sc.nextInt();
            System.out.println();
            sc.nextLine();
            switch (choose) {
                case 1:
                    getAllMemebrWorkingDay(totalMember, member);
                    break;
                case 2:
                    getDetailWhoWillWorkToday(totalMember, member);
                    break;
                case 3:
                    System.out.println("Enter Name : ");
                    String getName = sc.nextLine();
                    getDetailOfMember(totalMember, member, getName);
                    break;
                case 4:
                    getDetailOfAllMember(totalMember, member);
                    break;
                case 0:
                    sc.close();
                    System.exit(0);
            }
        }

    }

    public static void getDetailOfAllMember(int totalMember, Mess member[]) {
        for (int i = 0; i < totalMember; i++) {
            System.out.println("Details of " + member[i].name);
            System.out.println("Department : " + member[i].Department);
            System.out.println("Amount Paid : " + member[i].amountPaid);
            System.out.println("Amount Dues : " + member[i].amountDues);
            System.out.println();

        }
    }

    public static void getDetailOfMember(int totalMember, Mess member[], String getName) {
        for (int i = 0; i < totalMember; i++) {
            if (member[i].name.equalsIgnoreCase(getName)) {
                System.out.println("Details of " + member[i].name);
                System.out.println("Department : " + member[i].Department);
                System.out.println("Amount Paid : " + member[i].amountPaid);
                System.out.println("Amount Dues : " + member[i].amountDues);
                break;
            }
        }
    }

    public static void getAllMemebrWorkingDay(int totalMember, Mess member[]) {
        int timePreiod = 30 / totalMember;
        int temnpTimePeriod = timePreiod;
        int k = 0;
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Name\t\t" + "Dept\t\t" + "Amount Dues\t" + "amountPaid\t" + "Work Duration(in Date)");
        System.out.println("------------------------------------------------------------------------------------");
        for (int i = 1; i <= 30; i++) {
            if (i < timePreiod) {
                continue;
            }
            if (i == timePreiod) {
                int duration = k + 1;
                System.out.println(member[k].name + "\t\t" + member[k].Department + "\t\t" + member[k].amountDues
                        + "\t\t" + member[k].amountPaid + "\t\t" + duration + "to" + i);
                System.out.println();
                k++;
                timePreiod = timePreiod + temnpTimePeriod;
            }

        }
        System.out.println("------------------------------------------------------------------------------------");
    }

    public static void getDetailWhoWillWorkToday(int totalMember, Mess member[]) {
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Today Date is " + Integer.parseInt(date.format(now)));
        int timePreiod = 30 / totalMember;
        int temnpTimePeriod = timePreiod;
        int k = 0;
        for (int i = 1; i <= 30; i++) {
            if (i == timePreiod) {
                k++;
                timePreiod = timePreiod + temnpTimePeriod;
            }
            if (i == Integer.parseInt(date.format(now))) {
                System.out.println(member[k].name + " Will Work Today");
                System.out.println("Department " + member[k].Department);
                System.out.println();
                break;
            }
        }
    }
}
