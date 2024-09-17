package mainOnly;

// Bus class that is adopted from abstract class Vehicle
public class Bus extends Vehicle {
	
	// variables
    private static final double FARE_PER_KM = 2.0;

    // constructor call
    public Bus(String licensePlate, int capacity) {
        super(licensePlate, capacity);
    }

    // IMPLEMENTED FUNCTION from abstract class calculateFare()
    @Override
    public double calculateFare(int distance) {
        return distance * FARE_PER_KM;
    }

    // IMPLEMENTED FUNCTION from abstract class printInformation()
    // some method
    @Override
    public void printInformation() {
        System.out.println("Bus(" + licensePlate + ") with capacity " + capacity + ".");
    }
}
