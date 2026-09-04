class Solution {
    public boolean isAnagram(String s, String t) {
        char[] arrs=s.toCharArray();
        char[] arrt=t.toCharArray();
        Arrays.sort(arrs);
        Arrays.sort(arrt);
        if(Arrays.equals(arrs,arrt)){
            return true;
        }
        return false;
    }
}