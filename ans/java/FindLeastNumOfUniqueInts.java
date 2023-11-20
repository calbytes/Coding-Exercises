import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class FindLeastNumOfUniqueInts {

    public static void main(String[] args){
        FindLeastNumOfUniqueInts findLeastNumOfUniqueInts = new FindLeastNumOfUniqueInts();

        int[] arr = new int[]{4,3,1,1,3,3,2};
        int[] arr2 = new int[]{5,5,4};

        int result = findLeastNumOfUniqueInts.findLeastNumOfUniqueInts(arr2, 1);
        System.out.println(result);
    }

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> occMap = new HashMap<>();

        for(int i: arr){
            if(occMap.containsKey(i)){
                int occ = occMap.get(i);
                occMap.put(i, ++occ);
            }else{
                occMap.put(i, 1);
            }
        }

        ArrayList<Integer> occurrences = new ArrayList<>();
        for(int key: occMap.keySet()) occurrences.add(occMap.get(key));

        Collections.sort(occurrences);
        System.out.println(occurrences);

        int removed = 0;
        for(int i: occurrences){
            k -= i;
            if(k < 0) break;

            removed++;
        }

        System.out.println("rem: " + removed);
        return occMap.size() - removed;
    }
}

/*
class Solution {
    public HashMap<Integer, Integer> map = new HashMap<>();

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        for(int key : arr){
            if(map.containsKey(key)){
                int i = map.get(key);
                map.put(key, ++i);
            }
            else{
                map.put(key, 1);
            }
        }

        for(int key: map.keySet()){
            MEntry ent = new MEntry(key, map.get(key));
            addToList(ent);
        }

        while(k > 0){
            removeLeast();
            k--;
        }

        return map.size();
    }

    public void removeLeast(){
        int i = 0;
        MEntry mentry = mEntries.get(i);
        while(mentry.val == 0){
            mentry = mEntries.get(i);
            i++;
        }

        int val = map.get(mentry.key);
        val--;
        if(val == 0){
            map.remove(mentry.key);
            mEntries.remove(i);
            return;
        }
        map.put(mentry.key, val);
        mentry.val = val;
    }

    public ArrayList<MEntry> mEntries = new ArrayList<>();

    class MEntry{
        public int key;
        public int val;
        public MEntry(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    public void addToList(MEntry ent){
        int val = ent.val;
        for(int i = 0; i < mEntries.size(); i++){
            if(val < mEntries.get(i).val){
                mEntries.add(i, ent);
                return;
            }
        }
        mEntries.add(ent);
    }
}
 */
