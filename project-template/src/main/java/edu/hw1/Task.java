package edu.hw1;

import java.util.logging.Logger;
import java.util.Arrays;

public class Task {

    //Task0
    private static final Logger LOGGER = Logger.getLogger(Task.class.getName());

    public static void main(String[] args) {
        LOGGER.info("Привет, мир!");
    }


    //Task1
    public static int minutesToSeconds(String time){
        String[] nums = time.split(":");

        if (nums.length != 2 || nums[1].length() < 2) {
            return -1;
        }

        int minutes = Integer.parseInt(nums[0]);
        int seconds = Integer.parseInt(nums[1]);

        if (minutes < 0 || seconds < 0 || seconds >= 60) {
            return -1;
        }

        return minutes * 60 + seconds;
    }

    //Task2
    public static int countDigits(int num) {
        if (num < 0) num = Math.abs(num);
        if (num < 10) return 1;
        return 1 + countDigits(num / 10);
    }

    //Task3
    public static boolean isNestable(int[] ms1, int[] ms2){
        if (ms1.length == 0 || ms2.length == 0){
            return false;
        }
        return Arrays.stream(ms1).max().orElseThrow() < Arrays.stream(ms2).max().orElseThrow() &&
            Arrays.stream(ms1).min().orElseThrow() > Arrays.stream(ms2).min().orElseThrow();
    }

    //Task4
    public static String fixString(String str) {
        StringBuilder strAns = new StringBuilder();
        for (int i = 0; i < str.length() - 1; i += 2) {
            strAns.append(str.charAt(i + 1));
            strAns.append(str.charAt(i));
        }
        if (str.length() % 2 != 0) {
            strAns.append(str.charAt(str.length() - 1));
        }
        return String.valueOf(strAns);
    }

    //Task5
    public static boolean isPalindromeDescendant(int num) {
        if (num < 10) return false;
        String str = String.valueOf(num);
        return isPalindromeDescendant(str);

    }

    public static boolean isPalindromeDescendant(String str) {
        if (str.length() == 1) return false;
        boolean flag = true;
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(str.length() - 1 - i) != str.charAt(i))
            {
                StringBuilder newstr = new StringBuilder();
                for (int j = 0; j < str.length(); j += 2)
                    newstr.append(Integer.parseInt("" + str.charAt(i))
                        + Integer.parseInt("" + str.charAt(i + 1)));
                return isPalindromeDescendant(newstr.toString());
            }
        return true;
    }

    //Task6
    public static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    public static int countK(int num) {
        if (num <= 1000) return -1;
        int ans = 0;
        int tmp = num, prev = num % 10;
        boolean flag = true;
        while (tmp > 0){
            flag &= (prev == (tmp%10));
            tmp /= 10;
        }
        if (flag) return -1;
        while (num != 6174){

            char[] str = Integer.toString(num).toCharArray();
            Arrays.sort(str);
            int des = Integer.parseInt(String.valueOf(str));
            int inc = Integer.parseInt(reverseString(new String(str)));
            num = inc - des;
            ans++;
            if (num == 0) return -1;
        }
        return ans;
    }

    //Task7
    public static String toBinaryString(int n)
    {
        return String.format("%16s", Integer.toBinaryString(n)).replaceAll(" ", "0");
    }

    public static int findNextPowerOf2(int n)
    {
        n--;
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;
        return ++n;
    }
    public static int findDigits(int n)
    {
        int ans = 0;
        while(n > 0) {
            ans++;
            n /= 2;
        }
        return ans;
    }
    public static int rotateLeft(int n, int shift){
        return ((n << shift) | (n >> (findDigits(n) - shift))) & ( findNextPowerOf2(n) - 1);
    }
    public static int rotateRight(int n, int shift){
        return ((n >> shift) | (n << (findDigits(n) - shift))) & ( findNextPowerOf2(n) - 1);
    }

    //Task8
    public static boolean check(int x, int y) {
        return  x >= 0 && x < 8 && y >= 0 && y < 8;
    }

    private static final int[] xx = new int[]{-1,-2,-1,-2,1,2,1,2};

    private static final int[] yy = new int[]{-2,-1,2,1,2,1,-2,-1};

    public static boolean knightBoardCapture(int[][] field) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (field[i][j] == 1)
                    for (int u = 0; u < 8; u++) {
                        int x = i + xx[u];
                        int y = j + yy[u];
                        if (check(x, y)) {
                            if (field[x][y] == 1) {
                                //System.out.println(i + " " + j + " " + x + " " + y);
                                return false;
                            }
                        }
                    }
            }
        }
        return true;
    }
}
