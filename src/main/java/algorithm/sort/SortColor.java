package algorithm.sort;

public class SortColor {
    public static void main(String[] args) {
        int[] colors = new int[]{2,0,2,1,1,0};
        sort(colors);

    }

    public static void sort(int[] colors) {
        int index0 = 0;
        int index2 = colors.length-1;
        for (int i = 0; i <= index2; i++) {
            while (i <= index2 && colors[i] == 2) {
                swap(colors, i, index2);
                index2--;
            }
            if (colors[i] == 0) {
                swap(colors, i, index0);
                index0++;
            }
        }
    }
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
