import java.util.Scanner;

class ListNode {
  int val;
  ListNode next;

  ListNode() {}

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode first = dummy;
    ListNode second = dummy;
    for (int i = 0; i <= n; i++) first = first.next;
    while (first != null) {
      first = first.next;
      second = second.next;
    }
    second.next = second.next.next;
    return dummy.next;
  }
}

public class RemoveNthNode {
  public ListNode createLinkedList(int[] values) {
    ListNode dummyHead = new ListNode(0);
    ListNode current = dummyHead;
    for (int value : values) {
      current.next = new ListNode(value);
      current = current.next;
    }
    return dummyHead.next;
  }

  public void printLinkedList(ListNode node) {
    while (node != null) {
      System.out.print(node.val);
      if (node.next != null) {
        System.out.print(" -> ");
      }
      node = node.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Solution solution = new Solution();
    RemoveDuplicates adder = new RemoveDuplicates();
    int tc = scanner.nextInt();
    while (tc-- > 0) {
      String[] l1Input = scanner.next().split(",");
      int[] l1Values = new int[l1Input.length];
      for (int j = 0; j < l1Input.length; j++) {
        l1Values[j] = Integer.parseInt(l1Input[j]);
      }
      ListNode head = adder.createLinkedList(l1Values);
      int n = scanner.nextInt();
      head = solution.removeNthFromEnd(head, n);
      adder.printLinkedList(head);
    }
    scanner.close();
  }
}
