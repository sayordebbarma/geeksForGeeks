class Solution {

    static int sameOccurrence(int arr[], int x, int y) {
        // write code here
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        int diff = 0;
        int count = 0;
        
        for (int num : arr) {
            if (num == x) diff++;
            else if (num == y) diff--;

            count += map.getOrDefault(diff, 0);
            
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        
        return count;
    }
}
