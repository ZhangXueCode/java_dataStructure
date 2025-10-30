public class MyCircularQueue {
    private int[] elem;
    private int front;
    private int rear;
    public MyCircularQueue(int k) {
        this.elem =new int[k+1];
    }

    public boolean enQueue(int value) {
        if(isFull()) {
            return false;
        }
        elem[rear] = value;
        rear = (rear+1)%elem.length;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()) {
            return false;
        }
        front = (front+1)%elem.length;
        return true;

    }

    public int Front() {
        if(isEmpty()) {
            return -1;
        }
        return elem[front];


    }

    public int Rear() {
        if(isEmpty()) {
            return -1;
        }
        int key = (rear==0) ? elem.length-1 :rear-1;
        return elem[key];

    }

    public boolean isEmpty() {
        return rear==front;

    }
    public boolean isFull() {
        if((rear+1)%elem.length==front) {
            return true;
        }
        return false;
    }
}
