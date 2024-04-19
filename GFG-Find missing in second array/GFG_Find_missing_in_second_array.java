class Solution {
    ArrayList<Integer> findMissing(int a[], int b[], int n, int m) {
        HashSet<Integer> s = new HashSet<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < m; ++i) {
            s.add(b[i]);
        }

        for (int i = 0; i < n; ++i) {
            if (!s.contains(a[i])) {
                ans.add(a[i]);
            }
        }

        return ans;
    }
}
