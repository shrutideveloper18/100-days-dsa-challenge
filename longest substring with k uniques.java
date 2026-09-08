class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int low=0;

        int res=-1;
        Map<Character,Integer> f=new HashMap<>();
        for(int high=0;high<s.length();high++){
            char c=s.charAt(high);
            f.put(c,f.getOrDefault(c,0)+1);
            while(f.size()>k){
                char l=s.charAt(low);
                f.put(l,f.get(l)-1);
                if(f.get(l)==0){
                    f.remove(l);
                }
                low++;
            }
            if(f.size()==k){
                res=Math.max(res,high-low+1);
            }
        }
        return res;
    }
}
