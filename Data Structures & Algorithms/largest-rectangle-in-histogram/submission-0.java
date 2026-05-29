class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, maxArea = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= n; i++){
            int currElement = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && heights[stack.peek()] > currElement){
                int h = heights[stack.pop()];
                int prevSmaller = (stack.isEmpty()) ? -1 : stack.peek();
                int w = i - prevSmaller - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            stack.push(i);
        }
        return (maxArea == Integer.MIN_VALUE) ? 0 : maxArea;
    }
}
