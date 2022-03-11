package com.dyh.algorithms4.blind75.array;

/**
 * @author: dengyunhui
 * @datetime: 2022/3/8 下午4:15
 * @description:
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int max = 0;
        int low = 0, high = height.length - 1;

        while (low < high) {
            max = Math.max(Math.min(height[low], height[high]) * (high - low), max);

            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        ContainerWithMostWater container = new ContainerWithMostWater();
        System.out.println(container.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
