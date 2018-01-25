package com.zhou.datastructure;

import com.zhou.prepare.StdIn;
import com.zhou.prepare.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by dell on 2017/11/6.
 */
public class Bag<Item> implements Iterable<Item> {
    private Node<Item> first;
    private int n;//bag的大小
    private static class Node<Item> {
        //链表数据结构
        private Item item;
        private Node<Item> next;
    }

    public Bag() {
        first = null;
        this.n = 0;
    }

    public void add(Item item) {
        Node<Item> oldFirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    public boolean isEmpty() {
        return first == null;
    }

    private int size() {
        return this.n;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            this.current = first;
        }
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        Bag<String> bag = new Bag<String>();
        while(!StdIn.isEmpty()) {
            String item = StdIn.readString();
            bag.add(item);
        }

        StdOut.println("size of bag = " + bag.size());
        for (String s:bag) {
            StdOut.println(s);
        }
    }
}
