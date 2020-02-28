package com.dqcer.jtmcommon.utils.datastructure;

/**
 * 单向链表
 *
 * @author dqcer
 * @description
 * @date 18:52 2020/1/31
 */
public class SingleLinkedList {

    /**
     * 链表节点的个数
     */
    private int length;

    private Node head;

    public SingleLinkedList() {

    }

    private class Node {
        /**
         * 每个节点的数据
         */
        private Object data;

        /**
         * 每个节点指向下一个节点的链接
         */
        private Node next;

        public Node(Object data) {
            this.data = data;
        }
    }

    /**
     * 在链表头添加元素
     *
     * @param object
     * @return
     */
    public Object addHead(Object object) {
        //  定义新节点
        Node newHead = new Node(object);
        //  如果链表为空， 则将该节点设置为头部节点
        if (length == 0) {
            head = newHead;
        } else {
            //  设置当前节点为头部节点，并将当前节点的下一个节点指向原来的头部节点
            head = newHead;
            newHead.next = head;
        }
        //  链表长度 +1
        length ++;
        return object;
    }

    public boolean delete(Object object) {
        if (length == 0) {
            return false;
        }
        Node current = head;
        Node previous = head;
        while (current.data != object) {
            if (current.next == null) {
                return false;
            } else {
                previous = current;
                current = current.next;
            }
        }
        //  如果删除的节点是头节点
        if (current == head) {
            head = current.next;
            length--;
        } else {
            //  删除的不是头节点
            previous.next = current.next;
            length --;
        }
        return true;
    }

    /**
     * 查找指定的元素，若找到了则返回节点Node, 找不到则返回null
     *
     * @param object
     * @return
     */
    public Node find(Object object) {
       Node current = head;
       int tempSize = length;
        while (tempSize > 0) {
            if (object.equals(current.data)) {
                return current;
            } else {
                current = current.next;
            }
            tempSize --;
        }
        return null;
    }

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addHead("2");
        singleLinkedList.head.data = 12;
        singleLinkedList.addHead("3");
        singleLinkedList.addHead("4");
        Node node = singleLinkedList.find("3");
        System.out.println(node.next);
    }
}
