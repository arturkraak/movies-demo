package org.arturkraak.moviesdemo.seat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
@RequestMapping("/cinema/")
public class SeatController {

    @PostMapping("/seats")
    public String getSeats(@RequestParam int tickets, Model model) {
        Random random = new Random();
        long seed = random.nextLong();
        int[][] newSeats = SeatService.generateSeatsWithSeed(seed);
        model.addAttribute("seats", newSeats);
        System.out.println(tickets);
        SeatObject seatObject = new SeatObject();
        seatObject.setTickets(1);
        seatObject.setSeed(seed);
        System.out.println(seed);
        model.addAttribute("seatObject", seatObject);

        return "seats";
    }

    @PostMapping("/find")
    public String findSeats(@ModelAttribute SeatObject getSeatObject, Model model) {
        System.out.println(getSeatObject.getSeed());
        int[][] oldSeats = SeatService.generateSeatsWithSeed(getSeatObject.getSeed());
        System.out.println(getSeatObject.getTickets());
        model.addAttribute("seats", oldSeats);
        model.addAttribute("seatObject", getSeatObject);

        return "seats";
    }
}
