class Solution {
    public int gcdOfOddEvenSums(int n) {
       // int t= Math.abs(((n*n)-(n*n+1)));
        return (n*(n+1))-(n*n);
    }
}