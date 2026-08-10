class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        double sum=0;
        Arrays.sort(prices);
        Arrays.sort(discounts);
        int idx=prices.length-1;
        int jdx=discounts.length-1;

        while(idx>=0 && jdx>=0){
            sum+=(prices[idx]*(100-discounts[jdx])/100.0);
            idx--;
            jdx--;
        }
        while(idx>=0){
            sum+=prices[idx--];
        }
        return sum;
    }
}