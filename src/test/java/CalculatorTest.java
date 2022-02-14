import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private Calculator codeUnderTest;

    @BeforeEach
    void initTest(){
        codeUnderTest =  new Calculator();
    }

    @Test
    void addMethodReturnIsInteger0WhenGivenStringWith0(){
        //GIVEN
        int expected = 0;
        //WHEN
        int actual = codeUnderTest.add("0");
        //THEN
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void addMethodReturnIsInteger0WhenGivenStringIsEmpty(){
        //GIVEN
        int expected = 0;
        //WHEN
        int actual = codeUnderTest.add("");
        //THEN
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void addMethodReturnIsInteger3(){
        //GIVEN
        int expected = 3;
        //WHEN
        int actual = codeUnderTest.add("1,2");
        //THEN
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void addMethodReturnIsInteger6(){
        //GIVEN
        int expected = 6;
        //WHEN
        int actual = codeUnderTest.add("1\n2,3");
        //THEN
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void addMethodReturnIsInteger3WhenHaveADDelimiter(){
        //GIVEN
        int expected = 3;
        //WHEN
        int actual = codeUnderTest.add("//;\n1;2");
        //THEN
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void addMethodThrowsExceptionWhenGivenNegativeNumber(){
//        //GIVEN
        String expected = "negatives not allowed -1";
//        //WHEN
//        //THEN
        Exception actual = Assertions.assertThrows(RuntimeException.class,()->{
            codeUnderTest.add("-1,2");
        },"Exception was expected");
        Assertions.assertEquals(expected,actual.getMessage());
    }

    @Test
    void addMethodIgnoresNumbersAreBiggerThanThousand(){
//        //GIVEN
        int expected = 2;
//        //WHEN
        int actual = codeUnderTest.add("2,1002");
//        //THEN
        Assertions.assertEquals(expected,actual);

    }

    @Test
    void addMethodWithADDifferentDelimiter(){
//        //GIVEN
        int expected = 6;
//        //WHEN
        int actual = codeUnderTest.add("//[***]\n1***2***3");
//        //THEN
        Assertions.assertEquals(expected,actual);

    }

    @Test
    void addMethodWithADDifferentMultiDelimiter(){
//        //GIVEN
        int expected = 6;
//        //WHEN
        int actual = codeUnderTest.add("//[*][%]\n1*2%3");
//        //THEN
        Assertions.assertEquals(expected,actual);

    }

}
