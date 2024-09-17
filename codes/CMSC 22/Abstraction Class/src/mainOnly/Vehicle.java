package mainOnly;

// abstract class for BOTH Bus and Taxi
public abstract class Vehicle {
	
	// variables
    protected String licensePlate;
    protected int capacity;

    // constructor
    public Vehicle(String licensePlate, int capacity) {
        this.licensePlate = licensePlate;
        this.capacity = capacity;
    }

    // method 1
    public String getLicensePlate() {
        return licensePlate;
    }


    // method 2
    public int getCapacity() {
        return capacity;
    }


    // abstract method (IMPLEMENTED by CHILDREN)
    public abstract double calculateFare(int distance);
    public abstract void printInformation();
}
