// 1、无头单向非循环链表实现
public class SingleLinkedList {
    static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode head;
    public void createList() {
        ListNode node1 = new ListNode(12);
        ListNode node2 = new ListNode(23);
        ListNode node3 = new ListNode(34);
        ListNode node4= new ListNode(45);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;


        ListNode head = node1;

    }
    public int size() {
        ListNode cur = head;
        int count=1;
        while (cur.next!=null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
    public void display() {
        ListNode cur = head;
        for(int i=0;i<size();i++) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();

    }
    //头插法
    public void addFirst(int data) {
        ListNode cur = head;
        ListNode del = new ListNode(data);
        del.next = head;
        head = del;
    }
    //尾插法
    public void addLast(int data) {
        ListNode cur = head;
        ListNode del = new ListNode(data);
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = del;
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data) {
        ListNode cur = head;
        ListNode del = new ListNode(data);
        for (int i = 0; i <index-1 ; i++) {
            cur = cur.next;
        }
        del.next = cur.next;
        cur.next = del;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        ListNode cur = head;
        if(head==null) {
            if(head.val==key) {
                return true;
            }
        }
        while (cur.next!=null) {
            if(cur.val==key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        ListNode cur = head;
        if(head.val==key) {
            cur = cur.next;
            head = cur;
            return;
        }
        while (cur.next!=null) {
            if(cur.next.val==key) {
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
        }
        System.out.println("没有你要删除的节点");
    }

}
