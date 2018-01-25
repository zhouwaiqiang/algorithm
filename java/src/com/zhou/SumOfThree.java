package com.zhou;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 强 on 2017/12/20.
 */
public class SumOfThree {
    public static void main(String[] args) {
        int[] test = new int[]{-2,0,0,2,2};
        List<List<Integer>> result = threeSum(test);
        for (int i=0; i<result.size();i++) {
            System.out.print("第"+i+"个是：");
            for (int j=0; j<result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);//先对数组进行排序
        List<List<Integer>> result = new ArrayList<List<Integer>>();//声明需要返回的结果变量
        int length = nums.length;//获得数组长度
        if (nums[length-1] < 0) {
            return result;//不存在
        }
        int j=0,k=0;//声明后面需要索引的变量
        int prej=0,prek=0;//j、k的前一个值
        for (int i=0; i<length-2; i++) {
            if (nums[i]>0) {
                break;
            }
            if (i>0 && nums[i] == nums[i-1]) {
                continue;//继续下一个循环
            }
            int temp = -nums[i];//后面需要作比较的值
            j=i+1;
            k=length-1;
            int count = 0;
            while (true) {
                while(equal(nums[j]+nums[k], temp)) {
                    if (nums[j]+nums[k] < temp) {
                        j++;
                    } else {
                        k--;
                    }
                    if (j>=k) {
                        break;
                    }
                }
                if (j>=k) {
                    break;//结束循环
                }

                //遍历是否已经有该组合
                boolean flag = false;//检测标志，如果没有为false，如果有了那就是true
                if (nums[prej] == nums[j] && nums[prek] == nums[k]) {
                    flag = true;
                }
                if (!flag || count == 0) {
                    System.out.println("temp是："+temp);
                    System.out.println(nums[i] + " " + i + " " + nums[j] + " " + j + " " + nums[k] + " " + k);
                    List<Integer> tempList = new ArrayList<Integer>();
                    tempList.add(nums[i]);
                    tempList.add(nums[j]);
                    tempList.add(nums[k]);
                    result.add(tempList);
                }
                count++;
                prej = j;
                prek = k;
                k--;//减少
                j++;//增值
            }
        }
        return result;
    }

    private static boolean equal(int v, int w) {
        if (v == w) {
            return false;
        } else {
            return true;
        }
    }
}
