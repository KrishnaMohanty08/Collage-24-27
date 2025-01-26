import java.util.Scanner;

interface PersonalLoan{
    float find_simple_interest(float principal,int year);
}
class Bank1 implements PersonalLoan{

    static int interest_rate=10;
    public float find_simple_interest(float principal,int year){
        float simple_interest=(interest_rate*principal*year)/100;
        System.out.println("The bank 1 provides the simple interest:"+simple_interest);
        return simple_interest;
    }
}
class Bank2 implements PersonalLoan{
    
    static int interest_rate=15;
    
    public float find_simple_interest(float principal,int year){
        float simple_interest=(interest_rate*principal*year)/100;
        System.out.println("The bank 2 provides the simple interest:"+simple_interest);
        return simple_interest;
    }
}
public class loan {
    public static void main(String[] args) {
        PersonalLoan L=new Bank1();
        L.find_simple_interest(1000,5);
        
        Bank1 A=new Bank1();
        A.find_simple_interest(1000,4);

        Bank2 B=new Bank2();
        B.find_simple_interest(1300,3);
    }
}

