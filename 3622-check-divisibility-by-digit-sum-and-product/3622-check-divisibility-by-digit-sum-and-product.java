class Solution {
    public boolean checkDivisibility(int n) {
        if(String.valueOf(n).length()==1){
            return false;
        }
        int t=n;
        int pro=1;
        int sum=0;
        while(t!=0){
            int k=t%10;
            pro*=k;
            sum+=k;
            t/=10;
        }
        if( (n%(sum+pro))!=0){
            return false;
        }
        return true;
    }
}