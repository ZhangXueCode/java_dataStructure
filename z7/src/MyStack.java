import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class MyStack {
    private Queue<Integer> qu1;
    private Queue<Integer> qu2;
    public MyStack() {
        qu1 = new ArrayDeque<>();
        qu2 = new ArrayDeque<>();

    }

    public void push(int x) {
        if(!qu1.isEmpty()) {
            qu1.offer(x);
        } else if (!qu2.isEmpty()) {
            qu2.offer(x);
        }else {
            qu1.offer(x);
        }
    }

    public int pop() {
        if(!qu1.isEmpty()) {
            int size = qu1.size();
            for (int i = 0; i < size-1; i++) {
                int k = qu1.poll();
                qu2.offer(k);
            }
            return qu1.poll();
        }else if(!qu2.isEmpty()){
            int size = qu2.size();
            for (int i = 0; i < size-1; i++) {
                int k = qu2.poll();
                qu1.offer(k);
            }
            return qu2.poll();
        }else {
            return -1;
        }
    }

    public int top() {
        int k=0;
        if(!qu1.isEmpty()) {
            int size = qu1.size();
            for (int i = 0; i < size; i++) {
                k = qu1.poll();
                qu2.offer(k);
            }
            return k;
        }else if(!qu2.isEmpty()){
            int size = qu2.size();
            for (int i = 0; i < size; i++) {
                k = qu2.poll();
                qu1.offer(k);
            }
            return k;
        }else {
            return -1;
        }

    }

    public boolean empty() {
        if(!qu1.isEmpty()||!qu2.isEmpty()) {
            return false;
        }
        return true;

    }
}
