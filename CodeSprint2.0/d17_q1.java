import java.util.*;

public class d17_q1{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    Stack<Character> input=new Stack<>();
    while(true){
      String in =sc.nextLine();
      if(in.equals("exit"))break;
      for (int i=0;i<in.length();i++) {
        input.push(in.charAt(i));
      }
    }
    StringBuilder output=new StringBuilder("");
    while(!input.isEmpty()){
      output.append(input.pop());
    }
    System.out.print(output);
  }
}