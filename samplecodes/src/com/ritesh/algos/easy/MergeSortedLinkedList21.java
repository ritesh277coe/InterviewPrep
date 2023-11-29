package com.ritesh.algos.easy;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class MergeSortedLinkedList21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode l1Curr = list1;
        ListNode l1Prev = null;
        ListNode l2Curr = list2;
        ListNode l2CurrNext = null;

        ListNode head = l1Curr;
        if (head == null) {
            return l2Curr;
        }

        while (l1Curr != null && l2Curr != null) {
            while (l1Curr != null && l2Curr != null && l1Curr.val < l2Curr.val) {
                l1Prev = l1Curr;
                l1Curr = l1Curr.next;
            }

            if (l1Prev == null) {
                l1Prev = l2Curr;
                l2CurrNext = l2Curr.next;
                l2Curr.next = l1Curr;

                l2Curr = l2CurrNext;
                head = l1Prev;
            } else {
                l2CurrNext = l2Curr.next;

                l2Curr.next = l1Curr;
                l1Prev.next = l2Curr;
                l1Prev = l2Curr;

                l2Curr = l2CurrNext;

            }
        }

        if (l1Curr == null) {
            if (l1Prev != null) {
                l1Prev.next = l2Curr;
            }

        }

        return head;

    }
}


