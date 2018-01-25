package com.zhou.sort;


import com.zhou.prepare.In;
import com.zhou.prepare.StdOut;

/**
 * Created by dell on 2017/11/8.
 * 归并排序
 * 采用一个辅助数组进行额外空间使用
 * 递归排序有自顶向下（最普遍的排序）
 * 自顶向上（贼好用的一个排序方法）
 * 看了自顶向上的排序方法后觉得自顶向上比自顶向下更容易理解
 */
public class Merge {
    //辅助数组
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        //初始化aux数组
        aux = new Comparable[a.length];//和a一样的数组，一次性分配空间
        sort(a, 0, a.length - 1);
    }

    //自顶向下的递归归并排序
    public static void sort(Comparable[] a, int lo, int hi) {
        //lo表示最小索引，hi表示最大索引
        if (hi <= lo) return;//递归结束条件
        int mid = (lo + hi)/2;//中间值
        sort(a, lo, mid);//左半边递归
        sort(a, mid+1, hi);//右半边递归
        merge(a, lo, mid, hi);
    }

    /**
     * 自顶向上的归并排序
     *多次遍历整个数组，根据子数组大小进行两两归并
     * 类似于1+1=2,2+2=4一直到大于N结束为止
     * lo , mid = lo+sz -1, hi = lo +2*sz -1
     */
    public static void sortUp(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[a.length];
        for (int sz=1; sz<N; sz = sz + sz) {
            //lo < N-sz 保证mid = lo + sz <N,即是说[mid, hi]还存在着数据，这个数据只是可能没有sz这么大
            for (int lo=0; lo < N-sz; lo += sz+sz) {
                //进行逐序归并,利用Math.max防止最大值索引直接越界
                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
            }
        }
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        //lo表示最小索引，mid表示中间索引，hi表示最大索引
        int N = a.length;//获取数组的长度
        /**
         * 将lo到hi段的数组分为两组，第一组是lo到mid第二组是mid+1到hi
         * 分别进行索引迭代，由一个从从lo开始的变量k开始遍历，一直到所有的数据都能够
         * copy回到原来的数组a中
         */
        int i = lo;
        int j = mid + 1;
        //copy由lo到hi的数组到aux中
        for (int k=lo; k<=hi; k++) {
            aux[k] = a[k];
        }
        //开始遍历拷贝
        for (int k=lo; k<=hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
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
        StdOut.println("开始排序:");
        sortUp(a);
        assert isSorted(a);
        StdOut.println("排序结果是:");
        show(a);
}
}
