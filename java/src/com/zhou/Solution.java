package com.zhou;

/**
 * Created by 强 on 2017/12/14.
 */

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 */
public class Solution {
    public int reverse(int x) {
        long result=0;//存储结果(为了判断溢出，用更大的类型存储)
        boolean flag = true;//判断正负号
        if (x > 0) {
            flag = true;
        } else if (x < 0) {
            flag = false;
        }
        while (x != 0) {
            int temp = x % 10;//得到最后一位的值
            result = result*10 + temp;//依次反转得到值
            if ((flag && result > Integer.MAX_VALUE)||(!flag && result < Integer.MIN_VALUE)) {
                return 0;//判断是否溢出
            }
            x = x/10;//降位
        }
        return (int)result;//降位转回
    }
}
