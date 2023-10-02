public class Main {

    public static void main(String[] args) {
        try{
            String className = "DeleteColumns";
            Class<?> targetClass = Class.forName(className);
            print("Invoking the constructor for class: " +
            targetClass.newInstance().getClass().getSimpleName());
        }catch(Exception e) {
            print(e);
        }

        print("End of main()");
    }

    public static void print(Object obj){
        System.out.println(obj.toString());
    }
}