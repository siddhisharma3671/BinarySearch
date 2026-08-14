import java.util.*;

class LowerBound{
    // Function to find the lower bound index
    public int lowerBound(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= x) {
                return i;  // First index where element >= x
            }
        }
        return arr.length;  // If x is greater than all elements
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 15, 19};
        int x = 9; // Define the target value
        
        // Create an object of the class to call the non-static method
        LowerBoundFinder finder = new LowerBoundFinder();
        
        // Call the method and store the result
        int ind = finder.lowerBound(arr, x);
        
        // Print the result
        System.out.println("The lower bound is the index: " + ind);
    }
}
