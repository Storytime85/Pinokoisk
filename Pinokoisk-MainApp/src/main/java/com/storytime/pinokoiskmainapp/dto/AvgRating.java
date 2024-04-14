package com.storytime.pinokoiskmainapp.dto;

import lombok.Data;



@Data
public class AvgRating {
    private double avgRate;
    private long count;

    public AvgRating(double avgRate, long count) {
        this.avgRate = Math.floor(avgRate*100)/100;
//        this.avgRate = avgRate;
        this.count = count;
    }

    public AvgRating() {
    }

    public AvgRating(AvgRating first, AvgRating second) {
        if (first == null && second == null) {
            this.avgRate = 0;
            this.count = 0;
        } else if (first == null) {
            this.avgRate = second.avgRate;
            this.count = second.count;
        } else if (second == null) {
            this.avgRate = first.avgRate;
            this.count = first.count;
        } else {
            this.avgRate = (first.avgRate+ second.avgRate)/2;
            this.count = first.count+ second.count;
        }
    }
    //    public AvgRating(List<Short> ratings) {
//        long temp = 0;
//        count = ratings.size();
//        for (short r: ratings) {
//            temp +=r;
//        }
//        avgRate = (double)(temp/count);
//    }
    public static double getAvgBoth(AvgRating first, AvgRating second) {
        if (first == null && second == null) {
            return 0;
        } else if (second == null) {
            return first.avgRate;
        } else if (first == null) {
            return second.avgRate;
        }else {
            return (first.avgRate + second.avgRate) / 2;
        }
    }

}
