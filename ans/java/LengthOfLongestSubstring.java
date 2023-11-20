import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring {
    public static void main(String[] args){
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();

        String s = " ";

        int response = lengthOfLongestSubstring.solution(s);
        lengthOfLongestSubstring.print(response);
    }

    public void print(Object o){
        System.out.println(o.toString());
    }

    public int solution(String s){
        if(s==null) return 0;
        if(s.length() == 1) return 1;
        
        print("String: <" + s + ">");

        Map<Integer, Integer> map = new HashMap();

        int i = 0;
        while(i < s.length()-1){
            Set<Character> set = new HashSet();
            map.put(i, 0);

            print("\nStart char: " + s.charAt(i));

            for(int ii = i; ii<s.length(); ii++){
                if(!set.contains(s.charAt(ii))){
                    print("NonRepeat>>> : "+ s.charAt(ii));
                    set.add(s.charAt(ii));
                    int nonRepeat = map.get(i);
                    nonRepeat++;
                    map.put(i, nonRepeat);
                }else{
                    break;
                }
            }

            i++;
        }

        int longest = 0;
        String longLog = "";
        for(int key: map.keySet()){
            if(map.get(key) > longest){
                longest = map.get(key);
                longLog = "\nlongest: " + key + ":" + map.get(key);
            }
        }

        print(longLog);
        print("map-> " + map);
        return longest;
    }
}
