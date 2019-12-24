package com.xiayu.JavaDemo.xiayu.java.leetcode.easy;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author: starc
 * @date: 2019/6/23
 */
public class Demo2 {
    /*
    计算吸血鬼数
     */
    @Test
    public void test() {
        ArrayList<Integer> numbers = getNumbers(9999);
        System.out.println(numbers);
    }

    public ArrayList<Integer> getNumbers(int num) {
        if (num < 1000 || num > 9999) {
            return null;
        }
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1000; i <= num; i++) {
            int[] arr = new int[4];
            arr[0] = i / 1000;
            arr[1] = i / 100 % 10;
            arr[2] = i / 10 % 10;
            arr[3] = i % 10;
            if (checkNum(arr)) {
                numbers.add(i);
            }
        }
        return numbers;
    }

    private boolean checkNum(int[] arr) {
        if (arr.length != 4) {
            return false;
        }
        if (arr[2] == 0 && arr[3] == 0) {
            return false;
        }
        int num = arr[0] * 1000 + arr[1] * 100 + arr[2] * 10 + arr[3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j) {
                    if (((arr[i] * 10 + arr[j]) * getOtherNum(arr, i, j)) == num) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private int getOtherNum(int[] arr, int i, int j) {
        int first = 0, second = 0;
        boolean isSecond = false;
        for (int k = 0; k < arr.length; k++) {
            if (k != i && k != j) {
                if (!isSecond) {
                    first = arr[k];
                    isSecond = true;
                } else {
                    second = arr[k];
                }
            }
        }
        return first * 10 + second;
    }
}
