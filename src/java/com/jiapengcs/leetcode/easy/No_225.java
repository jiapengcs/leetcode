package com.jiapengcs.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2018/1/24
 *
 * 225. Implement Stack using Queues
 *
 * Implement the following operations of a stack using queues.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 *
 * Notes:
 * You must use only standard operations of a queue -- which means only push to back, peek/pop from front,
 * size, and is empty operations are valid.
 *
 * Depending on your language, queue may not be supported natively.
 * You may simulate a queue by using a list or deque (double-ended queue),
 * as long as you use only standard operations of a queue.
 *
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 *
 * 分析：用队列实现栈
 * 为了翻转出队顺序，每个元素入队后，将它之前的每个元素依次出队再重新入队。
 */
public class No_225 {
    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public No_225() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
        int size = queue.size();
        while (--size > 0) {
            queue.offer(queue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        No_225 no_225 = new No_225();
        no_225.push(1);
        no_225.push(2);
        no_225.push(3);
        System.out.println(no_225.empty());
        System.out.println(no_225.top());
        System.out.println(no_225.pop());
        System.out.println(no_225.pop());
        System.out.println(no_225.pop());
        System.out.println(no_225.empty());
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */