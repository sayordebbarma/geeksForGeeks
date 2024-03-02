class Solution
{
    public int firstElementKTime(int n, int k, int[] a) { 
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<n; i++) {
            map.putIfAbsent(a[i], 0);
            map.put(a[i], map.get(a[i])+1);
            
            if(map.get(a[i])==k) return a[i];
        }
        
        return -1;
    } 
}
