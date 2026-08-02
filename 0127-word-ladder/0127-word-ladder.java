class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        int n=wordList.size();
        Queue<Pair<String,Integer>> q=new LinkedList<>();
        Set<String> set=new HashSet<>();
        for(String x:wordList){
            set.add(x);
        }
        q.offer(new Pair<>(beginWord,1));
        set.remove(beginWord);

       while(!q.isEmpty()){
         Pair<String,Integer> p=q.poll();
         String word=p.getKey();
         int steps=p.getValue();

         if(word.equals(endWord)){
            return steps;
         }
         for(int i=0;i<word.length();i++){
            for(char ch='a';ch<='z';ch++){
                char[] replacearr=word.toCharArray();
                replacearr[i]=ch;
                String replaceWord=new String(replacearr);

                if(set.contains(replaceWord)){
                    q.offer(new Pair<>(replaceWord,steps+1));
                    set.remove(replaceWord);
                }
            }
         }
       }
       return 0;
    }
}