class Solution {
    public int minInsertions(String s) {
        if(s.length()==0){
            return 0;
        }
        int need=0;
        int ans=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                if(need%2==1){
                    need--;
                    ans++;
                }
                need+=2;
            }else{
                need--;
                if(need==-1){
                    ans++;
                    need=1;
                }
            }
        }
        return ans+need;
    }
}