class Solution {
    public int findMaxLength(int[] nums) {
        int z=0;
        int o=0;
        HashMap<Integer,Integer> f=new HashMap<>();
        f.put(0,-1);
        int res=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                z++;
            }else{
                o++;
            }
            int diff=z-o;
            if(diff==0){
                res=Math.max(res,i+1);
                continue;
            }
            if(!(f.containsKey(diff))){
                f.put(diff,i);
            }else{
                int index=f.get(diff);
                int len=i-index;
                res=Math.max(len,res);
            }
        }
        return res;
    }
}