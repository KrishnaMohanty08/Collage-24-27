import java.util.*;

public class d8_q2{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);

    String sen=new String();
    sen=sc.nextLine();

    String words[]=sen.split("\\s+");

    for(int i=words.length-1;i>=0;i--){
      System.out.print(words[i]+" ");
    }
  }
}