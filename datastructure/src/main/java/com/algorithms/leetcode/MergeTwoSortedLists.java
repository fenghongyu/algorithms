package com.algorithms.leetcode;

/**
 * Created on 2019-08-25
 *
 * @author fenghongyu
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        MergeTwoSortedLists lists = new MergeTwoSortedLists();
        lists.test();
    }

    private void test() {
        ListNode one = new ListNode(1);
        one.next = new ListNode(4);
        one.next.next = new ListNode(6);
        one.next.next.next = new ListNode(9);

        ListNode two = new ListNode(2);
        two.next = new ListNode(3);
        two.next.next = new ListNode(4);

        ListNode result = mergeList(one, two);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }

    }

    public ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode pre = result;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        if (l1 != null) {
            pre.next = l1;
        }
        if (l2 != null) {
            pre.next = l2;
        }

        return result.next;
    }

    public class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
