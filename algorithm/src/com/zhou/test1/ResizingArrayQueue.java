package com.zhou.test1;

import com.zhou.prepare.StdIn;
import com.zhou.prepare.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * 题1.3.14
 * Created by dell on 2017/11/7.
 */
public class ResizingArrayQueue<Item> implements Iterable<Item> {
    private Item[] q;//queue elements
    private int n;//number of elements on queue
    private int first;//index of the first element of queue
    private int last;//index of the last element of queue

    public ResizingArrayQueue() {
        this.q = (Item[])new Objects[2];
        this.n = 0;
        this.first = 0;
        this.last = 0;
    }

    public boolean isEmpty() {
        return this.n == 0;
    }

    public int size() {
        return this.n;
    }

    private void resize(int capacity) {
        assert capacity >= n;//断言调整的大小是否比目前的队列长度大
        Item[] temp = (Item[])new Objects[capacity];//新建数组
        for (int i=0; i<n; i++) {
            temp[i] = q[(first + i)%q.length];
        }
        q = temp;
        first = 0;
        last = n;
    }

    public void enqueue(Item item) {
        if (n == q.length) {
            this.resize(2*q.length);
        }
        q[last++] = item;
        if (last == q.length) {
            last = 0;//如果队列满了，队尾直接转到队首
        }
        this.n++;
    }

    public Item dequeue() {
        if (this.n == 0) {
            throw new NoSuchElementException("Queue underflow");
        }
        Item item = q[first];
        q[first] = null;
        first++;
        if (first == q.length) {
            first = 0;
        }
        if (n>0 && n == q.length/4) {
            resize(q.length/2);
        }
        return item;
    }

    public Item peek() {
        if (this.n == 0) {
            throw new NoSuchElementException("Queue underflow");
        }
        return q[first];
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }
    // an iterator, doesn't implement remove() since it's optional
    private class ArrayIterator implements Iterator<Item> {
        private int i = 0;
        public boolean hasNext()  { return i < n;                               }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = q[(i + first) % q.length];
            i++;
            return item;
        }
    }

    public static void main(String[] args) {
        ResizingArrayQueue<String> queue = new ResizingArrayQueue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) queue.enqueue(item);
            else if (!queue.isEmpty()) StdOut.print(queue.dequeue() + " ");
        }
        StdOut.println("(" + queue.size() + " left on queue)");
    }

}
