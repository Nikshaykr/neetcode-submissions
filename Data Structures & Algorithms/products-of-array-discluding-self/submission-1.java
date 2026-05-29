class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1; 
        int zeroCount = 0;

        for (int num : nums){
            if (num != 0){
                prod *= num;
            } else {
                zeroCount++;
            }
        }

        if (zeroCount > 1) return new int[nums.length];

        int[] res = new int[nums.length];
        if (zeroCount == 1) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) res[i] = prod;
                else res[i] = 0;
            }
        } else {
            for (int i = 0; i < nums.length; i++){
                res[i] = prod / nums[i];
            }
        }

        return res;
    }
}  
