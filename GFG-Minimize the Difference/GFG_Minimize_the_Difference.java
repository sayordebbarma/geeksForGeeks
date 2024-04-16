class Solution {
    public static int minimizeDifference(int n, int k, int[] arr) {
        // code here
        int rMax[]=new int[n];
        int rMin[]=new int[n];
        rMax[n-1]=arr[n-1];
        rMin[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            rMin[i]=Math.min(rMin[i+1],arr[i]);
            rMax[i]=Math.max(rMax[i+1],arr[i]);
        }
        int i=0,j=k-1,mn=Integer.MAX_VALUE,mx=Integer.MIN_VALUE,ans=Integer.MAX_VALUE;
        while(j<n){
            if(i!=0){
                mn=Math.min(arr[i-1],mn);
                mx=Math.max(arr[i-1],mx);
            }
            int temp1=mx,temp2=mn;
            if(j!=n-1){
                temp1=Math.max(mx,rMax[j+1]);
                temp2=Math.min(mn,rMin[j+1]);
            }
            ans=Math.min(ans,Math.abs(temp1-temp2));
            i++;
            j++;
        }
        return ans;
    }
}
