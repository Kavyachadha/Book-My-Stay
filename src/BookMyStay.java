import java.util.*;

// UC10: Cancellation & Inventory Rollback

class Reservation {
    String guestName;
    String roomType;

    Reservation(String name, String type) {
        guestName = name;
        roomType = type;
    }
}

class Inventory {
    Map<String, Integer> rooms = new HashMap<>();

    Inventory() {
        rooms.put("Single", 2);
        rooms.put("Double", 2);
    }

    void book(String type) {
        rooms.put(type, rooms.get(type) - 1);
    }

    void rollback(String type) {
        rooms.put(type, rooms.get(type) + 1);
    }

    void display() {
        System.out.println(rooms);
    }
}

class BookingService {
    Map<String, Reservation> confirmed = new HashMap<>();
    Inventory inventory;

    BookingService(Inventory inv) {
        inventory = inv;
    }

    void confirm(String id, Reservation r) {
        inventory.book(r.roomType);
        confirmed.put(id, r);
    }

    void cancel(String id) {
        if (confirmed.containsKey(id)) {
            Reservation r = confirmed.remove(id);
            inventory.rollback(r.roomType);
            System.out.println("Booking cancelled for " + r.guestName);
        }
    }
}

public class BookMyStay {
    public static void main(String[] args) {

        Inventory inv = new Inventory();
        BookingService service = new BookingService(inv);

        service.confirm("1", new Reservation("Abhi", "Single"));
        inv.display();

        service.cancel("1");
        inv.display();
    }
}
