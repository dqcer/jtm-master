package com.dqcer.jtmcommon.utils.datastructure;

/**
 * 队列
 *
 * @author dqcer
 * @description
 * @date 22:14 2020/1/30
 */
public class Queue<E> {

    private Object[] nodes = null;
    private int initialSize;
    private int start;
    private int end;

    public Queue() {
        this(8);
    }

    public Queue(int initialSize) {
        this.initialSize = initialSize;
        nodes = new Object[initialSize];
    }

    public boolean push(E e) {
        if (end == initialSize) {
            throw new RuntimeException("队列已满，无法插入新的元素");
        }
        nodes[end ++] = e;
        return true;
    }

    public E peek() {
        E node = (E) nodes[start];
        nodes[start ++] = null;
        return node;
    }

    public static void main(String[] args) {
        Queue<String> stringQueue = new Queue<>();
        stringQueue.push("1");
        stringQueue.push("2");
        stringQueue.push("3");
        stringQueue.push("4");
        stringQueue.push("5");
        stringQueue.push("6");
        stringQueue.push("7");
        stringQueue.push("8");
        stringQueue.push("9");
        System.out.println(stringQueue.peek());
        System.out.println(stringQueue.peek());
    }
}
