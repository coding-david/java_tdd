import javafx.scene.paint.Color;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ParkingLot {

    private int size;
    private int hourFee = 3;
    private int maxHours = 5;
    private int dailyFee = 15;
    private Map<Integer, Ticket> parkingLot = new HashMap<>();


    public ParkingLot(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public int getFee(int hours) {
        if (hours >= maxHours) {
            return dailyFee;
        } else if (hours > 0) {
            return hours * hourFee;
        }
        return 0;
    }

    public Ticket createTicket(String licensePlateNumber, Color carColor) {
        if (parkingLot.size() <= size) {
            for (int i = 1; i <= size; i++) {
                if (!parkingLot.containsKey(i)) {
                    Ticket ticket = new Ticket(licensePlateNumber, carColor);
                    parkingLot.put(i, ticket);
                    return ticket;
                }
            }
        }
        throw new RuntimeException("no slot is empty, sorry");
    }


    public Integer leaveParkingSlot(Ticket ticket) {
        long minutes = ChronoUnit.MINUTES.between(LocalDateTime.of(2022,2,15,8,0),LocalDateTime.now());
        if(minutes < 60){
            return 0;
        }
        return getFee((int)Math.ceil((double)minutes/60.0));
    }

    public List<String> getLicenseOfColor(Color color) {
       return parkingLot.values().stream().filter(ticket -> ticket.getCarColor() == color).map(Ticket::getLicensePlateNumber).collect(Collectors.toList());
    }

    public int getSlotOfLicense(String licensePlateNumber) {
        return parkingLot.entrySet().stream().filter(entry -> Objects.equals(entry.getValue().getLicensePlateNumber(), licensePlateNumber)).map(Map.Entry::getKey).findFirst().get();
    }

    public List<Integer> getSlotsOfColor(Color color) {
        return parkingLot.entrySet().stream().filter(entry -> entry.getValue().getCarColor() == color).map(Map.Entry::getKey).collect(Collectors.toList());
    }
}
