class Solution {
    Set<String> set=new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        List<String> list=new ArrayList<>();
        if(s.length()==0){
            return list;
        }
        dfs(s,0,0,new StringBuilder());
        int maxLen=0;
        for(String x:set){
            maxLen=Math.max(maxLen,x.length());
        }
        for(String x:set){
            if(maxLen==x.length()){
            list.add(x);
            }
        }
        return list;
    }
    public void dfs(String s,int idx,int balance,StringBuilder sb){
        if(balance<0){
            return;
        }
        if(s.length()==idx){
            if(balance==0){
                set.add(sb.toString());
            }
            return;
        }
        char ch=s.charAt(idx);
        if(ch!='(' && ch!=')'){
            sb.append(ch);
            dfs(s,idx+1,balance,sb);
            sb.deleteCharAt(sb.length()-1);
        }else{
            sb.append(ch);
            if(ch=='('){
                dfs(s,idx+1,balance+1,sb);
            }else{
                dfs(s,idx+1,balance-1,sb);
            }
        sb.deleteCharAt(sb.length()-1);
        dfs(s,idx+1,balance,sb);
        }    
    }
}