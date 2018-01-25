package com.zhou.test1;

import com.zhou.prepare.StdDraw;

/**
 * Created by dell on 2017/11/6.
 */
public class DrawFunction {
    public static void main(String[] args) {
        int N = 100;
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, N);
        StdDraw.setPenRadius(.01);
        for (int i=1; i<=N; i++) {
            StdDraw.point(i, i);
            StdDraw.point(i, i*i);
            StdDraw.point(i, i*Math.log(i));
        }
    }
}
