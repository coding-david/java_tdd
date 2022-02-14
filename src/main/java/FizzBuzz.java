
public class FizzBuzz {


//    public String fizzBuzz(int num) {
//        if(num % 5 == 0 && num % 3 == 0){
//            return "FizzBuzz";
//        }else if(num % 5 == 0){
//            return "Buzz";
//        }else if(num % 3 == 0){
//            return "Fizz";
//        }
//        return "" + num;
//    }

    public String fizzBuzz(int num) {
        return num % 3 == 0 && num % 5 == 0 ? "FizzBuzz" : num % 3 == 0 ? "Fizz" : num % 5 == 0 ? "Buzz" : ""+num;
    }
}
