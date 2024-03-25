class Solution {
    ArrayList<String> NBitBinary(int N) {
        // code here
        int count1s = 0;
        int count0s = 0;
        ArrayList<String> result = new ArrayList<>();
        StringBuilder currentBinary = new StringBuilder();

        generateBinary(N, count1s, count0s, currentBinary, result);
        return result;
    }

    private void generateBinary(int n, int count1s, int count0s, StringBuilder current, ArrayList<String> result) {
        if (n == 0) {
            result.add(current.toString());
            return;
        }

        generateBinary(n - 1, count1s + 1, count0s, new StringBuilder(current).append("1"), result);

        if (count1s > count0s) generateBinary(n - 1, count1s, count0s + 1, new StringBuilder(current).append("0"), result);
    }
}
