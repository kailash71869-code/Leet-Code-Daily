class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if(n==0){
            return ans;
        }
        bk(n,k,1,new ArrayList<>());
        return ans;
    }
    public void bk(int n,int k,int index,ArrayList<Integer> list){
        if(k==list.size()){
            ans.add(new ArrayList(list));
            return;
        }
        for(int i=index;i<=n;i++){
            list.add(i);
            bk(n,k,i+1,list);
            list.remove(list.size()-1);
        }
    
    }
}