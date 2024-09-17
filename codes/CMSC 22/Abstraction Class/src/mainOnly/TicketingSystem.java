package mainOnly;

// class that serves like an actual ticketing system
public class TicketingSystem {
	
	// variables
    private Bus[] buses;
    private Taxi[] taxis;
    private int busCount;
    private int taxiCount;

    // constants variables
    private static final int MAX_BUSES = 3;
    private static final int MAX_TAXIS = 5;

    // constructor call
    public TicketingSystem() {
        buses = new Bus[MAX_BUSES];
        taxis = new Taxi[MAX_TAXIS];
        busCount = 0;
        taxiCount = 0;
    }
    
    // herein follows your custom methods
    public boolean addBus(Bus bus) {
        if (busCount < MAX_BUSES) {
            buses[busCount++] = bus;
            return true;
        } else {
        	System.out.println("ADD_BUS_ERROR: exceeded maximum capacity (" + MAX_BUSES + ")");
            return false;
        }
    }

    public boolean addTaxi(Taxi taxi) {
        if (taxiCount < MAX_TAXIS) {
            taxis[taxiCount++] = taxi;
            return true;
        } else {
        	System.out.println("ADD_TAXI_ERROR: exceeded maximum capacity (" + MAX_TAXIS + ")");
            return false;
        }
    }

    public void showVehicles() {
        System.out.println("\nBuses in the system:");
        for (int i = 0; i < busCount; i++) {
            buses[i].printInformation();
        }
        System.out.println("\nTaxis in the system:");
        for (int i = 0; i < taxiCount; i++) {
            taxis[i].printInformation();
        }
    }
}
