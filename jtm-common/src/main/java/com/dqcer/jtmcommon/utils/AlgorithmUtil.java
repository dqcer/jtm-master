package com.dqcer.jtmcommon.utils;

/**
 *  算法util
 *
 * @author dqcer
 * @description
 * @date 15:37 2020/1/24
 */
public class AlgorithmUtil {

    public static void main(String[] args) {
        int array [] = {2,3,324,23,1,46, 12,213,534};
        int[] ints = AlgorithmUtil.insertSort(array);
        System.out.println(ints);
    }

    /**
     * 二分查找
     *
     * @param a
     * @param array
     * @return
     */
    public static int binarySearch(int a, int... array) {
        int low = 0;
        int high = array.length - 1;
        int mid;
        while (low <= high) {
            //  中间位置
            mid = (low + high) / 2;
            if (array[mid] == a) {
                return mid;
            } else if (a > array[mid]) {
                //  向右查找
                low = mid + 1;
            } else {
                //  向左查找
                high = mid - 1;
            }
        }
       return -1;
    }


    /**
     * 冒泡排序
     *
     * @param array
     * @return
     */
    public static int[] bubbleSort(int... array) {
        //  外层循环控制排序趟数
        for (int i = 0; i < array.length - 1; i++) {
            //  内层循环控制每一趟排序多少次
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    /**
     * 插入排序
     *
     * @param array
     * @return
     */
    public static int[] insertSort(int... array) {
        for (int i = 0; i < array.length; i++) {
            //  插入的数
            int insertVal = array[i];
            //  被插入的位置（准备和前一个数进行比较）
            int index = i - 1;
            //  如果插入的数比被插入的数小
            while (index >= 0 && insertVal < array[index]) {
                //  则将array[index] 向后移动
                array[index + 1] = array[index];
                //  将index向前移动
                index --;
            }
            //  将插入的数放入合适的位置
            array[index + 1] = insertVal;
        }
        return array;
    }

    /**
     * 快速排序
     *
     * @param low
     * @param high
     * @param array
     * @return
     */
    public static int[] quickSort(int low, int high, int... array) {
        //  从前向后比较的索引
        int start = low;
        //  从后向前比较的索引
        int end = high;
        //  基准值
        int key = array[low];
        while (end > start) {
            //  从后向前比较
            while (end > start && array[end] >= key) {
                end--;
            }
            //  如果没有比基准值小的，则比较下一个，直到有比基准值小的，
            //  则交换位置，然后又从前向后比较
            if (array[end] <= key) {
                int temp = array[end];
                array[end] = array[start];
                array[start] = temp;
            }
            //  从前向后比较
            while (end > start && array[start] <= key) {
                start++;
            }
            //  如果没有比基准值大的， 则比较下一个，直到有比基准值大的，则交换位置
            if (array[start] >= key) {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
            //  此时第一次循环比较结束，基准值得位置已经确定，左边的至都比关键值小，
            //  右边的值都比关键值大，但是两边的顺序还有可能不一样，接着进行下面的递归调用。

        }
        //  递归左边序列：从第一个索引位置到“关键值索引-1”
        if (start > low) {
            quickSort( low, start - 1, array);
        }
        //  递归右边序列：从“关键值索引 +1 ” 到最后一个位置
        if (end < high) {
            quickSort(end + 1, high, array);
        }
        return array;
    }

    /**
     * 希尔排序
     *
     * @param array
     * @return
     */
    public static int[] shellSort(int... array) {
       int dk = array.length / 3 + 1;
        while (dk == 1) {
            shellInsertSort(array, dk);
            dk = dk / 3 + 1;
        }
        return array;
    }

    private static void shellInsertSort(int[] array, int dk) {
        //  类似于插入排序算法，但插入排序算法的增量是1，这里的增量是dk,将1换成dk即可
        for (int i = dk; i < array.length; i++) {
            if (array[i] < array[i - dk]) {
                int j;
                //  x为待插入的元素
                int x = array[i];
                array[i] = array[i - dk];
                for (j = i - dk; j >= 0 && x < array[j]; j = j - dk) {
                    //  通过循环， 逐个后移一位找到插入的位置
                    array[j + dk] = array[j];
                    //  将数据插入对应的位置
                    array[j + dk] = x;
                }
            }
        }
    }
}
