class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> st=new Stack<>();
        int[] freq=new int[26];
        boolean[] vis=new boolean[26];

        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }

        for(char c:s.toCharArray()){
            freq[c-'a']--;
            if(vis[c-'a']){
                continue;
            }
            while(!st.isEmpty() && st.peek()>c && freq[st.peek()-'a']>0){
                vis[st.pop()-'a']=false;
            }
            st.push(c);
            vis[c-'a']=true;
        }
        StringBuilder sb=new StringBuilder();
        for(char x:st){
            sb.append(x);
        }
        return sb.toString();
    }
}