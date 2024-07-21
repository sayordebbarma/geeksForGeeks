class Solution {
    public long findMaxProduct(List<Integer> arr) {
        // code here
        int n = arr.size();
        if(n==1) return arr.get(0);
        
        long posProduct=1, negProduct=1, c1=0, c2=0;
        long maxNegative=Long.MIN_VALUE;
        long mod=1000000007;
        
        for(Integer x:arr){
            if(x<0) {
                negProduct = (negProduct*(long)x)%mod;;
                maxNegative = Math.max((long)x, maxNegative);
                c1++;
            }
            
            if(x>0) {
                posProduct = (posProduct*(long)x)%mod;
                c2++;
            }
        }
        if(c1<=1 && c2==0) return 0;
        
        if(negProduct<0) negProduct /= maxNegative;
        
        return (posProduct*negProduct)%mod;
    }
}
