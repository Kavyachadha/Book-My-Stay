import java.util.*;

// Use Case 6: Reservation Confirmation & Room Allocation

class Reservation {
    String guestName;
    String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

class RoomInventory {
    private Map<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
        inventory.put("Single", 2);
        inventory.put("Double", 2);
        inventory.put("Suite", 1);
    }

    public boolean isAvailable(String roomType) {
        return inventory.getOrDefault(roomType, 0) > 0;
    }

    public void decrement(String roomType) {
        inventory.put(roomType, inventory.get(roomType) - 1);
    }
}

class RoomAllocationService {

    private Set<String> allocatedRoomIds = new HashSet<>();
    private Map<String, Set<String>> assignedRoomsByType = new HashMap<>();
    private Map<String, Integer> counters = new HashMap<>();

    public void allocateRoom(Reservation reservation, RoomInventory inventory) {

        String roomType = reservation.roomType;

        if (!inventory.isAvailable(roomType)) {
            System.out.println("No rooms available for " + reservation.guestName);
            return;
        }

        String roomId = generateRoomId(roomType);

        allocatedRoomIds.add(roomId);

        assignedRoomsByType
                .computeIfAbsent(roomType, k -> new HashSet<>())
                .add(roomId);

        inventory.decrement(roomType);

        System.out.println("Booking confirmed for guest: "
                + reservation.guestName + ", Room ID: " + roomId);
    }

    private String generateRoomId(String roomType) {
        int count = counters.getOrDefault(roomType, 0) + 1;
        counters.put(roomType, count);
        return roomType + "-" + count;
    }
}

// MAIN CLASS (IMPORTANT)
public class BookMyStay {

    public static void main(String[] args) {

        Queue<Reservation> queue = new LinkedList<>();

        // FIFO booking requests
        queue.add(new Reservation("Abhi", "Single"));
        queue.add(new Reservation("Subha", "Single"));
        queue.add(new Reservation("Vanmathi", "Suite"));

        RoomInventory inventory = new RoomInventory();
        RoomAllocationService service = new RoomAllocationService();

        System.out.println("Room Allocation Processing\n");

        while (!queue.isEmpty()) {
            Reservation r = queue.poll(); // FIFO
            service.allocateRoom(r, inventory);
        }
    }
}
