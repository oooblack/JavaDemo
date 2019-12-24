package com.xiayu.JavaDemo.xiayu.java.leetcode.easy;


import org.junit.Test;

/**
 * @author: starc
 * @date: 2019/1/5
 */
public class Demo1 {

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，
     * 并返回他们的数组下标。你可以假设每种输入只会对应一个答案。
     * 但是，你不能重复利用这个数组中同样的元素。
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    if (nums[i] + nums[j] == target) {
                        arr[0] = i;
                        arr[1] = j;
                        return arr;
                    }
                }
            }
        }
        return arr;
    }


    public int reverse(int x) {
        int a = 0;
        if (x < 0) {
            a = 1;
            x = -x;
        }
        int[] arr = new int[10];
        int j = 0;
        int mod;
        for (int i = 1; j < 10; i = i * 10) {
            mod = (x / i) % 10;
            arr[j] = mod;
            j++;
        }
        long flag = 1;
        long num = 0;
        for (--j; j >= 0; j--) {
            if (flag == 1) {
                if (arr[j] > 0) {
                    flag = flag * 10;
                    num += arr[j];
                }
            } else {
                num = num + arr[j] * flag;
                flag = flag * 10;
            }
        }
        if (num > Integer.MAX_VALUE) {
            return 0;
        }
        if (a == 1) {
            return (int) -num;
        }
        return (int) num;
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int[] arr = new int[10];
        int j = 0;
        for (int i = 1; j < 10; i *= 10) {
            arr[j] = x / i % 10;
            j++;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + "");
            System.out.println();
        }
        for (int i = 9; i >= 0; i--) {
            if (arr[i] != 0) {
                for (int k = i; k > i / 2; k--) {
                    if (arr[k] != arr[i - k]) {
                        return false;
                    }
                }
                break;
            }
        }
        return true;
    }

    public int romanToInt(String s) {
        int index = s.length() - 1;
        int num = 0;
        while (index >= 0) {
            switch (s.charAt(index)) {
                case 'I':
                    num += 1;
                    index--;
                    break;
                case 'V':
                    if (index - 1 >= 0 && s.charAt(index - 1) == 'I') {
                        num += 4;
                        index -= 2;
                    } else {
                        num += 5;
                        index--;
                    }
                    break;
                case 'X':
                    if (index - 1 >= 0 && s.charAt(index - 1) == 'I') {
                        num += 9;
                        index -= 2;
                    } else {
                        num += 10;
                        index--;
                    }
                    break;
                case 'L':
                    if (index - 1 >= 0 && s.charAt(index - 1) == 'X') {
                        num += 40;
                        index -= 2;
                    } else {
                        num += 50;
                        index--;
                    }
                    break;
                case 'C':
                    if (index - 1 >= 0 && s.charAt(index - 1) == 'X') {
                        num += 90;
                        index -= 2;
                    } else {
                        num += 100;
                        index--;
                    }
                    break;
                case 'D':
                    if (index - 1 >= 0 && s.charAt(index - 1) == 'C') {
                        num += 400;
                        index -= 2;
                    } else {
                        num += 500;
                        index--;
                    }
                    break;
                case 'M':
                    if (index - 1 >= 0 && s.charAt(index - 1) == 'C') {
                        num += 900;
                        index -= 2;
                    } else {
                        num += 1000;
                        index--;
                    }
                    break;
                default:
            }
        }

        return num;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) {
            return "";
        }
        StringBuilder str = new StringBuilder();
        int index = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(index);
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].length() < index + 1 || strs[j].charAt(index) != c) {
                    return str.toString();
                }
            }
            str.append(c);
            index++;
        }
        return str.toString();
    }

    public boolean isValid(String s) {
        char[] arr = new char[s.length()];
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                    arr[index++] = '(';
                    break;
                case '{':
                    arr[index++] = '{';
                    break;
                case '[':
                    arr[index++] = '[';
                    break;
                case ')':
                    if (index < 1 || arr[--index] != '(') {
                        return false;
                    }
                    break;
                case '}':
                    if (index < 1 || arr[--index] != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (index < 1 || arr[--index] != '[') {
                        return false;
                    }
                    break;
                default:
            }
        }
        return index == 0;
    }

    //[2,4] 3,4]
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3;
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val <= l2.val) {
            l3 = new ListNode(l1.val);
            l1 = l1.next;
        } else {
            l3 = new ListNode(l2.val);
            l2 = l2.next;
        }
        ListNode now = l3;
        if(l2==null) {
            System.out.println("hello");
        }
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                now.next = new ListNode(l1.val);
                now = now.next;
                l1 = l1.next;
            } else {
                now.next = new ListNode(l2.val);
                now = now.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            now.next = l1;
        } else if (l2 != null) {
            now.next = l2;
        }
        return l3;
    }

    @Test
    public void test() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        ListNode listNode = mergeTwoLists(listNode1, listNode4);
        print(listNode);
    }

    private void print(ListNode listNode) {
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
