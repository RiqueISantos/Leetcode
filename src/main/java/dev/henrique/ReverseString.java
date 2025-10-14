package dev.henrique;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverseString(new char[]{'h','e','l','l','o'}));
    }

    public static char[] reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left <= right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }

        return s;
    }

}