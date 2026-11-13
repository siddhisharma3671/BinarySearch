class Solution {
    public int smallestDivisor(int[] nums, int threshold) {

        int low = 1;
        int high = 0;

        // Find maximum element
        for (int i = 0; i < nums.length; i++) {
            high = Math.max(high, nums[i]);
        }

        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (sumOfDivision(nums, mid) <= threshold) {
                ans = mid;
                high = mid - 1;
            } 
            else {
                low = mid + 1;
            }
        }

        return ans;
    }

    // Calculate sum of divisions
    public long sumOfDivision(int[] arr, int div) {

        long sum = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {

            sum = sum + (long) Math.ceil((double) arr[i] / div);

        }

        return sum;
    }
}
