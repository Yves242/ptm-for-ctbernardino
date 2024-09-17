package mainOnly;
import java.util.ArrayList;
import java.util.List;

class ModifiedTicketingSystem {
	
	// variables
    private List<Vehicle> vehicles;
    private final int MAX_VEHICLES = 8;

    // constructors
    public ModifiedTicketingSystem() {
        vehicles = new ArrayList<>();
    }

    // some methods thereafter
    public boolean addVehicle(Vehicle vehicle) {
    	if (vehicles.size() < MAX_VEHICLES) {
            vehicles.add(vehicle);
            System.out.println("Successfully added vehicle '" + vehicle.licensePlate + "'.");
            return true;
    	}
    	System.out.println("ADD_ERROR: exceeded maximum capacity (" + MAX_VEHICLES + ")");
    	return false;
    }

    public void displayAllVehicles() {
    	System.out.println("Current number of vehicles: " + vehicles.size());
        for (Vehicle vehicle : vehicles) {
            vehicle.printInformation();
        }
    }
}
