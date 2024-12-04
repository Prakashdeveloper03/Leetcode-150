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
  public ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode prev = dummy;
    ListNode temp = head;
    while (temp != null) {
      if (temp.next != null && temp.val == temp.next.val) {
        while (temp.next != null && temp.val == temp.next.val) {
          temp = temp.next;
        }
        prev.next = temp.next;
      } else {
        prev = prev.next;
      }
      temp = temp.next;
    }
    return dummy.next;
  }
}

public class RemoveDuplicates {
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
      head = solution.deleteDuplicates(head);
      adder.printLinkedList(head);
    }
    scanner.close();
  }
}
