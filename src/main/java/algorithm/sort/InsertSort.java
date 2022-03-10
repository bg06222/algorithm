package algorithm.sort;

public class InsertSort {
    public static void main(String[] args) {
        int[] colors = new int[]{3, 2, 4, 5, 7};
        sort(colors);

    }

    public static void sort(int[] nums) {
        // 主要思路：
        // 1. 从头到尾 全局扫描
        // 2. 将整个数组分为两大部分： 左边：已经排序好的部分；右边：待排序的部分
        // 3. 从右边的数组的最左边找到一个数字，同左边的数组，从右边开始，一一比较，进行排序
        for (int i = 1; i <= nums.length - 1; i++) {
            int temp = nums[i];
            int j = i;
            while (j > 0 && temp < nums[j - 1]) {
                nums[j] = nums[j-1];
                j--;
            }
            if (i != j) {
                nums[j] = temp;
            }
        }
    }

}
