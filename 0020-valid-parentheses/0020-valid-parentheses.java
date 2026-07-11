class Solution {
    public boolean isValid(String s) {
        Stack<Character> t=new Stack<>();
        for(char str:s.toCharArray())
        {
            if(str=='(')
            {
                t.push(')');
            }
            else if(str=='{')
            {
                t.push('}');
            }
            else if(str=='[')
            {
                t.push(']');
            }
            else if(t.isEmpty() || t.pop()!=str)
            {
                return false;
            }
        }
        return t.isEmpty();
    }
}