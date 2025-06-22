import java.util.*;
public class d38_q1{
  public static char nextChar(char c){
    return c=='z'?'a':(char)(c+1);
  }
  public static char getKthLetter(int k){
    StringBuilder s=new StringBuilder("a");
    while(s.length()<k){
      StringBuilder temp=new StringBuilder();
      for(int i=0;i<s.length();i++){
        temp.append(nextChar(s.charAt(i)));
      }
      s.append(temp);
    }
    return (s.charAt(k-1));
  }
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int k=sc.nextInt();
    System.out.println(getKthLetter(k));
  }
}