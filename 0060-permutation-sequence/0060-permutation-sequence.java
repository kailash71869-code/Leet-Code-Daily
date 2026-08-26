class Solution {
    public String getPermutation(int n, int k) {
        int f=1;
        List<Integer> list=new ArrayList<>();
        for(int i=1;i<n;i++)
        {
            f*=i;
            list.add(i);
        }
        list.add(n);
        String ans="";
        k-=1;
        while(true)
        {
            ans+=(list.get(k/f));
            list.remove(k/f);
            if(list.size()==0)
            break;
            k=k%f;
            f=f/list.size();
        }
        return ans;
    }
}