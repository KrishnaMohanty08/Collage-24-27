import java.util.*;

class ListNode {
  int val;
  ListNode next;
  ListNode (int x) {val=x;}
}
public class d11_q2{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    List <Integer>list=new LinkedList<>();
    while(true){
      String i=sc.nextLine();
      if(i.equals("exit"))break;
      list.add(Integer.parseInt(i));
    }
    int pos=sc.nextInt();

    ListNode head=null;
    ListNode tail=null;
    ListNode[] nodes=new ListNode[list.size()];
    for(int i=0;i<list.size();i++){
      ListNode node=new ListNode(list.get(i));
      nodes[i]=node;
      if(i>0) nodes[i-1].next=node;
      if(i==0)head=node;
      tail=node;
    }
    if(pos>=0 && pos<list.size()){
      tail.next=nodes[pos];
    }
    boolean hasCycle=detectCycle(head);
    System.out.println(hasCycle);
  }
  static boolean detectCycle(ListNode head){
    if(head==null)return false;
    ListNode slow=head;
    ListNode fast=head;
    while(fast!=null && fast.next!=null){
      slow=slow.next;
      fast=fast.next.next;
      if(slow==fast)return true;
    }return false;
  }
}