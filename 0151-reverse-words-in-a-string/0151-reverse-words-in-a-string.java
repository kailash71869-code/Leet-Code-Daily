class Solution {
    public String reverseWords(String s) {
        String[] k=s.trim().split("\\s+");
        StringBuilder t=new StringBuilder();
        for(int i=k.length-1;i>=0;i--)
        {
            t.append(k[i]);
            if(i!=0)
            {
                t.append(" ");
            }
        }
        
        return t.toString();
    }
}

         