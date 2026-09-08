class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> f=new HashMap<>();
        int res=0;
        int low=0;
        for(int high=0;high<s.length();high++){
            char c=s.charAt(high);
            f.put(c,f.getOrDefault(c,0)+1);

            while(f.size()!=high-low+1){
                char l=s.charAt(low);
                f.put(l,f.getOrDefault(l,0)-1);
                if (f.get(l) == 0) {
                    f.remove(l);
                }
                low++;
            }
            res=Math.max(res,high-low+1); 
        }
        return res;
    }
}