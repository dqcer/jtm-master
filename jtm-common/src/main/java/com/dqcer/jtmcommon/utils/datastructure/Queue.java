package com.dqcer.jtmcommon.utils.datastructure;

/**
 * 队列
 *
 * @author dqcer
 * @description
 * @date 22:14 2020/1/30
 */
public class Queue<E> {
    /**
     * 存储数组
     */
    private Object[] nodes = null;

    /**
     * 队列容量
     */
    private int size;

    /**
     * 队列头
     */
    private int front;

    /**
     * 队列尾
     */
    private int rear;

    public Queue() {
        this(10);
    }

    public Queue(int initialSize) {
        this.size = initialSize;
        nodes = new Object[initialSize];
    }

    public boolean add(E e) {
        if (rear == size) {
            throw new RuntimeException("队列已满，无法插入新的元素");
        }
        nodes[rear ++] = e;
        return true;
    }

    /**
     * 出队，并移除元素
     *
     * @return
     */
    public E poll() {
        E node = (E) nodes[front];
        if (node == null) {
            throw new RuntimeException("空队列异常");
        }
        nodes[front ++] = null;
        return node;
    }

    public E peek() {
        E node = (E) nodes[front];
        if (node == null) {
            throw new RuntimeException("空队列异常");
        }
        return node;
    }

    public static void main(String[] args) {
        Queue<String> stringQueue = new Queue<>();
        stringQueue.add("1");
        System.out.println(stringQueue.peek());
        stringQueue.add("2");
        stringQueue.add("3");
        stringQueue.add("4");
        stringQueue.add("5");
        stringQueue.add("6");
        stringQueue.add("7");
        stringQueue.add("8");
        stringQueue.add("9");
        System.out.println(stringQueue.peek());
        System.out.println(stringQueue.peek());
        System.out.println(stringQueue.peek());
        System.out.println(stringQueue.peek());
        System.out.println(stringQueue.peek());
        System.out.println(stringQueue.peek());
        System.out.println(stringQueue.peek());
        System.out.println(stringQueue.peek());
        System.out.println(stringQueue.peek());
    }
}
