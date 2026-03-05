/**
 * =====================================================
 * Use Case 2: Basic Room Types & Static Availability
 * Book My Stay Application
 * =====================================================
 */

/**
 * ABSTRACT CLASS - Room
 * Represents a generic hotel room.
 * @version 2.1
 */
abstract class Room {

    // Number of beds available in the room
    protected int numberOfBeds;

    // Total size of the room in square feet
    protected int squareFeet;

    // Price charged per night
    protected double pricePerNight;

    // Constructor used by child classes
    public Room(int numberOfBeds, int squareFeet, double pricePerNight) {
        this.numberOfBeds = numberOfBeds;
        this.squareFeet = squareFeet;
        this.pricePerNight = pricePerNight;
    }

    // Display room details
    public void displayRoomDetails() {
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Room Size: " + squareFeet + " sq.ft");
        System.out.println("Price per Night: $" + pricePerNight);
    }
}


/**
 * Single Room Class
 * @version 2.0
 */
class SingleRoom extends Room {

    public SingleRoom() {
        super(1, 200, 80.0);
    }
}


/**
 * Double Room Class
 * @version 2.0
 */
class DoubleRoom extends Room {

    public DoubleRoom() {
        super(2, 350, 120.0);
    }
}


/**
 * Suite Room Class
 * @version 2.0
 */
class SuiteRoom extends Room {

    public SuiteRoom() {
        super(3, 500, 250.0);
    }
}


/**
 * Main Application Class
 */
public class BookMyStay {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("       Book My Stay App");
        System.out.println("=================================\n");

        // Create room objects (Polymorphism)
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // Static availability variables
        int singleRoomAvailability = 5;
        int doubleRoomAvailability = 3;
        int suiteRoomAvailability = 2;

        System.out.println("Single Room Details:");
        singleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + singleRoomAvailability);
        System.out.println();

        System.out.println("Double Room Details:");
        doubleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + doubleRoomAvailability);
        System.out.println();

        System.out.println("Suite Room Details:");
        suiteRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + suiteRoomAvailability);
    }
}