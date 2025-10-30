import java.util.Stack;

public class MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();

    }

    public void push(int x) {
        s1.push(x);

    }

    public int pop() {
        if(empty()) {
            return -1;
        }
        if(s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    public int peek() {
        if(empty()) {
            return -1;
        }
        if(s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();

    }

    public boolean empty() {
        return s1.empty()&&s2.empty();
    }
}
