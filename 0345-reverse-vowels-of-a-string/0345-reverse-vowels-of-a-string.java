class Solution {
    public String reverseVowels(String s) {
        boolean[] a=new boolean[128];
        for(char str:"aeiouAEIOU".toCharArray())
        {
            a[str]=true;
        }
        char[] c=s.toCharArray();
        int i=0,j=s.length()-1;
        while(i<j)
        {
            while(i<j && !a[c[i]])
            {
                i++;
            }
            while(i<j && !a[c[j]])
            {
                j--;
            }
            if(i<j)
            {
                char t=c[i];
                c[i]=c[j];
                c[j]=t;
                i++;
                j--;
            }
        }
        return String.valueOf(c);
    }
}