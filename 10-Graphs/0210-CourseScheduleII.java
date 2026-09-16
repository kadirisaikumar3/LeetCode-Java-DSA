import java.util.*;
class CourseScheduleII {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());   }
        int[] indegree = new int[numCourses];
        // Build graph and calculate indegree
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            graph.get(prerequisiteCourse).add(course);
            indegree[course]++; }
        Queue<Integer> queue = new LinkedList<>();
        // Add courses having no prerequisites
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i); }   }
        int[] order = new int[numCourses];
        int index = 0;
        // Kahn's Algorithm
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            order[index++] = currentCourse;
            for (int nextCourse : graph.get(currentCourse)) {
                indegree[nextCourse]--;
                if (indegree[nextCourse] == 0) {
                    queue.offer(nextCourse);    }   }   }
        // If all courses are completed, return the order
        if (index == numCourses) {
            return order;   }
        // A cycle exists
        return new int[0];  }
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };
        int[] result = findOrder(numCourses, prerequisites);
        System.out.println("Course Order:");
        if (result.length == 0) {
            System.out.println("No valid ordering exists.");
        } else {
            System.out.println(Arrays.toString(result));    }   }   }