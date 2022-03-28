package algo;

/**
 * 849. Maximize Distance to Closest Person
 * Medium
 *
 * You are given an array representing a row of seats where seats[i] = 1 represents a person sitting in the ith seat,
 * and seats[i] = 0 represents that the ith seat is empty (0-indexed).
 *
 * There is at least one empty seat, and at least one person sitting.
 *
 * Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.
 *
 * Return that maximum distance to the closest person.
 *
 *
 *
 * Example 1:
 *
 * Input: seats = [1,0,0,0,1,0,1]
 * Output: 2
 * Explanation:
 * If Alex sits in the second open seat (i.e. seats[2]), then the closest person has distance 2.
 * If Alex sits in any other open seat, the closest person has distance 1.
 * Thus, the maximum distance to the closest person is 2.
 *
 * Example 2:
 *
 * Input: seats = [1,0,0,0]
 * Output: 3
 * Explanation:
 * If Alex sits in the last seat (i.e. seats[3]), the closest person is 3 seats away.
 * This is the maximum distance possible, so the answer is 3.
 *
 * Example 3:
 *
 * Input: seats = [0,1]
 * Output: 1
 *
 *
 *
 * Constraints:
 *
 * 2 <= seats.length <= 2 * 104
 * seats[i] is 0 or 1.
 * At least one seat is empty.
 * At least one seat is occupied.
 */
public class MaximizeDistanceToClosestPerson {

    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int val = -1;
        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                val = i;
            }
            left[i] = val;
        }

        val = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (seats[i] == 1) {
                val = i;
            }
            right[i] = val;
        }

        int max = 1;
        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) continue;
            max = Math.max(max, Math.min(left[i] == -1 ? Integer.MAX_VALUE : i - left[i], right[i] == -1 ? Integer.MAX_VALUE : right[i] - i));
        }

        return max;
    }

    public static void main(String[] args) {
        int seats[] = {1,0,0,0,1,0,1};
        // int seats[] = {1, 0, 0, 0};
        System.out.println(new MaximizeDistanceToClosestPerson().maxDistToClosest(seats));
    }
}