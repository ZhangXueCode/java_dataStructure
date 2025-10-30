import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

class IntCmp implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
    }
}
    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(arr.length);
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = priorityQueue.poll();
        }
        return ret;

    }
    public int[] smallestK2(int[] arr, int k){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new IntCmp());
        int[] ret = new int[k];
        if(k==0) {
            return ret;
        }
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(arr[i]);
        }
        for (int i = k; i < arr.length ; i++) {
            int t = priorityQueue.peek();
            if(arr[i]<t) {
                priorityQueue.poll();
                priorityQueue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            ret[i] = priorityQueue.poll();
        }
        return ret;


    }


}