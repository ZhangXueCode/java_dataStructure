import java.util.StringTokenizer;

public class MyLinkedList {
    static class ListNode {
        public int val;
        public ListNode next;
        public ListNode pre;
        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode head;
    public ListNode last;
    public void addFirst(ListNode node) {
        if(head == null) {
            head = last = node;
        }
        node.next = head;
        head.pre = node;
        head = node;

    }
    //尾插法
    public void addLast(ListNode node) {
        if(head == null) {
            head = last = node;
        }
        last.next = node;
        node.pre = last;
        last = node;
    }
    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index,ListNode node) {
        if(index < 0 ||index > size()) {
            return false;
        }
        if(index == 0) {
            addFirst(node);
            return true;
        }
        if(index == size()-1) {
            addLast(node);
            return true;
        }
        ListNode cur = find(index);
        node.next = cur;
        cur.pre.next = node;
        cur.pre = node;
        node.pre = cur.pre;
        return true;

    }
    public ListNode find(int index) {
        ListNode cur = head;
        while (index != 0) {
            cur = cur.next;
        }
        return cur;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        ListNode cur = head;
        while (cur != null) {
            if(cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        ListNode cur = head;
        while (cur != null) {
            if(cur.val == key) {
                if(cur == head) {
                    //删除头节点
                    head = head.next;
                    if(head != null) {
                        //不只有一个节点的情况
                        head.pre = null;
                    }else {
                        //只有一个节点 将尾也置为空
                        last = null;
                    }
                }else {
                    if(cur.next != null) {
                        //删除中间节点
                        cur.next.pre = cur.pre;
                        cur.pre.next = cur.next;
                    }else {
                        //删除last节点
                        last.pre.next =null;
                        last = last.pre;
                    }
                }
                return;
            }else {
                cur = cur.next;
            }
        }
    }
    //删除所有值为key的节点
    public void removeAllKey(int key) {
        ListNode cur = head;
        while (cur != null) {
            if(cur.val == key) {
                if(cur == head) {
                    //删除头节点
                    head = head.next;
                    if(head != null) {
                        //不只有一个节点的情况
                        head.pre = null;
                    }else {
                        //只有一个节点 将尾也置为空
                        last = null;
                    }
                }else {
                    if(cur.next != null) {
                        //删除中间节点
                        cur.next.pre = cur.pre;
                        cur.pre.next = cur.next;
                    }else {
                        //删除last节点
                        last.pre.next =null;
                        last = last.pre;
                    }
                }
                cur = cur.next;
            }else {
                cur = cur.next;
            }
        }

    }
    //得到单链表的长度
    public int size() {
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
    public void display() {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void clear() {
        ListNode cur = head;
        ListNode curNext = null;
        while (cur != null) {
            curNext = cur.next;
            cur.pre = null;
            cur.next = null;
            cur = curNext;
        }
        head = null;
        last = null;
    }
}
