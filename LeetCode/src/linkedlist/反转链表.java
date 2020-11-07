package linkedlist;

public class 反转链表 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        ListNode tmp = listNode;
        for (int i = 1; i < 10; i++) {
            ListNode next = new ListNode(i);
            tmp.next = next;
            tmp = next;
        }
//        print(listNode);
        listNode= reverseList(listNode);
        print(listNode);
    }

    /**
     * TODO 反转就可以把链表直接反转
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public static void print(ListNode head){

        StringBuilder sb = new StringBuilder();

        while(head!= null){
            ListNode tmp = head.next;
            sb.append(head.toString());
            head = tmp;
        }
        System.out.println(sb.toString());
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "" + val + "->";
        }
    }


}
