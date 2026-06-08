class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /* 
        Brute froce approach that comes to mind would be to strore the frequnency of
        each number in map with that key as the number
        Then create min heap and store k numbers at max in it and remove the one whose
        freq is smaller, then return an array polling the values of the heap
        */

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for (int key : map.keySet()){
            pq.add(key);

            if (pq.size() > k) pq.poll();
        }

        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) res[i] = pq.poll();
        return res;
    }
}
