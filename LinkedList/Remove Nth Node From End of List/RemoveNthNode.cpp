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
  ListNode* removeNthFromEnd(ListNode* head, int n) {
    ListNode* dummy = new ListNode(0);
    dummy->next = head;
    ListNode* first = dummy;
    ListNode* second = dummy;
    for (int i = 0; i <= n; i++) {
      first = first->next;
    }
    while (first != nullptr) {
      first = first->next;
      second = second->next;
    }
    second->next = second->next->next;
    return dummy->next;
  }
};

class RemoveNthNode {
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
  RemoveNthNode helper;
  while (tc-- > 0) {
    string l1Input;
    cin >> l1Input;
    vector<int> l1Values;
    stringstream ss(l1Input);
    string token;
    while (getline(ss, token, ',')) {
      l1Values.push_back(stoi(token));
    }
    int n;
    cin >> n;
    ListNode* head = helper.createLinkedList(l1Values);
    head = solution.removeNthFromEnd(head, n);
    helper.printLinkedList(head);
  }
  return 0;
}
