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
  ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
    ListNode* dummy = new ListNode(0);
    ListNode* current = dummy;
    while (list1 != nullptr && list2 != nullptr) {
      if (list1->val < list2->val) {
        current->next = list1;
        list1 = list1->next;
      } else {
        current->next = list2;
        list2 = list2->next;
      }
      current = current->next;
    }
    if (list1 != nullptr) {
      current->next = list1;
    } else {
      current->next = list2;
    }
    return dummy->next;
  }
};

class MergeSortedLists {
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
  MergeSortedLists helper;
  while (tc-- > 0) {
    string l1Input;
    cin >> l1Input;
    vector<int> l1Values;
    stringstream ss1(l1Input);
    string token;
    while (getline(ss1, token, ',')) {
      l1Values.push_back(stoi(token));
    }
    ListNode* list1 = helper.createLinkedList(l1Values);
    string l2Input;
    cin >> l2Input;
    vector<int> l2Values;
    stringstream ss2(l2Input);
    while (getline(ss2, token, ',')) {
      l2Values.push_back(stoi(token));
    }
    ListNode* list2 = helper.createLinkedList(l2Values);
    ListNode* mergedList = solution.mergeTwoLists(list1, list2);
    helper.printLinkedList(mergedList);
  }
  return 0;
}
