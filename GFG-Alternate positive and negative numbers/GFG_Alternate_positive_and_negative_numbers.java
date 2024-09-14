class Solution {
    void rearrange(ArrayList<Integer> arr) {
        // code here
        int n = arr.size();
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (arr.get(i) >= 0) pos.add(arr.get(i));
            else neg.add(arr.get(i));
        }
        
        int i = 0, j = 0, k = 0;
        boolean toggle = true;
        while (i < pos.size() && j < neg.size()) {
            if (toggle) arr.set(k++, pos.get(i++));
            else arr.set(k++, neg.get(j++));

            toggle = !toggle;
        }
        
        while (i < pos.size()) {
            arr.set(k++, pos.get(i++));
        }
        
        while (j < neg.size()) {
            arr.set(k++, neg.get(j++));
        }
    }
}
