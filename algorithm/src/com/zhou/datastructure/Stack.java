package com.zhou.datastructure;

import com.zhou.prepare.StdIn;
import com.zhou.prepare.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by dell on 2017/11/6.
 */
public class Stack<Item> implements Iterable<Item> {
    private Node<Item> top;//栈顶指针
    private int n;//栈的大小
    private class Node<Item> {
        Node<Item> next;
        Item item;
    }

    public Stack() {
        this.top = null;
        this.n = 0;
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
        Stack<String> stack = new Stack<String>();
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
