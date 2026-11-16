class Solution {

    // Function to check if we can make m bouquets
    public boolean possible(int[] bloomDay, int day, int m, int k) {

        int count = 0;
        int noOfBouquets = 0;

        for (int i = 0; i < bloomDay.length; i++) {

            if (bloomDay[i] <= day) {
                count++;
            } 
            else {
                noOfBouquets += count / k;
                count = 0;
            }
        }

        // Count the remaining flowers
        noOfBouquets += count / k;

        return noOfBouquets >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {

        // If insufficient flowers, return -1
        if ((long) m * k > bloomDay.length) {
            return -1;
        }

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        // Find minimum and maximum bloom days
        for (int i = 0; i < bloomDay.length; i++) {
            low = Math.min(low, bloomDay[i]);
            high = Math.max(high, bloomDay[i]);
        }

        int ans = -1;

        // Binary Search
        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (possible(bloomDay, mid, m, k)) {
                ans = mid;
                high = mid - 1;
            } 
            else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
