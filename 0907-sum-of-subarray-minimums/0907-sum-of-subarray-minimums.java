class Solution {
    public int[] findPse(int[] arr){
        int n=arr.length;
        int[] pse=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            pse[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return pse;
    }
    public int[] findNse(int[] arr){
        int n=arr.length;
        int[] nse=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            nse[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return nse;
    }
    public int sumSubarrayMins(int[] arr) {
       int n=arr.length;
       int[] nse=findNse(arr);
       int[] pse=findPse(arr);

       int sum=0;
       int mod=(int)(1e9+7);
       
       for(int i=0;i<n;i++){
        int left=i-pse[i];
        int right=nse[i]-i;
        long freq=left*right*1L;
        int val=(int)((freq*arr[i])%mod);

        sum=(sum+val)%mod;
       }
       return sum;
    }
}