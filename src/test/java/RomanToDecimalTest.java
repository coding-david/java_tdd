import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RomanToDecimalTest {

    private RomanToDecimal codeUnderTest;

    @BeforeEach
    void initTest() {
        codeUnderTest = new RomanToDecimal();
    }

    @ParameterizedTest(name = "istTestedForStandardRomanDecimal {0}")
    @CsvSource({"I,1", "V,5", "X,10", "L, 50,", "C, 100", "D, 500", "M, 1000"})
    void parameterTest(String input, String expected) {
        Assertions.assertEquals(Integer.parseInt(expected), codeUnderTest.romanToDecimal(input));
    }

    @Test
    void methodReturnANumberTest() {
        //GIVEN
        int expected = 4;
        //WHEN
        int actual = codeUnderTest.romanToDecimal("IV");
        //THEN
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void subCovertRomanToDecimal(){
        // Give
        String inputValue = "IV";
        String inputValue2 = "IX";

        // When
        int output = codeUnderTest.romanToDecimal(inputValue);
        int output2 = codeUnderTest.romanToDecimal(inputValue2);

        //Then
        int expectedValue = 4;
        int expectedValue2 = 9;

        Assertions.assertEquals(expectedValue, output);
        Assertions.assertEquals(expectedValue2, output2);
    }
    @Test
    public void simpleAddtionCovertRomanToDecimal(){
        // Give
        String inputValue = "MMV";

        // When
        int output = codeUnderTest.romanToDecimal(inputValue);

        //Then
        int expectedValue = 2005;

        Assertions.assertEquals(expectedValue, output);
    }
    @Test
    public void complexConvertTest(){
        // Give
        String inputValue = "MCMXLIV";

        // When
        int output = codeUnderTest.romanToDecimal(inputValue);

        //Then
        int expectedValue = 1944;

        Assertions.assertEquals(expectedValue, output);
    }


}
