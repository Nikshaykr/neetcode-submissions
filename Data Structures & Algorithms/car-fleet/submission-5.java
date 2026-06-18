class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length == 1) return 1;

        int n = position.length;
        int[][] cars = new int[n][2];

        for (int i = 0; i < n; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, Comparator.comparingInt(a -> a[0]));

        int fleet = 0;
        double fleetTime = 0;

        for (int i = n - 1; i >= 0; i--){
            double time = (double) (target - cars[i][0]) / cars[i][1];

            if (time > fleetTime){
                fleet++;
                fleetTime = time;
            }
        }
        return fleet;
    }
}
