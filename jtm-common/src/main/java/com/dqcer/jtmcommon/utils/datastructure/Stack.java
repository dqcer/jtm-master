package com.dqcer.jtmcommon.utils.datastructure;

/**
 * 基于数组实现的顺序栈
 *
 * @author dqcer
 * @description
 * @date 13:39 2020/1/29
 */
public class Stack<E> {

    private Object[] data = null;
    /**
     * 栈的容量
     */
    private int maxSize = 0;

    /**
     * 栈顶的指针
     */
    private int top = -1;

    Stack() {
        //  默认10；
        this(10);
    }

    Stack(int initialSize) {
        if (initialSize >= initialSize) {
            this.maxSize = initialSize;
            data = new Object[initialSize];
            top = -1;
        } else {
            throw new RuntimeException("初始化大小不能小于0 : " + initialSize);
        }
    }

    /**
     * 进栈， 第一个元素top 0
     *
     * @param e
     * @return
     */
    public boolean push(E e) {
        if (top == maxSize - 1) {
            throw new RuntimeException("栈已满， 无法将元素入栈");
        }
        data[++top] = e;
        return true;
    }

    /**
     * 弹出栈顶的元素
     *
     * @return
     */
    public E pop() {
        if (top == -1) {
            throw new RuntimeException("栈为空");
        }
        return (E) data[top --];
    }

    /**
     * 查看栈顶元素但不移除
     *
     * @return
     */
    public E peek() {
        if (top == -1) {
            throw new RuntimeException("栈为空");
        }
        return (E) data[top];
    }

    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>();
        stringStack.push("1");
        stringStack.push("2");
        System.out.println(stringStack.pop());
        System.out.println(stringStack.pop());
    }
}
