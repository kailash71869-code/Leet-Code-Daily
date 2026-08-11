class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq=new int[26];
        int maxcount=0;
        int maxlength=0;
        int r=0;
        int l=0;
        while(r<s.length()){
            freq[s.charAt(r)-'A']++;
            maxcount=Math.max(maxcount,freq[s.charAt(r)-'A']);
            if((r-l+1)-maxcount>k){
                freq[s.charAt(l)-'A']--;
                l++;
            }
            maxlength=Math.max(maxlength,(r-l+1));
            
            r++;
        }
        return maxlength;
    }  
}