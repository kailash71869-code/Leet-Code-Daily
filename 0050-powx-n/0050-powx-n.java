class Solution {
    public double myPow(double x, int n) {
        if(n==0 || x==1.0){
            return 1.0;
        }
        
        if(n<0){
            return 1/pow(x,(long)-1*n);
        }else{
            return pow(x,n);
        }
    }
    public double pow(double x,long n){
        if(n==1){
            return x;
        }
        if(n==0){
            return 1.0;
        }
        if(n%2==0){
            return pow(x*x,n/2);
        }
            return x*pow(x,n-1);
        
    }
}