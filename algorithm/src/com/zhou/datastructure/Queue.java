package com.zhou.datastructure;

import com.zhou.prepare.StdIn;
import com.zhou.prepare.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by dell on 2017/11/6.
 */
public class Queue<Item> implements Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int n;//队列的长度

    private class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Queue() {
        this.first = null;
        this.last = null;
        this.n = 0;
    }

    public void enqueue(Item item) {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
        }
        this.n++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw  new NoSuchElementException("Queue underflow");
        }
        Item itemTemp = first.item;
        first = first.next;
        this.n--;
        if (isEmpty()) {
            last = null;
        }
        return itemTemp;
    }

    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue UnderFlow");
        }
        return first.item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item itemTemp : this) {
            s.append(itemTemp);
            s.append(' ');
        }
        return s.toString();
    }

    public int size() {
        return this.n;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<String>();
        while(!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                queue.enqueue(item);
            } else if(!queue.isEmpty()) {
                StdOut.print(queue.dequeue() + " ");
            }
        }
        StdOut.println("(" + queue.size() + " left on queue)");
    }
}
