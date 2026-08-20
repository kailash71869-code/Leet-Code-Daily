class Solution {
    public String decodeString(String s) {
        Stack<Integer> st_num=new Stack<>();
        Stack<String> st_str=new Stack<>();
        String curr="";
        int num=0;

        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                num=num*10+(s.charAt(i)-'0');
            }else if(s.charAt(i)=='['){
                st_str.push(curr);
                st_num.push(num);
                num=0;
                curr="";
            }else if(s.charAt(i)==']'){
                int val=st_num.pop();
                String prev=st_str.pop();
                String temp="";
                for(int j=0;j<val;j++){
                    temp+=curr;
                }
                curr=prev+temp;
               // st_str.push(curr);
            }else{
                curr+=(s.charAt(i));
            }
        }
        return curr;
    }
}