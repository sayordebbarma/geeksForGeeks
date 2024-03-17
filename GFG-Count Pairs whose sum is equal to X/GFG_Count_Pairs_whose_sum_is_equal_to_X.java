class Solution {

    public static int countPairs(LinkedList<Integer> head1, LinkedList<Integer> head2, int x) {
        // add your code here
        int count =0;
        HashSet<Integer> set = new HashSet<>(head2);

        for (int i : head1) {
            int val = x - i;
            if (set.contains(val)) {
                count++;
            }
        }
        return count;
    }
}
