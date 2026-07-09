import java.util.HashSet;

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {

            if (set.contains(num)) {
                return true;
            }

            set.add(num);
        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 4, 5, 2};
        int[] nums2 = {10, 20, 30, 40, 50};

        System.out.println("Array 1: Contains Duplicate = " + containsDuplicate(nums1));
        System.out.println("Array 2: Contains Duplicate = " + containsDuplicate(nums2));
    }
}