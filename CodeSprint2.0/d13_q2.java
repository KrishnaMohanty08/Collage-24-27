import java.util.*;
class ListNode {
    int val;
    ListNode prev, next;
    ListNode(int val) { this.val = val; }
}
public class d13_q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListNode head = null, tail = null;
        while(true) {
            String in = sc.next();
            if(in.equals("exit")) break;
            ListNode newNode = new ListNode(Integer.parseInt(in));
            if(head == null) head = tail = newNode;
            else { tail.next = newNode; newNode.prev = tail; tail = newNode; }
        }
        if(head == null) { System.out.println("empty"); return; }
        head = mergeSort(head);
        ListNode current = head;
        while(current != null) {
            System.out.print(current.val + (current.next != null ? "->" : ""));
            current = current.next;
        }
        System.out.println();
    }
    static ListNode mergeSort(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null) { 
            slow = slow.next; 
            fast = fast.next.next; }
        ListNode mid = slow.next; slow.next = null; if(mid != null) mid.prev = null;
        ListNode left = mergeSort(head), right = mergeSort(mid);
        return merge(left, right);
    }
    static ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0), current = dummy;
        while(left != null && right != null) {
            if(left.val < right.val) { 
                current.next = left; 
                left.prev = current; 
                left = left.next; }
            else { 
                current.next = right; 
                right.prev = current; 
                right = right.next; }
            current = current.next;
        }
        current.next = left != null ? left : right;
        if(current.next != null) current.next.prev = current;
        ListNode head = dummy.next;
        if(head != null) head.prev = null;
        return head;
    }
}
