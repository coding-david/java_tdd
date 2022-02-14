import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParkingLotTest {

    ParkingLot codeUnderTest;

    @Test
    void parkingLotGetSizeTest(){
        //GIVEN
        codeUnderTest = new ParkingLot(6);
        int expected = 6;
        //WHEN
        int actual = codeUnderTest.getSize();
        //THEN
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void parkingLotGetFeeTest(){
        //GIVEN
        codeUnderTest = new ParkingLot(6);
        int expected = 9;
        int hours = 3;
        //WHEN
        int actual = codeUnderTest.getFee(3);
        //THEN
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void parkingLotGetDailyFeeTest(){
        //GIVEN
        codeUnderTest = new ParkingLot(6);
        int expected = 15;
        int hours = 6;
        //WHEN
        int actual = codeUnderTest.getFee(6);
        //THEN
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void parkingLot(){
        //GIVEN
        codeUnderTest = new ParkingLot(6);
        String licenzPlateNumber = "123456";
        Color carColor = Color.WHITESMOKE;
        //WHEN
        Ticket actual = codeUnderTest.createTicket(licenzPlateNumber,carColor);
        //THEN
        Assertions.assertEquals(licenzPlateNumber,actual.getLicenzPlateNumber());
        Assertions.assertEquals(carColor,actual.getCarColor());
    }





}
