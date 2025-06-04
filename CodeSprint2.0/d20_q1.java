import java.util.*;

public class d20_q1{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    String in=sc.nextLine();
    StringBuilder result =new StringBuilder();
    int depth=0;
    for(char c:in.toCharArray()){
      if(c=='('){
        if(depth>0)result.append(c);
        depth++;
      }else if(c==')'){
        depth--;
        if(depth>0)result.append(c);
      }
    }System.out.print(result);
  }
}