package com.zhou.homework;

import com.zhou.prepare.StdIn;
import com.zhou.prepare.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by dell on 2017/11/6.
 */
public class StackCopy<Item> implements Iterable<Item> {
    private Node<Item> top;//栈顶指针
    private int n;//栈的大小
    private class Node<Item> {
        Node<Item> next;
        Item item;
        public Node() {
        }

        //栈的复制需要的构造函数，暂时没懂啥意思
        public Node(Node<Item> x) {
            this.item = x.item;
            if (x.next != null) {
                this.next = new Node<Item>(x.next);
            }
        }
    }

    public StackCopy() {
        this.top = null;
        this.n = 0;
    }

    //迭代实现栈的复制
    public StackCopy(StackCopy<Item> s) {
        this.top = new Node<Item>(s.top);
    }

    public boolean isEmpty() {
        return this.top == null;
    }

    public int size() {
        return this.n;
    }

    public void push(Item item) {
        Node<Item> oldTop = this.top;
        top = new Node<Item>();
        top.next = oldTop;
        top.item = item;
        this.n++;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is null");
        }
        Item item = top.item;
        top = top.next;
        this.n--;
        return item;
    }

    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }
        return top.item;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    private class ListIterator<Item> implements Iterator<Item> {

        private Node<Item> first;

        public ListIterator(Node<Item> first) {
            this.first = first;
        }

        @Override
        public boolean hasNext() {
            return first != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = first.item;
            first = first.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        StackCopy<String> stack = new StackCopy<String>();
        while(!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                stack.push(item);
            } else if(!stack.isEmpty()) {
                StdOut.print(stack.pop() + " ");
            }
        }
        StdOut.println("(" + stack.size() + " left on stack)");
    }
}
