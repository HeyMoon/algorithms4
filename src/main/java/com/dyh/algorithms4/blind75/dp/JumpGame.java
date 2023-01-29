package com.dyh.algorithms4.blind75.dp;

/**
 * @author: dengyunhui
 * @datetime: 2022/3/11 下午3:52
 * @description: https://leetcode-cn.com/problems/jump-game/
 */
public class JumpGame {


    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }

        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= maxIndex) {
                maxIndex = Math.max(i + nums[i], maxIndex);
            }

            if (maxIndex >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        //System.out.println(jumpGame.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(jumpGame.canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(jumpGame.canJump(new int[]{2, 0}));
        System.out.println(jumpGame.canJump(new int[]{2, 5, 0, 0}));

    }

}
