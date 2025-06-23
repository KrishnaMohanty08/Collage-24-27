import java.util.*;
public class d39_q1{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    String secretMess=sc.nextLine();
    System.out.println(Decoder(secretMess));
  }
  public static String Decoder(String secretMess){
    int[] index =new int[]{0};
    return decodeHelper(secretMess,index);
  }
  public static String decodeHelper(String secretMess,int[] i){
    StringBuilder word=new StringBuilder();
    int n=secretMess.length();
    while(i[0]<n && secretMess.charAt(i[0]) !=']'){
      char c=secretMess.charAt(i[0]);
      if(Character.isDigit(c)){
        int count=0;
        while(i[0]<n && Character.isDigit(secretMess.charAt(i[0]))){
          count=count*10+(secretMess.charAt(i[0])-'0');
          i[0]++;
        }
        i[0]++;
        String decoded=decodeHelper(secretMess,i);
        i[0]++;
        while(count-- >0){
          word.append(decoded);
        }
      }else{
        word.append(c);
        i[0]++;
      }
    }return word.toString();
  }
}