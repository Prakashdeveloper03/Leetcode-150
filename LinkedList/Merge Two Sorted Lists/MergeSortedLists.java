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
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode dummy = new ListNode(0);
    ListNode current = dummy;
    while (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        current.next = list1;
        list1 = list1.next;
      } else {
        current.next = list2;
        list2 = list2.next;
      }
      current = current.next;
    }
    if (list1 != null) {
      current.next = list1;
    } else {
      current.next = list2;
    }
    return dummy.next;
  }
}

public class MergeSortedLists {
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
    MergeSortedLists adder = new MergeSortedLists();
    int tc = scanner.nextInt();
    while (tc-- > 0) {
      String[] l1Input = scanner.next().split(",");
      int[] l1Values = new int[l1Input.length];
      for (int j = 0; j < l1Input.length; j++) {
        l1Values[j] = Integer.parseInt(l1Input[j]);
      }
      ListNode list1 = adder.createLinkedList(l1Values);
      String[] l2Input = scanner.next().split(",");
      int[] l2Values = new int[l2Input.length];
      for (int j = 0; j < l2Input.length; j++) {
        l2Values[j] = Integer.parseInt(l2Input[j]);
      }
      ListNode list2 = adder.createLinkedList(l2Values);
      adder.printLinkedList(solution.mergeTwoLists(list1, list2));
    }
    scanner.close();
  }
}
