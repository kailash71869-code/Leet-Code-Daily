class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        long n=s.length();
        int i=0;
        long num=0;
        if(s.isEmpty()) return 0;
        int sign=1;
        if(s.charAt(i)=='-' || s.charAt(i)=='+'){
            sign=(s.charAt(i)=='-')?-1:1;
            i++;
        }
        while(i<n && Character.isDigit(s.charAt(i))){
            num=(num*10)+(s.charAt(i)-'0');
            if(sign*num<Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if(sign*num>Integer.MAX_VALUE) return Integer.MAX_VALUE;
            i++;
        }
        return (int)(num*sign);
    }
}