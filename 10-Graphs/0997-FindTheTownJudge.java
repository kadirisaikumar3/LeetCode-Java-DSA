class FindTheTownJudge {
    public static int findJudge(int n, int[][] trust) {
        // score[i]:
        // +1 when someone trusts i
        // -1 when i trusts someone
        int[] score = new int[n + 1];
        for (int[] relation : trust) {
            int person = relation[0];
            int judge = relation[1];
            // person trusts someone -> person cannot be judge
            score[person]--;
            // someone trusts judge -> judge gets one vote
            score[judge]++;
        }
        // The judge must:
        // 1. Be trusted by everyone else -> n - 1
        // 2. Trust nobody -> no negative score
        for (int person = 1; person <= n; person++) {
            if (score[person] == n - 1) {
                return person;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int n = 3;
        int[][] trust = {
                {1, 3},
                {2, 3}
        };
        int result = findJudge(n, trust);
        System.out.println("Town Judge: " + result);
    }
}