package mainOnly;

//Bus class that is adopted from abstract class Vehicle
public class Taxi extends Vehicle {
	
	// variable declarations
    private static final double BASE_FARE = 5.0;
    private static final double FARE_PER_KM = 3.0;

    // constructor call
    public Taxi(String licensePlate, int capacity) {
        super(licensePlate, capacity);
    }

    // IMPLEMENTED FUNCTION from abstract class calculateFare()
    @Override
    public double calculateFare(int distance) {
        return BASE_FARE + (distance * FARE_PER_KM);
    }

    // IMPLEMENTED FUNCTION from abstract class printInformation()
    // some method
    @Override
    public void printInformation() {
        System.out.println("Taxi(" + licensePlate + ") with capacity " + capacity + ".");
    }
}
