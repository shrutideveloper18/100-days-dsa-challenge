class Solution {
    public int minAddToMakeValid(String s) {
        int openNeeded = 0;
        int addCount = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                openNeeded++;
            } else { // c == ')'
                if (openNeeded > 0) {
                    openNeeded--;
                } else {
                    addCount++;
                }
            }
        }

        return openNeeded + addCount;
    }
}