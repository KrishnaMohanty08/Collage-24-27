import java.util.*;
class ListNode{
  int val;
  ListNode next;
  ListNode (int val){this.val=val;}
}
public class d13_q1{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    ListNode head=null,tail=null;
    int count=0;
    while(true){
      String in=sc.next();
      if(in.equals("exit"))break;
      ListNode newNode=new ListNode(Integer.parseInt(in));
      if(head==null){head=tail=newNode;}
      else {tail.next=newNode;tail=newNode;}
      count++;
    }
    int k=sc.nextInt();
    if(k<=0 || head==null){System.out.println("empty");return;}

    ListNode current=head;
    ListNode[] parts =new ListNode[k];
    int partSize=count/k;
    int remainder=count%k;
    for(int i=0;i<k && current!=null;i++){
      parts[i]=current;
      int currPartSize=partSize+(i<remainder?1:0);
      for(int j=1;j<currPartSize;j++){
        current=current.next;
      }
      if(current!=null){
        ListNode next=current.next;
        current.next=null;
        current=next;
      }
    }
    for(int i=0;i<k;i++){
      ListNode part=parts[i];
      System.out.print("[");
      while(part!=null){
        System.out.print(part.val);
        if(part.next!=null)System.out.print(",");
        part=part.next;
      }
      System.out.print(']');
      if(i!=k-1)System.out.print(",");
    }
  }
}