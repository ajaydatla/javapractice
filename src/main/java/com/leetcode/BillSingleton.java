package com.leetcode;

public class BillSingleton {

//    Input: head = [1,2,3,3,4,4,5]
//    Output: [1,2,5]
//    remove duplicates using singly link list

    public ListNode deleteDuplicates(ListNode head) {

        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode prev = temp;

        while(temp.next != null &&  temp.next.next != null) {

            if(prev.next.val == temp.next.next.val) {
                while(temp.next != null && temp.next.val == prev.next.val) {
                    prev.next = temp.next;
                }
            }else{

            }

        }

        return temp.next;
    }

    public static void main(String[] args) {
        BillSingleton  billSingleton = new BillSingleton();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        ListNode result = billSingleton.deleteDuplicates(head);
    }

}
class ListNodeCustom {
    int val;
    ListNodeCustom next;
    ListNodeCustom(int val) {
        this.val = val;
    }
    ListNodeCustom(int val, ListNodeCustom next) {
        this.val = val;
        this.next = next;
    }
}

