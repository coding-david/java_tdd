import javafx.scene.paint.Color;

import java.time.LocalDateTime;
import java.util.Random;

public class Ticket {

    private String licensePlateNumber;
    private Color carColor;
    private String ticketId;
    private LocalDateTime timeEntered;

    public Ticket(String licensePlateNumber, Color carColor) {
        this.licensePlateNumber = licensePlateNumber;
        this.carColor = carColor;
        this.ticketId = createRandomId();
        this.timeEntered = LocalDateTime.now();
    }

    private String createRandomId() {
        StringBuilder id = new StringBuilder();
        Random random = new Random();
        random.ints(65,90);
        while(id.length() < 5) id.append((char)random.nextInt());
        random.ints(0,9);
        while (id.length() < 11) id.append(random.nextInt());
        return id.toString();
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    public Color getCarColor() {
        return carColor;
    }

    public void setCarColor(Color carColor) {
        this.carColor = carColor;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public LocalDateTime getTimeEntered() {
        return timeEntered;
    }

    public void setTimeEntered(LocalDateTime timeEntered) {
        this.timeEntered = timeEntered;
    }
}
