class Solution
{
	// Function to find the peak element
	// arr[]: input array
	// n: size of array a[]
	public int peakElement(int[] arr,int n)
    {
       //add code here.
       int start = 0;
       int end = n-1;
       
       while(start<=end) {
           int mid = start+(end-start)/2;
           
           if((mid==0 || arr[mid]>=arr[mid-1]) && (mid == n-1 || arr[mid]>=arr[mid+1])) return mid;
           else if(arr[mid]<=arr[mid+1]) start = mid+1;
           else end = mid-1;
       }
       
       return -1;
    }
}
