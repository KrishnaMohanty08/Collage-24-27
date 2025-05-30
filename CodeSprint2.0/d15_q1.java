import java.util.*;
class ListNode{
  int val;
  ListNode prev;
  ListNode next;
  ListNode(int val){this.val=val;}
}
public class d15_q1{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);

    ListNode head=null,tail=null,prev=null;
    while(true){
      String in=sc.next();
      if(in.equals("exit"))break;
      ListNode newNode=new ListNode(Integer.parseInt(in));
      if(head==null)head=tail=newNode;
      else{tail.next=newNode;newNode.prev=tail;tail=newNode;}
      }
    int target=sc.nextInt();
    ListNode current=head;
    while(current!=null){
      if(current==null)System.out.print("empty");
      if(current.val==target){
        if(current==head){
          head=head.next;
          if(head!=null)head.prev=null;
          else{tail=null;}
        }else if(current==tail){
          tail=tail.prev;
          tail.next=null;
        }else{
          current.prev.next=current.next;
          current.next.prev=current.prev;
        }
      }
      current=current.next;
    }
    current=head;
    while(current!=null){
      System.out.print(current.val+" ");
      current=current.next;
    }
  }
}