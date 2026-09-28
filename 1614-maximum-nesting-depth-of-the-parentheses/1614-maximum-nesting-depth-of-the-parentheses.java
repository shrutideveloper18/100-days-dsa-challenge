class Solution {
    public int maxDepth(String s) {
        int maxdepth=0;
        int currentdepth=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                currentdepth++;
                maxdepth=Math.max(currentdepth,maxdepth);
            }
            else if(s.charAt(i)==')'){
                currentdepth--;
            }
        }
        return maxdepth;
    }
}