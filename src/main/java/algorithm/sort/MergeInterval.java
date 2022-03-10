package algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 */
public class MergeInterval {

    /**
     * 56. 合并区间
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
     * @param args
     */
    public static void main(String[] args) {

    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> result = new ArrayList<int[]>();
        int[] last = intervals[0];
        result.add(last);
        for (int i = 1; i < intervals.length; i++) {
            // 1. 判断是否覆盖
            if (last[1] >= intervals[i][0]) {
                // 2. 如果覆盖确定新的区间尾部
                if (last[1] < intervals[i][1]) {
                    last[1] = intervals[i][1];
                }
            } else {
                last = intervals[i];
                result.add(last);
            }
        }

        return result.toArray(new int[result.size()][]);
    }


}
