package algorithm.sort;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 8, 5, 6};
        sort(arr);
    }

    public static void sort(int[] array) {
        int[] temp = new int[array.length];
        sort(array,0,array.length-1,temp);
    }

    public static void sort(int[] array, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(array, left, mid, temp);
            sort(array, mid + 1, right, temp);
            merge(array,left,mid,right,temp);
        }
    }

    public static void merge(int[] array, int left, int mid, int right, int[] temp) {
        int i = 0;
        int leftIndex = left;
        int rightIndex = mid + 1;
        while (leftIndex <= mid && rightIndex <= right) {
            if (array[leftIndex] < array[rightIndex]) {
                temp[i++] = array[leftIndex++];
            } else {
                temp[i++] = array[rightIndex++];
            }

        }

        while (leftIndex <= mid) {
            temp[i++] = array[leftIndex++];
        }

        while (rightIndex <= right) {
            temp[i++] = array[rightIndex++];
        }

        i = 0;
        while (left <= right) {
            array[left++] = temp[i++];
        }
    }
}
