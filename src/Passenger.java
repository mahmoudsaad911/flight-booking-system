public class Passenger extends Person {
    private long ticket_number;
    private long flight_number;

    public Passenger(String name, int birth_year, long id, long ticket_number, long flight_number) {
        super(name, birth_year, id);
        this.ticket_number = ticket_number;
        this.flight_number = flight_number;
    }

    public long getTicket_number() {
        return ticket_number;
    }

    public void setTicket_number(long ticket_number) {
        this.ticket_number = ticket_number;
    }

    public long getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(long flight_number) {
        this.flight_number = flight_number;
    }
}
