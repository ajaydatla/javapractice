package com.leetcode;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode finalList;

        for (int i = 0; i < lists.length; i++) {
            finalList = new ListNode(lists[i].val);
        }

        return null;
    }
}


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
