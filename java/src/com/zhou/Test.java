package com.zhou;

/**
 * Created by 强 on 2017/12/6.
 */
public class Test {
    public static void main(String[] args) {
        String str = "12122436" ;
        boolean result = isAdditiveNumber(str);
        System.out.println("去掉后的字符串是："+result);
    }
    public static int reverse(int x) {
        long result=0;
        int i =0 ;
        while (x != 0) {
            int temp = x%10;
            result = result * 10 + temp;//越界检查
            x = x / 10;
        }
        return (int)result;
    }

    public static int myAtoi(String str) {
        int index = 0;//遍历string字符串索引
        long result = 0;
        str = str.trim();//先去掉首尾两边空格
        int length = str.length();//获取字符串的长度
        boolean flag = true;//确定最后的符号
        if (length == 0) {
            return 0;//字符串为空直接返回
        }
        if (str.charAt(0) == '-') {
            flag = false;
            index++;
        } else if (str.charAt(0) == '+') {
            flag = true;
            index++;
        }
        int count = 1;//计数
        while (index < length) {
            int digit = str.charAt(index++)-'0';
            if (digit <0 || digit > 9) {
                break;
            }
            System.out.println("这是第"+count+"个数："+digit);
            count++;
            result = result*10 + digit;
            if ((flag && result > Integer.MAX_VALUE)||(!flag && -result < Integer.MIN_VALUE)) {
                        if (!flag) {
                            System.out.println("我执行了");
                            return Integer.MIN_VALUE;
                        } else {
                            return 0;
                }
            }
        }
        if (!flag) {
            System.out.println("-111");
            result = -result;
        }
        return (int)result;
    }

    public static boolean isAdditiveNumber(String num) {
        boolean flag = true;//默认采用是Addititivenumber
        int length = num.length();//获取字符串长度
        if (length < 3 || num == null) {
            return false;
        }
        int indexOne = 1;//作为遍历整个字符串的索引值,第0位不索引
        int first = 0;//斐波拉契数列第一个值起始下标
        int second = 0;//斐波拉契数列第一个值终止下标
        int third = 0;//斐波拉契数列第二个终止下表里
        int count =0;//计数
        System.out.println("长度"+length);
        while (indexOne < length) {
            //遍历整个字符串
            if (indexOne > 1 && num.charAt(0) == '0') return false;
            int indexTwo = indexOne + 1;
            while(indexTwo < length) {
                first = 0;
                second = indexOne;
                third = indexTwo;
                if (num.charAt(second)=='0' && third > second + 1) return false;
                while (third < length) {
                    System.out.println("这是第 "+count+" 次"+"first: "+first+" second: "+second+" third: "+third);
                    count++;
                    Long result = (Long.parseLong(num.substring(first, second)) +
                            Long.parseLong(num.substring(second, third)));
                    if (num.substring(third).startsWith(result.toString())) {
                        first = second;
                        second = third;
                        third += result.toString().length();
                    } else {
                        break;
                    }
                }
                if (third == length-1) {
                    return true;
                }
                indexTwo++;
            }
            indexOne++;
        }
        return false;
    }

}
