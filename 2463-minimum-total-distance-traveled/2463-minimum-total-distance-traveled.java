class Solution {
    private long solve(int ri, int fi, List<Integer> robot, List<Integer> positions, long[][] memo) {
        if (ri >= robot.size()) {
            return 0; // No more distance to be covered
        }
        
        if (fi >= positions.size()) {
            return (long) 1e12; // Large value representing an infeasible solution
        }

        if (memo[ri][fi] != -1) {
            return memo[ri][fi];
        }

        long takeCurrentFactory = Math.abs(robot.get(ri) - positions.get(fi)) + solve(ri + 1, fi + 1, robot, positions, memo);
        long skip = solve(ri, fi + 1, robot, positions, memo);

        return memo[ri][fi] = Math.min(takeCurrentFactory, skip);
    }

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        // Step 1: Sort robot and factory arrays
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));

        int m = robot.size();

        // Step 2: Expand factory positions to avoid tracking of limit and easy recursion
        List<Integer> positions = new ArrayList<>();
        for (int[] f : factory) {
            int pos = f[0];
            int limit = f[1];
            for (int j = 0; j < limit; j++) {
                positions.add(pos);
            }
        }

        int n = positions.size();
        long[][] memo = new long[m + 1][n + 1];
        for (long[] row : memo) {
            Arrays.fill(row, -1);
        }

        // Step 3: Solve the problem
        return solve(0, 0, robot, positions, memo);
    }
}