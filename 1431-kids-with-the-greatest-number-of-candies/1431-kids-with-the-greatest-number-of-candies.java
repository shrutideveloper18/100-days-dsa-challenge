class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res=new ArrayList<>();
        int max=0;
        for(int i=0;i<candies.length;i++){
            if(candies[i]>max){
                max=candies[i];
            }
        }
        for(int i=0;i<candies.length;i++){
            int current=candies[i]+extraCandies;
            if(current>=max){
                res.add(true);
            }
            else{
                res.add(false);
            }
        }
        return res;
    }
}