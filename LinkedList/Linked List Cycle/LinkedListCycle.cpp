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
  bool hasCycle(ListNode* head) {
    ListNode* slow = head;
    ListNode* fast = head;
    while (fast != nullptr && fast->next != nullptr) {
      slow = slow->next;
      fast = fast->next->next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }
};

class LinkedListCycle {
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
  LinkedListCycle adder;
  while (tc-- > 0) {
    string l1Input;
    cin >> l1Input;
    vector<int> l1Values;
    stringstream ss(l1Input);
    string token;
    while (getline(ss, token, ',')) {
      l1Values.push_back(stoi(token));
    }
    ListNode* head = adder.createLinkedList(l1Values);
    cout << (solution.hasCycle(head) ? "true" : "false") << endl;
  }
  return 0;
}
