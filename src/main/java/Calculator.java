import java.util.Arrays;

public class Calculator {


    public int add(String numbers) {
        StringBuilder negativeException = new StringBuilder("negatives not allowed");
        if (numbers.isEmpty()) {
            return 0;
        }
        String delimeter = ",";
        if (numbers.startsWith("//")) {
            String[] deliArray = numbers.split("\n");
            if(!deliArray[0].contains("[")){
                deliArray[1] = deliArray[1].replace(deliArray[0].replace("//",""),",");
            }
            while(deliArray[0].contains("[")){
                String str = deliArray[0].substring(deliArray[0].indexOf("[")+1,deliArray[0].indexOf("]"));
                deliArray[0] = deliArray[0].replace(str,",");
                deliArray[0] = deliArray[0].substring(deliArray[0].indexOf("]")+1);
                deliArray[1] = deliArray[1].replace(str,",");
            }
            numbers = deliArray[1];
        }
        int[] numArray = Arrays.stream(numbers.replace("\n", delimeter).split(delimeter)).mapToInt(Integer::parseInt).filter(num -> num < 1000).toArray();
        int[] negativeArray = Arrays.stream(numArray).filter(num -> num < 0).toArray();
        if (negativeArray.length > 0) {
            for (int negativeNum : negativeArray) {
                negativeException.append(" ").append(negativeNum);
            }
            throw new RuntimeException(negativeException.toString());
        }
        return Arrays.stream(numArray).sum();
    }
}
