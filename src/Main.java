public class Main {

    public static void main(String[] args) {
        try{
            String className = "PathSum2";
            print("Invoking the constructor for: " + className);
            Class<?> targetClass = Class.forName(className);
            targetClass.newInstance();
        }catch(Exception e) {
            print(e);
        }

        print("End of main()");
    }

    public static void print(Object obj){
        System.out.println(obj.toString());
    }
}