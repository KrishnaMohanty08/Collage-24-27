import java.util.*;
public class d22_q2{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    Queue<Integer> students=new LinkedList<>();
    for(int i=0;i<n;i++)students.add(sc.nextInt());
    int[] sandwiches=new int[n];
    for(int i=0;i<n;i++) sandwiches[i]=sc.nextInt();
    int sIndex=0;
    int r=0;
    while(!students.isEmpty() && r<students.size()){
      if(students.peek()==sandwiches[sIndex]){
        students.poll();
        sIndex++;
        r=0;
      }else{
        students.add(students.poll());
        r++;
      }
    }System.out.println(students.size());
    }
}