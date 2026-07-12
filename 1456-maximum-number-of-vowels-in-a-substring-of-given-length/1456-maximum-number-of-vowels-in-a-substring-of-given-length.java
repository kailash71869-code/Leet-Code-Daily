class Solution {
    public int maxVowels(String s, int k) {
        int count=0,max=0;
        int l=0;
        for(int r=0;r<s.length();r++){
            if(isvowel(s.charAt(r))){
                count++;
            }
            if((r-l+1)==k){
                max=Math.max(max,count);
                if(isvowel(s.charAt(l))){
                    count--;
                }
                
                    l++;
                
            }
        }
        return max;
    }
    public boolean isvowel(char s){
        return "aeiou".indexOf(s)!=-1;
    }
}