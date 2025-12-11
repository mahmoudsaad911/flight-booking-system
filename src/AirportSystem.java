import java.util.ArrayList;

public class AirportSystem {

    private ArrayList<Passenger> passengers = new ArrayList<>();
    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Flight> flights = new ArrayList<>();

    // Counts
    public int countPassengers() { return passengers.size(); }
    public int countEmployees() { return employees.size(); }
    public int countFlights() { return flights.size(); }

    // Return list of all flights (used in UI)
    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    // Add Flight
    public void addFlight(long flight_number, String destination, int capacity, double price, double takeofftime){
        // prevent duplicate flight numbers
        for (Flight f : flights) {
            if (f.getFlight_number() == flight_number) {
                System.out.println("Flight already exists!");
                return;
            }
        }

        Flight f = new Flight(flight_number, destination, capacity, price, takeofftime);
        flights.add(f);
        System.out.println("Flight added successfully!");
    }

    // Add Employee
    public void addEmployee(String name, int birth_year, long id, double salary, String position){
        Employee e = new Employee(name, birth_year, id, salary, position);
        employees.add(e);
        System.out.println("Employee added successfully");
    }

    // Book Ticket
    public void bookTicket(String name, int birth_year, long id, long flight_number) {

        Flight f = findFlight(flight_number);
        if (f == null) {
            System.out.println("Flight not found!");
            return;
        }

        if (f.availableSeats() <= 0) {
            System.out.println("Flight is full!");
            return;
        }

        long ticket_number = System.currentTimeMillis(); // unique

        Passenger booker = new Passenger(name, birth_year, id, ticket_number, flight_number);
        passengers.add(booker);
        f.addPassenger(booker);

        System.out.println("Ticket booked successfully!");
    }

    //Take off Flight (remove flight + its passengers)
    public void flight_takeoff(long flight_number) {

        Flight f = findFlight(flight_number);
        if (f == null) {
            System.out.println("Flight not found!");
            return;
        }

        flights.remove(f);

        // remove all passengers on this flight
        passengers.removeIf(p -> p.getFlight_number() == flight_number);

        System.out.println("Flight took off successfully!");
    }

    //Helper: find flight by number
    private Flight findFlight(long flight_number) {
        for (Flight f : flights) {
            if (f.getFlight_number() == flight_number)
                return f;
        }
        return null;
    }

    //Helper: find passenger by ticket number

    private Passenger findPassenger(long ticketNumber){
        for(Passenger pas : passengers) {
            if (pas.getTicket_number() == ticketNumber)
                return pas;
        }
        return null;
    }

    //For UI: return formatted list of flights
    public String showFlightsFormatted() {
        if (flights.isEmpty()) return "No flights found.";

        StringBuilder sb = new StringBuilder();
        sb.append("Flight No\tDestination\tCapacity\tTaken\tPrice\n");

        for (Flight f : flights) {
            sb.append(f.getFlight_number()).append("\t")
                    .append(f.getDestination()).append("\t")
                    .append(f.getCapacity()).append("\t")
                    .append(f.getNPassengers()).append("\t")
                    .append(f.getPrice()).append("\n");
        }

        return sb.toString();
    }

    public void refundTicket(long ticketNumber){
        Passenger pas = findPassenger(ticketNumber);
        Flight f = findFlight(pas.getFlight_number());
        f.removePassenger(ticketNumber);
        passengers.remove(pas);
        System.out.println("Passenger has been removed successfully\n");
    }

}
