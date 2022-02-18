package company.amazon;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain  water (blue section) are being trapped.
 *
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int water = 0;

        int leftIndex = 0;
        int rightIndex = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        while(leftIndex <= rightIndex) {
            leftMax = Math.max(leftMax, height[leftIndex]);
            rightMax = Math.max(rightMax, height[rightIndex]);

            if(leftMax < rightMax) {
                water += leftMax - height[leftIndex];
                leftIndex++;
            } else {
                water += rightMax - height[rightIndex];
                rightIndex--;
            }
        }

        return water;
    }
}
