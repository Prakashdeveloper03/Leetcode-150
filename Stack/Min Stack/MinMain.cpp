#include <iostream>
#include <sstream>
#include <stack>
#include <string>
using namespace std;

class MinStack {
 private:
  struct Pair {
    int val;
    int minValue;
    Pair(int v, int m) : val(v), minValue(m) {}
  };
  stack<Pair> stack;

 public:
  MinStack() {}

  void push(int val) {
    if (stack.empty()) {
      stack.emplace(val, val);
    } else {
      int currentMin = min(stack.top().minValue, val);
      stack.emplace(val, currentMin);
    }
  }

  bool pop() {
    if (!stack.empty()) {
      stack.pop();
      return true;
    }
    return false;
  }

  bool top(int& result) {
    if (!stack.empty()) {
      result = stack.top().val;
      return true;
    }
    return false;
  }

  bool getMin(int& result) {
    if (!stack.empty()) {
      result = stack.top().minValue;
      return true;
    }
    return false;
  }
};

int main() {
  MinStack minStack;
  int operationsCount;
  cout << "Enter number of operations: ";
  cin >> operationsCount;
  cin.ignore();
  for (int i = 0; i < operationsCount; ++i) {
    cout << "Enter operation (push <value> / pop / top / getMin): ";
    string line;
    getline(cin, line);
    stringstream ss(line);
    string command;
    ss >> command;

    if (command == "push") {
      int value;
      ss >> value;
      minStack.push(value);
      cout << "Pushed: " << value << endl;
    } else if (command == "pop") {
      if (minStack.pop()) {
        cout << "Popped top element" << endl;
      } else {
        cout << "Stack is empty" << endl;
      }
    } else if (command == "top") {
      int topValue;
      if (minStack.top(topValue)) {
        cout << "Top element: " << topValue << endl;
      } else {
        cout << "Stack is empty" << endl;
      }
    } else if (command == "getMin") {
      int minValue;
      if (minStack.getMin(minValue)) {
        cout << "Minimum element: " << minValue << endl;
      } else {
        cout << "Stack is empty" << endl;
      }
    } else {
      cout << "Invalid command" << endl;
    }
  }
  return 0;
}