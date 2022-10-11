import java.util.*;

class Main {
  // Given an array of unsorted numbers and a target number, find a triplet in the
  // array whose sum is as close to the target number as possible, return the sum
  // of the triplet. If there are more than one such triplet, return the sum of
  // the triplet with the smallest sum.

  // Example 1:

  // Input: [-2, 0, 1, 2], target=2
  // Output: 1
  // Explanation: The triplet [-2, 1, 2] has the closest sum to the target.
  // Example 2:

  // Input: [-3, -1, 1, 2], target=1
  // Output: 0
  // Explanation: The triplet [-3, 1, 2] has the closest sum to the target.
  // Example 3:

  // Input: [1, 0, 1, 1], target=100
  // Output: 3
  // Explanation: The triplet [1, 1, 1] has the closest sum to the target.

  private static int findTripletSumClosestToTarget(int targetSum, int[] a) {
    Arrays.sort(a);
    int smallestDiff = Integer.MAX_VALUE;

    for (int i = 0; i < a.length - 2; i++) {
      // Skip duplicates

      if (i == 0 || i > 0 && a[i] != a[i - 1]) {

        // Use Two-sum approach to get the other two numbers
        // such that the sum of all three numbers are closest to target
        int left = i + 1, right = a.length - 1;
        while (left < right) {
          int currentSum = a[i] + a[left] + a[right];
          int currentDiff = targetSum - currentSum;

          if (currentDiff == 0) {
            return currentSum;
          }

          if (Math.abs(currentDiff) < Math.abs(smallestDiff)) {
            smallestDiff = currentDiff;
          }

          if (currentDiff > 0) {
            // TargetSum is greater than the sum of triplets.
            // Increment left pointer to increase the sum so that the difference moves
            // closer to zero
            left++;
          } else {
            // TargetSum is smaller than the sum of triplets.
            // Decrement right pointer to decrease the sum so that the difference moves
            // closer to zero
            right--;
          }
        }
      }
    }

    return targetSum - smallestDiff;
  }

  public static void main(String[] args) {
    System.out.printf("Triplet sum closest to target = %d%n",
        Main.findTripletSumClosestToTarget(2, new int[] { -2, 0, 1, 2 }));
    System.out.printf("Triplet sum closest to target = %d%n",
        Main.findTripletSumClosestToTarget(1, new int[] { -3, -1, 1, 2 }));
    System.out.printf("Triplet sum closest to target = %d%n",
        Main.findTripletSumClosestToTarget(100, new int[] { 1, 0, 1, 1 }));

  }
}