import java.util.*;

public class LetterCasePermutation {

    public static void main(String[] args){
        String word = "a1b2";
        print(letterCasePermutation(word));
    }

    public static List<String> letterCasePermutation(String S) {
        Set<String> set = new HashSet<>();
        set.add("");

        int i = 0;
        while(i < S.length()){
            char c = S.charAt(i);
            Set<String> curSet = new HashSet<>();
            print("cur c : " + c);

            if(Character.isLetter(c)){
                for(String s: set){

                    String cStr = c + "";
                    String capC = cStr.toUpperCase();
                    String lowC = cStr.toLowerCase();

                    System.out.println("cap/low: " + capC + lowC);

                    curSet.add(s + capC);
                    curSet.add(s + lowC);

                }
            }else{
                print("else : " + set);
                for(String s: set){
                    curSet.add(s+c);
                }
            }

            set = curSet;
            i++;
        }

        ArrayList<String> list = new ArrayList<>();
        for(String s: set) list.add(s);
        return list;
    }

    public static void print(Object o){
        System.out.println(o.toString());
    }
}
