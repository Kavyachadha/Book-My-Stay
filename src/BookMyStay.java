import java.util.*;
import java.io.*;

// UC12: Data Persistence & System Recovery

class Reservation implements Serializable {
    String guestName;
    String roomType;

    Reservation(String name, String type) {
        guestName = name;
        roomType = type;
    }

    public String toString() {
        return guestName + " - " + roomType;
    }
}

class PersistenceService {

    public void save(List<Reservation> list) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.ser"));
            oos.writeObject(list);
            oos.close();
            System.out.println("Data saved successfully");
        } catch (Exception e) {
            System.out.println("Save Error: " + e.getMessage());
        }
    }

    public List<Reservation> load() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.ser"));
            List<Reservation> list = (List<Reservation>) ois.readObject();
            ois.close();
            return list;
        } catch (Exception e) {
            System.out.println("Load Error: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}

public class BookMyStay {
    public static void main(String[] args) {

        List<Reservation> bookings = new ArrayList<>();
        bookings.add(new Reservation("Abhi", "Single"));
        bookings.add(new Reservation("Kavya", "Suite"));

        PersistenceService ps = new PersistenceService();

        // Save data
        ps.save(bookings);

        // Load data (simulate restart)
        List<Reservation> loaded = ps.load();

        System.out.println("Recovered Bookings:");
        for (Reservation r : loaded) {
            System.out.println(r);
        }
    }
}
