package org.arturkraak.moviesdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class seatController {
    int y = 8;
    int x = 15;
    int[][] seats = new int[y][x];

    public void generateSeats() {
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
    }

    @GetMapping("/seats")
    public int[][] getSeats() {
        generateSeats();
        return seats;
    }
}
