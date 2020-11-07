package linkedlist;

public class 合并两个有序链表 {
    public static void main(String[] args) {

    }

    /**
     * 我的解决方案
     * 还可以去掉cur1和cur2
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 找到最短的链表
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode head = new ListNode(0);
        ListNode head1 = head;
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        while(cur1!= null && cur2 != null){
            if(cur1.val < cur2.val){
                head.next = cur1;
                head = cur1;
                cur1 = cur1.next;
                /**
                 *  目的：当为空的时候可以把这个值复制到末尾；但是实际是可以去掉这一步的
                 * {@link #mergeTwoLists2(ListNode, ListNode)中while 后的设置}
                 * */
                if(cur1 == null){
                    head.next = cur2;
                }
            } else  {
                head.next = cur2;
                head = cur2;
                cur2 = cur2.next;
                if(cur2 == null){
                    head.next = cur1;
                }
            }
        }
        return head1.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        // 找到最短的链表
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode head = new ListNode(0);
        ListNode head1 = head;
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        while(cur1!= null && cur2 != null){
            if(cur1.val < cur2.val){
                head.next = cur1;
                head = cur1;
                cur1 = cur1.next;

            } else  {
                head.next = cur2;
                head = cur2;
                cur2 = cur2.next;

            }
            /**
             * TODO
             * {@link #mergeTwoLists(ListNode, ListNode)}
             */
            head.next = cur1 == null? cur2:cur1;
        }
        return head1.next;
    }


    /**
     * 递归解决
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists0(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
