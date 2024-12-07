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
  public ListNode reverseBetween(ListNode head, int left, int right) {
    if (head == null || left == right) return head;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev = dummy;
    for (int i = 0; i < left - 1; i++) prev = prev.next;
    ListNode cur = prev.next;
    for (int i = 0; i < right - left; i++) {
      ListNode temp = cur.next;
      cur.next = temp.next;
      temp.next = prev.next;
      prev.next = temp;
    }
    return dummy.next;
  }
}

public class ReverseLinkedList {
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
    ReverseLinkedList adder = new ReverseLinkedList();
    int tc = scanner.nextInt();
    while (tc-- > 0) {
      String[] l1Input = scanner.next().split(",");
      int[] l1Values = new int[l1Input.length];
      for (int j = 0; j < l1Input.length; j++) {
        l1Values[j] = Integer.parseInt(l1Input[j]);
      }
      ListNode head = adder.createLinkedList(l1Values);
      int left = scanner.nextInt();
      int right = scanner.nextInt();
      System.out.println(solution.reverseBetween(head, left, right));
    }
    scanner.close();
  }
}
