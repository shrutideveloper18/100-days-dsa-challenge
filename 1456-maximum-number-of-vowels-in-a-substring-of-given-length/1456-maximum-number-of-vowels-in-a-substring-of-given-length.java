class Solution {

    public int maxVowels(String s, int k) {

        int low = 0;
        int high = k - 1;
        int v = 0;
        int max = 0;

        // First window
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                v++;
            }
        }

        max = v;

        // Slide the window
        while (high < s.length() - 1) {

            // Remove character leaving
            char c = s.charAt(low);

            if (isVowel(c)) {
                v--;
            }

            low++;
            high++;

            // Add character entering
            if (isVowel(s.charAt(high))) {
                v++;
            }

            max = Math.max(max, v);
        }

        return max;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' ||
               c == 'o' || c == 'u';
    }
}