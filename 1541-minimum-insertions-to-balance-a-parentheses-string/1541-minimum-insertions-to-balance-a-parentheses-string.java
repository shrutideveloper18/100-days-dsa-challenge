class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int openNeeded = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == '(') {
                openNeeded++;
            } else {
                // Check if we have two consecutive ')'
                if (i + 1 < n && s.charAt(i + 1) == ')') {
                    i++; // Consume the second ')'
                } else {
                    insertions++; // Insert one missing ')'
                }

                // Match with an open parenthesis
                if (openNeeded > 0) {
                    openNeeded--;
                } else {
                    insertions++; // Insert one missing '('
                }
            }
        }

        // Each remaining '(' needs two ')'
        insertions += openNeeded * 2;

        return insertions;
    }
}