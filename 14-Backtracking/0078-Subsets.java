import java.util.ArrayList;
import java.util.List;

class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }
    private static void backtrack(int[] nums,
                                  int index,
                                  List<Integer> current,
                                  List<List<Integer>> result) {

        result.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        List<List<Integer>> result = subsets(nums);

        System.out.println("Subsets:");

        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}