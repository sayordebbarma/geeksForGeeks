class Solution
{
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        // add your code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        Set<Integer> set = new TreeSet<>();
        
        for (int x : arr1) {
            set.add(x);
        }
        
        for (int x : arr2) {
            set.add(x);
        }

        for (int x : set) {
            list.add(x);
        }

        return list;
    }
}
