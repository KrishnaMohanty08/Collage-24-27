import java.util.*;

public class d37_q1{
  public static void main(String args[]){
    System.out.print(powTwo(Float.parseFloat(args[0])));
  }
  public static boolean powTwo(float n){
    if(n==1.0) return true;
    else if(n<1.0)return false;
    else{
      return powTwo(n/2.0f);
    }
  }
}