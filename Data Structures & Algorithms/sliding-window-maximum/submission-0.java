class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length, index = 0;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++){
            while (!deque.isEmpty() && deque.peekFirst() <= i - k)
                deque.removeFirst();

            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()])
                deque.removeLast();

            deque.addLast(i);
            if (i >= k - 1) result[index++] = nums[deque.peekFirst()];
        }
        return result;
    }
}
