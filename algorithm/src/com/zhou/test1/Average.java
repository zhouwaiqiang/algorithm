package com.zhou.test1;

import com.zhou.prepare.StdIn;
import com.zhou.prepare.StdOut;

/**
 * Created by dell on 2017/11/6.
 */
public class Average {
    public static void main(String[] args) {
        System.out.println("请输入参数：按住ctrl+d结束输入");
        double sum = 0.0;
        int cnt = 0;
        while (!StdIn.isEmpty()) {
            //读取一个数并计算累计之和
            sum += StdIn.readDouble();
            cnt++;
        }
        double avg = sum/cnt;
        StdOut.printf("Average is %.5f\n", avg);
    }
}
