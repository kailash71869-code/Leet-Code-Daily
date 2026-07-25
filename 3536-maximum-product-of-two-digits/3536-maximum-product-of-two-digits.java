class Solution {
    public int maxProduct(int n) {
       int max1=0;
       int max2=0;
       int t=n;
       while(t!=0){
        int k=t%10;
        if(k>max1){
            max2=max1;
            max1=k;
            
        }else if(k>max2){
            max2=k;
        }
        t/=10;
       }
       return max1*max2;
    }
}