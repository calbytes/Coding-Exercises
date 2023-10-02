import java.util.*;

public class RoomsAndKeys {

    //LeetCode 841, not the most efficient because im using a hashset. a queue/stack to hold the keys would be more space efficient
    public RoomsAndKeys(){

    }

    class Solution {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            HashSet<Integer> roomSet = new HashSet<>();
            Queue<Integer> keys = new LinkedList<>();
            keys.add(0);

            while(!keys.isEmpty()){
                int roomKey = keys.remove();
                roomSet.add(roomKey);

                for(int key : rooms.get(roomKey)){
                    if(roomSet.contains(key)) continue;
                    keys.add(key);
                }
            }

            if(roomSet.size() != rooms.size()) return false;
            return true;
        }
    }
}
