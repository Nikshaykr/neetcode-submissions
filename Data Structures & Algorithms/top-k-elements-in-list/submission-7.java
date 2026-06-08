class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int i = 0; i < buckets.length; i++) buckets[i] =  new ArrayList<>();

        for (var entry : map.entrySet()){
            int freq = entry.getValue();
            buckets[freq].add(entry.getKey());
        }

        int[] res = new int[k];
        var index = 0;
        for (int i = buckets.length - 1; i >= 0; i--){
            for(int num : buckets[i]){
                res[index++] = num;
                if (index == k) return res;
            }
        }
        return new int[0];
    }
}
