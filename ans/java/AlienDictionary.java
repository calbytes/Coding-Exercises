import java.util.HashMap;
import java.util.Map;

public class AlienDictionary {
    //#953

    public static void main(String[] a){
        String[] words = new String[]{"apple","app"};
        String order = "pqowieurythgjfkdlsamznxbcv";

        AlienDictionary ad = new AlienDictionary();
        System.out.println(ad.isAlienSorted(words, order));
    }

    public boolean isAlienSortedMyWay(String[] words, String order) {
        Map<Character, Integer> orderMap = new HashMap<>();
        for(int i = 0; i < order.length(); i++){
            orderMap.put(order.charAt(i), i);
        }

        for(int i=0; i+1 < words.length; i++){
            if(!inAlienOrder(orderMap, words[i], words[i+1])) return false;
        }

        return true;
    }

    public boolean inAlienOrder(Map<Character, Integer> orderMap, String str1, String str2){
        char[] arrOne = str1.toCharArray();
        char[] arrTwo = str2.toCharArray();

        int i = 0;
        while(i < arrOne.length && i < arrTwo.length){
            int val1 = orderMap.get(arrOne[i]);
            int val2 = orderMap.get(arrTwo[i]);

            if(val1 < val2) break;
            if(val1 > val2) return false;
            if(val1 == val2 && i == arrTwo.length-1) return false;

            i++;
        }

        return true;
    }





















    public boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < order.length(); ++i)
            index[order.charAt(i) - 'a'] = i;

        search: for (int i = 0; i < words.length - 1; ++i) {
            String word1 = words[i];
            String word2 = words[i+1];

            // Find the first difference word1[k] != word2[k].
            for (int k = 0; k < Math.min(word1.length(), word2.length()); ++k) {
                if (word1.charAt(k) != word2.charAt(k)) {
                    // If they compare badly, it's not sorted.
                    if (index[word1.charAt(k) - 'a'] > index[word2.charAt(k) - 'a'])
                        return false;
                    continue search;
                }
            }

            // If we didn't find a first difference, the
            // words are like ("app", "apple").
            if (word1.length() > word2.length())
                return false;
        }

        return true;
    }

    public static void print(Object o){
        System.out.println(o.toString());
    }
}
