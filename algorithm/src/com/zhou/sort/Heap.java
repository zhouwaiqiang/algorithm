package com.zhou.sort;


import com.zhou.prepare.In;
import com.zhou.prepare.StdOut;

/**
 * Created by dell on 2017/11/8.
 * 选择排序算法，时间复杂度是O（n^2）
 */
public class Heap {
    public static void sort(Comparable[] a) {
        /**
         * 堆排序使用的方法是首先遍历所有的数组构造一个大根堆
         * 然后从根节点取出最大元素，剩下的再进行堆排序构造大根堆，
         * 依次取出后得到一个由大到小的有序序列
         * 关于N的数值和构造的数组有关系，数组中起始下标是0本身是只能到N-1的索引
         * 然后在下列算法过程中并没有使用下标0，所以只有N-2的数量，所以要注意索引越界的问题
         */
        int N = a.length - 1;
        /**
         * 初始化构造大根堆
         * 不能采用上浮算法，上浮的方法的前提是已有的左子树全是有序的堆
         * 没有初始化的数组是不满足此条件
         * 只能采用下沉算法，下沉的过程中只要子树是堆了那么合成父节点也会形成一个堆
         * 所以从最后一个节点开始它的位置是N那么它的父节点就是N/2开始
         */
        for (int i=N/2; i>= 1; i--) {
            sink(a, i, N);
        }
        //取出最大值的元素使得序列有序化
        while (N>1) {
            exch(a, 1, N--);
            //进行堆再次构造
            sink(a, 1, N);
        }
    }

    private static void sink(Comparable[] a, int k, int N) {
        /**
         *N为现在堆所需要使用的实际长度，而k而插入的函数的起始位置，a是传入的数组
         * 它的实际长度可能比N大，所以需要传入N的参数
         */

        while (2*k < N) {
            int j = 2*k;
            if (less(a[j],a[j+1])) {
                j++;
            }
            if (!less(a[k], a[j])) {
                //a[k]比a[j]大就不需要做改动，现在使用的是大根堆
                break;
            }
            exch(a, k, j);
            k = j;
    }
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
