import java.util.*;

class ListNode{
  int val;
  ListNode next;
  ListNode(int val){this.val =val;}
}

public class d14_q1{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);

    ListNode head=null,tail=null;
    while(true){
      String in=sc.next();
      if(in.equals("exit"))break;
      ListNode newNode=new ListNode(Integer.parseInt(in));
      if(head==null)head=tail=newNode;
      else {tail.next=newNode;tail=newNode;}
    }

    ListNode fast=head,slow=head;
    while(fast!=null && fast.next!=null){
        slow=slow.next;
        fast=fast.next.next;
    }
    while(slow!=null){
        System.out.print(slow.val+" ");
        slow=slow.next;
    }
}
}
