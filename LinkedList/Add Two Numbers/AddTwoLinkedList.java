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
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode tail = dummyHead;
    int carry = 0;
    while (l1 != null || l2 != null || carry != 0) {
      int digit1 = (l1 != null) ? l1.val : 0;
      int digit2 = (l2 != null) ? l2.val : 0;
      int sum = digit1 + digit2 + carry;
      int digit = sum % 10;
      carry = sum / 10;
      ListNode newNode = new ListNode(digit);
      tail.next = newNode;
      tail = tail.next;
      l1 = (l1 != null) ? l1.next : null;
      l2 = (l2 != null) ? l2.next : null;
    }
    return dummyHead.next;
  }
}

public class AddTwoLinkedList {
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
    AddTwoLinkedList adder = new AddTwoLinkedList();
    int tc = scanner.nextInt();
    while (tc-- > 0) {
      String[] l1Input = scanner.next().split(",");
      int[] l1Values = new int[l1Input.length];
      for (int j = 0; j < l1Input.length; j++) {
        l1Values[j] = Integer.parseInt(l1Input[j]);
      }

      String[] l2Input = scanner.next().split(",");
      int[] l2Values = new int[l2Input.length];
      for (int j = 0; j < l2Input.length; j++) {
        l2Values[j] = Integer.parseInt(l2Input[j]);
      }

      ListNode l1 = adder.createLinkedList(l1Values);
      ListNode l2 = adder.createLinkedList(l2Values);
      ListNode result = solution.addTwoNumbers(l1, l2);
      adder.printLinkedList(result);
    }
    scanner.close();
  }
}
