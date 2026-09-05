class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list=new ArrayList<>();
        int[] window=new int[26];
        int k=p.length();
        if(s.length()<p.length()){
            return list;
        }
        for(char ph:p.toCharArray()){
            window[ph-'a']++;
        }
        int[] freq=new int[26];
        for(int i=0;i<k;i++){
            freq[s.charAt(i)-'a']++;
        }
        if(Arrays.equals(freq,window)){
            list.add(0);
        }
        for(int i=k;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
            freq[s.charAt(i-k)-'a']--;
            if(Arrays.equals(freq,window)){
                list.add(i-k+1);
            }
        }
        return list;
    }
}