import java.util.*;;


class Account_5359 {
    int acc_no;
    double balance;

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Account Number and Balance:");
        acc_no = sc.nextInt();
        balance = sc.nextDouble();
    }

    public void disp() {
        System.out.println("Account Number: " + acc_no);
        System.out.println("Balance: " + balance);
    }
}

class Person extends Account_5359 {
    String name;
    String aadhar_no;

    public void input() {
        Scanner sc = new Scanner(System.in);
        super.input();
        System.out.println("Enter Name and Aadhar Number:");
        name = sc.next();
        aadhar_no = sc.next();
    }

    public void disp() {
        System.out.println("Name: " + name);
        System.out.println("Aadhar Number: " + aadhar_no);
        super.disp();
    }
}

public class d4p4_5359 {
    public static void main(String[] args) {
        Person[] persons = new Person[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter details for Person " + (i + 1) + ":");
            persons[i] = new Person();
            persons[i].input();
        }

        System.out.println("\nDetails of all persons:");
        for (int i = 0; i < 3; i++) {
            System.out.println("\nPerson " + (i + 1) + ":");
            persons[i].disp();
        }
    }
}
