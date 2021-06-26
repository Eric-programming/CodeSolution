class MinStack {
    Stack<Integer> stack = new Stack<>(); //Store all values
    Stack<Integer> minStack = new Stack<>(); //Min value for each insertion
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int val) {
        if(minStack.isEmpty() || val < minStack.peek()){
            minStack.add(val);
        }else{
            minStack.add(minStack.peek());
        }
        stack.add(val);
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
