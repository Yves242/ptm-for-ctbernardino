package mainOnly;

public class Main1 {

	// main thread to be run
    public static void main(String[] args) {    	
		System.out.println("We are in normal mode.\n");
		
    	// make new ticketing system
        TicketingSystem system = new TicketingSystem();

        // Adding Buses
        System.out.println("Adding more buses...");
        system.addBus(new Bus("BUS123", 40));
        system.addBus(new Bus("BUS456", 50));
        system.addBus(new Bus("BUS789", 60));

        // Adding Taxis
        System.out.println("Adding more taxis...");
        system.addTaxi(new Taxi("TAXI123", 4));
        system.addTaxi(new Taxi("TAXI456", 4));
        system.addTaxi(new Taxi("TAXI789", 4));
        system.addTaxi(new Taxi("TAXI321", 4));
        system.addTaxi(new Taxi("TAXI654", 4));

        // Attempting to add more than the maximum allowed
        System.out.println("\nAdding beyond what is allowed by the system...");
        system.addBus(new Bus("BUS000", 30)); // Should print an error
        system.addTaxi(new Taxi("TAXI000", 4)); // Should print an error

        // Display all vehicles
        System.out.println("\n\nPrinting all vehicle information...\n");
        system.showVehicles();
    }
}
