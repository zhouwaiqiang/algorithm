package com.zhou.test1;

import com.zhou.prepare.StdOut;
import com.zhou.datastructure.Queue;

import java.util.Scanner;

/**
 * Created by dell on 2017/11/8.
 */
public class Josephus {

    public static void main(String[] args) {
        int N,M;
        Scanner in = new Scanner(System.in);
        StdOut.println("请输入N：");
        N = in.nextInt();
        StdOut.println("请输入M：");
        M = in.nextInt();
        Queue<Integer> queue = new Queue<Integer>();
        for (int i=0; i<N; i++) {
            queue.enqueue(i);
        }
        while (!queue.isEmpty()) {
            for (int i=0; i<M-1; i++) {
                queue.enqueue(queue.dequeue());
            }
            System.out.print(queue.dequeue() + " ");
        }
        StdOut.println();
    }
}
