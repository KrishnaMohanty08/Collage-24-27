import java.util.*;

class ListNode{
  int val;
  ListNode next;
  ListNode( int val){this.val=val;}
}
public class d12_q1{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    ListNode head=null,tail=null;

    while(true){
      String in=sc.nextLine();
      if(in.equals("exit"))break;
      ListNode newNode=new ListNode(Integer.parseInt(in));
      if(head==null)head=tail=newNode;
      else{tail.next=newNode;tail=newNode;}
    }
    if(head==null)System.out.print("empty");
    else{ 
      head=mergeSort(head);
      ListNode current=head;
      while(current!=null){
        System.out.print(current.val);
        if(current.next!=null)System.out.print("->");
        current =current.next;
      }
         System.out.println();
     }
  }
  private static ListNode mergeSort(ListNode head ){
    if(head==null||head.next==null )return head;
    ListNode fast=head,slow=head,prev=null;
    while(fast!=null && fast.next!=null){
      prev=slow;
      fast=fast.next.next;
      slow=slow.next;
    }
    prev.next=null;
    ListNode left=mergeSort(head);
    ListNode right=mergeSort(slow);
    return merge(left,right);
  }
  private static ListNode merge(ListNode left,ListNode right){
    ListNode temp=new ListNode(0);
    ListNode current=temp;
    while(left!=null && right!=null){
      if(left.val<right.val){
        current.next=left;
        left=left.next;
      }else{
        current.next=right;
        right=right.next;
      }
      current=current.next;
    }
    current.next=(left!=null)?left:right;
    return temp.next;
  }
}
