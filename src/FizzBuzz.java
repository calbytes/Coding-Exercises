public class FizzBuzz {

    public static void main(String[] args){
        fizzBuzz(15);
    }

    public static void fizzBuzz(int n) {
        if(n <= 0 ) return;

        int i = 1;
        while(i <= n){
            if(i%3 == 0 && i%5 == 0){
                System.out.println("FizzBuzz");
            }else if(i%3 == 0){
                System.out.println("Fizz");
            }else if(i%5 == 0){
                System.out.println("Buzz");
            }else if(i%3 != 0 && i%5 != 0){
                System.out.println(i);
            }
            i++;
        }

    }
}
