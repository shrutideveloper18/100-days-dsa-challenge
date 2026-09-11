class Solution {
    private int find(int[] a){
        int maxc=-1;
        for(int i=0;i<256;i++){
            maxc=Math.max(maxc,a[i]);
        }
        return maxc;
    }
    public int characterReplacement(String s, int k) {
        int low=0;
        int res=0;
        int[] f=new int[256];
        for(int high=0;high<s.length();high++){
            f[s.charAt(high)]++;
            int maxcount=find(f);
            int len=high-low+1;
            int diff=len-maxcount;
            while(diff>k){
                f[s.charAt(low)]--;
                low++;
                maxcount=find(f);
                len=high-low+1;
                diff=len-maxcount;
            }
    
            res=Math.max(res,high-low+1);
        }
        return res;
    }
}