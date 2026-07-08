class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int l=str1.length();
        int r=str2.length();
        if(!(str1+str2).equals(str2+str1)){
            return "";
        }
        String res=str1.substring(0,gcd(l,r));
        return res;
    }
    public int gcd(int n_1,int n_2)
    {
        if(n_2==0){
            return n_1;
        }
        return gcd(n_2,n_1%n_2);
    }
}