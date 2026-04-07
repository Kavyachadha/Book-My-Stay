import java.util.*;

// UC8: Booking History & Reporting

class Reservation {
    String guestName;
    String roomType;

    Reservation(String name, String type) {
        guestName = name;
        roomType = type;
    }
}

class BookingHistory {
    List<Reservation> history = new ArrayList<>();

    public void add(Reservation r) {
        history.add(r);
    }

    public void printReport() {
        Map<String, Integer> count = new HashMap<>();

        for (Reservation r : history) {
            count.put(r.roomType, count.getOrDefault(r.roomType, 0) + 1);
        }

        System.out.println("Booking Report:");
        for (String type : count.keySet()) {
            System.out.println(type + " rooms booked: " + count.get(type));
        }
    }
}

public class BookMyStay {
    public static void main(String[] args) {
        BookingHistory bh = new BookingHistory();

        bh.add(new Reservation("A", "Single"));
        bh.add(new Reservation("B", "Double"));
        bh.add(new Reservation("C", "Single"));

        bh.printReport();
    }
}
