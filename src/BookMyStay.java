import java.util.*;

// UC11: Concurrent Booking Simulation

class Inventory {
    private int rooms = 2;

    public synchronized boolean bookRoom(String guest) {
        if (rooms > 0) {
            System.out.println(guest + " is booking...");
            rooms--;
            System.out.println("Booking confirmed for " + guest);
            return true;
        } else {
            System.out.println("No rooms available for " + guest);
            return false;
        }
    }

    public void display() {
        System.out.println("Rooms left: " + rooms);
    }
}

class BookingThread extends Thread {
    Inventory inventory;
    String guest;

    BookingThread(Inventory inv, String guest) {
        this.inventory = inv;
        this.guest = guest;
    }

    public void run() {
        inventory.bookRoom(guest);
    }
}

public class BookMyStay {
    public static void main(String[] args) {

        Inventory inv = new Inventory();

        Thread t1 = new BookingThread(inv, "Abhi");
        Thread t2 = new BookingThread(inv, "Kavya");
        Thread t3 = new BookingThread(inv, "Rahul");

        t1.start();
        t2.start();
        t3.start();
    }
}
