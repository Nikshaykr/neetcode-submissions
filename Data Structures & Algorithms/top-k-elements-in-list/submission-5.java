class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Create a map to store the frequency of each element
        Map<Integer, Integer> map = new HashMap<>();
        for (var num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        // Create a priority queue to store the elements based on their frequency
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (var key : map.keySet()){
            pq.add(key);

            // if the size of the priority queue is greater than k, remove the element with the lowest frequency
            if (pq.size() > k) pq.poll();
        }

        // Create an array to store the k most frequent elements
        int[] res = new int[k];
        for (var i = k - 1; i >= 0; i--) res[i] = pq.poll();

        return res;
    }
}
