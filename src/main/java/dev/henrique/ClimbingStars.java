package dev.henrique;

public class ClimbingStars {
    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }

    public static int climbStairs(int n) {
        int prev = 1, curr = 1;

        for (int i = 2; i <= n; i++) {
           int temp = curr;
           curr = prev + curr;
            prev = temp;
        }
        return curr;
    }
}
