class Solution {
    // Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // add your code here
        ArrayList<Integer> union = new ArrayList<>();
        int i = 0, j = 0;
        
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                if (union.isEmpty() || union.get(union.size() - 1) != a[i]) union.add(a[i]);
                i++;
            }
            else if (a[i] > b[j]) {
                if (union.isEmpty() || union.get(union.size() - 1) != b[j]) union.add(b[j]);
                j++;
            }
            else {
                if (union.isEmpty() || union.get(union.size() - 1) != a[i]) union.add(a[i]);
                i++;
                j++;
            }
        }
        
        while (i < a.length) {
            if (union.isEmpty() || union.get(union.size() - 1) != a[i]) union.add(a[i]);
            i++;
        }
        
        while (j < b.length) {
            if (union.isEmpty() || union.get(union.size() - 1) != b[j]) union.add(b[j]);
            j++;
        }
        
        return union;
    }
}
