import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotTest {

    ParkingLot codeUnderTest;

    @Test
    void parkingLotGetSizeTest() {
        //GIVEN
        codeUnderTest = new ParkingLot(6);
        int expected = 6;
        //WHEN
        int actual = codeUnderTest.getSize();
        //THEN
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void parkingLotGetFeeTest() {
        //GIVEN
        codeUnderTest = new ParkingLot(6);
        int expected = 9;
        int hours = 3;
        //WHEN
        int actual = codeUnderTest.getFee(3);
        //THEN
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void parkingLotGetDailyFeeTest() {
        //GIVEN
        codeUnderTest = new ParkingLot(6);
        int expected = 15;
        int hours = 6;
        //WHEN
        int actual = codeUnderTest.getFee(6);
        //THEN
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void parkingLotCreateTicketTest() {
        //GIVEN
        codeUnderTest = new ParkingLot(6);
        String licensePlateNumber = "123456";
        Color carColor = Color.WHITESMOKE;
        //WHEN
        Ticket actual = codeUnderTest.createTicket(licensePlateNumber, carColor);
        //THEN
        Assertions.assertEquals(licensePlateNumber, actual.getLicensePlateNumber());
        Assertions.assertEquals(carColor, actual.getCarColor());
    }

    @Test
    void parkingLotTicketRandomNumberIdTest() {
        //GIVEN
        codeUnderTest = new ParkingLot(6);
        String licensePlateNumberOne = "123456";
        String licensePlateNumberTwo = "654321";
        Color carColorOne = Color.WHITESMOKE;
        Color carColorTwo = Color.YELLOW;
        //WHEN
        Ticket actualOne = codeUnderTest.createTicket(licensePlateNumberOne, carColorOne);
        Ticket actualTwo = codeUnderTest.createTicket(licensePlateNumberTwo, carColorTwo);
        //THEN
        Assertions.assertNotEquals(actualOne.getTicketId(),actualTwo.getTicketId());
    }

    @Test
    void parkingLotEmptyParkingSlotTest() {
        //GIVEN
        codeUnderTest = new ParkingLot(1);
        String licensePlateNumberOne = "123456";
        String licensePlateNumberTwo = "654321";
        Color carColorOne = Color.WHITESMOKE;
        Color carColorTwo = Color.YELLOW;
        //WHEN
        Ticket actualOne = codeUnderTest.createTicket(licensePlateNumberOne, carColorOne);
        //THEN
        Assertions.assertNotNull(actualOne);
        Throwable actualTwo = Assertions.assertThrows(RuntimeException.class,()->{
            codeUnderTest.createTicket(licensePlateNumberTwo, carColorTwo);
        },"Exception was expected");
        Assertions.assertEquals("no slot is empty, sorry",actualTwo.getMessage());
    }

    @Test
    void parkingLotEmptyParkingSlotGetTimeEnteredTest() {
        //GIVEN
        codeUnderTest = new ParkingLot(6);
        String licensePlateNumberOne = "123456";
        String licensePlateNumberTwo = "654321";
        Color carColorOne = Color.WHITESMOKE;
        Color carColorTwo = Color.YELLOW;
        //WHEN
        Ticket actualOne = codeUnderTest.createTicket(licensePlateNumberOne, carColorOne);
        Ticket actualTwo = codeUnderTest.createTicket(licensePlateNumberTwo, carColorTwo);
        //THEN
        Assertions.assertNotNull(actualOne.getTimeEntered());
        Assertions.assertNotNull(actualTwo.getTimeEntered());
    }

    @Test
    void parkingLotEmptyParkingSlotLeaveParkingLotTest() {
        //GIVEN
        codeUnderTest = new ParkingLot(6);
        String licensePlateNumberOne = "123456";
        String licensePlateNumberTwo = "654321";
        Color carColorOne = Color.WHITESMOKE;
        Color carColorTwo = Color.YELLOW;
        //WHEN
        Ticket actualOne = codeUnderTest.createTicket(licensePlateNumberOne, carColorOne);
        Ticket actualTwo = codeUnderTest.createTicket(licensePlateNumberTwo, carColorTwo);
        //THEN
        Assertions.assertNotNull(codeUnderTest.leaveParkingSlot(actualOne));
    }

    @Test
    void parkingLotEmptyParkingSlotGetParticularLicensePlateOfColor() {
        //GIVEN
        codeUnderTest = new ParkingLot(6);
        String licensePlateNumberOne = "123456";
        String licensePlateNumberTwo = "654321";
        Color carColorOne = Color.WHITESMOKE;
        Color carColorTwo = Color.WHITESMOKE;
        //WHEN
        Ticket actualOne = codeUnderTest.createTicket(licensePlateNumberOne, carColorOne);
        Ticket actualTwo = codeUnderTest.createTicket(licensePlateNumberTwo, carColorTwo);
        List<String> actualList = codeUnderTest.getLicenseOfColor(Color.WHITESMOKE);
        //THEN
        Assertions.assertTrue(actualList.contains(licensePlateNumberOne));
        Assertions.assertTrue(actualList.contains(licensePlateNumberTwo));
    }

    @Test
    void parkingLotEmptyParkingSlotGetSlotOfLicense() {
        //GIVEN
        codeUnderTest = new ParkingLot(6);
        String licensePlateNumberOne = "123456";
        String licensePlateNumberTwo = "654321";
        Color carColorOne = Color.WHITESMOKE;
        Color carColorTwo = Color.WHITESMOKE;
        //WHEN
        Ticket actualOne = codeUnderTest.createTicket(licensePlateNumberOne, carColorOne);
        Ticket actualTwo = codeUnderTest.createTicket(licensePlateNumberTwo, carColorTwo);
        //THEN
        Assertions.assertEquals(1,codeUnderTest.getSlotOfLicense(licensePlateNumberOne));
        Assertions.assertEquals(2,codeUnderTest.getSlotOfLicense(licensePlateNumberTwo));
    }

    @Test
    void parkingLotEmptyParkingSlotGetSlotsOfColor() {
        //GIVEN
        codeUnderTest = new ParkingLot(6);
        String licensePlateNumberOne = "123456";
        String licensePlateNumberTwo = "654321";
        Color carColorOne = Color.WHITESMOKE;
        Color carColorTwo = Color.WHITESMOKE;
        //WHEN
        Ticket actualOne = codeUnderTest.createTicket(licensePlateNumberOne, carColorOne);
        Ticket actualTwo = codeUnderTest.createTicket(licensePlateNumberTwo, carColorTwo);
        //THEN
        List<Integer> listOfColorSlots = codeUnderTest.getSlotsOfColor(Color.WHITESMOKE);
        Assertions.assertTrue(listOfColorSlots.contains(1));
        Assertions.assertTrue(listOfColorSlots.contains(2));
        Assertions.assertEquals(2, listOfColorSlots.size());
    }






}
