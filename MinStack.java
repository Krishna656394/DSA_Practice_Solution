package StackDataStructure;

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int value) {
        if (stack.isEmpty()) {
            stack.push(value);
            minStack.push(value);
        } else {
            stack.push(value);
            minStack.push(Math.min(value, minStack.peek()));
        }
    }

    public void pop() throws Exception {
        if (stack.isEmpty()) {
            throw new Exception("Stack Underflow");
        } else {
            stack.pop();
            minStack.pop();
        }
    }

    public int top() {
        if(stack.isEmpty()){
            return -1;
        }
        return stack.peek();
    }

    public int getMin() {
        if(stack.isEmpty()){
            return 0;
        }
        return minStack.peek();
    }

    public static void main(String[] args) throws Exception {

        MinStack obj = new MinStack();

        obj.push(5);
        obj.push(20);
        obj.push(3);
        obj.push(10);
        obj.push(2);

        System.out.println("Top: " + obj.top());
        System.out.println("Minimum: " + obj.getMin());

        obj.pop();

        System.out.println("After pop:");
        System.out.println("Top: " + obj.top());
        System.out.println("Minimum: " + obj.getMin());
    }
}