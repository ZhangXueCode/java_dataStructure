import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();

    }
    public void push(int val) {
        stack.push(val);
        if(minStack.empty()) {
            minStack.push(val);
        }else {
            if(val<=minStack.peek()) {
                minStack.push(val);
            }
        }

    }


    public void pop() {
        if(!stack.empty()) {
            int val = stack.peek();
            stack.pop();
            if(minStack.peek()==val) {
                minStack.pop();
            }
        }

    }

    public int top() {
        if(stack.empty()) {
            return -1;
        }else {
            return stack.peek();
        }


    }

    public int getMin() {
        if(minStack.empty()) {
            return -1;
        }else {
            return minStack.peek();
        }

    }

}
