class Solution {
    public int compress(char[] chars) {
        int write=0;
        int i=0;
        while(i<chars.length){
            char s=chars[i];
            int count=0;
            while(i<chars.length && s==chars[i]){
                count++;
                i++;
            }
            chars[write++]=s;
            if(count>1){
                String t=String.valueOf(count);
                for(char c:t.toCharArray()){
                    chars[write++]=c;
                }
            }
        }
        return write;
    }
}