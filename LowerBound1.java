public class Lowerbound {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 4, 5, 6};
        int target = 4;
        int lowerBoundIndex = lowerBound(arr, target);
        System.out.println("Lower bound index of " + target + " is: " + lowerBoundIndex);
    }

    public static int lowerBound(int[] arr, int target) {
        int low= 0;
        int high = arr.length-1;
        int ans = arr.length; // Initialize ans to the length of the array

        while (low <= high) {
            int mid = low + (high- low) / 2;
            if (arr[mid] >= target) {
                ans = mid; // Update the answer
                high = mid - 1; // Continue searching in the left half
            } else {
                low = mid + 1;
            }
        }
        return ans; // Return the index of the lower bound
    }
}
