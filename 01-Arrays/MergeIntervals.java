import java.util.Arrays;
public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[][] temp = new int[intervals.length][2];
        int index = 0;
        temp[index] = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= temp[index][1]) {
                temp[index][1] = Math.max(temp[index][1], intervals[i][1]);
            } else {
                index++;
                temp[index] = intervals[i];
            }
        }
        return Arrays.copyOf(temp, index + 1);
    }
    public static void main(String[] args) {

        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };
        int[][] result = merge(intervals);
        System.out.println("Merged Intervals:");
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}