package edu.hw1;

public class Task1 {
    public static Integer minutesToSeconds(String time){
        String[] nums = time.split(":");

        if (nums[0].length() < 2 | nums[1].length() < 2)
            return -1;


        int minutes = Integer.parseInt(nums[0]);
        int seconds = Integer.parseInt(nums[1]);

        if (minutes < 0 | seconds < 0 | seconds >= 60)
            return -1;

        return minutes * 60 + seconds;
    }

}
