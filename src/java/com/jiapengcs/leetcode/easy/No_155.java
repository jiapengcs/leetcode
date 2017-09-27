package com.jiapengcs.leetcode.easy;

import java.util.Stack;

/**
 * Created by Jiapeng 2017/9/27.
 *
 * 155. Min Stack
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */
public class No_155 {
    long min;
    Stack<Long> stack;

    public No_155(){
        stack=new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()){
            stack.push(0L);
            min=x;
        }else{
            stack.push(x-min);//Could be negative if min value needs to change
            if (x<min) min=x;
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;

        long pop=stack.pop();

        if (pop<0)  min=min-pop;//If negative, increase the min value

    }

    public int top() {
        long top=stack.peek();
        if (top>0){
            return (int)(top+min);
        }else{
            return (int)(min);
        }
    }

    public int getMin() {
        return (int)min;
    }

    public static void main(String[] args) {
        No_155 no_155 = new No_155();
        no_155.push(-2);
        no_155.push(0);
        no_155.push(-3);
        System.out.println(no_155.getMin());
        no_155.pop();
        System.out.println(no_155.top());
        System.out.println(no_155.getMin());
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
