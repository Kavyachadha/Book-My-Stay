/**
 * =====================================================
 * CLASS - RoomInventory
 * Use Case 3: Centralized Room Inventory Management
 *
 * This class acts as the single source of truth for room
 * availability in the hotel.
 *
 * Room pricing and characteristics are obtained from Room objects,
 * not duplicated here.
 *
 * This creates multiple sources of truth and
 * keeps responsibilities clearly separated.
 *
 * @version 3.1
 */
import java.util.HashMap;

class RoomInventory {

    // Maps room name to available count
    private HashMap<String, Integer> inventory;

    // Constructor initializes inventory with fixed availability
    public RoomInventory() {
        inventory = new HashMap<>();
        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }

    // Returns current availability for room type
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    // Updates availability count for a room type
    public void updateAvailability(String roomType, int count) {
        inventory.put(roomType, count);
    }

    // Prints current inventory status to console
    public void displayInventory() {
        System.out.println("\nHotel Room Inventory Status");
        for (String roomType : inventory.keySet()) {
            System.out.println(roomType + ": " + inventory.get(roomType));
        }
    }
}

/**
 * =====================================================
 * MAIN CLASS - UseCase3InventorySetup
 *
 * Use Case 3: Centralized Room Inventory Management
 *
 * Demonstrates room availability management using centralized HashMap.
 * @version 3.1
 */
abstract class Room {

    protected int numberOfBeds;
    protected int squareFeet;
    protected double pricePerNight;

    public Room(int numberOfBeds, int squareFeet, double pricePerNight) {
        this.numberOfBeds = numberOfBeds;
        this.squareFeet = squareFeet;
        this.pricePerNight = pricePerNight;
    }

    public void displayRoomDetails() {
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Size: " + squareFeet + " sqft");
        System.out.println("Price per night: $" + pricePerNight);
    }
}

class SingleRoom extends Room {
    public SingleRoom() {
        super(1, 200, 150.0);
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() {
        super(2, 350, 250.0);
    }
}

class SuiteRoom extends Room {
    public SuiteRoom() {
        super(3, 500, 500.0);
    }
}

public class BookMyStay {

    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println("       Book My Stay App");
        System.out.println("=================================");

        // Initialize rooms
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // Display room details
        System.out.println("\nSingle Room:");
        singleRoom.displayRoomDetails();

        System.out.println("\nDouble Room:");
        doubleRoom.displayRoomDetails();

        System.out.println("\nSuite Room:");
        suiteRoom.displayRoomDetails();

        // Initialize centralized inventory
        RoomInventory inventory = new RoomInventory();

        // Show inventory status
        inventory.displayInventory();
    }
}