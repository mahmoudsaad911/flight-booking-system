import java.util.ArrayList;

public class Flight {
    private long flight_number;
    private String destination;
    private int capacity;
    private double price;
    private double takeoff_time;
    private ArrayList<Passenger> passengers;

    public Flight(long flight_number, String destination, int capacity,double price, double takeoff_time) {
        this.flight_number = flight_number;
        this.destination = destination;
        this.capacity = capacity;
        this.price = price;
        this.takeoff_time = takeoff_time;
        passengers = new ArrayList<Passenger>();
    }

    public long getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(long flight_number) {
        this.flight_number = flight_number;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getNPassengers(){return passengers.size();}

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void displayFlight(){
        System.out.printf("%d\t%s\t%d\t%d\t%.2f\n", flight_number, destination, capacity, passengers.size(), price);

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTakeoff_time() {
        return takeoff_time;
    }

    public void setTakeoff_time(double takeoff_time) {
        this.takeoff_time = takeoff_time;
    }

    public int availableSeats(){
        return capacity - passengers.size();
    }

    public void addPassenger(Passenger p){
        passengers.add(p);
    }

    public void removePassenger(long ticketNumber){
        for(Passenger pas: passengers){
            if(pas.getTicket_number() == ticketNumber)
                passengers.remove(pas);
        }
    }
}
