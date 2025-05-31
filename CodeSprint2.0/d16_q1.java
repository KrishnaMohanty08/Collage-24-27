import java.util.*;
class ListNode {
    String val;
    ListNode next;
    ListNode(String val) {
        this.val = val;
    }
}
public class d16_q1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        ListNode head = null, tail = null;
        int length = 0;
        while (true) {
            String in = sc.next();
            if (in.equals("exit"))break;
            ListNode newNode = new ListNode(in);
            if (head == null)head = tail = newNode;
            else {tail.next = newNode;tail = newNode;}
            length++;
        }
        int left = sc.nextInt();
        int right = sc.nextInt();
        ListNode temp = new ListNode("");
        temp.next = head;
        ListNode preNode = temp;
        for (int i = 1; i < left - 1; i++) preNode = preNode.next;
        if (1 <= left && left <= right && right <= length) {
            ListNode start = preNode.next;
            ListNode prev = null;
            ListNode nextNode;
            ListNode current = start;
            for (int i = left; i <=right; i++) {
                nextNode = current.next;
                current.next = prev;
                prev = current;
                current = nextNode;
            }
            preNode.next = prev;
            start.next = current;
            current = tail;
            while (current != null) {
                System.out.println(current.val);
                current = current.next;
            }
        } else System.out.println("invalid");
    }
}
