import java.util.*;

class ListNode{
  int val;
  ListNode next;
  ListNode(int val){ this.val=val;}
}
public class d10_q1{
  public static ListNode removeDuplicate(ListNode head){
    ListNode current=head;
    while(current!=null && current.next!=null){
      if(current.val==current.next.val){
        current.next=current.next.next;
      }else{
        current=current.next;
      }
    }return head;
  }
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    ListNode head=null,tail=null;
    while(true){
      String in=sc.nextLine();
      if(in.equals("exit"))break;
      int val=Integer.parseInt(in);
      ListNode newNode =new ListNode(val);
      if(head==null) head=tail=newNode;
      else{
        tail.next=newNode;
        tail=newNode;
      }
    }head=removeDuplicate(head);
    printList(head);
    
  }public static void printList(ListNode head){
    for(ListNode current =head;current!=null;current=current.next){
      System.out.print(current.val+" ");
    }System.out.println();
  }
}