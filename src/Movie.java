public class Movie {
    private String name;
    private String category;
    private int availableTickets;

    public Movie(String name, String category, int availableTickets) {
        this.name = name;
        this.category = category;
        this.availableTickets = availableTickets;
    }

    public void ticketIsToken() {
        this.availableTickets--;
    }

    public int getAvailableTickets() {
        return availableTickets;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }
}
