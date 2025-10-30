public class Test {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        singleLinkedList.addFirst(12);
        singleLinkedList.addFirst(23);
        singleLinkedList.addFirst(34);
        singleLinkedList.addFirst(45);
        singleLinkedList.display();
        singleLinkedList.addIndex(1,67);
        singleLinkedList.display();
        singleLinkedList.addLast(99);
        singleLinkedList.display();
        singleLinkedList.remove(45);
        singleLinkedList.display();
        System.out.println(singleLinkedList.size());
    }
}
