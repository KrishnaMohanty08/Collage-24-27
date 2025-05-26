import java.util.*;

public class d11_q1{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);

    List<Integer> appointments=new ArrayList<>();
    while(true){
      String in=sc.nextLine();
      if(in.equals("exit"))break;
      appointments.add(Integer.parseInt(in));
    }
    int n=appointments.size();
    for(int i=0;i<n/2;i++){
      System.out.print(appointments.get(i)+" "+appointments.get(n-1-i)+" ");
    }
    if(n%2!=0){
      System.out.print(appointments.get(n/2));
    }System.out.println();
  }
}