package com.zhou.sort;


import com.zhou.prepare.In;
import com.zhou.prepare.StdOut;

/**
 * Created by dell on 2017/11/8.
 * 选择排序算法，时间复杂度是O（n^2）
 */
public class Selection {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i=0; i<N; i++) {
            int min = i;
            for (int j=i+1; j<N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, min, i);
        }
    }

    public static void select(Comparable[] a) {
        //选择排序的递归选择

    }
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
     }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i=0; i<a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i=1; i<a.length; i++) {
            if (less(a[i], a[i-1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] a = In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
