import java.util.*;
class AccountsMerge {
    static class DSU {
        int[] parent;
        int[] rank;
        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) {
                return;
            }
            if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB;
            } else if (rank[rootA] > rank[rootB]) {
                parent[rootB] = rootA;
            } else {
                parent[rootB] = rootA;
                rank[rootA]++;  }   }   }
    public static List<List<String>> accountsMerge(
            List<List<String>> accounts) {
        int n = accounts.size();
        DSU dsu = new DSU(n);
        // Map each email to the account index
        Map<String, Integer> emailToAccount = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (emailToAccount.containsKey(email)) {
                    dsu.union(
                            i,
                            emailToAccount.get(email)
                    );
                } else {
                    emailToAccount.put(email, i);   }   }   }
        // Group emails by their root account
        Map<Integer, List<String>> mergedEmails =
                new HashMap<>();
        for (String email : emailToAccount.keySet()) {
            int account = emailToAccount.get(email);
            int root = dsu.find(account);
            mergedEmails
                    .computeIfAbsent(root, key -> new ArrayList<>())
                    .add(email);
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry
                : mergedEmails.entrySet()) {
            int root = entry.getKey();
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            List<String> mergedAccount = new ArrayList<>();
            // Account name
            mergedAccount.add(accounts.get(root).get(0));
            // Sorted emails
            mergedAccount.addAll(emails);
            result.add(mergedAccount);
        }
        return result;
    }
    public static void main(String[] args) {
        List<List<String>> accounts = Arrays.asList(
                Arrays.asList(
                        "John",
                        "johnsmith@mail.com",
                        "john_newyork@mail.com"
                ),
                Arrays.asList(
                        "John",
                        "johnsmith@mail.com",
                        "john00@mail.com"
                ),
                Arrays.asList(
                        "Mary",
                        "mary@mail.com"
                ),
                Arrays.asList(
                        "John",
                        "johnnybravo@mail.com"
                )
        );
        List<List<String>> result =
                accountsMerge(accounts);
        for (List<String> account : result) {
            System.out.println(account);
        }
    }
}