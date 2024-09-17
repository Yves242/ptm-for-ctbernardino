package mainOnly;

public class Main2 {
	
    public static void main(String[] args) {
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
        System.out.println("\n\nPrinting all vehicle information...\n");
        ticketingSystem.displayAllVehicles();
    }
}
