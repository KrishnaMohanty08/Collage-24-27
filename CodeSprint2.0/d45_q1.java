import java.util.*;

public class d45_q1{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    String exp=sc.nextLine();
    System.out.println(evalFrac(exp));
  }
  public static String evalFrac(String expr){
    int numerator=0,deNominator=1;
    int i=0;
    while(i<expr.length()){
      int sign=1;
      if(expr.charAt(i)=='-'){
        sign=-1;i++;
      }else if(expr.charAt(i)=='+'){
        i++;
      }int num=0;
      while(i<expr.length() && Character.isDigit(expr.charAt(i))){
        num=num*10+(expr.charAt(i++)-'0');
      }
      i++;
      int denom=0;
      while(i<expr.length() && Character.isDigit(expr.charAt(i))){
        denom=denom*10+(expr.charAt(i++)-'0');
      }
      numerator=numerator*denom+sign*num*deNominator;
      deNominator*=denom;
      int gcd=gcd(Math.abs(numerator),deNominator);
      numerator/=gcd;
      deNominator/=gcd;
    }
    return numerator+"/"+deNominator;
  }
  private static int gcd(int a,int b){
    while(b!=0){
      int temp=b;
      b=a%b;
      a=temp;
    }return a;
  }
}