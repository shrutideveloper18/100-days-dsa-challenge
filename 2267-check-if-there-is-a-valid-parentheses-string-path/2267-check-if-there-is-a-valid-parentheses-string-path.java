class Solution {
    private Boolean[][][] memo;
    private int m, n;

    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        // Total path length is m + n - 1. A valid parentheses string must have an even length.
        if ((m + n - 1) % 2 != 0 || grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }

        // Maximum possible open brackets in a path of length m + n - 1 is (m + n) / 2
        int maxBalance = (m + n) / 2;
        memo = new Boolean[m][n][maxBalance + 1];

        return dfs(grid, 0, 0, 0);
    }

    private boolean dfs(char[][] grid, int r, int c, int balance) {
        // Update balance for the current cell
        if (grid[r][c] == '(') {
            balance++;
        } else {
            balance--;
        }

        // Invalid path if balance goes negative or exceeds maximum possible needed balance
        if (balance < 0 || balance > (m + n) / 2) {
            return false;
        }

        // Reached the bottom-right corner
        if (r == m - 1 && c == n - 1) {
            return balance == 0;
        }

        // Return memoized result if already computed
        if (memo[r][c][balance] != null) {
            return memo[r][c][balance];
        }

        boolean hasPath = false;

        // Move Down
        if (r + 1 < m) {
            hasPath = dfs(grid, r + 1, c, balance);
        }

        // Move Right (if not already found valid path going down)
        if (!hasPath && c + 1 < n) {
            hasPath = dfs(grid, r, c + 1, balance);
        }

        return memo[r][c][balance] = hasPath;
    }
}