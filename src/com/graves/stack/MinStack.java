package com.graves.stack;

import java.util.Stack;

/**
 * @author Graves
 * @DESCRIPTION 最小栈
 * @create 2020/5/21
 */
public class MinStack {
    private Stack<Integer> mainStack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();

    /**
     * @author Graves
     * @DESCRIPTION:
     * @params: 入栈
     * @return: void
     * @Date: 2020/5/21 22:16
     * @Modified By:
     */
    public void push(int element) {
        mainStack.push(element);
        // 如果辅助栈为空，或者新元素小于或等于辅助栈顶元素，则将新元素压入辅助栈
        if (minStack.empty() || element < minStack.peek()) {
            minStack.push(element);
        }
    }

    /**
     * @author Graves
     * @DESCRIPTION:
     * @params: 出栈
     * @return: java.lang.Integer
     * @Date: 2020/5/21 22:17
     * @Modified By:
     */
    public Integer pop() {
        // 如果出栈元素和辅助栈栈顶元素相同，辅助栈出栈
        if (mainStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        return mainStack.pop();
    }

    /**
     * @author Graves
     * @DESCRIPTION:
     * @params: 获取最小元素
     * @return: int
     * @Date: 2020/5/21 22:20
     * @Modified By:
     */
    public int getMin() throws Exception {
        if (minStack.empty()) {
            throw new Exception("stack is empty");
        }
        return minStack.peek();
    }

    public static void main(String[] args) throws Exception {
        MinStack stack = new MinStack();
        stack.push(4);
        stack.push(9);
        stack.push(7);
        stack.push(3);
        stack.push(8);
        stack.push(5);
        System.out.println(stack.getMin());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin());
    }
}
