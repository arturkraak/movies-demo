package org.arturkraak.moviesdemo.seat;

import java.util.Random;

public class SeatService {
    static int y = 7;
    static int x = 15;
    static int[][] seats = new int[y][x];

    public static int[][] randomSeats() {
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                seats[i][j] = (Math.random() < 0.5) ? 1 : 0;
            }
        }
        // Print the array
//        for (int i = 0; i < y; i++) {
//            for (int j = 0; j < x; j++) {
//                System.out.print(seats[i][j] + " ");
//            }
//            System.out.println();
//        }

        return seats;
    }

    public static int[][] generateSeatsWithSeed(long seed) {
        Random random = new Random(seed);
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                seats[i][j] = (random.nextDouble() < 0.5) ? 1 : 0;
                if(i == 3 && seats[i][j] == 0) {
                    seats[i][j] = 2;
                }
            }
        }
        return seats;
    }
}
