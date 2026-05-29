class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 1) return 1;

        Stack<Double> stack = new Stack<>();
        int[][] cars = new int[n][2];

        for (int i = 0; i < n; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, java.util.Comparator.comparingInt(o -> o[0]));

        for (int i = cars.length - 1; i >= 0; i--){
            double currentTime = (double)(target - cars[i][0]) / cars[i][1];

            if (!stack.isEmpty() && currentTime <= stack.peek()) continue;
            else stack.push(currentTime);
        }
        return stack.size();
    }
}
