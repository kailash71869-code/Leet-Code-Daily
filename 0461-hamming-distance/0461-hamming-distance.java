class Solution {
    public int hammingDistance(int x, int y) {
        int ans=x^y;
        return Integer.bitCount(ans);
    }
}