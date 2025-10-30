public class HashBuck {
    private static class Node {
        private int key;
        private int value;
        Node next;


        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node[]  array;
    private int size;   // 当前的数据个数
    private static final double LOAD_FACTOR = 0.75;
    private static final int DEFAULT_SIZE = 8;//默认桶的大小
    public HashBuck() {
        array = new Node[10];
    }

    public int put(int key, int value) {
        int index = key % array.length;
        Node cur = array[index];
        while (cur != null) {
            if(cur.key == key) {
                cur.value = value;
                return value;
            }
            cur = cur.next;
        }
        Node node = new Node(key,value);
        node.next = array[index];
        array[index] = node;
        size++;
        if(loadFactor() >= 0.75) {
            resize();
        }
        return -1;
    }


    private void resize() {
        Node[] tmp = new Node[array.length*2];
        for (int i = 0; i < array.length; i++) {
            Node cur = array[i];
            while (cur != null) {
               Node curNext = cur.next;
               int newIndex = cur.key % tmp.length;
               cur.next = tmp[newIndex];
               tmp[newIndex] = cur;
               cur = curNext;
            }
        }
        array = tmp;
    }


    private double loadFactor() {
        return size * 1.0 / array.length;
    }


    public int get(int key) {
        int index = key % array.length;
        Node cur = array[index];
        while (cur != null) {
            if(cur.key == key) {
                return cur.value;
            }
            cur = cur.next;
        }
        return -1;
    }
}
