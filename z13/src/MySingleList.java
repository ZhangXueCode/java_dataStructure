public class MySingleList {
    static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode head;



    public ListNode partition(ListNode pHead, int x) {
        // write code here
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;
        ListNode cur = pHead;
        while(cur != null) {
            if(cur.val < x) {
                if(bs == null) {
                    bs = be = cur;
                }else {
                    be.next = cur;
                    be = be.next;
                }
            }else {
                if(as == null) {
                    as = ae = cur;
                }else {
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }
        if(bs == null) {
            return as;
        }
        if(ae != null) {
            ae.next = null;
        }
        be.next = as;
        return bs;
    }

    //判断是否为回文
    public boolean chkPalindrome(ListNode A) {
        // write code here
        //1.找到中间节点
        ListNode head = A;
        ListNode slow = A;
        ListNode fast = A;
        ListNode cur = A;
        ListNode curNext = null;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        cur = slow.next;
        //2.翻转
        while(cur != null) {
            curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        //3.head和slow往中间走直至相遇
        while(head != slow) {
            if(head.val != slow.val) {
                return false;
            }
            if(head.next == slow) {
                return true;
            }
            head = head.next;
            slow = slow.next;

        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            return head;
        }
        ListNode cur = head.next;
        ListNode curNext = null;
        head.next = null;

        while(cur != null) {
            curNext = cur.next;
            cur.next = head;
            head = cur;
            cur = curNext;
        }
        return head;
    }

    //删除所有等于val的节点
    public ListNode removeElements(.ListNode head, int val) {
        if(head == null) {
            return null;
        }
        ListNode cur = head.next;
        while(cur != null) {
            ListNode pre = find(head,val);
            if(cur.val == val) {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        if(head.val == val) {
            head = head.next;
        }
        return head;
    }
    public ListNode find(ListNode head, int val) {
        ListNode pre = head;
        while(pre != null && pre.next != null) {
            if(pre.next.val == val) {
                return pre;
            }
            pre = pre.next;
        }
        return null;
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //获取倒数第k个节点
    public ListNode getNode(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k-1; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    //合并两个升序链表
    public ListNode mergeTwoLists(ListNode headA, ListNode headB) {
        ListNode newHead = new ListNode(-1);
        ListNode cur = newHead;
        while(headA != null && headB != null) {
            if(headA.val < headB.val) {
                cur.next = headA;
                headA = headA.next;
            }else {
                cur.next = headB;
                headB = headB.next;
            }
            cur = cur.next;
        }
        if(headA != null) {
            cur.next = headA;
        }
        if(headB != null) {
            cur.next = headB;
        }
        return newHead.next;

    }


    //找出链表相交的节点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode pL = headA;//假设链表A是pL是更长的链表
        ListNode pS = headB;//假设链表B是pS是更短的链表
        while(pL != null) {
            lenA++;
            pL = pL.next;
        }
        while(pS != null) {
            lenB++;
            pS = pS.next;
        }
        pL = headA;
        pS = headB;
        int len = lenA-lenB;
        //修正
        if(len < 0) {
            pL = headB;
            pS = headA;
            len = lenB-lenA;
        }
        while(len > 0) {
            pL = pL.next;
            len--;
        }
        while(pL != pS ) {
            pL = pL.next;
            pS = pS.next;
        }
        return pL;
    }
}
