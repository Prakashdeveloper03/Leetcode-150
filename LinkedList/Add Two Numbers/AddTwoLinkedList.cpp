#include <iostream>
#include <sstream>
#include <string>
#include <vector>
using namespace std;

class ListNode {
 public:
  int val;
  ListNode* next;
  ListNode() : val(0), next(nullptr) {}
  ListNode(int x) : val(x), next(nullptr) {}
  ListNode(int x, ListNode* next) : val(x), next(next) {}
};

class Solution {
 public:
  ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
    ListNode* dummyHead = new ListNode(0);
    ListNode* tail = dummyHead;
    int carry = 0;
    while (l1 != nullptr || l2 != nullptr || carry != 0) {
      int digit1 = (l1 != nullptr) ? l1->val : 0;
      int digit2 = (l2 != nullptr) ? l2->val : 0;
      int sum = digit1 + digit2 + carry;
      int digit = sum % 10;
      carry = sum / 10;
      tail->next = new ListNode(digit);
      tail = tail->next;
      l1 = (l1 != nullptr) ? l1->next : nullptr;
      l2 = (l2 != nullptr) ? l2->next : nullptr;
    }
    return dummyHead->next;
  }
};

class AddTwoLinkedList {
 public:
  ListNode* createLinkedList(const vector<int>& values) {
    ListNode* dummyHead = new ListNode(0);
    ListNode* current = dummyHead;
    for (int value : values) {
      current->next = new ListNode(value);
      current = current->next;
    }
    return dummyHead->next;
  }

  void printLinkedList(ListNode* node) {
    while (node != nullptr) {
      cout << node->val;
      if (node->next != nullptr) {
        cout << " -> ";
      }
      node = node->next;
    }
    cout << endl;
  }
};

int main() {
  int tc;
  cin >> tc;
  Solution solution;
  AddTwoLinkedList adder;
  while (tc-- > 0) {
    string l1Input, l2Input;
    cin >> l1Input;
    vector<int> l1Values;
    stringstream l1Stream(l1Input);
    string token;
    while (getline(l1Stream, token, ',')) {
      l1Values.push_back(stoi(token));
    }
    cin >> l2Input;
    vector<int> l2Values;
    stringstream l2Stream(l2Input);
    while (getline(l2Stream, token, ',')) {
      l2Values.push_back(stoi(token));
    }
    ListNode* l1 = adder.createLinkedList(l1Values);
    ListNode* l2 = adder.createLinkedList(l2Values);
    ListNode* result = solution.addTwoNumbers(l1, l2);
    adder.printLinkedList(result);
  }
  return 0;
}
