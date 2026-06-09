class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Initialize and populate the map
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        // create and initialize each bucket to an empty arrayList
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (int i = 0; i < bucket.length; i++) bucket[i] = new ArrayList<>();

        // populate the bucket using each map entry
        for (var entry : map.entrySet()){
            int freq = entry.getValue();
            bucket[freq].add(entry.getKey());
        }

        // create and populate the res array
        int[] res = new int[k];
        int index = 0;
        for (int i = bucket.length - 1; i >= 0; i--){
            for (int num : bucket[i]){
                res[index++] = num;
                if (index == k) return res;
            }
        }
        return new int[0];
    }
}
