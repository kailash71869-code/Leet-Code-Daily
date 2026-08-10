class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count=0;
        for(int i=left;i<=right;i++){
            int bitcount=Integer.bitCount(i);
            if(prime(bitcount)){
                count++;
            }
        }
        return count;
    }
    public boolean prime(int bit){
        if(bit<2){
            return false; 
        }
        if(bit==2){
            return true;
        }
        if((bit&1)==0){
            return false;
        }
        for(int i=3;i*i<=bit;i+=2){
            if((bit%i)==0){
                return false;
            }
        }
        return true;
    }
}