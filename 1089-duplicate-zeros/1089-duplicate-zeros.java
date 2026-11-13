class Solution {
    public int[] duplicatezeroes(int[] arr ){
        int zeroes=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                zeroes++;
            }
        }
        int[] res=new int[arr.length];
        int j=0;
        for(int num:arr){
            if(j>=arr.length) break;
            if(num==0){
                res[j++]=0;
                if(j<arr.length){
                    res[j++]=0;
                }
            }
            else{
                res[j++]=num;
            }
        }
        return res;
    }
    public void duplicateZeros(int[] arr) {
        int[] result=duplicatezeroes(arr);
        for(int i=0;i<arr.length;i++){
            arr[i]=result[i];
        }
    }
}