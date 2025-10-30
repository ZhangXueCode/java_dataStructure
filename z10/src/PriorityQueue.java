import java.util.Arrays;


public class PriorityQueue {
    public int[] elem;
    public int usedSize;

    public PriorityQueue() {
        this.elem = new int[10];
    }

    /**
     * 建堆的时间复杂度：
     *
     * @param array
     */
    public  void initHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            elem[i] = array[i];
            usedSize++;
        }
    }
    public void createHeap() {
        for (int parent = (usedSize-2)/2 ; parent >=0 ; parent--) {
            shiftDown(parent,usedSize);
        }
    }


    private void shiftDown(int parent,int usedSize) {
        int child = parent*2+1;
        while (child < usedSize) {
            if(child+1 < usedSize && elem[child] <elem[child+1]) {
                child++;
            }
            //child一定指向更大的
            if(elem[child] >elem[parent]) {
                swap(child,parent);
                parent = child;
                child = parent*2+1;
            }else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        int tmp = elem[i];
        elem[i] = elem[j];
        elem[j] = tmp;
    }


    /**
     * 入队：仍然要保持是大根堆
     * @param val
     */
    public void push(int val) {
        if(isFull()) {
            elem = Arrays.copyOf(elem,2*elem.length);
        }
        elem[usedSize] = val;
        shiftUp(usedSize);
        usedSize++;


    }

    private void shiftUp(int child) {
        int parent = (child-1)/2;
        while (child > 0) {
            if(elem[child] > elem[parent]) {
                swap(child,parent);
                child = parent;
                parent = (child-1)/2;
            }else {
                break;
            }
        }
    }

    public boolean isFull() {
        return usedSize== elem.length;
    }

    /**
     * 出队【删除】：每次删除的都是优先级高的元素
     * 仍然要保持是大根堆
     */
    public int pollHeap() {
        int tmp = elem[0];
        swap(0,usedSize-1);
        usedSize--;
        shiftDown(0,usedSize);
        return tmp;

    }

    public boolean isEmpty() {
        return usedSize==0;
    }

}




