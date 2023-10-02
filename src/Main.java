public class Main {

    public static void main(String[] args) {
        try{
            String className = "DeleteColumns";
            Class<?> newClass = Class.forName(className);
            newClass.newInstance();
        }catch(Exception e) {
            print(e);
        }

        print("End of main()");
    }

    public static void print(Object obj){
        System.out.println(obj.toString());
    }

}