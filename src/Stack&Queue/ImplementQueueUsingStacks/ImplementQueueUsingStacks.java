import java.util.*;

class MyQueue {
    Stack<Integer> pushStack = new Stack<>();
    Stack<Integer> popStack = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        pushStack.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        transferItems();
        return popStack.pop();
    }

    private void transferItems() {
        if (popStack.isEmpty()) {
            // Transfer elements onto the pop stack
            while (!pushStack.isEmpty()) {
                popStack.add(pushStack.pop());
            }
        }
    }

    /** Get the front element. */
    public int peek() {
        transferItems();
        return popStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such: MyQueue obj =
 * new MyQueue(); obj.push(x); int param_2 = obj.pop(); int param_3 =
 * obj.peek(); boolean param_4 = obj.empty();
 */
