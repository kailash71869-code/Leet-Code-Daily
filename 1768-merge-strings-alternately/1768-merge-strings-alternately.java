class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i=0;
        int j=0;
        StringBuilder sb=new StringBuilder();
        while(i<word1.length() && j<word2.length()){
            sb.append(word1.charAt(i));
            i++;
            sb.append(word2.charAt(j));
            j++;
        }
        while(i<word1.length()){
            sb.append(word1.charAt(i));
            i++;
        }
        while(j<word2.length()){
        sb.append(word2.charAt(j));
        j++;
        }
    return sb.toString();
    }
}