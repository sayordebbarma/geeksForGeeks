class Solution {
    public static ArrayList<Integer> constructList(int q, int[][] queries) {
        // code here
        int cumulativeXor = 0;
        ArrayList<Integer> resultList = new ArrayList<>();
        
        for (int i = q - 1; i >= 0; i--) {
            if (queries[i][0] == 1) {
                cumulativeXor ^= queries[i][1];
            } else if (queries[i][0] == 0) {
                resultList.add(queries[i][1] ^ cumulativeXor);
            }
        }
        
        resultList.add(cumulativeXor);
        Collections.sort(resultList);
        return resultList;
    }
}
