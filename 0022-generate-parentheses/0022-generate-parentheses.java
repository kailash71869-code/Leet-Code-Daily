class Solution {
    List<String> list=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        bkt("",0,0,n);
        return list;
    }
    public void bkt(String curr,int open,int close,int n){
        if(curr.length()==n*2){
            list.add(curr);
            return;
        }
        if(open<n){
        bkt(curr+"(",open+1,close,n);
        }

        if(close<open){
            bkt(curr+")",open,close+1,n);
        }
    }
}