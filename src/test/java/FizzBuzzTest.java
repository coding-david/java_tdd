
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FizzBuzzTest {

    private FizzBuzz codeUnderTest;

    @BeforeEach
    void initTest(){
        codeUnderTest = new FizzBuzz();
    }

    @Test
    void fizzBuzzReturnIsNotNull(){
        //GIVEN
        //WHEN
        String actual = codeUnderTest.fizzBuzz(3);
        //THEN
        Assertions.assertNotNull(actual);
    }

    @Test
    void fizzBuzzReturnFizzDividableBy3(){
        //GIVEN
        String expected = "Fizz";
        //WHEN
        String actual = codeUnderTest.fizzBuzz(6);
        //THEN
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void fizzBuzzReturnBuzzDividableBy5(){
        //GIVEN
        String expected = "Buzz";
        //WHEN
        String actual = codeUnderTest.fizzBuzz(10);
        //THEN
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void fizzBuzzReturnBuzzDividableBy3And5(){
        //GIVEN
        String expected = "FizzBuzz";
        //WHEN
        String actual = codeUnderTest.fizzBuzz(15);
        //THEN
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void fizzBuzzReturnOtherwiseReturnNumberAsString(){
        //GIVEN
        String expected = "2";
        //WHEN
        String actual = codeUnderTest.fizzBuzz(2);
        //THEN
        Assertions.assertEquals(expected,actual);
    }




}
