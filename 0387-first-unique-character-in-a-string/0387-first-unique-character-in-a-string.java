class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> f = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            f.put(s.charAt(i), f.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (f.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}