import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AirportUI extends JFrame {

    AirportSystem system = new AirportSystem();

    public AirportUI() {

        setTitle("Airport System");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1));

        // Buttons
        JButton addFlightBtn = new JButton("Add Flight");
        JButton showFlightsBtn = new JButton("Show Flights");
        JButton bookTicketBtn = new JButton("Book Ticket");
        JButton addEmployeeBtn = new JButton("Add Employee");
        JButton takeoffBtn = new JButton("Flight Takeoff");
        JButton refundBtn = new JButton("Refund Ticket");
        JButton passengersListBtn = new JButton("show passengers list");
        JButton showEmployeesBtn = new JButton("show employees list");

        add(addFlightBtn);
        add(showFlightsBtn);
        add(passengersListBtn);
        //add(showEmployeesBtn);
        add(bookTicketBtn);
        add(refundBtn);
        //add(addEmployeeBtn);
        add(takeoffBtn);

        // Add Flight
        addFlightBtn.addActionListener(e -> {
            try {
                long fn = Long.parseLong(JOptionPane.showInputDialog("Flight number:"));
                String dest = JOptionPane.showInputDialog("Destination:");
                int cap = Integer.parseInt(JOptionPane.showInputDialog("Capacity:"));
                double price = Double.parseDouble(JOptionPane.showInputDialog("Ticket price:"));
                double time = Double.parseDouble(JOptionPane.showInputDialog("Takeoff time:"));

                system.addFlight(fn, dest, cap, price, time);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Invalid input");
            }
        });

        // Show Flights
        showFlightsBtn.addActionListener(e -> {
            ArrayList<Flight> fs = system.getFlights();

            if(fs.isEmpty()){
                JOptionPane.showMessageDialog(null, "No flights available");
                return;
            }

            // Column names
            String[] columns = {"Flight No", "Destination", "Capacity", "Taken", "Price"};

            // Data
            String[][] data = new String[fs.size()][5];
            for(int i=0; i<fs.size(); i++){
                Flight f = fs.get(i);
                data[i][0] = String.valueOf(f.getFlight_number());
                data[i][1] = f.getDestination();
                data[i][2] = String.valueOf(f.getCapacity());
                data[i][3] = String.valueOf(f.getNPassengers());
                data[i][4] = String.valueOf(f.getPrice());
            }

            // Create JTable and put it in JScrollPane
            JTable table = new JTable(data, columns);
            JScrollPane scrollPane = new JScrollPane(table);
            table.setFillsViewportHeight(true);

            // Show in a JFrame
            JFrame tableFrame = new JFrame("Flights");
            tableFrame.setSize(500, 300);
            tableFrame.add(scrollPane);
            tableFrame.setVisible(true);
        });
        showEmployeesBtn.addActionListener(e -> {
            ArrayList<Employee> fs = system.getEmployees();

            if(fs.isEmpty()){
                JOptionPane.showMessageDialog(null, "No Employees");
                return;
            }

            // Column names
            String[] columns = {"name", "birth year", "ID", "Salary", "Position"};

            // Data
            String[][] data = new String[fs.size()][5];
            for(int i=0; i<fs.size(); i++){
                Employee f = fs.get(i);
                data[i][0] = f.getName();
                data[i][1] = String.valueOf(f.getBirth_year());
                data[i][2] = String.valueOf(f.getId());
                data[i][3] = String.valueOf(f.getSalary());
                data[i][4] = f.getPosition();
            }

            // Create JTable and put it in JScrollPane
            JTable table = new JTable(data, columns);
            JScrollPane scrollPane = new JScrollPane(table);
            table.setFillsViewportHeight(true);

            // Show in a JFrame
            JFrame tableFrame = new JFrame("Employees");
            tableFrame.setSize(500, 300);
            tableFrame.add(scrollPane);
            tableFrame.setVisible(true);
        });

        passengersListBtn.addActionListener(e ->{
            ArrayList<Passenger> pas = system.getPassengers();
            if(pas.isEmpty()){
                JOptionPane.showMessageDialog(null, "there is no passengers");
                return;
            }

            // columns name
            String[] col = {"name", "birth year", "ID", "ticket number", "flight number"};

            // data
            String[][] data = new String[pas.size()][5];
            for(int i = 0; i < pas.size();i++){
                Passenger p = pas.get(i);
                data[i][0] = p.getName();
                data[i][1] = String.valueOf(p.getBirth_year());
                data[i][2] = String.valueOf(p.getId());
                data[i][3] = String.valueOf(p.getTicket_number());
                data[i][4] = String.valueOf(p.getFlight_number());
            }
            JTable table = new JTable(data, col);
            JScrollPane scrollPane = new JScrollPane(table);
            table.setFillsViewportHeight(true);

            JFrame tableFrame = new JFrame("passengers");
            tableFrame.setSize(500, 300);
            tableFrame.add(scrollPane);
            tableFrame.setVisible(true);

        });


        // Book Ticket
        bookTicketBtn.addActionListener(e -> {
            try {
                String name = JOptionPane.showInputDialog("Passenger name:");
                int year = Integer.parseInt(JOptionPane.showInputDialog("Birth year:"));
                long id = Long.parseLong(JOptionPane.showInputDialog("ID:"));
                long fn = Long.parseLong(JOptionPane.showInputDialog("Flight number:"));

                system.bookTicket(name, year, id, fn);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Invalid input");
            }
        });


        // Refund Ticket
        refundBtn.addActionListener(e ->{
            try{
                long tn = Long.parseLong(JOptionPane.showInputDialog("Ticket number:"));
                system.refundTicket(tn);
            }catch (Exception ex){
                JOptionPane.showMessageDialog(null, "invalid input");
            }
        });


        // Add Employee
        addEmployeeBtn.addActionListener(e -> {
            try {
                String name = JOptionPane.showInputDialog("Employee name:");
                int year = Integer.parseInt(JOptionPane.showInputDialog("Birth year:"));
                long id = Long.parseLong(JOptionPane.showInputDialog("ID:"));
                double salary = Double.parseDouble(JOptionPane.showInputDialog("Salary:"));
                String pos = JOptionPane.showInputDialog("Position:");

                system.addEmployee(name, year, id, salary, pos);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Invalid input");
            }
        });

        // Takeoff Flight
        takeoffBtn.addActionListener(e -> {
            try {
                long fn = Long.parseLong(JOptionPane.showInputDialog("Flight number:"));
                system.flight_takeoff(fn);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Invalid input");
            }
        });

        setVisible(true);
    }
}
