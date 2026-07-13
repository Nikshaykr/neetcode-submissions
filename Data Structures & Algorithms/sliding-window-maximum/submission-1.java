class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;

        for (int i = 0; i < n; i++){
            // Check if the deque is not empty and the first element index is smaller than window size
            while (!deque.isEmpty() && deque.peekFirst() <= i - k){
                deque.removeFirst();
            }

            // Check if the deque is not empty and the last element is smaller than the current element
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.removeLast();
            }

            deque.addLast(i);

            if (i >= k - 1){
                result[index++] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}
