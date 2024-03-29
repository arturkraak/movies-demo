package org.arturkraak.moviesdemo.seat;

// seat object for Thymeleaf. Used in seats.html
public class SeatObject {
    public int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

    public long getSeed() {
        return seed;
    }

    public void setSeed(long seed) {
        this.seed = seed;
    }

    private long seed;
    private int tickets;
}
