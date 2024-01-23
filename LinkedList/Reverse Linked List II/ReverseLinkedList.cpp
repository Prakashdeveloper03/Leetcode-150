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
  ListNode* reverseBetween(ListNode* head, int left, int right) {
    if (head == nullptr || left == right) return head;
    ListNode* dummy = new ListNode(0);
    dummy->next = head;
    ListNode* prev = dummy;
    for (int i = 0; i < left - 1; i++) {
      prev = prev->next;
    }
    ListNode* cur = prev->next;
    for (int i = 0; i < right - left; i++) {
      ListNode* temp = cur->next;
      cur->next = temp->next;
      temp->next = prev->next;
      prev->next = temp;
    }
    return dummy->next;
  }
};

class ReverseLinkedList {
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
  ReverseLinkedList helper;
  while (tc-- > 0) {
    string l1Input;
    cin >> l1Input;
    vector<int> l1Values;
    stringstream ss(l1Input);
    string token;
    while (getline(ss, token, ',')) {
      l1Values.push_back(stoi(token));
    }
    int left, right;
    cin >> left >> right;
    ListNode* head = helper.createLinkedList(l1Values);
    head = solution.reverseBetween(head, left, right);
    helper.printLinkedList(head);
  }
  return 0;
}
