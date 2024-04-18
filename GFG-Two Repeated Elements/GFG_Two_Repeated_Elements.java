class Solution
{
    //Function to find two repeated elements.
    public int[] twoRepeated(int arr[], int n)
    {
        // Your code here
        int[] result = new int[2];
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        
        for (int i = 0; i < n + 2; i++) {
            if (!visited.add(arr[i])) {
                result[count++] = arr[i];
            }
        }
        
        return result;

    }
    
}
