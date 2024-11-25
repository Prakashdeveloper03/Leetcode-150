import java.util.Scanner;
import java.util.Stack;

class MinStack {
  class Pair {
    int val, minValue;

    Pair(int val, int minValue) {
      this.val = val;
      this.minValue = minValue;
    }
  }

  Stack<Pair> stack;

  public MinStack() {
    stack = new Stack<>();
  }

  public void push(int val) {
    if (stack.isEmpty()) {
      stack.push(new Pair(val, val));
    } else {
      int currentMin = Math.min(stack.peek().minValue, val);
      stack.push(new Pair(val, currentMin));
    }
  }

  public void pop() {
    if (!stack.isEmpty()) {
      stack.pop();
    }
  }

  public int top() {
    if (!stack.isEmpty()) {
      return stack.peek().val;
    }
    throw new IllegalStateException("Stack is empty");
  }

  public int getMin() {
    if (!stack.isEmpty()) {
      return stack.peek().minValue;
    }
    throw new IllegalStateException("Stack is empty");
  }
}

public class MinMain {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    MinStack minStack = new MinStack();
    System.out.println("Enter number of operations:");
    int operationsCount = sc.nextInt();
    sc.nextLine();
    for (int i = 0; i < operationsCount; i++) {
      System.out.println("Enter operation (push <value> / pop / top / getMin):");
      String[] command = sc.nextLine().split(" ");

      switch (command[0]) {
        case "push":
          int value = Integer.parseInt(command[1]);
          minStack.push(value);
          System.out.println("Pushed: " + value);
          break;
        case "pop":
          minStack.pop();
          System.out.println("Popped top element");
          break;
        case "top":
          try {
            System.out.println("Top element: " + minStack.top());
          } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
          }
          break;
        case "getMin":
          try {
            System.out.println("Minimum element: " + minStack.getMin());
          } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
          }
          break;
        default:
          System.out.println("Invalid command");
      }
    }
    sc.close();
  }
}
