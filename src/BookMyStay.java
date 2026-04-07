import java.util.*;

// UC9: Error Handling & Validation

class Reservation {
    String guestName;
    String roomType;

    Reservation(String name, String type) {
        this.guestName = name;
        this.roomType = type;
    }
}

class BookingService {

    public void book(Reservation r) {
        try {
            if (r.guestName == null || r.guestName.isEmpty())
                throw new Exception("Invalid guest name");

            if (!Arrays.asList("Single", "Double", "Suite").contains(r.roomType))
                throw new Exception("Invalid room type");

            System.out.println("Booking successful for " + r.guestName);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

public class BookMyStay {
    public static void main(String[] args) {

        BookingService service = new BookingService();

        service.book(new Reservation("", "Single"));      // error
        service.book(new Reservation("Abhi", "Luxury"));  // error
        service.book(new Reservation("Kavya", "Suite"));  // success
    }
}
