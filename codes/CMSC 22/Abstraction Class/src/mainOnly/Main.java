package mainOnly;

// Main class
public class Main {
	
	
	// main thread to be run
    public static void main(String[] args) {

    	// normal variable
    	boolean abstractionArrayImplemented = false;
    	

    	// if bus system not implemented by abstraction array
    	if (!abstractionArrayImplemented) {        	
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
            System.out.println("\n\nPrinting all vehicle information...");
            system.showVehicles();
    		

        // if using abstract-implemented bus system
    	} else {
    		System.out.println("We are now storing Bus and Taxi classes under Vehicles array.\n");
        	
            // Create an instance of ModifiedTicketingSystem
            ModifiedTicketingSystem ticketingSystem = new ModifiedTicketingSystem();

            // Create some Taxi and Bus instances
            Taxi taxi1 = new Taxi("ABC123", 4);
            Taxi taxi2 = new Taxi("DEF456", 4);
            Bus bus1 = new Bus("XYZ789", 50);
            Bus bus2 = new Bus("LMN321", 30);

            // Add vehicles to the ticketing system
            System.out.println("Adding more vehicles...");
            ticketingSystem.addVehicle(taxi1);
            ticketingSystem.addVehicle(taxi2);
            ticketingSystem.addVehicle(bus1);
            ticketingSystem.addVehicle(bus2);
            System.out.println("");

            // Display all vehicles
            ticketingSystem.displayAllVehicles();

            // Try to add more vehicles than the system can hold
            System.out.println("\nAdding beyond what is allowed by the system...");
            for (int i = 3; i <= 10; i++) {
                Taxi extraTaxi = new Taxi("EXTRA" + i, 4);
                ticketingSystem.addVehicle(extraTaxi);
            }

            // Display all vehicles after attempting to add more
            System.out.println("\n\nPrinting all vehicle information...");
            ticketingSystem.displayAllVehicles();
    	}
    }
}
