class Solution {
    // Function to sort the array according to frequency of elements.
    public ArrayList<Integer> sortByFreq(int arr[]) {
        // add your code here
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        for (int num : arr) {
            result.add(num);
        }
        
        Collections.sort(result, (a, b) -> {
            int freqA = frequencyMap.get(a);
            int freqB = frequencyMap.get(b);
            
            if (freqA != freqB) return freqB - freqA;
            else return a - b;
        });
        
        return result;
    }
}
