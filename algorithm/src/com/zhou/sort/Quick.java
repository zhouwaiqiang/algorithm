package com.zhou.sort;
import com.zhou.prepare.In;
import com.zhou.prepare.StdOut;
import com.zhou.prepare.StdRandom;

/**
 * Created by dell on 2017/11/8.
 * 选择排序算法，时间复杂度是O（n^2）
 */
public class Quick {
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);//消除对输入的依赖
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        //递归的思想
        if (hi <= lo) {
            return;//递归终止条件
        }
        int j = partitioin(a, lo, hi);
        //左快排
        sort(a, lo, j-1);
        //右快排
        sort(a, j+1, hi);
    }

    private static int partitioin(Comparable[]  a, int lo, int hi) {
        /**
         * 快排思想如下图中所示:由小到大和由大到小开始遍历，直到最后交叠，总的来说就是左边右边同时与对应值比较，左边比它小，右边比他大就不用管，反过来就需要交换位置
         * -->  <--
         * 》---------------|中点-------------------《
         * 最后需要返回的是该比较值最后插入的位置，形成左边都比比较值小，右边都比比较值大的体系
         */
        int i = lo, j = hi + 1;
        Comparable v = a[lo];//默认取用传入的最低索引作为比较值
        while (true) {
            //采用while死循环
            while (less(a[++i],v)) {
                if (i == hi) {
                    break;//所有元素都比第一个小，直接跳出循环
                }
                //当有不满足比它小的元素时就直接跳过该内层while循环
            }
            //同理比较比该比较值大的数，从右侧开始往左
            while (less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (j <= i) {
                break;//如果二者相遇或反向了则直接跳出
            }
            exch(a, i, j);
        }
        exch(a, lo, j);//将该最后的索引与第一个值交换得到那个位置
        //返回j
        return j;
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
