import java.util.*;

// UC7: Add-On Service Selection

class Reservation {
    String guestName;
    List<String> addOns = new ArrayList<>();

    Reservation(String name) {
        this.guestName = name;
    }
}

class AddOnService {
    private Map<String, Integer> services = new HashMap<>();

    AddOnService() {
        services.put("Breakfast", 500);
        services.put("Spa", 1500);
        services.put("Airport Pickup", 800);
    }

    public void addService(Reservation r, String service) {
        if (services.containsKey(service)) {
            r.addOns.add(service);
        }
    }

    public void printBill(Reservation r) {
        int total = 0;
        System.out.println("Add-ons for " + r.guestName);
        for (String s : r.addOns) {
            int price = services.get(s);
            total += price;
            System.out.println(s + " - " + price);
        }
        System.out.println("Total Add-on Cost: " + total);
    }
}

public class BookMyStay {
    public static void main(String[] args) {
        Reservation r = new Reservation("Abhi");

        AddOnService service = new AddOnService();
        service.addService(r, "Breakfast");
        service.addService(r, "Spa");

        service.printBill(r);
    }
}
