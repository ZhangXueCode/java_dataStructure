public class Main {
    static class ListNode {
        public ListNode next;
        public ListNode pre;
        public int val;
    }

    //判断是否有环
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                return true;
            }
        }
        return false;
    }


    //如果有环 返回循环入口节点
    public ListNode detectCycle(ListNode head) {
        ListNode cur = head;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                break;
            }
        }
        if(fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}