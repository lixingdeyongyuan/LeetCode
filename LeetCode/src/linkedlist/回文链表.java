package linkedlist;

public class 回文链表 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(1);

        nextHa(listNode,listNode1);
        nextHa(listNode1,listNode2);
        nextHa(listNode2,listNode3);
//        ListNode listNode = new ListNode(0);
//
//        ListNode cur = listNode;
//        for (int i = 1; i <= 4; i++) {
//            ListNode next = new ListNode(i);
//            cur.next = next;
//            cur = next;
//        }
//        for (int i = 5; i >= 0; i--) {
//            ListNode next = new ListNode(i);
//            cur.next = next;
//            cur = next;
//        }
        System.out.println(isPalindrome(listNode));
    }

    public static void nextHa(ListNode pre, ListNode next) {
        pre.next = next;
    }

    public static boolean isPalindrome(ListNode head) {
        /**
         * TODO 快慢指针的定义更加的完美，灵活使用了二分法
         */
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        ListNode middleListNode = slow;
        middleListNode = reverseListNode(middleListNode);
        while (middleListNode != null) {
            if (middleListNode.val != head.val) {
                return false;
            }
            middleListNode = middleListNode.next;
            head = head.next;
        }
        return true;
    }

    public static ListNode reverseListNode(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public static ListNode middleListNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
