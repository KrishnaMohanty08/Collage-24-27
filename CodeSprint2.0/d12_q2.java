import java.util.*;
class ListNode{
  int val;
  ListNode next;
  ListNode(int val) {this.val=val;}
}
public class d12_q2{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    ListNode head=null,tail=null;
    while(true){
      String in=sc.nextLine();
      if(in.equals("exit"))break;
      ListNode newNode=new ListNode(Integer.parseInt(in));
      if(head==null)head=tail=newNode;
      else {tail.next=newNode;tail=newNode;}
    }
    ListNode current=head;
    int red=0,blue=0,green=0;
    while(current!=null){
      switch(current.val){
        case 0:{red++;break;}
        case 1:{blue++;break;}
        case 2:{green++;break;}
      }current=current.next;
    }

  current=head;
    while(red!=0){
      current.val=0;
      current=current.next;
      red--;
    }while(blue!=0){
      current.val=1;
      current=current.next;
      blue--;
    }while(green!=0){
      current.val=2;
      current=current.next;
      green--;
    }
  current=head;
  while(current!=null){
    System.out.print(current.val+" ");
    current=current.next;
  }System.out.println();
}}