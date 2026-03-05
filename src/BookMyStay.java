import java.util.HashMap;
import java.util.Map;

class Room {
    private String type;
    private double price;
    private String amenities;

    public Room(String type, double price, String amenities) {
        this.type = type;
        this.price = price;
        this.amenities = amenities;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public String getAmenities() {
        return amenities;
    }

    public void displayDetails() {
        System.out.println("Room Type: " + type);
        System.out.println("Price per night: $" + price);
        System.out.println("Amenities: " + amenities);
    }
}

class RoomInventory {
    private Map<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
    }

    public void addRoomType(String roomType, int count) {
        inventory.put(roomType, count);
    }

    public int getAvailableRooms(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    public Map<String, Integer> getInventorySnapshot() {
        return new HashMap<>(inventory);
    }
}

class RoomSearchService {
    private RoomInventory inventory;
    private Map<String, Room> roomCatalog;

    public RoomSearchService(RoomInventory inventory, Map<String, Room> roomCatalog) {
        this.inventory = inventory;
        this.roomCatalog = roomCatalog;
    }

    public void searchAvailableRooms() {
        System.out.println("Available Rooms:\n");

        Map<String, Integer> snapshot = inventory.getInventorySnapshot();

        for (String roomType : snapshot.keySet()) {
            int available = snapshot.get(roomType);

            if (available > 0 && roomCatalog.containsKey(roomType)) {
                Room room = roomCatalog.get(roomType);
                room.displayDetails();
                System.out.println("Available Rooms: " + available);
                System.out.println("---------------------------");
            }
        }
    }
}

public class BookMyStay {
    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();
        inventory.addRoomType("Single Room", 5);
        inventory.addRoomType("Double Room", 0);
        inventory.addRoomType("Suite Room", 2);

        Map<String, Room> roomCatalog = new HashMap<>();

        roomCatalog.put("Single Room",
                new Room("Single Room", 100.0, "WiFi, TV, Queen Bed"));

        roomCatalog.put("Double Room",
                new Room("Double Room", 150.0, "WiFi, TV, King Bed, Balcony"));

        roomCatalog.put("Suite Room",
                new Room("Suite Room", 300.0, "WiFi, TV, King Bed, Jacuzzi, Sea View"));

        RoomSearchService searchService =
                new RoomSearchService(inventory, roomCatalog);

        searchService.searchAvailableRooms();
    }
}