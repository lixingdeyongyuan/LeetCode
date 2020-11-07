package linkedlist;

public class 移除链表元素 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(1);

        nextHa(listNode,listNode1);
        nextHa(listNode1,listNode2);
        nextHa(listNode2,listNode3);

        ListNode first = removeElements(null,3);
        System.out.println(first);
    }

    public static void nextHa(ListNode pre, ListNode next) {
        pre.next = next;
    }

    public ListNode removeElements1(ListNode head, int val) {
        // 哨兵解决法，这个可以通过增加一个，来去掉盘空的逻辑
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode prev = sentinel, curr = head;
        while (curr != null) {
            if (curr.val == val) prev.next = curr.next;
            else prev = curr;
            curr = curr.next;
        }
        return sentinel.next;
    }

    /**
     * TODO 我的解法
     * 1.增加了判空逻辑
     * 2.增加了next的空间复杂度
     * @param listNode
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode listNode,int val){
        ListNode first = null;
        ListNode next;
        ListNode pre = null;
        ListNode cur = listNode;
        while (cur != null){
            next = cur.next;
            if (cur.val == val) {
                cur = next;
                if (pre != null) {
                    pre.next = null;
                }
            } else {
                if(pre != null){
                    pre.next = cur;
                }
                // 增加了判断的逻辑。这一步实际可以想办法用哨兵解决掉
                if(first == null){
                    first = cur;
                }
                pre = cur;
                cur = next;
            }
        }
        return first;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
