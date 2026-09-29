import java.util.ArrayList;
import java.util.List;
class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            graph.get(prerequisiteCourse).add(course);
        }
        int[] state = new int[numCourses];
        for (int course = 0; course < numCourses; course++) {
            if (state[course] == 0) {
                if (hasCycle(graph, course, state)) {
                    return false;   }   }   }
        return true;
    }
    private static boolean hasCycle(List<List<Integer>> graph,
                                    int course,
                                    int[] state) {
        // Course is currently being explored
        if (state[course] == 1) {
            return true;
        }
        // Course has already been completely processed
        if (state[course] == 2) {
            return false;
        }
        state[course] = 1;
        for (int nextCourse : graph.get(course)) {
            if (hasCycle(graph, nextCourse, state)) {
                return true;    }   }
        state[course] = 2;
        return false;
    }
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {
                {1, 0}
        };
        boolean result = canFinish(numCourses, prerequisites);
        System.out.println("Can Finish All Courses: " + result);
    }
}