class Solution {
    public int totalFruit(int[] fruits) {
        int low=0;
        int res=-1;
        Map<Integer,Integer> f=new HashMap<>();
        for(int high=0;high<fruits.length;high++){
            int a=fruits[high];
            f.put(a,f.getOrDefault(a,0)+1);
            while(f.size()>2){
                int l=fruits[low];
                f.put(l,f.get(l)-1);
                if(f.get(l)==0){
                    f.remove(l);
                }
                 low++;
            }

            res=Math.max(res,high-low+1);
        }
        return res;
    }
}