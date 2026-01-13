package com.leetcode;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode initial = null;
        for (int i = 0; i < lists.length; i++) {
            if(initial == null) initial = lists[i];
            else if(initial.val > lists[i].val){
                initial = lists[i];
            }
        }
        return initial;
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
