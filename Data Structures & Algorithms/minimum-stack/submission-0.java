class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);

        if (minStack.isEmpty() || val <= minStack.peek()) minStack.push(val);
    }
    
    public void pop() {
        var poppedVal = stack.pop();
        if (Objects.equals(poppedVal, minStack.peek())) minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
