package com.zhou.sort;


import com.zhou.prepare.In;
import com.zhou.prepare.StdOut;

/**
 * Created by dell on 2017/11/8.
 * 选择排序算法，时间复杂度是O（n^2）
 */
public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;//基于堆的完全二叉树
    private int N=0;
    public MaxPQ() {

    }

    public MaxPQ(int max) {
        pq = (Key[]) new Comparable[max+1];//比最大的大一个空间
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        pq[++N] = v;

    }

    public Key delMax() {
        return pq[0];
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
     }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void swim(int k) {
        //上浮算法
        /**
         * 由下至上的检索
         */
        while (k>1 && less(k/2, k)) {
            exch(k/2, k);
            k = k/2;
        }
    }

    private void sink(int k) {
        //下沉算法
        /**
         * 由上至下检索直到合适的位置
         */
        while (2*k <= N) {
            int j = 2*k;
            if (j<N && less(j, j+1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k,j);
            k = j;
        }
    }


}
