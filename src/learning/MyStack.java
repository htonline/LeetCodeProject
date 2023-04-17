package learning;

import java.util.Stack;

/**
 * @author Zuohaitao
 * @date 2023-04-17 16:25
 * @describe
 * 用数组实现栈
 */
public class MyStack {
    private int[] stack;
    private int top;

    public MyStack(int size) {
        stack = new int[size];
        top = -1;
    }
    public void push(int x) {
        if (top == stack.length - 1) {
            throw new RuntimeException("Stack is full");
        }
        stack[++top] = x;
    }
//    弹出顶端元素
    public int pop() {
        if (top == -1) {
            throw new RuntimeException("Stack is empty");
        }
        return stack[top--];
    }
//    输出顶端元素
    public int peek() {
        if (top == -1) {
            throw new RuntimeException("Stack is empty");
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

}
