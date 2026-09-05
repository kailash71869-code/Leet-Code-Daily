class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list=new ArrayList<>();
        int k=p.length();
        int[] pre=new int[26];
        for(char ph:p.toCharArray()){
            pre[ph-'a']++;
        }
        for(int i=0;i<=s.length()-k;i++){
            int[] freq=new int[26];
            for(int j=i;j<k+i;j++){
                freq[s.charAt(j)-'a']++;
            }
            if(Arrays.equals(pre,freq)){
                list.add(i);
            }
        }
        return list;
    }
}