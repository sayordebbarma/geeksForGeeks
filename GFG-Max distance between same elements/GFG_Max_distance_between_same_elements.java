class Solution {
    public int maxDistance(int[] arr) {
        // Code here
        HashMap<Integer, Integer> firstOccurrence = new HashMap<>();
        int maxDistance = 0;
        
        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            
            if (firstOccurrence.containsKey(element)) {
                int firstIndex = firstOccurrence.get(element);
                int distance = i - firstIndex;
                maxDistance = Math.max(maxDistance, distance);
            } else {
                firstOccurrence.put(element, i);
            }
        }
        
        return maxDistance;
    }
}
