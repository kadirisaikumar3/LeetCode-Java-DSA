import java.util.HashMap;

public class HashMapDemo {

    public static void main(String[] args) {

       HashMap<Integer, String> employees = new HashMap<>();
       employees.put(101, "Software Engineer");
       employees.put(102, "Backend Developer");
       employees.put(103, "Java Developer");

        // Display HashMap
        System.out.println("HashMap: " + employees);

        // Search by key
        int key = 102;

        if (employees.containsKey(key)) {
            System.out.println("Key Found");
            System.out.println("Value: " + employees.get(key));
        } else {
            System.out.println("Key Not Found");
        }

        // Remove an element
        employees.remove(103);

        // Display after deletion
        System.out.println("After Removing Key 103:");
        System.out.println(employees);

        // Size of HashMap
        System.out.println("Size: " + employees.size());
    }
}