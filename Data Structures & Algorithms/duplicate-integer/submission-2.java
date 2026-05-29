class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> map  =  new HashMap<>();

        for (int num : nums){
            if (map.containsKey(num)) map.put(num, map.get(num) + 1);
            else map.put(num, 1);
        }

        for (int num : map.keySet()){
            if (map.get(num) > 1) return true;
        }
        return false;
    }
}