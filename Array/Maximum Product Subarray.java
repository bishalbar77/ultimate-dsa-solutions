class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        long currentMax = 1;
        long currentMin = 1;
        long maxProd = 0;
        boolean flag = true;
        
        if(n == 1) {
            return arr[0];
        }
        for(int i = 0; i < n; i++) {
            // Postive
            if(arr[i] > 0) {
                currentMax *= arr[i];
                currentMin = min(currentMin * arr[i], 1);
                flag = false;
            }
            // Zero
            else if(arr[i] == 0) {
                currentMax = 1;
                currentMin = 1;
            }
            // Negative
            else {
                long temp = currentMax;
                currentMax = max(currentMin * arr[i], 1);
                currentMin = temp * arr[i];
            }
            if(maxProd < currentMax) {
                maxProd = currentMax;
            }
        }
        if(flag && maxProd == 0) {
            return 0;
        }
        return maxProd;
    }
    
    static long max(long x, long y) {
        return x > y ? x : y;
    }
    
    static long min(long x, long y) {
        return x > y ? y : x;
    }
}