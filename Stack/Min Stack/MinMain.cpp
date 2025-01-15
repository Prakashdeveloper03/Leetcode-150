#include <iostream>
#include <sstream>
#include <stack>
#include <stdexcept>
#include <string>
using namespace std;

class MinStack {
 private:
  struct Pair {
    int val, minValue;
    Pair(int val, int minValue) : val(val), minValue(minValue) {}
  };
  stack<Pair> st;

 public:
  MinStack() {}

  void push(int val) {
    if (st.empty()) {
      st.push(Pair(val, val));
    } else {
      int currentMin = min(st.top().minValue, val);
      st.push(Pair(val, currentMin));
    }
  }

  void pop() {
    if (!st.empty()) {
      st.pop();
    } else {
      throw runtime_error("Stack is empty");
    }
  }

  int top() {
    if (!st.empty()) {
      return st.top().val;
    }
    throw runtime_error("Stack is empty");
  }

  int getMin() {
    if (!st.empty()) {
      return st.top().minValue;
    }
    throw runtime_error("Stack is empty");
  }
};

int main() {
  MinStack minStack;
  cout << "Enter number of operations:" << endl;
  int operationsCount;
  cin >> operationsCount;
  cin.ignore();
  for (int i = 0; i < operationsCount; i++) {
    cout << "Enter operation (push <value> / pop / top / getMin):" << endl;
    string input;
    getline(cin, input);
    istringstream iss(input);
    string command;
    iss >> command;
    try {
      if (command == "push") {
        int value;
        iss >> value;
        minStack.push(value);
        cout << "Pushed: " << value << endl;
      } else if (command == "pop") {
        minStack.pop();
        cout << "Popped top element" << endl;
      } else if (command == "top") {
        cout << "Top element: " << minStack.top() << endl;
      } else if (command == "getMin") {
        cout << "Minimum element: " << minStack.getMin() << endl;
      } else {
        cout << "Invalid command" << endl;
      }
    } catch (const exception& e) {
      cout << e.what() << endl;
    }
  }
  return 0;
}
