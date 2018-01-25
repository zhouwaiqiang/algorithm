package com.zhou.homework;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by dell on 2017/11/8.
 * 没写完
 */
public class CircleQueue<Item> implements Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int n;
    private class Node<Item> {
        Item item;
        Node<Item> next;
    }

    public CircleQueue() {
        this.first = null;
        this.last = null;
        this.n = 0;
    }

    public void enqueue(Item item) {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = first;
        if (this.isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
        }
        this.n++;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return this.n;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue underflow");
        }
        Node<Item> oldfirst = first;
        first = first.next;
        last.next = first;
        this.n--;
        return oldfirst.item;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}
